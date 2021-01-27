package fr.m2i.demospringboot.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.m2i.demospringboot.Models.User;
import services.UserService;

@RestController
@RequestMapping("users") //localhost:8080/users
public class UserController {
	
	private UserService service = new UserService();
	
	@GetMapping() //Lancer un Get sur l'URL users. //localhost:8080/users
	public List<User> findAll() {
		return this.service.getAll();
	}
	
	@GetMapping("/{id}") //localhost:8080/users
	public User findById(@PathVariable int id) {
		return this.service.findById(id);
	}
	
	@GetMapping("/nom/{nom}")
	public List<User> findByNom(@PathVariable String nom) {
		return this.service.findByNom(nom);
	}	
	
	@PostMapping() //localhost:8080/users ---> Post
	public User save(@RequestBody User user) {
		return this.service.save(user);
	}
	
	@PutMapping("/{id}") //localhost:8080/users/id ---> Put
	public User update(@PathVariable int id, @RequestBody User user) {
		return this.service.update(id, user);
	}
	
	@DeleteMapping("/{id}")
	public User delete(@PathVariable int id) {
		return this.service.delete(id);
	}
	
}
