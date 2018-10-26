/**
 * 
 * File name		: FileUploadUtil.java
 * Author			: Anand Sivadas
 * Version			: 0.1
 * Created on		: 4 Sep, 2018
 * Reviewed by		: 
 * 
 */
package com.sivadas.anand.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

/**
 * The Class FileUploadUtil.
 */
public class FileUploadUtil {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadUtil.class);
	
	/** The Constant IWORK_API_V1_EXPORT_URL. */
	private static final String IWORK_API_V1_EXPORT_URL = "https://resturltoconverterservice/api/v1/export";
	
	/** The Constant TMP_I_WORK_DIR. */
	private static final String TMP_WORK_DIR = "/tmp/work/";
	
	/** The Constant FAILED_I_WORK_DIR. */
	private static final String FAILED_I_WORK_DIR = "/tmp/work/failed-vault/";
	
	/** The Constant ISTRECRUITING. */
	private static final String PARTYID = "partyid";
    
    /** The current date time. */
    static String currentDateTime = ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT);

    /** The signature. */
    byte[] signature;

    /**
     * Instantiates a new file upload util.
     *
     * @param data the data
     * @param keyFile the key file
     * @throws Exception the exception
     */
    //The constructor of Message class builds the list that will be written to the file. The list consists of the message and the signature.
    public FileUploadUtil(String data, String keyFile) throws Exception {

        signature = signDataWithKeyFile(data, keyFile);
    }

    /**
     * Sign the data using the private key that is stored in keyFile path.
     *
     * @param data the data
     * @param keyFile the key file
     * @return the byte[]
     * @throws Exception the exception
     */
    public byte[] signDataWithKeyFile(String data, String keyFile) throws Exception{

        Signature dsa = Signature.getInstance("SHA256withDSA");
        dsa.initSign(getPrivateKey(keyFile));
        dsa.update(data.getBytes());

        return dsa.sign();
    }

    /**
     * Gets the the Private Key from a file.
     *
     * @param filename the filename
     * @return the private
     * @throws Exception the exception
     */
    public PrivateKey getPrivateKey(String filename) throws Exception {

        byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("DSA");

        return kf.generatePrivate(spec);
    }

    /**
     * Convert binary signature to string.
     *
     * @return the string representation of the signature
     */
    private String convertBinarySignatureToString()  {

        return new String( Base64.getUrlEncoder().encode(signature) );
    }

    /**
     * Send request to convert.
     *
     * @param data the data
     * @param originalFilename the original filename
     * @throws Exception the exception
     */
    public static void sendRequestToConvert(final String data, String originalFilename) throws Exception {

    	File privateCertificate = new ClassPathResource("dsa.priv.pkcs8").getFile();
    	String absolutePath = privateCertificate.getAbsolutePath();
    	LOGGER.debug("Certificate absolutePath = " + absolutePath);
    	final String signedData = new FileUploadUtil(data, absolutePath ).convertBinarySignatureToString();
        int responseCode = executePost(IWORK_API_V1_EXPORT_URL, signedData, originalFilename);
        LOGGER.info("Response code = " + responseCode);
        cleanupFile(responseCode, originalFilename);
    }

    /**
     * Cleanup files in the temp folder.
     *
     * @param responseCode the response code
     * @param originalFilename the original filename
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static void cleanupFile(int responseCode, String originalFilename) throws IOException {
		
    	if (HttpStatus.valueOf(responseCode) == HttpStatus.CREATED) {
    		Files.delete(Paths.get(originalFilename));
    		LOGGER.info("Original file deleted");
    	} else {
    		String failedDir = FAILED_I_WORK_DIR + System.currentTimeMillis() + File.separator;
    		LOGGER.debug("failedDir = " + failedDir);
    		if(! new File(failedDir).exists())
    		{
//    			new File(failedDir).mkdir();
    			Files.createDirectories(Paths.get(failedDir));
    		}
    		
    		String fileName = FilenameUtils.getName(originalFilename);
    		Files.move(Paths.get(originalFilename), Paths.get(failedDir + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
    		LOGGER.info("Moved failed file");
    		throw new IOException("Failed to convert file. Original file has been moved to vault.");
    	}
	}

	/**
	 * Execute post.
	 *
	 * @param targetURL the target URL
	 * @param signedData the signed data
	 * @param originalFilename the original filename
	 * @return the int
	 */
	private static int executePost(String targetURL, String signedData, String originalFilename) {

        HttpURLConnection connection = null;
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            	}
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/octet-stream");
            connection.setRequestProperty("X-API-PartyId", PARTYID);

            String urlSafeEncodedFilename = getUrlSafeEncodedFilename(originalFilename);
            connection.setRequestProperty("X-API-Base64-Filename", urlSafeEncodedFilename);
            
            connection.setRequestProperty("X-API-SignDateTime", currentDateTime);
            //This all we support at the moment
            connection.setRequestProperty("X-API-ExportFormat", "com.adobe.pdf");
            connection.setRequestProperty("X-API-Signature", signedData);
            LOGGER.info("X-API-Signature = " + signedData);
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            LOGGER.info("Sending Request ...");

            //write our file
            BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
            byte[] data = getBytesFromFile(originalFilename);
            for(int i=0; i< data.length; i++){
                bos.write(data[i]);
            }
            bos.close();
            LOGGER.info("Receiving Response ...");
            String fileName = FilenameUtils.getBaseName(originalFilename);
            InputStream is = connection.getInputStream();
            String requestProperty = connection.getHeaderField("X-Request-UUID");
            LOGGER.info("X-Request-UUID = " + requestProperty);
            FileOutputStream outputStream = new FileOutputStream(getOSHomeDir() + File.separator + "Downloads" + File.separator + fileName + ".pdf");
            int bytesRead = -1;
            byte[] buffer = new byte[1024];
            while((bytesRead = is.read(buffer)) != -1){
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            LOGGER.info("Wrote pdf file");
            return 201;

        } catch (Exception exception) {
        	LOGGER.error("Exeception occurred ... ", exception.getMessage());
        	LOGGER.error("Exeception is = ", exception);
        	String requestProperty = connection.getHeaderField("X-Request-UUID");
            LOGGER.info("X-Request-UUID = " + requestProperty);
            return 403;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    /**
     * Gets the content length.
     *
     * @param originalFilename the original filename
     * @return the content length
     */
    private static long getContentLength(String originalFilename){

        return  getFileToSend(originalFilename).length();
    }

    /**
     * Gets the file to send.
     *
     * @param fileName the file name
     * @return the file to send
     */
    private static File getFileToSend(String fileName) {

        File file = new File(fileName);
        LOGGER.debug("Using file :" + file.getAbsolutePath());

        return file;
    }

    /**
     * Gets the bytes from file.
     *
     * @param originalFilename the original filename
     * @return the bytes from file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static byte[] getBytesFromFile(String originalFilename) {

    	File fileToSend = getFileToSend(originalFilename);
        byte[] bFile = new byte[(int) fileToSend.length()];
        FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(fileToSend);
			fileInputStream.read(bFile);
		} catch (FileNotFoundException exception) {
			LOGGER.error("File not found exception occurred while getting bytes from File ", exception.getMessage());
        	LOGGER.error("Exeception is = ", exception);
		} catch (IOException exception) {
			LOGGER.error("Exeception occurred while getting bytes from File ", exception.getMessage());
        	LOGGER.error("Exeception is = ", exception);
		}

        return bFile;
    }

    /**
     * Gets the url safe encoded filename.
     *
     * @param originalFilename the original filename
     * @return the url safe encoded filename
     */
    public static String getUrlSafeEncodedFilename(String originalFilename){
    	
    	String encodedFilename = Base64.getUrlEncoder().encodeToString(originalFilename.getBytes(StandardCharsets.UTF_8));
    	LOGGER.debug("encodedFilename = " + encodedFilename);

        return encodedFilename;
    }

    /**
     * Convert pages file to PDF.
     *
     * @param multipartFile the multipart file to be converted
     * @throws Exception the exception
     */
    public static void convertPagesFileToPDF(MultipartFile multipartFile) throws Exception {

    	String conversionDir = TMP_WORK_DIR;
    	if(! new File(conversionDir).exists())
    	{
    		new File(conversionDir).mkdir();
    	}
    	// Get the file and save it somewhere
    	String originalFilename = conversionDir + multipartFile.getOriginalFilename();
    	LOGGER.debug("originalFilename = " + originalFilename);
        byte[] bytes = multipartFile.getBytes();
        Path path = Paths.get(originalFilename);
        Files.write(path, bytes);
        
		String urlSafeEncodedFilename = Base64.getUrlEncoder().encodeToString(originalFilename.getBytes(StandardCharsets.UTF_8));
		LOGGER.debug("urlSafeEncodedFilename = " + urlSafeEncodedFilename);
		File inputFile = new File(originalFilename);
		multipartFile.transferTo(inputFile);

		String apiSig = String.join("/",
                PARTYID,   //TODO: change this to 'istrecruiting' along with your key
                getUrlSafeEncodedFilename(originalFilename),    //this is Base64 urlsafe encoding of the input filename to convert
                Long.toString(getContentLength(originalFilename)),
                currentDateTime,
                "com.adobe.pdf" );

//        sendRequestToConvert(apiSig, originalFilename);
    }
    
    /**
     * Prompt logged in user.
     *
     * @throws ClassNotFoundException the class not found exception
     * @throws SecurityException the security exception
     * @throws NoSuchMethodException the no such method exception
     * @throws InstantiationException the instantiation exception
     * @throws IllegalAccessException the illegal access exception
     * @throws IllegalArgumentException the illegal argument exception
     * @throws InvocationTargetException the invocation target exception
     */
    public static void promptUser() throws ClassNotFoundException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String osName = System.getProperty( "os.name" ).toLowerCase();
		String className = null;

		LOGGER.debug("Your OS Name is " + osName);
		if( osName.contains( "windows" ) ){
		    className = "com.sun.security.auth.module.NTSystem";
		} 		else if( osName.contains( "linux" ) ){
		    className = "com.sun.security.auth.module.UnixSystem";
		} 		else if( osName.contains( "solaris" ) || osName.contains( "sunos" ) ){
		    className = "com.sun.security.auth.module.SolarisSystem";
		} else if( osName.contains( "mac" ) || osName.contains( "os x" ) ){
		    className = "com.sun.security.auth.module.UnixSystem";
		}

		if( className != null ){
		    Class<?> c = Class.forName( className );
		    Method method = c.getDeclaredMethod( "getUsername" );
		    Object o = c.newInstance();
		    LOGGER.debug("Hello " + method.invoke(o));
		}
    }
    
    /**
     * Gets the OS home directory.
     *
     * @return string representation of the OS home directory
     */
    public static String getOSHomeDir() {

    	String home = System.getProperty("user.home");
    	return home;
    }

}
