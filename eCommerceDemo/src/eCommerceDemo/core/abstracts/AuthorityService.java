package eCommerceDemo.core.abstracts;

public interface AuthorityService {

	void register(int id,String firstName,String lastName, String email,String password);
	void login(String email, String password);
}
