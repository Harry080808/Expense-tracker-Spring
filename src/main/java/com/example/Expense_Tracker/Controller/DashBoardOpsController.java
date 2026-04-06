package com.example.Expense_Tracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Expense_Tracker.Model.Dashboard;
import com.example.Expense_Tracker.Model.Login;
import com.example.Expense_Tracker.Model.User;
import com.example.Expense_Tracker.Repo.UserRepo;
import com.example.Expense_Tracker.Service.DashboardService;

import jakarta.servlet.http.HttpSession;

@RestController
public class DashBoardOpsController {
	
	@Autowired
	private DashboardService dService;
	
	@Autowired
	private UserRepo urepo;
	
	@PostMapping("/login")
	public String login(@RequestBody Login req, HttpSession session) {
	    User user = urepo.findByEmailId(req.getEmail());

	    if(user != null && user.getPassword().equals(req.getPassword())) {
	        session.setAttribute("user", user);
	        return "Login success";
	    }

	    return "Invalid credentials";
	}
	
	@GetMapping("/dashboard")
	public Dashboard getInsights(HttpSession session) {
	    User user = (User) session.getAttribute("user");

	    if(user == null) {
	        throw new RuntimeException("User not logged in");
	    }

	    return dService.getAllUserInsights(user.getUser_id());
	}
}
