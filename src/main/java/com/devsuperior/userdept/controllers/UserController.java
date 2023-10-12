package com.devsuperior.userdept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.userdept.entities.User;
import com.devsuperior.userdept.repositories.UserRepository;

@RestController // anotacao que configura a classe como um configurador REST
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping // informa qual o verbo http esta sendo usada do tipo [GET]
	public List<User> findAll() {
		List<User> result = repository.findAll(); // metodo que busca no banco todos os usuarios
		return result;
	}

	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Long id) {
		User result = repository.findById(id).get(); // metodo que busca no banco todos os usuarios
		return result;
	}

	@PostMapping
	public User insert(@RequestBody User user) { // anotacao para definir o corpo da requisicao
		User result = repository.save(user); // metodo que busca no banco todos os usuarios
		return result;
	}
}
