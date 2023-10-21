package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.AnnounceVO;
import com.example.demo.model.PagingVO;

@Mapper
public interface BoardMapper {
	List<AnnounceVO> ann_selectAll(PagingVO vo) throws Exception;
	int ann_insert(AnnounceVO vo);
	int countBoard();
}
