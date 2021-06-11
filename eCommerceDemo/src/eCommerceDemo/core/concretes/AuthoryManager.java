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
			System.out.println("kullanýcý bilgilerinizi kontrol ediniz!");
		}
		
		if(!checkIfUserExists(email))
		{
			System.out.println("bu e-mail adresi ile kayýt mevcut. Lütfen baþka bir mail adresi giriniz.");
			return;
		}
		if (!this.controlService.control(userToRegister)) {
			System.out.println("üyelik doðrulama iþlemi tamamlanamadýdðý için kaydýnýz yapýlamadý!");
		}

		userService.add(userToRegister);
		
	}

	@Override
	public void login(String email, String password) {
		if(!this.userControlService.loginControl(email, password))
		{
			System.out.println("giriþ bilgilerinizi kontrol ediniz!");
			return;
		}
		User userToLogin=userService.getToEmailAndPasword(email, password);
		
		if (userToLogin == null) {
			System.out.println("e-posta veya þifrenizi kontrol ediniz!");
			return;
		}
		if(!checkIfUserControled(userToLogin)) 
		{
			System.out.println("üyelik doðrulama iþlemi tamamlanamadýðý için giriþiniz yapýlamadý!");
			return;
		}
		System.out.println("giriþiniz baþarýlý! hoþgeldiniz! " + userToLogin.getFirstName() + " " + userToLogin.getLastName());
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


