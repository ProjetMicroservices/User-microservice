package com.esprit.microservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.entities.User;
import com.esprit.microservice.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	private String title = "Hello; I'm the user Microservice";
	
	@Autowired
	private UserService userService; 
	
	
	@RequestMapping("/hello")
	public String sayHello(){
		System.out.println(title);
		return title;
	}
	
	
	
	
	
	

	//Configuration de la methode POST
	@PostMapping("/addUser")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
	}
	
	
	
	//Configuration de la methode PUT
	//Execution URL: http://localhost:8282/api/candidats/1
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<User> updateUsert(@PathVariable(value = "id") int id,
			@RequestBody User user){
		return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
	}
	
	//Configuation de la methode Delete
	//Execution URL: http://localhost:8282/api/candidats/{id}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<User> deleteUser(@PathVariable(value = "id") int id){
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	//Additional (Optionnel) - N'existe pas dans l'atelier
	//Configuration de la methode GET All
	//Execution URL: http://localhost:8282/api/candidats/
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<User> getAllUsers(){
		return userService.GetUser();
	}
	
	
	//Additional (Optionnel) - N'existe pas dans l'atelier
	//Configuration de la methode de recherche GET specifique avec PathParam
	//il faut que les noms des methodes ici Candidat Resst API) et celles dans CandidatService n'aient pas le meme nom, sinon ca degere une erreue de mapping
	//Execution URL: http://localhost:8282/api/candidats
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<User> searchUser(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(userService.findUser(id), HttpStatus.OK);
	}
	
	
	
}
