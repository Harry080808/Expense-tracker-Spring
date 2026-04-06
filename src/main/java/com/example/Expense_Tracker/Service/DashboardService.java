package com.example.Expense_Tracker.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Expense_Tracker.Model.Dashboard;
import com.example.Expense_Tracker.Model.Transaction;
import com.example.Expense_Tracker.Repo.TransRepo;

@Service
public class DashboardService {
	
	@Autowired
	private TransRepo tRepo;

	public Dashboard getAllUserInsights(Integer user_id) {
		List<Transaction> expenses = tRepo.findByUserId(user_id);
		int income = 0;
		int totalExpense = 0;
		
		for(Transaction t: expenses) {
			if(t.getType().equals("income")) {
				income = Integer.parseInt(t.getAmount());
			}
			else {
				totalExpense += Integer.parseInt(t.getAmount());
			}
		}
		int NetBalance = income - totalExpense;
		HashMap<String, Integer> catTotal = new HashMap<String, Integer>();
		
		for(Transaction t: expenses) {
			
			if(t.getCategory().equals("Food")) {
				catTotal.put("Food", catTotal.getOrDefault("Food", 0) + Integer.parseInt(t.getAmount()));
			}
			else if(t.getCategory().equals("Shopping")) {
				catTotal.put("Shopping", catTotal.getOrDefault("Shopping", 0) + Integer.parseInt(t.getAmount()));
			}
			else if(t.getCategory().equals("Education")) {
				catTotal.put("Education", catTotal.getOrDefault("Education", 0) + Integer.parseInt(t.getAmount()));
			}
			else if(t.getCategory().equals("Utilities")) {
				catTotal.put("Utilities", catTotal.getOrDefault("Utilities", 0) + Integer.parseInt(t.getAmount()));
			}
			else if(t.getCategory().equals("Medical")) {
				catTotal.put("Medical", catTotal.getOrDefault("Medical", 0) + Integer.parseInt(t.getAmount()));
			}
			else if(t.getCategory().equals("Travel")) {
				catTotal.put("Travel", catTotal.getOrDefault("Travel", 0) + Integer.parseInt(t.getAmount()));
			}
		}
		Dashboard dashB = new Dashboard();
		dashB.setIncome(income);
		dashB.setTotalEx(totalExpense);
		dashB.setNetBalance(NetBalance);
		dashB.setCatTotal(catTotal);
		return dashB;
	}
	
}
