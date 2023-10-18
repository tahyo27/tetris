package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.AnnounceVO;
import com.example.demo.service.AnnounceService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AccounceController {
	
	@Autowired
	private AnnounceService annService;
	
	@GetMapping("/announce.do")
	public String announce_selectAll(Model model) throws Exception {
		log.info("announce_selectAll");
		
		List<AnnounceVO> vos = annService.ann_selectAll();
		
		model.addAttribute("vos", vos);
		return "WEB-INF/views/board/announce.jsp";
	}
	
	@GetMapping("announceOne.do")
	public String announce_selectOne(Model model, String num) {
		log.info("announce_selectOne....num" + num);
		
		return "WEB-INF/views/board/ann_selectone.jsp";
	}
	
	@GetMapping("announce_insert.do")
	public String announce_insert(Model model) {
		log.info("ann_insert...");
		
		return "WEB-INF/views/board/ann_insert.jsp";
	}
	
	@PostMapping("ann_insertOK.do")
	public String announce_insertOK(AnnounceVO vo) {
		log.info("ann_insertOK....." + vo);
		int result = annService.ann_insert(vo);
		log.info("result" + result);
		if(result==1)
			return "redirect:/announce.do";
		else
			return "redirect:/board.do";
	}
	
}//end controller
