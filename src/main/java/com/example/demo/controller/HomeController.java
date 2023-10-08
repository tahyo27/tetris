package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.ScoreVO;
import com.example.demo.service.ScoreService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	private ScoreService service;
	
	@GetMapping("/")
	public String home(ScoreVO vo, Model model) throws Exception {
		
		log.info("테스트 여기까지 나오는지 확인ㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		List<ScoreVO> vos = service.score_selectAll();
		
		for(ScoreVO x : vos) {
			log.info(x.toString());
		}
		
		return "index.jsp";
	}
	
	@GetMapping("/board.do")
	public String board() {
		log.info("board controller");
		
		return "WEB-INF/views/board/board.jsp";
	}
}
