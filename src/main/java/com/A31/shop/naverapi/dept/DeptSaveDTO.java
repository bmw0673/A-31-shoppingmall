package com.A31.shop.naverapi.dept;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class DeptSaveDTO {
	
	@JsonIgnore
    private String externalKey;              // "dept0000",
    private String name;               		 // "최영진",
    private String parentDeptExternalKey;    // null,
    private String dispOrd;                	 // "1.0",
}
