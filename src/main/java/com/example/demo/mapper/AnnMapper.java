package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.AnnounceVO;
import com.example.demo.model.PagingVO;

@Mapper
public interface AnnMapper {
	List<AnnounceVO> ann_selectAll(PagingVO vo) throws Exception;
	int ann_insert(AnnounceVO vo);
	int countBoard();
	AnnounceVO ann_selectOne(int num);
	int ann_update(AnnounceVO vo);
	int ann_delete(String num);
}
