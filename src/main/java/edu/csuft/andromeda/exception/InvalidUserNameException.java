package edu.csuft.andromeda.exception;

public class InvalidUserNameException extends Exception {
	public InvalidUserNameException() {
		super("用户名不存在！");
	}
}
