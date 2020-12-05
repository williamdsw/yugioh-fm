package com.yugioh.fm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yugioh.fm.domain.GameCharacter;
import com.yugioh.fm.repositories.GameCharacterRepository;

@Service
public class GameCharacterService {

	// FIELDS

	private GameCharacterRepository repository;

	// CONSTRUCTOR

	@Autowired
	public GameCharacterService(GameCharacterRepository repository) {
		this.repository = repository;
	};

	// HELPER FUNCTIONS

	public List<GameCharacter> findAll() {
		return repository.findAll();
	}

	public GameCharacter findById(Integer id) {
		Optional<GameCharacter> character = repository.findById(id);
		return character.orElseThrow(null);
	}

	@Transactional
	public GameCharacter insert(GameCharacter character) {
		character.setId(null);
		character = repository.save(character);

		return character;
	}
}