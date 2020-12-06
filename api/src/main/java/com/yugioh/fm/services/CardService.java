package com.yugioh.fm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yugioh.fm.model.Card;
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
	public List<Card> findAllByNameOrNumber(String name, String number) {
		return repository.findByNameOrNumberContainingIgnoreCase(name, number);
	}

	@Transactional(readOnly = true)
	public List<Card> findAllByDeck() {
		return null; // TODO!
	}

	@Transactional
	public Card insert(Card card) {
		card.setId(null);
		card = repository.save(card);
		return card;
	}
}