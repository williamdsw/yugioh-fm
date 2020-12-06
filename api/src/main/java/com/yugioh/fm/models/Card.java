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
import javax.persistence.OneToMany;

import com.yugioh.fm.models.enums.CardType;
import com.yugioh.fm.models.enums.GuardianStar;
import com.yugioh.fm.models.enums.MonsterType;

@Entity
public class Card extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	private String number;
	private String name;
	private String description;

	@CollectionTable(name = "card_type")
	private Integer cardType;

	@CollectionTable(name = "monster_type")
	private Integer monsterType;

	private Integer level;
	private Integer atk;
	private Integer def;
	private String password;
	private Double starChipCost;

	@OneToMany(mappedBy = "id.card")
	private List<DeckCard> deckCards = new ArrayList<>();

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "guardian_star")
	private Set<Integer> guardians = new HashSet<>();

	private String imageUrl;

	public Card() {
	}

	public Card(Integer id) {
		super();
		this.id = id;
	}

	public Card(String number) {
		super();
		this.number = number;
	}

	public Card(String number, String name, String description, CardType cardType, MonsterType monsterType,
			Integer level, Integer atk, Integer def, String password, Double starChipCost) {
		super();
		this.number = number;
		this.name = name;
		this.description = description;
		this.cardType = (cardType != null ? cardType.getCode() : null);
		this.monsterType = (monsterType != null ? monsterType.getCode() : null);
		this.level = level;
		this.atk = atk;
		this.def = def;
		this.password = password;
		this.starChipCost = starChipCost;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CardType getCardType() {
		return (this.cardType != null ? CardType.toEnum(cardType) : null);
	}

	public void setCardType(CardType cardType) {
		this.cardType = (cardType != null ? cardType.getCode() : null);
	}

	public MonsterType getMonsterType() {
		return (this.monsterType != null ? MonsterType.toEnum(monsterType) : null);
	}

	public void setMonsterType(MonsterType monsterType) {
		this.monsterType = (monsterType != null ? monsterType.getCode() : null);
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getAtk() {
		return atk;
	}

	public void setAtk(Integer atk) {
		this.atk = atk;
	}

	public Integer getDef() {
		return def;
	}

	public void setDef(Integer def) {
		this.def = def;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getStarChipCost() {
		return starChipCost;
	}

	public void setStarChipCost(Double starChipCost) {
		this.starChipCost = starChipCost;
	}

	public List<DeckCard> getDeckCards() {
		return deckCards;
	}

	public void setDeckCards(List<DeckCard> deckCards) {
		this.deckCards = deckCards;
	}

	public Set<GuardianStar> getGuardians() {
		return guardians.stream().map(code -> GuardianStar.toEnum(code)).collect(Collectors.toSet());
	}

	public void setGuardians(Set<GuardianStar> guardians) {
		if (guardians != null & guardians.size() == 2) {
			this.guardians = guardians.stream().map(guardian -> guardian.getCode()).collect(Collectors.toSet());
		}
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}