package com.yugioh.fm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yugioh.fm.models.Card;
import com.yugioh.fm.repositories.CardRepository;

@Service
public class CardService {

	@Autowired
	private CardRepository repository;

	@Transactional(readOnly = true)
	public List<Card> findAllCards() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Card> findByName(String name) {
		return repository.findByNameContainingIgnoreCase(name);
	}

}