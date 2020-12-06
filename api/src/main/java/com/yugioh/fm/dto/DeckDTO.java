package com.yugioh.fm.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.yugioh.fm.models.Deck;

public class DeckDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Set<CardDTO> cards = new HashSet<CardDTO>();

	public DeckDTO(Deck deck) {
		if (deck.getDeckCards() != null) {
			cards = deck.getDeckCards().stream().map(deckCard -> new CardDTO(deckCard.getId().getCard())).collect(Collectors.toSet());
		}
	}

	public Set<CardDTO> getCards() {
		return cards;
	}
}
