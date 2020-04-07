package com.yugioh.fm.models;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DeckCard implements Serializable {

	// FIELDS

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private DeckCardPK id = new DeckCardPK();

	// CONSTRUCTORS

	public DeckCard() {}
	public DeckCard(Deck deck, Card card) {
		super();
		this.id.setDeck(deck);
		this.id.setCard(card);
	}

	// GETTERS / SETTERS

	public DeckCardPK getId() {
		return id;
	}

	public void setId(DeckCardPK id) {
		this.id = id;
	}

	// OVERRIDED FUNCTIONS

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeckCard other = (DeckCard) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}