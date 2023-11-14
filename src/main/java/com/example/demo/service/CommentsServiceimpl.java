package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CommentsMapper;
import com.example.demo.model.CommentsVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentsServiceimpl implements CommentsService{
	
	@Autowired
	CommentsMapper commentsMapper;
	
	@Override
	public List<CommentsVO> cm_selectAll(int bd_num) {
		log.info("Comments Service.... cm_selectAll() bd_num:" + bd_num);
		return commentsMapper.cm_selectAll(bd_num);
	}

	@Override
	public int cm_pInsert(CommentsVO vo) {
		log.info("Comments Service.... cm_pInsert()");
		return commentsMapper.cm_pInsert(vo);
	}

	@Override
	public int cm_pUpdate(CommentsVO vo) {
		log.info("Comments Service.... cm_pUpdate()");
		return commentsMapper.cm_pUpdate(vo);
	}

	@Override
	public int cm_selectStep(int cm_num) {
		log.info("Comments cm_selectPnum().... cm_num:" + cm_num);
		return commentsMapper.cm_selectStep(cm_num);
	}

}
