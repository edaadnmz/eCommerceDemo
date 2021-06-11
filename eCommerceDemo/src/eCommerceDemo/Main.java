package eCommerceDemo;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.business.concretes.UserManager;
import eCommerceDemo.core.abstracts.AuthoryService;
import eCommerceDemo.core.concretes.AuthoryManager;
import eCommerceDemo.core.concretes.emailControlManager;
import eCommerceDemo.core.concretes.userControlManager;
import eCommerceDemo.dataAccess.concretes.HibernateUserDao;


public class Main {

	public static void main(String[] args) {
		
		UserService userService = new UserManager(new HibernateUserDao());

		AuthoryService authoryService = new AuthoryManager(userService, new emailControlManager(), new userControlManager());
		authoryService.register(1, "eda", "dönmez", "edadnmz18@gmail.com", "123456"); 

	}

}
