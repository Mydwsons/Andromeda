package edu.csuft.andromeda.exception;

public class UserNameAlreadyExistsException extends Exception {
	
	public UserNameAlreadyExistsException() {
		super("该用户名已存在！");
	}
	
}
