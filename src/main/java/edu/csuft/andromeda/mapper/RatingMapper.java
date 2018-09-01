package edu.csuft.andromeda.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.csuft.andromeda.entity.Rating;
import edu.csuft.andromeda.entity.RatingInfo;

@Mapper
public interface RatingMapper {
	@Insert("insert into rating(user_id,score,time) values(#{userId},#{score},#{time})")
	void add(Rating rating);
	
	@Select("select name,score,time from user right join rating on user.id=user_id order by score desc,time")
	List<RatingInfo> query();
}
