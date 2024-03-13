package com.A31.shop.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.A31.shop.domain.dto.CompanyInfoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CompanyInfo")
@Entity
public class CompanyInfoEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long no;
	
	private String csTel; //고객센터 전화번호
	
	private String operatingTime; //운영시간
	
	private String lunchTime; //점심시간
	
	private String companyName; //회사이름
	
	private String ceoName; //대표이름
	
	private String adress; //주소
	
	private String asTel; //a/s센터 전화번호
	
	private String businessNum; //통신판매업신고번호
	
	private String comRegNum; //사업자등록번호
	
	
	public CompanyInfoDTO toCompanyInfoDTO() {
		return CompanyInfoDTO.builder()
				.adress(adress).asTel(asTel).businessNum(businessNum).ceoName(ceoName)
				.companyName(companyName).comRegNum(comRegNum).csTel(csTel).operatingTime(operatingTime)
				.no(no)
				.lunchTime(lunchTime)
				.build();
	}
	
	public void update(CompanyInfoDTO dto) {
		
		this.operatingTime = dto.getOperatingTime();
		this.lunchTime =dto.getLunchTime();
		this.companyName = dto.getCompanyName();
		this.ceoName = dto.getCeoName();
		this.adress = dto.getAdress();
		this.asTel = dto.getAsTel();
		this.businessNum = dto.getBusinessNum();
		this.comRegNum = dto.getComRegNum();
		              
	}
}
