package com.yugioh.fm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yugioh.fm.dto.DeckDTO;
import com.yugioh.fm.models.Deck;
import com.yugioh.fm.services.DeckService;

@RestController
@RequestMapping("/api/decks")
public class DeckController {

	@Autowired
	private DeckService service;

	@GetMapping("/character")
	public ResponseEntity<DeckDTO> findByCharacter(@RequestParam Integer characterId) {
		Deck deck = service.findByCharacter(characterId);
		DeckDTO dto = new DeckDTO(deck);
		return ResponseEntity.ok().body(dto);
	}

}
