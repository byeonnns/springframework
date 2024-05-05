package com.mycompany.springframework.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Ch13Board {
	private int bno;
	private String btitle;
	private String bcontent;
	private Date bdate;
	private String mid;
	private int bhitcount;
	private String battachoname;
	private String battachsname;
	private String battachtype;
	private byte[] battachdata; // Blob 타입으로 받아도 됨
	
	private MultipartFile battach; // 첨부파일은 이 타입으로 받아야 한다
}
