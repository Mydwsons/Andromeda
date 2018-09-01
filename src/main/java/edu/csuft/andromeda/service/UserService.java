package edu.csuft.andromeda.service;

import edu.csuft.andromeda.entity.User;
import edu.csuft.andromeda.exception.InvalidPasswordException;
import edu.csuft.andromeda.exception.InvalidUserNameException;
import edu.csuft.andromeda.exception.UserNameAlreadyExistsException;

public interface UserService {
	/**
	 * 登录
	 * 
	 * @param user
	 * @return 
	 * @throws InvalidUserNameException 
	 * @throws InvalidPasswordException 
	 */
	public User logIn(User user) throws InvalidUserNameException, InvalidPasswordException;
	
	/**
	 * 
	 * @param user
	 * @throws UserNameAlreadyExistsException 
	 */
	public void register(User user) throws UserNameAlreadyExistsException;
}
