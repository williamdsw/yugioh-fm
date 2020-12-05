package com.yugioh.fm.domain.enums;

public enum GuardianStar {

	// VALUES

	SUN(1, "Sun"), 
	MERCURY(2, "Mercury"), 
	VENUS(3, "Venus"), 
	MOON(4, "Moon"), 
	MARS(5, "Mars"), 
	JUPITER(6, "Jupiter"),
	SATURN(7, "Saturn"), 
	URANUS(8, "Uranus"), 
	NEPTUNE(9, "Neptune"), 
	PLUTO(10, "Pluto");

	// FIELDS

	private Integer code;
	private String description;

	// CONSTRUCTOR

	private GuardianStar(Integer code, String description) {
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

	public static GuardianStar toEnum(Integer code) {
		if (code == null) {
			return null;
		}

		for (GuardianStar guardian : GuardianStar.values()) {
			if (guardian.getCode().equals(code)) {
				return guardian;
			}
		}

		throw new IllegalArgumentException(String.format("Guardian Star invalid for code : %s", code));
	}

	public static GuardianStar toEnum(String description) {
		if (description == null) {
			return null;
		}

		for (GuardianStar guardian : GuardianStar.values()) {
			if (guardian.getDescription().equals(description)) {
				return guardian;
			}
		}

		throw new IllegalArgumentException(String.format("Guardian Star invalid for description : %s", description));
	}
}