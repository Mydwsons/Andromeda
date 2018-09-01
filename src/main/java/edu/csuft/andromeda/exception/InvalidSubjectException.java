package edu.csuft.andromeda.exception;

public class InvalidSubjectException extends Exception {
	public InvalidSubjectException() {
		super("请不要添加相同的题目！");
	}
}
