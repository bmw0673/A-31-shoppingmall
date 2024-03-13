package com.A31.shop.service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.A31.shop.domain.dto.CompanyInfoDTO;
import com.A31.shop.domain.entity.CompanyInfoEntity;
import com.A31.shop.domain.entity.CompanyInfoEntityRepository;
import com.A31.shop.naverapi.OpenApiUtil;
import com.A31.shop.naverapi.dept.DeptListDTO;
import com.A31.shop.naverapi.dept.DeptSaveDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Service
@Log4j2
public class CompanyService {
	
	@Value("${naver.ncp.access-key}")
	private String accessyKey;
	
	@Value("${naver.ncp.secret-key}")
	private String secretKey;
	
	@Value("${naver.ncp.company-id}")
	private String companyId;
	
	private final CompanyInfoEntityRepository companyRepo;
	
	private final OpenApiUtil naverApi;
	
	/*
	 * 푸터 회사정보 가져오기
	 */
	@GetMapping("/footerInfo")
	public ModelAndView footerInfo(ModelAndView mv) {
		CompanyInfoEntity company;
		
		company = companyRepo.findById(1L)
				.orElseThrow(() -> new EntityNotFoundException("ID가 1인 회사를 찾을 수 없습니다."));
		
		CompanyInfoDTO footerInfo = company.toCompanyInfoDTO();
		
		mv.addObject("footerInfo", footerInfo);
		mv.setViewName("/layout/footer");
		
		return mv;
	}
	
	/**
	 * 관리자페이지 회사정보 수정
	 * @return 회사정보 DTO
	 */
	public CompanyInfoDTO companyInfo() {
		CompanyInfoDTO companyInfo = companyRepo.findById(1L).orElseThrow().toCompanyInfoDTO();
		return companyInfo;
	}
	
	//////////////////////////네이버API 활용///////////////////////////////////////////////
	
	/**
	 * 네이버API를 요청하기 위한 SignatureKey 생성
	 * @param _method : "POST" or "GET"
	 * @param _url : 요청 url
	 * @param _timestamp : String.valueOf(System.currentTimeMillis());
	 * @return SHA256암호화를 사용한 SignatureKey
	 */
	private String makeSignature(String _method, String _url, String _timestamp) {
		String space = " ";						// one space
		String newLine = "\n";					// new line
		String method = _method;				// method
		String url = _url;						// url (include query string)
		String timestamp = _timestamp;			// current timestamp (epoch)
		String accessKey = "{accessKey}";		// access key id (from portal or Sub Account)

		String message = new StringBuilder()
			.append(method)
			.append(space)
			.append(url)
			.append(newLine)
			.append(timestamp)
			.append(newLine)
			.append(accessyKey)
			.toString();

		SecretKeySpec signingKey;
		String encodeBase64String=null;
		try {
			signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(signingKey);
			
			byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
			encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  return encodeBase64String;
	}
	
	/**
	 * HttpHeader 헤더 생성
	 * @param method : "POST" or "GET"
	 * @param url : 요청url
	 * @return HttpHeader 
	 */
	private Map<String, String> requestHttpHeader(String method, String url) {
		String timestamp = String.valueOf(System.currentTimeMillis());
		
		
		//sinature-key 생성 메서드
		String sinature=makeSignature(method, url, timestamp);
		
		Map<String, String> header = new HashMap();
		header.put("x-ncp-apigw-timestamp", timestamp);
		header.put("x-ncp-iam-access-key", accessyKey);
		header.put("x-ncp-apigw-signature-v2", sinature);
		return header;
	}

	/*
	 * 부서목록 조회 
	 */
	public void deptList(Model model) {
		String url = "/organization/apigw/v2/company/"+companyId+"/department";
		String method="GET";
		
		//요청할때 필요한 헤더정보
		Map<String, String> header = requestHttpHeader(method, url);
		
		String host = "https://workplace.apigw.ntruss.com";
		String jsonFormatStringresult = naverApi.request(host+url, header, method, null);
		
		ObjectMapper objectMapper = new ObjectMapper();
		DeptListDTO result=null;
		try {
			result = objectMapper.readValue(jsonFormatStringresult, DeptListDTO.class);
		} catch (Exception e) {
			System.out.println(">>>>>>>>>jsonTojava mapping error!!");
		}
		model.addAttribute("list", result.getElements());
	}
	
	/**
	 * 부서 등록
	 * @param model
	 * @param dto : HttpBody 내용
	 */
	public void saveDept(DeptSaveDTO dto) {
		String url = "/organization/apigw/v2/company/"+companyId+"/department/"+dto.getExternalKey();
		String method="POST";
		String host = "https://workplace.apigw.ntruss.com";
		
		//요청할때 필요한 헤더정보
		Map<String, String> httpHeader = requestHttpHeader(method, url);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String httpBody = null;
		try {
			httpBody=mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		httpHeader.put("Content-Type", "application/json");
		
		String jsonFormatStringresult = naverApi.request(host+url, httpHeader, method, httpBody);
	}


	public void update(Long companyId, CompanyInfoDTO dto) {
		
		CompanyInfoEntity companyInfoEntity = companyRepo.findById(companyId).orElseThrow();
		
		
		companyInfoEntity.update(dto);
		companyRepo.save(companyInfoEntity);
		
	}
	
	
	
}
