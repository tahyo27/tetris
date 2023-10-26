package com.example.demo.model;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardVO {
	private int bd_num;
	private String bd_title;
	private String bd_content;
	private String bd_writer;
	private Timestamp bd_date;
	private int bd_vcount;
	private String bd_pwd;
	//html에서 받음
	private MultipartFile attachFile; // 첨부 파일
	private List<MultipartFile> imageFiles; // 첨부 이미지
	//서버에 들어갈 이름 저장
	private String bd_attach;   
	//이미지 여러개 들어가는곳 num값;
	private int img_num;
}
