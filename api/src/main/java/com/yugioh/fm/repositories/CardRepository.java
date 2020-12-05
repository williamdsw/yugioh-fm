package com.yugioh.fm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yugioh.fm.domain.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

	// HELPER FUNCTIONS

	@Transactional(readOnly = true)
	public List<Card> findByNameOrNumberContainingIgnoreCase(String name, String number);
}
