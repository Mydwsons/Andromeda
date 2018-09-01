package edu.csuft.andromeda.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.csuft.andromeda.entity.User;

@Mapper
public interface LogMapper {

	@Insert("insert into user(name,pwd) values(#{name},#{pwd})")
	void add(User user);
	
	@Select("select * from user where name=#{name}")
	User findByUname(User user);

}
