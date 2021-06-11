package eCommerceDemo.business.abstracts;

import java.util.List;

import eCommerceDemo.entities.concretes.User;

public interface UserService {

	void add(User user);
	void update(User user);
	void delete(User user);
	User getToId(int id);
	User getToMail(String email);
	List<User> getAll();
	User getToEmailAndPasword(String email, String password);

}
