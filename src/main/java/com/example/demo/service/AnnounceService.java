package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AnnounceVO;
import com.example.demo.model.PagingVO;

public interface AnnounceService {
	List<AnnounceVO> ann_selectAll(PagingVO vo) throws Exception;
	int ann_insert(AnnounceVO vo);
	int countBoard();
}
