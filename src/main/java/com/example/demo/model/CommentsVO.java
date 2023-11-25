package com.example.demo.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CommentsVO {
	 private int cm_num;
	 private String cm_writer;
	 private String cm_content;
	 private Timestamp cm_date;
	 private int cm_bdnum; //게시판글 번호
	 private int cm_pnum; // 부모글 번호
	 private int cm_step; // 들여쓰기
	 private String cm_pwd;

}
