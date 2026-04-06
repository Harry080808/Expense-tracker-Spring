package com.example.Expense_Tracker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Expense_Tracker.Model.Transaction;
import com.example.Expense_Tracker.Service.TransService;

@RestController
public class TransController {
	
	@Autowired
	private TransService tService;
	
	@GetMapping("/transactions")
	public List<Transaction> getTrans(){
		return tService.getTransactions();
	}
	
	@GetMapping("transactions/{user_id}")
	public List<Transaction> getTransByUserId(@PathVariable int user_id) {
		return tService.getTransByUserId(user_id);
	}
	
	
	@PostMapping("/transactions")
	public void createTransuser(@RequestBody Transaction trans) {
		tService.createTransUser(trans);
	}
	
	@DeleteMapping("/transactions/{id}")
	public void deleteUserTrans(@PathVariable int id) {
		tService.deleteTrans(id);
	}
	
	@GetMapping("/transactions/search")
	public ResponseEntity<List<Transaction>> getTransByCategory(@RequestParam(required = false) String keyword) {
		List<Transaction> trans = tService.searchTransactions(keyword);
		return new ResponseEntity<>(trans,HttpStatus.OK);
	}
}
