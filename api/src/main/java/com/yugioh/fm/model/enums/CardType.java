package com.yugioh.fm.model.enums;

public enum CardType {

	MONSTER(1, "Monster"), 
	EQUIP(2, "Equip"), 
	FIELD(3, "Field"), 
	MAGIC(4, "Magic"), 
	RITUAL(5, "Ritual"),
	TRAP(6, "Trap");

	private Integer code;
	private String description;

	private CardType(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static CardType toEnum(Integer code) {
		if (code == null) {
			return null;
		}

		for (CardType type : CardType.values()) {
			if (type.getCode().equals(code)) {
				return type;
			}
		}

		String message = String.format("Card Type invalid for code : %s", code);
		throw new IllegalArgumentException(message);
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

		String message = String.format("Card Type invalid for description : %s", description);
		throw new IllegalArgumentException(message);
	}
}
