package com.A31.shop.service.amdinprocess;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Component
public class FileUplodUtil  {
	
	/**
	 * temp경로에서 새로운경로로 이미지를 이동시키기위한 메서드
	 * 
	 * 
	 * @param client  --> AmazonS3Client client
	 * @param bucketName : 버킷이름
	 * @param uploadPath : 버킷내부 새로운경로 ex> /goods/images/
	 * @param tempKey    : 이동할 이미지의 key
	 * @param orgName    : 원본파일일름 내부에서 새로운 이름으로변경됨
	 * @return
	 */
	public String fromTempToImages(AmazonS3Client client, String bucketName, String uploadPath, String tempKey, String orgName ) {
		
		String uploadKey=uploadPath+ newFileNameByNanotime(orgName);
		CopyObjectRequest cor=new CopyObjectRequest(bucketName, tempKey, bucketName, uploadKey);
		
		client.copyObject(cor.withCannedAccessControlList(CannedAccessControlList.PublicRead));
		
		//원본은 삭제
		client.deleteObject(bucketName, tempKey);
		
		return uploadKey;		
	}
	
	
	public Map<String, String> s3Upload(AmazonS3Client s3Client, String bucket, String path, MultipartFile img) {
		// 버킷 내부의 이미지 경로
		String bucketKey = path + newFileNameByNanotime(img.getOriginalFilename());

		try {
			PutObjectRequest or = new PutObjectRequest(bucket, bucketKey, img.getInputStream(), objectMetadata(img));
			s3Client.putObject(or.withCannedAcl(CannedAccessControlList.PublicRead));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String, String> result = new HashMap<>();
		result.put("url", s3Client.getUrl(bucket, bucketKey).toString().substring(6));
		result.put("bucketKey", bucketKey);
		result.put("orgName", img.getOriginalFilename());
		return result;
	}

	public Map<String, String> classPathUpload(String path, MultipartFile tempImg) {
		ClassPathResource cpr = new ClassPathResource("static" + path);
		String newFileName = newFileName(tempImg.getOriginalFilename());
		try {
			File folder = cpr.getFile();
			if (!folder.exists())
				folder.createNewFile();

			tempImg.transferTo(new File(folder, newFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String, String> result = new HashMap<>();
		result.put("url", path + newFileName);
		result.put("orgName", tempImg.getOriginalFilename());
		return result;

	}

	public ObjectMetadata objectMetadata(MultipartFile mf) {
		ObjectMetadata objectMetadata=new ObjectMetadata();
		objectMetadata.setContentType(mf.getContentType());//파일타입
		objectMetadata.setContentLength(mf.getSize());//파일사이즈
		return objectMetadata;
	}

	public String newFileName(String orgName) {
		int idx=orgName.lastIndexOf(".");
		return UUID.randomUUID().toString() //새로운이름을 UUID로 생성
				+ orgName.substring(idx); //.확장자
	}

	public String newFileNameByNanotime(String orgName) {
		int idx=orgName.lastIndexOf(".");
		return orgName.substring(0, idx)+"-"+(System.nanoTime()/1000000)
				+ orgName.substring(idx); //.확장자
	}

}
