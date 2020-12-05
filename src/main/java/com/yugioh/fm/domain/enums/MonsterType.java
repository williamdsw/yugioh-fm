package com.yugioh.fm.domain.enums;

public enum MonsterType {

	// VALUES

	AQUA(1, "Aqua"),
	BEAST(2, "Beast"),
	BEAST_WARRIOR(3, "Beast-Warrior"),
	DINOSAUR(4, "Dinosaur"),
	DRAGON(5, "Dragon"),
	FAIRY(6, "Fairy"),
	FIEND(7, "Fiend"),
	FISH(8, "Fish"),
	INSECT(10, "Insect"),
	MACHINE(11, "Machine"),
	PLANT(12, "Plant"),
	PYRO(13, "Pyro"),
	REPTILE(14, "Reptile"),
	ROCK(15, "Rock"),
	SEA_SERPENT(16, "Sea Serpent"),
	SPELLCASTER(17, "Spellcaster"),
	THUNDER(18, "Thunder"),
	WARRIOR(19, "Warrior"),
	WINGED_BEAST(20, "Winged Beast"),
	ZOMBIE(21, "Zombie");

	// FIELDS

	private Integer code;
	private String description;

	// CONSTRUCTOR

	private MonsterType(Integer code, String description) {
			this.code = code;
			this.description = description;
		}

	// GETTERS

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	// HELPER FUNCTIONS

	public static MonsterType toEnum(Integer code) {
		if (code == null) {
			return null;
		}

		for (MonsterType type : MonsterType.values()) {
			if (type.getCode().equals(code)) {
				return type;
			}
		}

		throw new IllegalArgumentException(String.format("Monster Type invalid for code : %s", code));
	}

	public static MonsterType toEnum(String description) {
		if (description == null) {
			return null;
		}

		for (MonsterType type : MonsterType.values()) {
			if (type.getDescription().equals(description)) {
				return type;
			}
		}

		throw new IllegalArgumentException(String.format("Monster Type invalid for description : %s", description));
	}
}
