package com.yugioh.fm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yugioh.fm.models.Deck;
import com.yugioh.fm.models.GameCharacter;
import com.yugioh.fm.repositories.DeckRepository;

@Service
public class DeckService {

	@Autowired
	private DeckRepository repository;
	
	@Autowired
	private GameCharacterService gameCharacterService;

	@Transactional(readOnly = true)
	public Deck findByCharacter(Integer characterId) {
		GameCharacter character = gameCharacterService.findById(characterId);
		return repository.findByCharacter(character);
	}
}