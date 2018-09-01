package edu.csuft.andromeda.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.csuft.andromeda.entity.NoAnswerQuestion;
import edu.csuft.andromeda.entity.Question;

@Mapper
public interface QuestionMapper {
	@Insert("insert into question(subject,item1,item2,item3,item4,answer) values(#{subject},#{item1},#{item2},#{item3},#{item4},#{answer})")
	void add(Question question);
	
	@Select("Select * from question")
	List<Question> query();
	
	@Select("Select * from question where subject=#{subject}")
	Question find(Question question);
	
	@Select("Select * from question")
	List<NoAnswerQuestion> queryNoAnswer();
}
