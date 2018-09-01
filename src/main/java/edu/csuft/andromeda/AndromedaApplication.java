package edu.csuft.andromeda;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.csuft.andromeda.mapper")
public class AndromedaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AndromedaApplication.class, args);
	}
}
