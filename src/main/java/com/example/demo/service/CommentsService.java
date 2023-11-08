package com.example.demo.service;

import java.util.List;

import com.example.demo.model.CommentsVO;

public interface CommentsService {
	
	List<CommentsVO> cm_selectAll(int bd_num);
	int cm_pInsert(CommentsVO vo);
	int cm_pUpdate(CommentsVO vo);
}
