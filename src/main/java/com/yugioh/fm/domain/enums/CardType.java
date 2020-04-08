package com.yugioh.fm.domain.enums;

public enum CardType {
	
	// VALUES

	MONSTER(1, "Monster"),
	EQUIP(2, "Equip"),
	FIELD(3, "Field"),
	MAGIC(4, "Magic"),
	RITUAL(5, "Ritual"),
	TRAP(6, "Trap");

	// FIELDS

	private Integer code;
	private String description;

	// CONSTRUCTOR

	private CardType(Integer code, String description) {
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

	public static CardType toEnum(Integer code) {
		if (code == null) {
			return null;
		}

		for (CardType type : CardType.values()) {
			if (type.getCode().equals(code)) {
				return type;
			}
		}

		throw new IllegalArgumentException(String.format("Card Type invalid for code : %s", code));
	}

	public static CardType toEnum(String description) {
		if (description == null) {
			return null;
		}

		for (CardType type : CardType.values()) {
			if (type.getDescription().equals(description)) {
				return type;
			}
		}

		throw new IllegalArgumentException(String.format("Card Type invalid for description : %s", description));
	}
}
