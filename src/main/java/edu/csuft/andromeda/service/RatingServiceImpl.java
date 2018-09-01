package edu.csuft.andromeda.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.tools.ToolProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csuft.andromeda.entity.Question;
import edu.csuft.andromeda.entity.Rating;
import edu.csuft.andromeda.entity.RatingInfo;
import edu.csuft.andromeda.entity.User;
import edu.csuft.andromeda.exception.UnloggedException;
import edu.csuft.andromeda.mapper.QuestionMapper;
import edu.csuft.andromeda.mapper.RatingMapper;

@Service
public class RatingServiceImpl implements RatingService {
	@Autowired
	RatingMapper ratingMapper;
	@Autowired
	QuestionMapper questionMapper;

	@Override
	public List<String> add(List<String> answers, HttpSession session) throws UnloggedException {
		List<String> right = new ArrayList<>();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			throw new UnloggedException();
		}

		Rating rating = new Rating();
		double count = 0;
		double index = 0;

		for (Question q : questionMapper.query()) {
			if (q.getAnswer().equals(answers.get((int) index))) {
				count++;
			}
			right.add(q.getAnswer());
			index++;
		}

		rating.setScore((count / index) * 100 + "");
		rating.setTime(System.currentTimeMillis() - (long) session.getAttribute("time") + "");
		rating.setUserId(user.getId());
		ratingMapper.add(rating);
		return right;
	}

	@Override
	public Map<String, Object> query() {
		List<RatingInfo> list = ratingMapper.query();
		int time5 = 0, time10 = 0, time15 = 0, time20 = 0, time25 = 0, time30 = 0;
		int score0 = 0, score60 = 0, score70 = 0, score80 = 0, score90 = 0;
		for (RatingInfo r : list) {
			int tempTime = Integer.parseInt(r.getTime())/1000;
			if (tempTime <= 5) {
				time5++;
			} else if (tempTime <= 10) {
				time10++;
			} else if (tempTime <= 15) {
				time15++;
			} else if (tempTime <= 20) {
				time20++;
			} else if (tempTime <= 25) {
				time25++;
			} else {
				time30++;
			}
			double tempScore = Double.parseDouble(r.getScore());
			if (tempScore < 60) {
				score0++;
			} else if (tempScore < 70) {
				score60++;
			} else if (tempScore < 80) {
				score70++;
			} else if (tempScore < 90) {
				score80++;
			} else {
				score90++;
			}
		}
		Map<String, Object> map = new Hashtable<>();
		map.put("list", list);
		map.put("time5", time5);
		map.put("time10", time10);
		map.put("time15", time15);
		map.put("time20", time20);
		map.put("time25", time25);
		map.put("time30", time30);
		map.put("score0", score0);
		map.put("score60", score60);
		map.put("score70", score70);
		map.put("score80", score80);
		map.put("score90", score90);
		return map;
	}

}
