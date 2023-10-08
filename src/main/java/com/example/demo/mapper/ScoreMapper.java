package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.ScoreVO;

@Mapper
public interface ScoreMapper {
	List<ScoreVO> score_selectAll() throws Exception;
}
