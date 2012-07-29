package cn.longkai.struts.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.longkai.struts.entity.User;
import cn.longkai.struts.repository.UserDao;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Inject
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(User user) {
		userDao.persist(user);
	}

}
