package edu.csuft.andromeda.exception;

public class InvalidPasswordException extends Exception {
	public InvalidPasswordException() {
		super("密码错误！请重新输入");
	}
}
