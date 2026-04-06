package com.example.Expense_Tracker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Expense_Tracker.Model.Transaction;
import com.example.Expense_Tracker.Repo.TransRepo;

@Service
public class TransService {
	
	@Autowired
	private TransRepo trepo;

	public List<Transaction> getTransactions() {
		return trepo.findAll();
	}

	public List<Transaction> getTransByUserId(int user_id) {
		return trepo.findByUserId(user_id);
	}
	
	public void deleteTrans(int id) {
		trepo.deleteById(id);
	}

	public void createTransUser(Transaction trans) {
		trepo.save(trans);
	}

	public List<Transaction> searchTransactions(String keyword) {
		// TODO Auto-generated method stub
		return trepo.findTransByKeyword(keyword);
	}

}
