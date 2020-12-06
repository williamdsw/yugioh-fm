package com.yugioh.fm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yugioh.fm.models.GameCharacter;
import com.yugioh.fm.repositories.GameCharacterRepository;
import com.yugioh.fm.services.exception.ObjectNotFoundException;

@Service
public class GameCharacterService {

	@Autowired
	private GameCharacterRepository repository;

	@Transactional(readOnly = true)
	public List<GameCharacter> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public GameCharacter findById(Integer id) {
		Optional<GameCharacter> character = repository.findById(id);
		String message = String.format("Character not found by id %s", id);
		return character.orElseThrow(() -> new ObjectNotFoundException(message));
	}
}