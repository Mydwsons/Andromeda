package edu.csuft.andromeda.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.fabric.xmlrpc.base.Array;

import edu.csuft.andromeda.entity.Question;
import edu.csuft.andromeda.entity.Rating;
import edu.csuft.andromeda.entity.User;
import edu.csuft.andromeda.exception.UnloggedException;
import edu.csuft.andromeda.service.RatingServiceImpl;


@RestController
@RequestMapping("/api/v1/rating")
public class RatingController {
	@Autowired
	RatingServiceImpl service;
	
	@PostMapping("/add")
	public List<String> add(@RequestBody List<String> list,HttpSession session) {
		List<String> msg = new ArrayList<>();
		try {
			msg = service.add(list, session);
			return msg;
		} catch (UnloggedException e) {
			msg.add(e.getMessage());
			return msg;
		}
	}
	
	@PostMapping("/query")
	public Map<String, Object> query(){
//		Map<String, Object> map = service.query();
		return service.query();
	}
}
