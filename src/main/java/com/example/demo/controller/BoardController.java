package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.BoardVO;
import com.example.demo.model.UploadFile;
import com.example.demo.service.FileStore;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	@Autowired
	private FileStore fileStore;
	
	@GetMapping("bd_selectAll.do")
	public String bd_selectAll() {
		return "";
	}
	
	@GetMapping("bd_insert.do")
	public String bd_insert() {
		log.info("board controller...bd_insert()");
		return "WEB-INF/views/board/bd_insert.jsp";
	}
	
	@PostMapping("bd_insertOK.do")
	public String bd_insertOK(BoardVO vo) throws IOException {
		log.info("bd_insertOK..... vo" + vo);
		//이미지 처리
		UploadFile attachFile = fileStore.storeFile(vo.getAttachFile());
		List<UploadFile> imageFiles = fileStore.storeFiles(vo.getImageFiles());
		for(UploadFile x : imageFiles) {
			System.out.println("upload img" + x);
		}
		vo.setAttach(attachFile);
		vo.setImage(imageFiles);
		
		log.info("insertOK vo:" + vo);
		return "WEB-INF/views/board/bd_insert.jsp";
	}
}
