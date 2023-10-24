package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BoardMapper;
import com.example.demo.model.AnnounceVO;
import com.example.demo.model.PagingVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AnnounceServiceimpl implements AnnounceService {
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<AnnounceVO> ann_selectAll(PagingVO vo) throws Exception {
		log.info("ann_selectAll...serviceimpl PagingVO" + vo);
		return boardMapper.ann_selectAll(vo);
	}

	@Override
	public int ann_insert(AnnounceVO vo) {
		log.info("ann_insert...serviceimpl");
		int result = boardMapper.ann_insert(vo);
		return result;
	}

	@Override
	public int countBoard() {
		log.info("countBoard...serviceimpl");
		return boardMapper.countBoard();
	}

	@Override
	public AnnounceVO ann_selectOne(String num) {
		return boardMapper.ann_selectOne(num);
	}

	@Override
	public int ann_update(AnnounceVO vo) {
		return boardMapper.ann_update(vo);
	}
	
	
}
