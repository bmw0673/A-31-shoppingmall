package com.A31.shop.domain.dto;

import com.A31.shop.domain.entity.CompanyInfoEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class CompanyInfoDTO {
	
	private Long no;
	
	private String csTel; //고객센터 전화번호
	
	private String operatingTime; //운영시간
	
	private String lunchTime; //점심시간
	
	private String companyName; //회사이름
	
	private String ceoName; //대표이름
	
	private String adress; //주소
	
	private String asTel; //a/s센터 전화번호
	
	private String businessNum; //통신판매업신고번호
	
	private String comRegNum; //사업자등록번호
	
	public CompanyInfoEntity toEntity() {
		return CompanyInfoEntity.builder()
				.adress(adress).asTel(asTel).businessNum(businessNum).ceoName(ceoName)
				.companyName(companyName).comRegNum(comRegNum).csTel(csTel).operatingTime(operatingTime)
				.lunchTime(lunchTime)
				.build();
	}
}
