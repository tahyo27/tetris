package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AttachVO;
import com.example.demo.model.BoardVO;
import com.example.demo.model.ImageVO;
import com.example.demo.model.PagingVO;

public interface BoardService {
	int img_insert(ImageVO vo);
	int bd_insert(BoardVO vo);
	int getBoardSeq();
	int bd_attach_update(BoardVO vo); //첨부파일 업데이트
	int bd_img_update(BoardVO vo); // 이미지파일 보드에 업데이트
	List<BoardVO> bd_selectAll(PagingVO vo);
	BoardVO bd_selectOne(int num);
	int bd_countBoard();
	int at_insert(AttachVO vo);
	AttachVO at_selectOne(int num);
	ImageVO img_selectOne(int num);
}
