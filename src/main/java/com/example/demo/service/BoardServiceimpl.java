package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BoardMapper;
import com.example.demo.model.BoardVO;
import com.example.demo.model.ImageVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceimpl implements BoardService{
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public int img_insert(ImageVO vo) {
		log.info("img_insert.... boardservice");
		return boardMapper.img_insert(vo);
	}

	@Override
	public int bd_insert(BoardVO vo) {
		log.info("bd_insert.... boardservice");
		return boardMapper.bd_insert(vo);
	}

	@Override
	public int getBoardSeq() {
		log.info("getBoardSeq.... boardservice");
		return boardMapper.getBoardSeq();
	}

	@Override
	public int bd_attach_update(BoardVO vo) {
		log.info("bd_attach_update.... boardservice");
		return boardMapper.bd_attach_update(vo);
	}

	@Override
	public int bd_img_update(BoardVO vo) {
		log.info("bd_img_update.... boardservice");
		return boardMapper.bd_img_update(vo);
	}

}
