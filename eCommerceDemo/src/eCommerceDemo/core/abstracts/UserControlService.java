package eCommerceDemo.core.abstracts;

import eCommerceDemo.entities.concretes.User;

public interface UserControlService {

	boolean registerControl(User user);
	boolean loginControl(String email, String password);
}
