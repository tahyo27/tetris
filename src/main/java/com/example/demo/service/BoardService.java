package com.example.demo.service;

import com.example.demo.model.BoardVO;
import com.example.demo.model.ImageVO;

public interface BoardService {
	int img_insert(ImageVO vo);
	int bd_insert(BoardVO vo);
	int getBoardSeq();
}
