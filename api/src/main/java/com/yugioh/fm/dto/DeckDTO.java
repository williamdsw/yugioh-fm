package com.yugioh.fm.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.yugioh.fm.model.Deck;

public class DeckDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private GameCharacterDTO character;
	private Set<CardDTO> cards = new HashSet<CardDTO>();
	private Set<String> monsterTypes = new HashSet<String>();

	public DeckDTO(Deck deck) {
		character = new GameCharacterDTO(deck.getCharacter());

		if (deck.getDeckCards() != null) {
			cards = deck.getDeckCards().stream().map(deckCard -> new CardDTO(deckCard.getId().getCard()))
					.collect(Collectors.toSet());
		}

		if (deck.getMonsterTypes() != null) {
			this.monsterTypes = deck.getMonsterTypes().stream().map(type -> type.getDescription())
					.collect(Collectors.toSet());
		}
	}

	public GameCharacterDTO getCharacter() {
		return character;
	}

	public Set<CardDTO> getCards() {
		return cards;
	}

	public Set<String> getMonsterTypes() {
		return monsterTypes;
	}

}
