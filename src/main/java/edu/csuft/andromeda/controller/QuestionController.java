package edu.csuft.andromeda.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.csuft.andromeda.entity.NoAnswerQuestion;
import edu.csuft.andromeda.entity.Question;
import edu.csuft.andromeda.exception.InvalidSubjectException;
import edu.csuft.andromeda.service.QuestionServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class QuestionController {
	@Autowired
	QuestionServiceImpl service;
	
	@PostMapping("/add")
	public String add(@RequestBody Question question) {
		try {
			service.add(question);
			return "添加成功！";
		} catch (InvalidSubjectException e) {
			return e.getMessage();
		}
	}
	
	@GetMapping("/extract")
	public List<NoAnswerQuestion> extract(HttpSession session){
		session.setAttribute("time", System.currentTimeMillis());
		return service.queryNoAnswer();
	}
}
