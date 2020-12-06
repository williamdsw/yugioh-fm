package com.yugioh.fm.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yugioh.fm.dto.CardDTO;
import com.yugioh.fm.models.Card;
import com.yugioh.fm.services.CardService;

@RestController
@RequestMapping("/api/cards")
public class CardController {

	@Autowired
	private CardService service;

	@GetMapping
	public ResponseEntity<List<CardDTO>> findAll() {
		List<Card> cards = service.findAllCards();
		List<CardDTO> dtos = cards.stream().map(card -> new CardDTO(card)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}

	@GetMapping("/name")
	public ResponseEntity<List<CardDTO>> findByName(@RequestParam(defaultValue = "") String name) {
		List<Card> cards = service.findByName(name);
		List<CardDTO> dtos = cards.stream().map(card -> new CardDTO(card)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}

}
