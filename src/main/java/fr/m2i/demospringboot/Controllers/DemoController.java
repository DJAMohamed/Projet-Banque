package fr.m2i.demospringboot.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

//	@RequestMapping("Mohamed") // Requête Get : http://localhost:8080/hello
	@GetMapping("hello")
	public String hello() { // Le nom de la méthode importe peu.
		return "Hello World !";
	}

	@GetMapping("bye")
	public String bye() {
		return "Bye World !";
	}
	
	// MÉTHODE 1 : Envoyer des informations.
	
	@PostMapping("message/{message2}/{message1}")
	public String message(@PathVariable String message1, @PathVariable String message2) {
		return "Message 1 : " + message1 + " | Message 2 : " + message2;
	}
	
	// MÉTHODE 2 : Envoyer des informations.
	
	@PostMapping("messages")
	public String messages(@RequestBody List<String> messages) {
		return "Vous avez "  + messages.size() + " nouveaux messages.";
	}
	
	// MÉTHODE 3 : Envoyer les paramètres URL.
	@PostMapping("params")
	
	public String params(@RequestParam String a, @RequestParam String b) {
		return "Vous avez "  + List.of(a, b).size() + " nouveaux messages.";
	}
}
