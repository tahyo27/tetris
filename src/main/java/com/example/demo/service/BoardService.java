package com.example.demo.service;

import com.example.demo.model.BoardVO;
import com.example.demo.model.ImageVO;

public interface BoardService {
	int img_insert(ImageVO vo);
	int bd_insert(BoardVO vo);
	int getBoardSeq();
	int bd_attach_update(BoardVO vo); //첨부파일 업데이트
	int bd_img_update(BoardVO vo); // 이미지파일 보드에 업데이트
}
