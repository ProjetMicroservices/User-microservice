package com.esprit.microservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservice.entities.User;
import com.esprit.microservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository; 
	
	//Ajouter un candidat
		public User addUser(User user) {
			return userRepository.save(user);
		}
		
		
		//Mettre a jour les informations d'un candidat
		public User updateUser(int id, User newUser) {
			if(userRepository.findById(id).isPresent()) {
				User existingUser = userRepository.findById(id).get();
				existingUser.setNom(newUser.getNom());
				existingUser.setPrenom(newUser.getPrenom());
				existingUser.setEmail(newUser.getEmail());
				
				return userRepository.save(existingUser);
			}
			else {
				return null;
			}
		}
		
		
		//Supprimer un candidat
		public String deleteUser(int id) {
			if(userRepository.findById(id).isPresent()) {
				userRepository.deleteById(id);
				return "User avec l'id " + id + " a ete supprime";
			}
			else {
				return "User avec l'id " + id + " n'a pas ete supprime";
			}
		}
		
		
		
		//Obtenir tous les candidats
		public  List<User> GetUser() {
			return userRepository.findAll();
		}
		
		//Methode additionnelle (Pas dans l'atelier)
		//Chercher un candidat
		public User findUser(int id) {
			if(userRepository.findById(id).isPresent()) {
				User existingUser = userRepository.findById(id).get();
				return existingUser;
			}
			else {
				return null;
			}
		}
		
		
}
