package eCommerceDemo.core.concretes;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.core.abstracts.AuthoryService;
import eCommerceDemo.core.abstracts.ControlService;
import eCommerceDemo.core.abstracts.UserControlService;
import eCommerceDemo.entities.concretes.User;

public class AuthoryManager implements AuthoryService {

	UserService userService;
	UserControlService userControlService;
	ControlService controlService;
	
	public AuthoryManager() {
		
	}
	public AuthoryManager(UserService userService, ControlService controlService, UserControlService userControlService) {
		super();
		this.userService = userService;
		this.controlService = controlService;
		this.userControlService = userControlService;
	}
	
	@Override
	public void register(int id, String firstName, String lastName, String email, String password) {
		User userToRegister = new User(id, firstName, lastName, email, password);
		if(!this.userControlService.registerControl(userToRegister))
		{
			System.out.println("kullan�c� bilgilerinizi kontrol ediniz!");
		}
		
		if(!checkIfUserExists(email))
		{
			System.out.println("bu e-mail adresi ile kay�t mevcut. L�tfen ba�ka bir mail adresi giriniz.");
			return;
		}
		if (!this.controlService.control(userToRegister)) {
			System.out.println("�yelik do�rulama i�lemi tamamlanamad�d�� i�in kayd�n�z yap�lamad�!");
		}

		userService.add(userToRegister);
		
	}

	@Override
	public void login(String email, String password) {
		if(!this.userControlService.loginControl(email, password))
		{
			System.out.println("giri� bilgilerinizi kontrol ediniz!");
			return;
		}
		User userToLogin=userService.getToEmailAndPasword(email, password);
		
		if (userToLogin == null) {
			System.out.println("e-posta veya �ifrenizi kontrol ediniz!");
			return;
		}
		if(!checkIfUserControled(userToLogin)) 
		{
			System.out.println("�yelik do�rulama i�lemi tamamlanamad��� i�in giri�iniz yap�lamad�!");
			return;
		}
		System.out.println("giri�iniz ba�ar�l�! ho�geldiniz! " + userToLogin.getFirstName() + " " + userToLogin.getLastName());
	}
	
	private boolean checkIfUserExists(String email)
	{
		return userService.getToMail(email)==null;
	}
	
	private boolean checkIfUserControled(User user)
	{
		return controlService.control(user);
	}

		
	}


