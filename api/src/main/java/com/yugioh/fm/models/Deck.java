package com.yugioh.fm.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Deck extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "character_id")
	private GameCharacter character;

	@OneToMany(mappedBy = "id.deck")
	private List<DeckCard> deckCards = new ArrayList<>();

	public Deck() {}

	public Deck(GameCharacter character) {
		this.character = character;
	}

	public GameCharacter getCharacter() {
		return character;
	}

	public void setCharacter(GameCharacter character) {
		this.character = character;
	}

	public List<DeckCard> getDeckCards() {
		return deckCards;
	}

	public void setDeckCards(List<DeckCard> deckCards) {
		this.deckCards = deckCards;
	}
}