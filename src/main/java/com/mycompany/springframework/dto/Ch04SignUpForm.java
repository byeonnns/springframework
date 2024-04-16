package com.mycompany.springframework.dto;

import lombok.Data;

@Data
public class Ch04SignUpForm {
	private String mid;
	private String mpassword;
	private String mname;
	private String memail;
	private String mphone;
}
