package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ScoreVO;

public interface ScoreService {
	List<ScoreVO> score_selectAll() throws Exception;
	int score_insert(ScoreVO vo);
}
