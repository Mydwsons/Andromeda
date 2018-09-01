package edu.csuft.andromeda.service;

import java.util.List;

import edu.csuft.andromeda.entity.NoAnswerQuestion;
import edu.csuft.andromeda.entity.Question;
import edu.csuft.andromeda.exception.InvalidSubjectException;

public interface QuestionService {
	/**
	 * 添加试题
	 * 
	 * @param question
	 * @throws InvalidSubjectException
	 */
	public void add(Question question) throws InvalidSubjectException;

	/**
	 * 查看所有题目
	 * 
	 * @return
	 */
	public List<Question> query();

	/**
	 * 查看所有题目，不包括答案
	 * 
	 * @return
	 */
	public List<NoAnswerQuestion> queryNoAnswer();
}
