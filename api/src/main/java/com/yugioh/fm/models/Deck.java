package com.yugioh.fm.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yugioh.fm.models.enums.MonsterType;

@Entity
public class Deck extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "character_id")
	private GameCharacter character;

	@OneToMany(mappedBy = "id.deck")
	private List<DeckCard> deckCards = new ArrayList<>();

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "monster_type")
	private Set<Integer> monsterTypes = new HashSet<>();

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

	public Set<MonsterType> getMonsterTypes() {
		return monsterTypes.stream().map(code -> MonsterType.toEnum(code)).collect(Collectors.toSet());
	}

	public void addMonsterType(MonsterType monsterType) {
		if (monsterType != null) {
			this.monsterTypes.add(monsterType.getCode());
		}
	}
}