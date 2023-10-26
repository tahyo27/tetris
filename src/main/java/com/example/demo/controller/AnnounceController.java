package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.AnnounceVO;
import com.example.demo.model.PagingVO;
import com.example.demo.service.AnnounceService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AnnounceController {
	
	@Autowired
	private AnnounceService annService;
	
	@GetMapping("announce.do")
	public String announce_selectAll(Model model, PagingVO vo 
			,@RequestParam (value="nowPage", required = false)String nowPage
			,@RequestParam (value="cntPerPage",required = false)String cntPerPage) throws Exception {
		log.info("announce_selectAll PagingVO", vo);
		int total = annService.countBoard();
		log.info("total...{}",total);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		}else if(nowPage == null) {
			nowPage = "1";	
		}else if(cntPerPage == null) {
			cntPerPage = "5";
		}
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging",vo);
		model.addAttribute("vos", annService.ann_selectAll(vo));
		return "WEB-INF/views/board/announce.jsp";
	}
	
	@GetMapping("announceOne.do")
	public String announce_selectOne(Model model, String num) {
		log.info("announce_selectOne....num" + num);
		int num1 = Integer.parseInt(num);
		AnnounceVO selectOne = annService.ann_selectOne(num1);
		model.addAttribute("vo2", selectOne);
		return "WEB-INF/views/board/ann_selectone.jsp";
	}
	
	@GetMapping("announce_insert.do")
	public String announce_insert(Model model) {
		log.info("ann_insert...");
		
		return "WEB-INF/views/board/ann_insert.jsp";
	}
	
	@GetMapping("announce_update.do")
	public String announce_update(Model model, String num) {
		log.info("announce_update... num" + num);
		int num1 = Integer.parseInt(num);
		AnnounceVO selectOne = annService.ann_selectOne(num1);
		model.addAttribute("vo2", selectOne);
		
		return "WEB-INF/views/board/ann_update.jsp";
	}
	@PostMapping("ann_insertOK.do")
	public String announce_insertOK(AnnounceVO vo) {
		log.info("ann_insertOK....." + vo);
		int result = annService.ann_insert(vo);
		log.info("result" + result);
		if(result==1)
			return "redirect:/announce.do";
		else
			return "redirect:/";
	}
	
	@PostMapping("ann_updatetOK.do")
	public String ann_updatetOK(AnnounceVO vo) {
		log.info("ann_updatetOK....." + vo);
		int result = annService.ann_update(vo);
		log.info("result" + result);
		if(result==1)
			return "redirect:/announce.do";
		else
			return "redirect:/";
	}
	
	@GetMapping("announce_delete.do")
	public String announce_delete(String num) {
		log.info("announce_delete....." + num);
		int result = annService.ann_delete(num);
		log.info("result" + result);
		if(result==1)
			return "redirect:/announce.do";
		else
			return "redirect:/";
	}
	
}//end controller
