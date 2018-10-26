/**
 * 
 * File name		: FileUploadController.java
 * Author			: Anand Sivadas
 * Version			: 0.1
 * Created on		: 2 Aug, 2018
 * Reviewed by		: 
 * 
 */
package com.sivadas.anand.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sivadas.anand.util.FileUploadUtil;
import com.sivadas.anand.util.FileUtil;

/**
 * The Class FileUploadController.
 */
@Controller
public class FileUploadController {
	
	/** The logger. */
	private Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

    /**
     * Index.
     *
     * @return the string
     */
    @GetMapping("/")
    public String index() {
        return "upload";
    }

    /**
     * Single file upload.
     *
     * @param file the file
     * @param redirectAttributes the redirect attributes
     * @return the string
     */
    @PostMapping("/upload") 
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:showErrorMessage";
        }
        
        String contentType = file.getContentType();
        LOGGER.info("contentType = " + contentType);
        boolean mimeAllowChecker = FileUtil.mimeAllowChecker(contentType);
        LOGGER.info("mimeAllowChecker = " + mimeAllowChecker);
        
        
        if (mimeAllowChecker == Boolean.FALSE) {
            redirectAttributes.addFlashAttribute("message", "Please select a valid file type to upload");
            return "redirect:showErrorMessage";
        }

        try {
        	
        	int verifiedMimeResult = FileUtil.verifyMime(file.getInputStream(), file.getOriginalFilename());
        	
        	String message = "";
        	if (verifiedMimeResult == 1) {
        		message = "Mime information cannot be retrieved from the stream.";
        		LOGGER.error(message);
        		redirectAttributes.addFlashAttribute("message", message);
                return "redirect:showErrorMessage";
        	} else if (verifiedMimeResult == 2) {
        		message = "Mime not supported by the system.";
        		LOGGER.error(message);
        		redirectAttributes.addFlashAttribute("message", message);
                return "redirect:showErrorMessage";
        	} else if (verifiedMimeResult == 3) {
        		message = "Mime type doesn't match with the file extension provided.";
        		LOGGER.error(message);
        		redirectAttributes.addFlashAttribute("message", message);
                return "redirect:showErrorMessage";
        	} else {
        		message = "Mime information cannot be retrieved from the stream.";
        		LOGGER.info(message);
        	}

            FileUploadUtil.convertPagesFileToPDF(file);
            
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException exception) {
        	LOGGER.error("Message = ", exception.getMessage());
        	LOGGER.error("exception = ", exception);
        	redirectAttributes.addFlashAttribute("message", exception.getMessage());
            return "redirect:showErrorMessage";
        } catch (Exception exception) {
        	LOGGER.error("Message = ", exception.getMessage());
        	LOGGER.error("exception = ", exception);
        	redirectAttributes.addFlashAttribute("message", exception.getMessage());
            return "redirect:showErrorMessage";
        } 

        return "redirect:/uploadStatus";
    }

	/**
	 * Upload status.
	 *
	 * @return the string
	 */
	@GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
    
    /**
     * Show error message.
     *
     * @return the string
     */
    @GetMapping("/showErrorMessage")
    public String showErrorMessage() {
        return "uploadError";
    }
}