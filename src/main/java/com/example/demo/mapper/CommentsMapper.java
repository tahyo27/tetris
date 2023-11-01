package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.CommentsVO;

@Mapper
public interface CommentsMapper {
	
	List<CommentsVO> cm_selectAll();
	int cm_pInsert(CommentsVO vo);
	int cm_pUpdate(CommentsVO vo);
}
