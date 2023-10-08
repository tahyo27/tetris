package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.AnnounceVO;

@Mapper
public interface BoardMapper {
	List<AnnounceVO> ann_selectAll() throws Exception;
}
