package edu.csuft.andromeda.exception;

public class UnloggedException extends Exception {
	public UnloggedException() {
		super("未登录不能提交！");
	}
}
