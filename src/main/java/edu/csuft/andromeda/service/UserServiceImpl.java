package edu.csuft.andromeda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csuft.andromeda.entity.User;
import edu.csuft.andromeda.exception.InvalidPasswordException;
import edu.csuft.andromeda.exception.InvalidUserNameException;
import edu.csuft.andromeda.exception.UserNameAlreadyExistsException;
import edu.csuft.andromeda.mapper.LogMapper;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	LogMapper mapper;

	@Override
	public User logIn(User user) throws InvalidUserNameException, InvalidPasswordException {
		User u = mapper.findByUname(user);
		
		if(u == null) {
//			System.out.println("u==null");
			throw new InvalidUserNameException();
		} else {
			if(!u.getPwd().equals(user.getPwd())) {
				throw new InvalidPasswordException();
			} else {
				System.out.println("service"+u);
				return u;
			}
		}
	}

	@Override
	public void register(User user) throws UserNameAlreadyExistsException {
		if (mapper.findByUname(user) != null) {
			throw new UserNameAlreadyExistsException();
		} else {
			mapper.add(user);
		}
	}

}
