package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AnnounceVO;

public interface AnnounceService {
	List<AnnounceVO> ann_selectAll() throws Exception;
	int ann_insert(AnnounceVO vo);
}
