/**
 * 
 * File name		: ResumeMimeTypes.java
 * Author			: Anand Sivadas
 * Version			: 0.1
 * Created on		: 25 Jul, 2018
 * Reviewed by		: 
 * 
 */
package com.sivadas.anand.util;

import java.util.HashMap;

/**
 * The Enum ResumeMimeTypes.
 */
public enum ResumeMimeTypes {
	
	/** The pdf. */
	PDF("application/pdf"),
	
	/** The text. */
	TEXT("text/plain"),
	
	/** The doc. */
	DOC("application/msword"),
	
	/** The pages. */
	PAGES("application/vnd.apple.pages"),
	
	/** The rtf. */
	RTF("application/rtf"),
	
	/** The docx. */
	DOCX("application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
	
	/** The pageszip. */
	PAGESZIP("application/zip");
	
	/** The Constant map. */
	private final static HashMap<String, ResumeMimeTypes> map = new HashMap<String, ResumeMimeTypes>();
	
	/** The pdf string. */
	private static String PDF_STRING = "PDF";
	
	/** The text string. */
	private static String TEXT_STRING = "TXT";
	
	/** The doc string. */
	private static String DOC_STRING = "DOC";
	
	/** The pages string. */
	private static String PAGES_STRING = "PAGES";
	
	/** The rtf string. */
	private static String RTF_STRING = "RTF";
	
	/** The docx string. */
	private static String DOCX_STRING = "DOCX";
	
	/** The pages zip string. */
	private static String PAGES_ZIP_STRING = "PAGES.ZIP";
	
	static{
		map.put(PDF_STRING, PDF);
		map.put(TEXT_STRING, TEXT);
		map.put(DOC_STRING, DOC);
		map.put(PAGES_STRING, PAGES);
		map.put(RTF_STRING, RTF);
		map.put(DOCX_STRING, DOCX);
		map.put(PAGES_ZIP_STRING, PAGESZIP);
	}
	
	/**
	 * Instantiates a new resume mime types.
	 *
	 * @param mimeType the mime type
	 */
	ResumeMimeTypes(String mimeType){
		this.mimeType=mimeType;
	}
	
	/** The mime type. */
	private final String mimeType;
	
	/**
	 * Gets the mime type.
	 *
	 * @return the mime type
	 */
	public String getMimeType(){
		return mimeType;
	}
	
	/**
	 * Gets the supported mime types.
	 *
	 * @param key the key
	 * @return the supported mime types
	 */
	public static ResumeMimeTypes getSupportedMimeTypes(String key){
		if (map.containsKey(key)){
			return map.get(key);
		}
		return null;
	}
}
