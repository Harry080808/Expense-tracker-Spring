package com.example.Expense_Tracker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Expense_Tracker.Model.User;
import com.example.Expense_Tracker.Repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	public void saveUser(User user) {
		repo.save(user);
	}

	public List<User> getUsers() {
		
		return repo.findAll();
	}

	public void updateUser(User user) {
		repo.save(user);
	}

	public void deleteUser(int user_id) {
		User user = repo.findById(user_id).orElse(null);
		repo.delete(user);
	}

}
