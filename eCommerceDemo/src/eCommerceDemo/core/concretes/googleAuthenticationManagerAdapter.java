package eCommerceDemo.core.concretes;

import eCommerceDemo.core.abstracts.AuthoryService;
import eCommerceDemo.googleAuhenticator.GoogleAuthenticatorManager;

public class googleAuthenticationManagerAdapter implements AuthoryService {

	GoogleAuthenticatorManager manager=new GoogleAuthenticatorManager();

	
	@Override
	public void register(int id, String firstName, String lastName, String email, String password) {
		manager.register(id,firstName,lastName,email,password);
		System.out.println("Google hesabı ile kayıt olundu : " + email);
		
	}

	@Override
	public void login(String email, String password) {
		manager.login(email, password);
		System.out.println("Google hesabı ile giriş yapıldı : " + email);
		
	}

}
