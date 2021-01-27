package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import fr.m2i.demospringboot.Models.User;

@Service
public class UserService {
	
	// Base de données virtuelle.
	private List<User> users = initUser();
	
	private List<User> initUser() {
		List<User> users = new ArrayList<User>();
		users.add(new User ("Toto", "John", 12));
		users.add(new User ("Tutu", "John", 13));
		users.add(new User ("Tata", "John", 14));
		return users;
	}
	
	public List<User> getAll() {
		return this.users;
	}

	public User findById(int id) {
		return this.users.get(id);
	}
	
	public List<User> findByNom(String nom) {
		List<User> utilisateur = new ArrayList<>();
		for (int index = 0 ; index < this.users.size() ; index++) {
			if (this.users.get(index).getNom().toUpperCase().equals(nom.toUpperCase())) {
				utilisateur.add(this.users.get(index));
			}
		}
		return utilisateur;
	}
	
	public User save(User user) {
		this.users.add(user);
		return user;
	}
	
	public User update(int id, User user) {
		User newUser = findById(id);
		newUser.setNom(user.getNom());
		newUser.setPrenom(user.getPrenom());
		newUser.setAge(user.getAge());
		return user;
	}
	
	public User delete(@PathVariable int id) {
		User newUser = findById(id);
		this.users.remove(id);
		return newUser;
	}

}