package com.example.Expense_Tracker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Expense_Tracker.Model.User;
import com.example.Expense_Tracker.Service.UserService;

@RestController // user can store their info in database using below controller api
@CrossOrigin
public class UsersController {
	
	@Autowired
	private UserService uService;
	
	@PostMapping("/user")
	public void saveUser(@RequestBody User user) {
		uService.saveUser(user);
	}
	
	@RequestMapping("/users")
	public List<User> getUsers(){
		return uService.getUsers();
	}
	
	@PutMapping("/user")
	public void updateUser(@RequestBody User user) {
		uService.updateUser(user);
	}
	
	@DeleteMapping("/user/{user_id}")
	public void deleteUser(@PathVariable int user_id) {
		uService.deleteUser(user_id);
	}
}
