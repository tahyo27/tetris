package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		
		if (vos.isEmpty()) {
		    System.out.println("The list is empty.");
		} else {
		    // 리스트가 비어있지 않으면 각 요소의 값을 출력
		    for (AnnounceVO vo : vos) {
		        System.out.println(vo.toString()); // 또는 필요한 정보를 출력하는 방법으로 변경 가능
		    }
		}
		model.addAttribute("vos", vos);
		return "WEB-INF/views/board/anncounce.jsp";
	}

}
