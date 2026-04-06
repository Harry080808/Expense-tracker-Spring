package com.example.Expense_Tracker.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Expense_Tracker.Model.Transaction;

@Repository
public interface TransRepo extends JpaRepository<Transaction, Integer>{
	
	@Query("SELECT t FROM Transaction t WHERE t.user.user_id = :userId")
	public List<Transaction> findByUserId(@Param("user_id") Integer userId);
	
	@Query("SELECT t FROM Transaction t WHERE "+
			"LOWER(t.category) LIKE LOWER(CONCAT('%', :keyword , '%')) OR "+
			"LOWER(t.amount) LIKE LOWER(CONCAT('%', :keyword , '%')) OR "+
			"LOWER(t.date) LIKE LOWER(CONCAT('%', :keyword , '%'))")
	public List<Transaction> findTransByKeyword(String keyword);
}
