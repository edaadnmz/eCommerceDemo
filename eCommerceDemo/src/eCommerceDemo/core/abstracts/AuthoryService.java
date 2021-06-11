package eCommerceDemo.core.abstracts;

public interface AuthoryService {

	void register(int id,String firstName,String lastName, String email,String password);
	void login(String email, String password);
}
