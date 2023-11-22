package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.ScoreVO;
import com.example.demo.service.ScoreService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	private ScoreService service;
	
	@GetMapping("/")
	public String home() {
		log.info("home");
		return "index.jsp";
	}
	
	@GetMapping("board.do")
	public String board() {
		log.info("board controller");
		
		return "WEB-INF/views/board/board.jsp";
	}
	
	@PostMapping("sc_insertOK.do")
	public String sc_insert(ScoreVO vo) {
		log.info("home controller sc_insert vo:" + vo);
		int result = service.score_insert(vo);
		log.info("home controller sc_insert result:" + result);
		if(result == 1) {
			return "WEB-INF/views/board/rk_board.jsp";
		} else {
			return "index.jsp";
		}	
	}
	
	@GetMapping("RankingBoard.do")
	public String RankingBoard(Model model) throws Exception {
		List<ScoreVO> vos = service.score_selectAll();
		log.info("RankingBoard vos:{}", vos);
		model.addAttribute("vos", vos);
		
		return "WEB-INF/views/board/rk_board.jsp";
	}
}
