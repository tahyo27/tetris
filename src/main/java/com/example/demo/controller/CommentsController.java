package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.CommentsVO;
import com.example.demo.service.CommentsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommentsController {

	@Autowired
	CommentsService commentsService;

	@ResponseBody
	@GetMapping("cm_selectAll.do")
	public List<CommentsVO> cm_selectAll() {
		List<CommentsVO> vos = commentsService.cm_selectAll();
		log.info("comments controller vos:" + vos);

		return vos;
	}

	@ResponseBody
	@GetMapping("cm_pInsertOK.do")
	public Map<String, String> cm_pInsertOK(CommentsVO vo) {
		log.info("cm_pInsertOK.....vo:{}", vo);
		Map<String, String> map = new HashMap<String, String>();
		
		String msg = "";
		int result = commentsService.cm_pInsert(vo);
		log.info("result:{}", result);
		if (result == 1) {
			msg = "1";
		} else {
			msg = "0";
		}
		map.put("result", msg);

		return map;
	}
}
