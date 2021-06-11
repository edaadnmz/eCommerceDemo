package eCommerceDemo.dataAccess.concretes;
import java.util.ArrayList;
import java.util.List;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	List<User> users =new ArrayList<User>();

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("hibernate ile eklendi : " + user.getFirstName() + user.getLastName());
		
	}

	@Override
	public void update(User user) {
		User userToUpdate = getToId(user.getId());
		userToUpdate.setFirstName((user.getFirstName()));
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setPassword(user.getPassword());
		
		
	}

	@Override
	public void delete(User user) {
		users.removeIf(u->u.getId()==user.getId());
		
	}

	@Override
	public User getToId(int id) {
		for(User user : users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User getToMail(String email) {
		for(User user : users) {
			if (user.getEmail()==email) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		
		return null;
	}

	@Override
	public User getToEmailAndPasword(String email, String password) {
		for(User user : users) {
			if(user.getEmail() == email && user.getPassword() == password) {
				return user;
			}
		}
		return null;
	}
	
}
