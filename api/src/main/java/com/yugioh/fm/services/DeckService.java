package com.yugioh.fm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yugioh.fm.domain.Deck;
import com.yugioh.fm.domain.GameCharacter;
import com.yugioh.fm.repositories.DeckRepository;

@Service
public class DeckService {

	// FIELDS

	private DeckRepository repository;

	// CONSTRUCTOR

	@Autowired
	public DeckService(DeckRepository repository) {
		this.repository = repository;
	};

	// HELPER FUNCTIONS
	
	public Deck findByCharacter(GameCharacter character) {
		return repository.findByCharacter(character);
	}

	@Transactional
	public Deck insert(Deck deck) {
		deck.setId(null);
		deck = repository.save(deck);
		return deck;
	}
}