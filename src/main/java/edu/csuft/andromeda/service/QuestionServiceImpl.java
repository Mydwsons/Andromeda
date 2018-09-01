package edu.csuft.andromeda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csuft.andromeda.entity.NoAnswerQuestion;
import edu.csuft.andromeda.entity.Question;
import edu.csuft.andromeda.exception.InvalidSubjectException;
import edu.csuft.andromeda.mapper.QuestionMapper;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	QuestionMapper mapper;

	@Override
	public void add(Question question) throws InvalidSubjectException {
		if(mapper.find(question) != null) {
			throw new InvalidSubjectException();
		} else {
			mapper.add(question);
		}
	}

	@Override
	public List<Question> query() {
//		List<Question> list = mapper.query();
		return mapper.query();
	}

	@Override
	public List<NoAnswerQuestion> queryNoAnswer() {
		return mapper.queryNoAnswer();
	}

}
