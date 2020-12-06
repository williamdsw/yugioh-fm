package com.yugioh.fm.services;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yugioh.fm.model.Card;
import com.yugioh.fm.model.Deck;
import com.yugioh.fm.model.DeckCard;
import com.yugioh.fm.model.GameCharacter;
import com.yugioh.fm.model.enums.CardType;
import com.yugioh.fm.model.enums.GuardianStar;
import com.yugioh.fm.model.enums.MonsterType;
import com.yugioh.fm.repositories.CardRepository;
import com.yugioh.fm.repositories.DeckCardRepository;
import com.yugioh.fm.repositories.DeckRepository;
import com.yugioh.fm.repositories.GameCharacterRepository;

@Service
public class MockDatabase {
	
	@Autowired
	private GameCharacterRepository gameCharacterRepository;
	
	@Autowired
	private DeckRepository deckRepository;
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private DeckCardRepository deckCardRepository;
	
	private final Integer NUMBER_OF_CHARACTERS = 39;
	private final Integer NUMBER_OF_CARDS = 722;
	
	// LISTS
	private List<GameCharacter> characters = new ArrayList<>();
	private List<Deck> decks = new ArrayList<>();
	private List<Card> cards = new ArrayList<>();
	private List<DeckCard> deckCards = new ArrayList<>();
	
	// HELPER FUNCTIONS
	
	public void instantiate() throws Exception {
		
		// Data from files
		List<String> gameCharacterNames = getContentFromFile("files/data/game-character/names.txt");
		List<String> gameCharacterImageUrls = getContentFromFile("files/data/game-character/image-urls.txt");
		List<String> cardNumbers = getContentFromFile("files/data/card/numbers.txt");
		List<String> cardNames = getContentFromFile("files/data/card/names.txt");
		List<String> cardDescriptions = getContentFromFile("files/data/card/descriptions.txt");
		List<String> cardTypes = getContentFromFile("files/data/card/card-types.txt");
		List<String> cardMonsterTypes = getContentFromFile("files/data/card/monster-types.txt");
		List<String> cardLevels = getContentFromFile("files/data/card/levels.txt");
		List<String> cardAttacks = getContentFromFile("files/data/card/attacks.txt");
		List<String> cardDefenses = getContentFromFile("files/data/card/defenses.txt");
		List<String> cardPasswords = getContentFromFile("files/data/card/passwords.txt");
		List<String> cardStarChipCosts = getContentFromFile("files/data/card/starchip-costs.txt");
		List<String> cardGuardianStars = getContentFromFile("files/data/card/guardian-stars.txt");
		List<String> deckCardNumbers = getContentFromFile("files/data/deck-card/numbers.txt");
		
		// GAME CHARACTER --> DECK
		for (int index = 0; index < NUMBER_OF_CHARACTERS; index++) {
			GameCharacter character = new GameCharacter(null, null, null);
			Deck deck = new Deck(character);
			
			character.setName(gameCharacterNames.get(index));
			character.setImageUrl(gameCharacterImageUrls.get(index));
			character.setDeck(deck);
			
			characters.add(character);
			decks.add(deck);
		}
		
		// CARD
		for (int index = 0; index < NUMBER_OF_CARDS; index++) {

			CardType cardType = CardType.toEnum(cardTypes.get(index));
			MonsterType monsterType = (!cardMonsterTypes.get(index).contains("NULL") ? MonsterType.toEnum(cardMonsterTypes.get(index)) : null);
			Integer level = (!cardLevels.get(index).contains("NULL") ? Integer.parseInt(cardLevels.get(index)) : null);
			Integer attack = (!cardAttacks.get(index).contains("NULL") ? Integer.parseInt(cardAttacks.get(index)) : null);
			Integer defense = (!cardDefenses.get(index).contains("NULL") ? Integer.parseInt(cardDefenses.get(index)) : null);
			String password = (!cardPasswords.get(index).contains("NULL") ? cardPasswords.get(index) : null);
			Double starChipCost = (!cardStarChipCosts.get(index).contains("NULL") ? Double.parseDouble(cardStarChipCosts.get(index)) : null);
			String guardianStars = cardGuardianStars.get(index);
			
			Card card = new Card();
			card.setId(null);
			card.setNumber(cardNumbers.get(index));
			card.setName(cardNames.get(index));
			card.setDescription(cardDescriptions.get(index));
			card.setNumber(cardNumbers.get(index));
			card.setCardType(cardType);
			card.setMonsterType(monsterType);
			card.setLevel(level);
			card.setAtk(attack);
			card.setDef(defense);
			card.setPassword(password);
			card.setStarChipCost(starChipCost);
			card.setImageUrl(String.format("assets/cards/%s.jpg", card.getNumber()));
			
			if (!guardianStars.contains("NULL")) {
				String[] stars = guardianStars.split(",");
				if (stars.length == 2) {
					GuardianStar primary = GuardianStar.toEnum(stars[0]);
					GuardianStar secondary = GuardianStar.toEnum(stars[1]);
					card.setGuardians(setGuardianStar(primary, secondary));
				}
			}
			
			cards.add(card);
		}
		
		gameCharacterRepository.saveAll(characters);		
		deckRepository.saveAll(decks);
		cardRepository.saveAll(cards);

		// DECK CARDS : TODO
		for (int index = 0; index < deckCardNumbers.size(); index++) {
			Deck deck = decks.get(index);
			String[] currentDeckCardNumbers = deckCardNumbers.get(index).split(",");
			List<DeckCard> currentDeckCards = fillDeckCards(deck, currentDeckCardNumbers);
			deck.setDeckCards(currentDeckCards);
			this.deckCards.addAll(currentDeckCards);
		}

		deckCardRepository.saveAll(deckCards);
	}
	
	private List<DeckCard> fillDeckCards(Deck deck, String[] cardNumbers) {
		List<DeckCard> deckCards = new ArrayList<>();
		
		for (String code : cardNumbers) {
			Card card = cards.stream().filter(c -> c.getNumber().equals(code)).collect(Collectors.toList()).get(0);
			DeckCard deckCard = new DeckCard(deck, card);
			deckCards.add(deckCard);
		}
		
		return deckCards;		
	}
	
	private Set<GuardianStar> setGuardianStar(GuardianStar primary, GuardianStar secondary) {
		
		if (primary != null && secondary != null) {
			return Stream.of(primary, secondary).collect(Collectors.toSet());
		}
		
		return new HashSet<>();
	}
	
	private List<String> getContentFromFile(String path) {
		List<String> content = new ArrayList<>();
		
		try {
			String line = "";
			try (FileReader reader = new FileReader(path)) {
				try (BufferedReader bufferedReader = new BufferedReader(reader)) {
					while ((line = bufferedReader.readLine()) != null) {
						content.add(line);
					}
				}
			}
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		
		return content;
	}
}
