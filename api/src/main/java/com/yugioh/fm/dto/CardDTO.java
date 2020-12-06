package com.yugioh.fm.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.yugioh.fm.models.Card;

public class CardDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String number;
	private String name;
	private String description;
	private String cardType;
	private String monsterType;
	private Integer level;
	private Integer atk;
	private Integer def;
	private String password;
	private Double starChipCost;
	private String imageUrl;
	private Set<String> guardians = new HashSet<>();

	public CardDTO(Card card) {
		this.id = card.getId();
		this.number = card.getNumber();
		this.name = card.getName();
		this.description = card.getDescription();
		this.cardType = (card.getCardType() != null ? card.getCardType().getDescription() : null);
		this.monsterType = (card.getMonsterType() != null ? card.getMonsterType().getDescription() : null);
		this.level = card.getLevel();
		this.atk = card.getAtk();
		this.def = card.getDef();
		this.password = card.getPassword();
		this.starChipCost = card.getStarChipCost();
		this.imageUrl = card.getImageUrl();
		if (card.getGuardians() != null) {
			this.guardians = card.getGuardians().stream().map(guardian -> guardian.getDescription())
					.collect(Collectors.toSet());
		}
	}

	public Integer getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getCardType() {
		return cardType;
	}

	public String getMonsterType() {
		return monsterType;
	}

	public Integer getLevel() {
		return level;
	}

	public Integer getAtk() {
		return atk;
	}

	public Integer getDef() {
		return def;
	}

	public String getPassword() {
		return password;
	}

	public Double getStarChipCost() {
		return starChipCost;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Set<String> getGuardians() {
		return guardians;
	}
}
