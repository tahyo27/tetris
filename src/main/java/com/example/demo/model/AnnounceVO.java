package com.example.demo.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AnnounceVO {
	private int an_num;
	private String an_title;
	private String an_content;
	private String an_writer;
	private Timestamp an_date;
	private int an_vcount;
}
