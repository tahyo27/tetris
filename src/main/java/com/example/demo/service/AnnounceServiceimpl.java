package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BoardMapper;
import com.example.demo.model.AnnounceVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AnnounceServiceimpl implements AnnounceService {
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<AnnounceVO> ann_selectAll() throws Exception {
		log.info("ann_selectAll...serviceimpl");
		return boardMapper.ann_selectAll();
	}

	@Override
	public int ann_insert(AnnounceVO vo) {
		log.info("ann_insert...serviceimpl");
		int result = boardMapper.ann_insert(vo);
		return result;
	}
	
	
}
