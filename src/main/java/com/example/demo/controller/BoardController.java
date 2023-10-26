package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.BoardVO;
import com.example.demo.model.ImageVO;
import com.example.demo.model.UploadFile;
import com.example.demo.service.BoardService;
import com.example.demo.service.FileStore;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	@Autowired
	private FileStore fileStore;
	
	@Autowired
	private BoardService boardService;
	
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
		//먼저 인서트하고
		int bdinsert = boardService.bd_insert(vo);
		int bdseq = boardService.getBoardSeq();// 시퀀스값
		//이미지 처리는 update로 수정
		if(!vo.getAttachFile().isEmpty()) {
			UploadFile attachFile = fileStore.storeFile(vo.getAttachFile());
			vo.setBd_attach(attachFile.getStoreFilename());
		} 
		if(!vo.getImageFiles().isEmpty()) {
			List<UploadFile> imageFiles = fileStore.storeFiles(vo.getImageFiles());
			ImageVO img = new ImageVO();
			switch (imageFiles.size()) {
		    case 1:
		        img.setImg_first(imageFiles.get(0).getStoreFilename());
		        break;
		    case 2:
		    	img.setImg_first(imageFiles.get(0).getStoreFilename());
		    	img.setImg_second(imageFiles.get(1).getStoreFilename());
		        break;
		    case 3:
		    	img.setImg_first(imageFiles.get(0).getStoreFilename());
		    	img.setImg_second(imageFiles.get(1).getStoreFilename());
		        img.setImg_third(imageFiles.get(2).getStoreFilename());
		        break;
			}
		}
		
		
		
		
		System.out.println("bdseq값:" + bdseq + "bd insert값:" + bdinsert);
		
		
		log.info("insertOK vo:" + vo);
		return "WEB-INF/views/board/bd_insert.jsp";
	}//end insertOK
	
}//end BoardController
