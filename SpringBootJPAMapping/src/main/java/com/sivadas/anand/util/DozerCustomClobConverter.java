package com.sivadas.anand.util;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.Clob;

import org.apache.commons.io.IOUtils;
import org.dozer.CustomConverter;

public class DozerCustomClobConverter implements CustomConverter {

	@Override
	public String convert(Object destination, Object source, Class<?> destinationClass, Class<?> sourceClass) {
		
		String content = null;
		if (null != source && source instanceof Clob) {
			Clob clobData = (Clob) source;
			content = getAsString(clobData);
		}
		
		return content;
	}
	
	private String getAsString(Clob clob) {
	    Reader reader = null;
	    BufferedReader bufferedReader = null;
	    try {
	        reader = clob.getCharacterStream();
	        bufferedReader = new BufferedReader(reader);
	        return IOUtils.toString(bufferedReader);

	    } catch (Exception e) {
	        throw new RuntimeException("Error while reading String from CLOB", e);
	    } finally {
	        IOUtils.closeQuietly(reader);
	        IOUtils.closeQuietly(bufferedReader);
	    }
	}



}
