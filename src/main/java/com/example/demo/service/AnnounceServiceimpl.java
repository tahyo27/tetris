package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.AnnMapper;
import com.example.demo.model.AnnounceVO;
import com.example.demo.model.PagingVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AnnounceServiceimpl implements AnnounceService {
	
	@Autowired
	private AnnMapper annMapper;

	@Override
	public List<AnnounceVO> ann_selectAll(PagingVO vo) throws Exception {
		log.info("ann_selectAll...serviceimpl PagingVO" + vo);
		return annMapper.ann_selectAll(vo);
	}

	@Override
	public int ann_insert(AnnounceVO vo) {
		log.info("ann_insert...serviceimpl");
		int result = annMapper.ann_insert(vo);
		return result;
	}

	@Override
	public int countBoard() {
		log.info("countBoard...serviceimpl");
		return annMapper.countBoard();
	}

	@Override
	public AnnounceVO ann_selectOne(int num) {
		log.info("ann_selectOne...serviceimpl");
		return annMapper.ann_selectOne(num);
	}

	@Override
	public int ann_update(AnnounceVO vo) {
		log.info("ann_update...serviceimpl");
		return annMapper.ann_update(vo);
	}

	@Override
	public int ann_delete(String num) {
		log.info("ann_delete...serviceimpl");
		return annMapper.ann_delete(num);
	}
	
	
}
