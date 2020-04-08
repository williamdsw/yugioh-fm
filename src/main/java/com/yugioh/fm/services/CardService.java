package com.yugioh.fm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yugioh.fm.domain.Card;
import com.yugioh.fm.repositories.CardRepository;

@Service
public class CardService {

	// FIELDS

	private CardRepository repository;

	// CONSTRUCTOR

	@Autowired
	public CardService(CardRepository cardRepository) {
		this.repository = cardRepository;
	}

	// HELPER FUNCTIONS

	public List<Card> findAllCards() {
		return repository.findAll();
	}

	public List<Card> findAllByNameOrNumber(String name, String number) {
		return repository.findByNameOrNumberContainingIgnoreCase(name, number);
	}

	public List<Card> findAllByDeck() {
		return null;
	}
	
	@Transactional
	public Card insert(Card card) {
		card.setId(null);
		card = repository.save(card);
		return card;
	}
}