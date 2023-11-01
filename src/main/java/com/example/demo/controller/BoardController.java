package com.example.demo.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriUtils;

import com.example.demo.model.AttachVO;
import com.example.demo.model.BoardVO;
import com.example.demo.model.ImageVO;
import com.example.demo.model.PagingVO;
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
	public String bd_selectAll(Model model, PagingVO vo,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) throws Exception {
		log.info("bd_selectAll PagingVO", vo);
		int total = boardService.bd_countBoard();
		log.info("total...{}", total);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", vo);
		model.addAttribute("vos", boardService.bd_selectAll(vo));
		return "WEB-INF/views/board/board.jsp";
	}

	@GetMapping("bd_insert.do")
	public String bd_insert() {
		log.info("board controller...bd_insert()");
		return "WEB-INF/views/board/bd_insert.jsp";
	}

	@PostMapping("bd_insertOK.do")
	public String bd_insertOK(BoardVO vo) throws IOException {
		log.info("bd_insertOK..... vo" + vo);
		// 먼저 인서트하고
		int bdinsert = boardService.bd_insert(vo);
		int bdseq = boardService.getBoardSeq();// 시퀀스값을받아온후에 그 값을 img테이블에 저장후 다시 보드에 업데이트
		List<UploadFile> imageFiles = fileStore.storeFiles(vo.getImageFiles());
		for (UploadFile x : imageFiles) {
			log.info("이미지파일 들어오는거 확인" + x);
		}
		// 이미지 처리는 update로 수정
		if (!vo.getAttachFile().isEmpty()) { // 첨부파일에 값 들어있으면
			UploadFile attachFile = fileStore.storeFile(vo.getAttachFile());
			AttachVO at = new AttachVO();
			at.setAt_num(bdseq);
			at.setAt_oname(attachFile.getUploadFilename());
			at.setAt_sname(attachFile.getStoreFilename());
			int atinsert = boardService.at_insert(at);
			vo.setAt_num(bdseq);
			vo.setBd_num(bdseq); // seq넘버 세팅하고
			int bdAttach = boardService.bd_attach_update(vo);
			log.info("보드의 at_num 확인용:" + bdAttach + " Attach업데이트 확인:" + atinsert);
		}
		if (!imageFiles.isEmpty()) {
			log.info("이미지 엠티아니면");
			ImageVO img = new ImageVO();
			img.setImg_num(bdseq);
			switch (imageFiles.size()) {
			case 1:
				img.setImg_first(imageFiles.get(0).getStoreFilename());
				img.setImg_ofirst(imageFiles.get(0).getUploadFilename());
				img.setImg_osecond("default.png");
				img.setImg_second("default.png");
				img.setImg_othird("default.png");
				img.setImg_third("default.png");
				break;
			case 2:
				img.setImg_first(imageFiles.get(0).getStoreFilename());
				img.setImg_ofirst(imageFiles.get(0).getUploadFilename());
				img.setImg_second(imageFiles.get(1).getStoreFilename());
				img.setImg_osecond(imageFiles.get(1).getUploadFilename());
				img.setImg_third("default.png");
				img.setImg_othird("default.png");
				break;
			case 3:
				img.setImg_first(imageFiles.get(0).getStoreFilename());
				img.setImg_ofirst(imageFiles.get(0).getUploadFilename());
				img.setImg_second(imageFiles.get(1).getStoreFilename());
				img.setImg_osecond(imageFiles.get(1).getUploadFilename());
				img.setImg_third(imageFiles.get(2).getStoreFilename());
				img.setImg_othird(imageFiles.get(2).getUploadFilename());
				break;
			}
			int imgInsert = boardService.img_insert(img);
			log.info("img 들어가는거 확인" + img + "img인서트 결과 확인" + imgInsert);
			vo.setImg_num(img.getImg_num());
			vo.setBd_num(bdseq);
			int bdImgupdate = boardService.bd_img_update(vo);
			log.info("bdImgupdate 결과 확인" + bdImgupdate);
		}

		System.out.println("bdseq값:" + bdseq + " bd insert값:" + bdinsert);

		log.info("insertOK vo:" + vo);
		return "WEB-INF/views/board/bd_insert.jsp";

	}// end insertOK

	@GetMapping("bd_selectone.do")
	public String bd_selectone(Model model, String num) {
		log.info("bd_selectone....num" + num);
		int num1 = Integer.parseInt(num);

		BoardVO selectOne = boardService.bd_selectOne(num1);
		AttachVO attachOne = boardService.at_selectOne(num1);
		ImageVO imgOne = boardService.img_selectOne(num1);
		model.addAttribute("at", attachOne);
		model.addAttribute("img", imgOne);
		model.addAttribute("vo2", selectOne);
		return "WEB-INF/views/board/bd_selectone.jsp";
	}

	@ResponseBody
	@GetMapping("/images/{filename}")
	public Resource showImage(@PathVariable String filename) throws MalformedURLException {
		return new UrlResource("file:" + fileStore.getFullPath(filename)); // 파일 경로 url 반환
	}

	@GetMapping("/imgdown/{id}/{num}")
	public ResponseEntity<Resource> imageDown(@PathVariable int id, @PathVariable int num) throws MalformedURLException {
		ImageVO imgselectOne = boardService.img_selectOne(id);
		log.info("Image 확인용 :" + imgselectOne + "id 확인용:" + id + "num확인용:" + num);
		String storeFilename;
		String uploadFilename;
		if(num == 1) {
			storeFilename = imgselectOne.getImg_first();
			uploadFilename = imgselectOne.getImg_ofirst();
		} else if(num == 2) {
			storeFilename = imgselectOne.getImg_second();
			uploadFilename = imgselectOne.getImg_osecond();
		} else {
			storeFilename = imgselectOne.getImg_third();
			uploadFilename = imgselectOne.getImg_othird();
		}
		
		UrlResource urlResource = new UrlResource("file:" + fileStore.getFullPath(storeFilename));
		String encodedUploadFileName = UriUtils.encode(uploadFilename, StandardCharsets.UTF_8);
		String contentDisposition = "attachment; filename=\"" + encodedUploadFileName + "\""; // 특수문자 때문에 \""처리 해줌

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition).body(urlResource);
		
	}

	@GetMapping("/attachdown/{id}")
	public ResponseEntity<Resource> attachDown(@PathVariable int id) throws MalformedURLException {
		AttachVO atselectOne = boardService.at_selectOne(id);
		log.info("Attach 확인용 :" + atselectOne);
		String storeFilename = atselectOne.getAt_sname();
		String uploadFilename = atselectOne.getAt_oname();

		UrlResource urlResource = new UrlResource("file:" + fileStore.getFullPath(storeFilename));
		String encodedUploadFileName = UriUtils.encode(uploadFilename, StandardCharsets.UTF_8);
		String contentDisposition = "attachment; filename=\"" + encodedUploadFileName + "\""; // 특수문자 때문에 \""처리 해줌

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition).body(urlResource);
	}

}// end BoardController
