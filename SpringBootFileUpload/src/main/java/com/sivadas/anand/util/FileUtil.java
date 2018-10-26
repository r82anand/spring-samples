/**
 * 
 * File name		: FileUtil.java
 * Author			: Anand Sivadas
 * Version			: 0.1
 * Created on		: 25 Jul, 2018
 * Reviewed by		: 
 * 
 */
package com.sivadas.anand.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ContentHandler;

/**
 * The Class FileUtil.
 */
public class FileUtil {

	/** The logger. */
	private static Logger LOGGER = LoggerFactory.getLogger(FileUtil.class);
	
	/**
	 * Method to check whether to allow the mime type.
	 *
	 * @param fileContentType the file content type
	 * @return true, if successful
	 */
	public static boolean mimeAllowChecker(final String fileContentType) {
		return supportedMimeMap.containsKey(fileContentType);
	}

	/** The supported mime map. */
	public static Map<String, String> supportedMimeMap = new HashMap<String, String>();
	static {
		supportedMimeMap.put("application/rtf", "RTF");
		supportedMimeMap.put("text/rtf", "RTF");
		supportedMimeMap.put("text/richtext", "RTF");
		supportedMimeMap.put("text/plain", "TXT");
		supportedMimeMap.put("application/vnd.openxmlformats-officedocument.wordprocessingml.document", "DOCX");
		supportedMimeMap.put("application/pdf", "PDF");
		supportedMimeMap.put("application/msword", "DOC");
		supportedMimeMap.put("application/msword", "DOCX");
		supportedMimeMap.put("application/x-tika-msoffice", "DOC");
		supportedMimeMap.put("application/x-tika-ooxml", "OOXML");
		supportedMimeMap.put("application/x-iwork-pages-sffpages", "PAGES");
		supportedMimeMap.put("application/vnd.apple.pages", "PAGES");
		supportedMimeMap.put("application/zip", "PAGESZIP");
		supportedMimeMap.put("application/vnd.openxmlformats-officedocument.wordprocessingml.document", "ODF");

	}

	/**
	 * Gets the file extension.
	 *
	 * @param fullFileName the full file name
	 * @return the fileextension
	 */
	public static String getFileextension(String fullFileName) {
		int mid = fullFileName.lastIndexOf(".");
		String fileExtension = fullFileName.substring(mid + 1, fullFileName.length());
		int dotCount = fullFileName.split("\\.").length - 1;
		if (fileExtension.equalsIgnoreCase("zip") && dotCount > 1) {
			String fileName = fullFileName.substring(0, mid);
			int secondDot = fileName.lastIndexOf(".");
			String pagesExtension = fileName.substring(secondDot + 1, fileName.length());
			if (pagesExtension.equalsIgnoreCase("pages")) {
				return pagesExtension + "." + fileExtension;
			}
		}

		return fileExtension;
	}

	/**
	 * Method to verify mime.
	 *
	 * @param fileStream the file stream
	 * @param fileName the file name
	 * @return statusCode 
	 * 		   0 - success. Mime supported and matched with extension
	 *         1 - error. Mime information cannot be retrieved from the stream
	 *         2 - error. Mime not supported by the system 
	 *         3 - error. Mime type doesn't match with the file extension provided
	 *         
	 */
	public static int verifyMime(InputStream fileStream, String fileName) {

		String fileExtension = "";
		fileExtension = getFileextension(fileName);
		ContentHandler textHandler = new BodyContentHandler();
		Metadata metadata = new Metadata();
		metadata.set("resourceName", fileName);
		Date dateBef = new Date();
		try {
			Parser parser = new AutoDetectParser();
			parser.parse(fileStream, textHandler, metadata, new ParseContext());
		} catch (Exception exception) {
			LOGGER.error("Exception =" + exception.getMessage());
			LOGGER.error("Exception = ", exception);
		}

		Date dateAft = new Date();
		LOGGER.info("Time Taken by for detection = " + (dateAft.getTime() - dateBef.getTime()));
		String contentType = metadata.get("Content-Type");

		ResumeMimeTypes mimeTypeByExtension = null;
		if (fileExtension != null) {
			mimeTypeByExtension = ResumeMimeTypes.getSupportedMimeTypes(fileExtension.toUpperCase());
		}

		if (contentType == null) {
			return 1;
		}
		if (mimeTypeByExtension == null) {
			return 2;
		}
		if (contentType != null && mimeTypeByExtension != null
				&& (mimeTypeByExtension.getMimeType().equals(contentType))) {
			return 0;
		} else {
			return 3;
		}
	}
	
	/**
	 * Write file to disk.
	 *
	 * @param inputStream the input stream
	 * @param fileName the file name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void writeFileToDisk(InputStream inputStream, String fileName) throws IOException {
		FileOutputStream outputStream = new FileOutputStream("./output.pdf");
        int bytesRead = -1;

        byte[] buffer = new byte[1024];
        while((bytesRead = inputStream.read(buffer)) != -1){
            outputStream.write(buffer, 0, bytesRead);
        }

        outputStream.close();
        LOGGER.info("Wrote pdf to ./output.pdf");
	}
	
	/**
	 * Write file to disk.
	 *
	 * @param inputStreamReader the input stream reader
	 * @param fileName the file name
	 */
	public static void writeFileToDisk(InputStreamReader inputStreamReader, String fileName) {
		
		BufferedReader bufferedReader = null;
		OutputStream outputStream = null; 
		
		try {
			outputStream = new FileOutputStream(new File(fileName));
			bufferedReader = new BufferedReader(inputStreamReader);
			StringBuilder stringBuilder = new StringBuilder();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
			}
			
			outputStream.write(String.valueOf(stringBuilder).getBytes());
	        LOGGER.info("Wrote pdf to ./output.pdf");

		} catch (FileNotFoundException fileNotFoundException) {
			LOGGER.error("FileNotFoundException ", fileNotFoundException );
		} catch (IOException ioException) {
			LOGGER.error("IOException ", ioException );
		} finally {
			if (null != outputStream) {
				try {
					outputStream.close();
				} catch (IOException ioException) {
					LOGGER.error("IOException ", ioException );
				}
			}
			if (null != bufferedReader) {
				try {
					bufferedReader.close();
				} catch (IOException ioException) {
					LOGGER.error("IOException ", ioException );
				}
			}
		}
	}

}
