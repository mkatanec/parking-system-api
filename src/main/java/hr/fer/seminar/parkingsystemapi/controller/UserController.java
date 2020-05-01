package hr.fer.seminar.parkingsystemapi.controller;

import hr.fer.seminar.parkingsystemapi.model.User;
import hr.fer.seminar.parkingsystemapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
	private final UserService userService;

	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping(value = "/user/{id}")
	public void getUser(final @PathVariable("id") Long id) {
		userService.getUser(id);
	}

	@PostMapping(value = "/user")
	public User createUser(final @RequestBody User user) {
		return userService.addUser(user);
	}

	@PutMapping(value = "/user")
	public User updateUser(final @RequestBody User user) {
		return userService.updateUser(user);
	}

	@DeleteMapping(value = "/user/{id}")
	public void deleteUser(final @PathVariable("id") Long id) {
		userService.deleteUser(id);
	}
}
