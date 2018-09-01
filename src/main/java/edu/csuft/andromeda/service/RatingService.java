package edu.csuft.andromeda.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


import edu.csuft.andromeda.exception.UnloggedException;

public interface RatingService {
	public List<String> add(List<String> answer,HttpSession session) throws UnloggedException;
	
	public Map<String, Object> query();
}
