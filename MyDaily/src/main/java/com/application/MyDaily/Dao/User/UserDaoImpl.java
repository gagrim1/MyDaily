package com.application.MyDaily.Dao.User;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.MyDaily.Exceptions.ValidationException;
import com.application.MyDaily.model.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDaoImpl implements UserService {
	
	private final UserDao userDao;
	
	void validateUser(User user) throws ValidationException{
		if(user == null) {
			throw new ValidationException("Object user is null!");
		}
		if((user.getUsername() == null) || (user.getUsername().isEmpty())){
			throw new ValidationException("Username is empty.");
		}
	}

	@Override
	public User saveUser(User user) {
		try {
		    validateUser(user);
		    userDao.save(user);
		    return user;
		}catch(ValidationException e) {
			e.printStackTrace();
			return user;
		}
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll()
				.stream()
				.collect(Collectors.toList());
	}

	@Override
	public void deleteUser(Long id) {
		userDao.deleteById(id);
		
	}

}
