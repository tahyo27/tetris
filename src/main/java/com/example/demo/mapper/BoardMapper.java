package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.AttachVO;
import com.example.demo.model.BoardVO;
import com.example.demo.model.ImageVO;
import com.example.demo.model.PagingVO;

@Mapper
public interface BoardMapper {
	int img_insert(ImageVO vo);
	int bd_insert(BoardVO vo);
	BoardVO bd_selectOne(int num);
	int getBoardSeq();
	int bd_attach_update(BoardVO vo);
	int bd_img_update(BoardVO vo);
	List<BoardVO> bd_selectAll(PagingVO vo);
	int bd_countBoard();
	int at_insert(AttachVO vo);
	AttachVO at_selectOne(int num);
	ImageVO img_selectOne(int num);
	BoardVO bd_deleteCheck(BoardVO vo);
	int bd_delete(int num);
	int bd_cmDelete (int num);
	int bd_update(BoardVO vo);
}
