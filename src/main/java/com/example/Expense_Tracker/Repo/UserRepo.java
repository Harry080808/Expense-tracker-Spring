package com.example.Expense_Tracker.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Expense_Tracker.Model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	@Query("SELECT u FROM User u where u.emailId = :email")
	public User findByEmailId(String email);
}
