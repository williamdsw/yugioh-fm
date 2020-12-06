package com.yugioh.fm.model.enums;

public enum GuardianStar {

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

	private Integer code;
	private String description;

	private GuardianStar(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static GuardianStar toEnum(Integer code) {
		if (code == null) {
			return null;
		}

		for (GuardianStar guardian : GuardianStar.values()) {
			if (guardian.getCode().equals(code)) {
				return guardian;
			}
		}

		String message = String.format("Guardian Star invalid for code : %s", code);
		throw new IllegalArgumentException(message);
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

		String message = String.format("Guardian Star invalid for description : %s", description);
		throw new IllegalArgumentException(message);
	}
}