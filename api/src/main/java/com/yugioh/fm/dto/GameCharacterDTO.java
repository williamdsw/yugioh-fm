package com.yugioh.fm.dto;

import java.io.Serializable;

import com.yugioh.fm.model.GameCharacter;

public class GameCharacterDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String imageUrl;

	public GameCharacterDTO(GameCharacter character) {
		this.id = character.getId();
		this.name = character.getName();
		this.imageUrl = character.getImageUrl();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

}
