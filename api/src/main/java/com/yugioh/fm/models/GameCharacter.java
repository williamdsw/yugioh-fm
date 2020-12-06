package com.yugioh.fm.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class GameCharacter extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	private String name;

	@JsonIgnore
	@OneToOne(mappedBy = "character", cascade = CascadeType.ALL)
	private Deck deck;

	private String imageUrl;

	public GameCharacter() {
	}

	public GameCharacter(Integer id, String name, Deck deck) {
		super();
		this.id = id;
		this.name = name;
		this.deck = deck;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}