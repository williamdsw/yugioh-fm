package com.yugioh.fm.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yugioh.fm.dto.GameCharacterDTO;
import com.yugioh.fm.models.GameCharacter;
import com.yugioh.fm.services.GameCharacterService;

@RestController
@RequestMapping("/api/characters")
public class GameCharacterController {
	
	@Autowired
	private GameCharacterService service;
	
	@GetMapping
	public ResponseEntity<List<GameCharacterDTO>> findAll() {
		List<GameCharacter> characters = service.findAll();
		List<GameCharacterDTO> dtos = characters.stream().map(character -> new GameCharacterDTO(character)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GameCharacterDTO> findById(@PathVariable Integer id) {
		GameCharacter character = service.findById(id);
		GameCharacterDTO dto = new GameCharacterDTO(character);
		return ResponseEntity.ok().body(dto);
	}
	
	

}
