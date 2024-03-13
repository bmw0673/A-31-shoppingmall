package com.A31.shop.service.admin;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;


public interface AdminService {
	
	public Map<String, String> s3Upload(AmazonS3Client s3Client, String bucket, String path, MultipartFile img);
	
	public Map<String, String> classPathUpload(String path, MultipartFile tempImg);
	
	public ObjectMetadata objectMetadata(MultipartFile mf);
	
	public String newFileName(String orgName);
	
	public String newFileNameByNanotime(String orgName);
	
	
	
	
	
	
	
	
}
