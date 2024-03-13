package com.A31.shop.naverapi.dept;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Element {
	//private String tenantId;                 // "de2c8af6-3d24-4758-be05-1ea2a7ae5e67",
    //private String companyId;                // "de2c8af6-3d24-4758-be05-1ea2a7ae5e67",
    private String externalKey;              // "dept0000",
    private String name;               		 // "최영진",
    //private Object i18nNames;                // {},
    //private String parentDeptExternalKey;    // null,
    //private String deptLeaderExternalKey;    // null,
    //private String deptEmailAddress;         // "ac00010278@acamptest.by-works.com",
    //private String externalEmailReceiveYn;   // false,
    private String dispOrd;                	 // "1.0",
    private String deptNo;          	     // "de2c8af6-3d24-4758-be05-1ea2a7ae5e67",
    private String parentDeptNo;           	 // "#",
    private String deptLeaderEmpId;          // null
}
