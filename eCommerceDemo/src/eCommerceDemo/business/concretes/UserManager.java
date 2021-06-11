package eCommerceDemo.business.concretes;

import java.util.List;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.entities.concretes.User;
import eCommerceDemo.dataAccess.abstracts.UserDao;

public class UserManager implements UserService {

	UserDao userDao;
	public UserManager(UserDao userDao) {
		this.userDao=userDao;
	}
	
	@Override
	public void add(User user) {
		userDao.add(user);
		System.out.println("kullanýcý eklendi. ");
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		System.out.println("kullanýcý güncellendi. ");
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		System.out.println("kullanýcý silindi. ");
		
	}

	@Override
	public User getToId(int id) {
		
		return userDao.getToId(id);
	}

	@Override
	public User getToMail(String email) {
		
		return userDao.getToMail(email);
	}

	@Override
	public List<User> getAll() {
		
		return userDao.getAll();
	}

	@Override
	public User getToEmailAndPasword(String email, String password) {
		
		return userDao.getToEmailAndPasword(email, password);
	}

}
