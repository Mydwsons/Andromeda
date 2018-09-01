package edu.csuft.andromeda.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.csuft.andromeda.entity.User;
import edu.csuft.andromeda.exception.InvalidPasswordException;
import edu.csuft.andromeda.exception.InvalidUserNameException;
import edu.csuft.andromeda.exception.UserNameAlreadyExistsException;
import edu.csuft.andromeda.service.UserServiceImpl;
import edu.csuft.andromeda.util.LogUtil;

@RestController
@RequestMapping("/api/v1")
public class LogController {
	@Autowired
	UserServiceImpl service;
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		try {
			user.setPwd(LogUtil.encryptBySHA256(user.getPwd()));
			service.register(user);
			return "注册成功！";
		} catch (UserNameAlreadyExistsException e) {
			return e.getMessage();
		} catch (NoSuchAlgorithmException e) {
			return e.getMessage();
		}
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user,HttpSession session) {
		try {
			user.setPwd(LogUtil.encryptBySHA256(user.getPwd()));
			session.setAttribute("user", service.logIn(user));
			return "登录成功！";
		} catch (InvalidUserNameException | InvalidPasswordException e) {
			return e.getMessage();
		} catch (NoSuchAlgorithmException e) {
			return e.getMessage();
		}
	}
	
	@PostMapping("/logout")
	public void logout(HttpSession session) {
		session.removeAttribute("user");
	}
	
	@GetMapping("/user")
	public User user(HttpSession session) {
		return (User) session.getAttribute("user");
	}
}
