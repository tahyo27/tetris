package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BoardMapper;
import com.example.demo.model.AttachVO;
import com.example.demo.model.BoardVO;
import com.example.demo.model.ImageVO;
import com.example.demo.model.PagingVO;

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

	@Override
	public List<BoardVO> bd_selectAll(PagingVO vo) {
		log.info("bd_selectAll...serviceimpl PagingVO" + vo);
		return boardMapper.bd_selectAll(vo);
	}

	@Override
	public int bd_countBoard() {
		log.info("bd_countBoard.... boardservice");
		return boardMapper.bd_countBoard();
	}

	@Override
	public BoardVO bd_selectOne(int num) {
		log.info("bd_selectOne.... boardservice");
		return boardMapper.bd_selectOne(num);
	}

	@Override
	public int at_insert(AttachVO vo) {
		log.info("at_insert.... boardservice");
		return boardMapper.at_insert(vo);
	}

	@Override
	public AttachVO at_selectOne(int num) {
		log.info("at_selectOne.... boardservice");
		return boardMapper.at_selectOne(num);
	}

	@Override
	public ImageVO img_selectOne(int num) {
		log.info("at_selectOne.... boardservice");
		return boardMapper.img_selectOne(num);
	}

	@Override
	public BoardVO bd_deleteCheck(BoardVO vo) {
		log.info("bd_deleteCheck.... boardservice");
		return boardMapper.bd_deleteCheck(vo);
	}

	@Override
	public int bd_delete(int num) {
		log.info("bd_delete.... boardservice");
		return boardMapper.bd_delete(num);
	}

	@Override
	public int bd_cmDelete(int num) {
		log.info("bd_cmDelete.... boardservice");
		return boardMapper.bd_cmDelete(num);
	}

	@Override
	public int bd_update(BoardVO vo) {
		log.info("bd_update.... boardservice vo:" + vo);
		return boardMapper.bd_update(vo);
	}

}
