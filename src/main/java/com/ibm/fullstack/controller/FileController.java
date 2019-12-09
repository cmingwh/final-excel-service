package com.ibm.fullstack.controller;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.fullstack.service.FileService;
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class FileController {
	private static final Logger logger = Logger.getLogger(FileController.class.getName());
	
	private final FileService fileService;
	 
	@Autowired
	public FileController(FileService fileService) {
		this.fileService = fileService;
	}
 
	@PostMapping(value = "/api/files")
	@ResponseStatus(HttpStatus.OK)
	public void handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		fileService.storeFile(file);
	}
//	
//	@PostMapping("/upload")
//	public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) throws Exception {
//		if (file == null) {
//			throw new RuntimeException("You must select the a file for uploading");
//		}
//		InputStream inputStream = file.getInputStream();
//		String originalName = file.getOriginalFilename();
//		String name = file.getName();
//		String contentType = file.getContentType();
//		long size = file.getSize();
//		logger.info("inputStream: " + inputStream);
//		logger.info("originalName: " + originalName);
//		logger.info("name: " + name);
//		logger.info("contentType: " + contentType);
//		logger.info("size: " + size);
//		// Do processing with uploaded file data in Service layer
//		return new ResponseEntity<String>(originalName, HttpStatus.OK);
//	}
}