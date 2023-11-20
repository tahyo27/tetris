package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.ScoreMapper;
import com.example.demo.model.ScoreVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScoreServiceimpl implements ScoreService {
	
	@Autowired
	private ScoreMapper scoreMapper;
	
	@Override
	public List<ScoreVO> score_selectAll() throws Exception {
		log.info("score_selectAll...serviceimpl");
		return scoreMapper.score_selectAll();
	}

	@Override
	public int score_insert(ScoreVO vo) {
		log.info("score_insert...serviceimpl");
		return scoreMapper.score_insert(vo);
	}

}
