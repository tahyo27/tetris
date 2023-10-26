package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.BoardVO;
import com.example.demo.model.ImageVO;

@Mapper
public interface BoardMapper {
	int img_insert(ImageVO vo);
	int bd_insert(BoardVO vo);
	BoardVO bd_selectOne(int num);
	int getBoardSeq();
}
