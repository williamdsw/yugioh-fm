package com.yugioh.fm.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yugioh.fm.domain.Card;
import com.yugioh.fm.domain.Deck;
import com.yugioh.fm.domain.DeckCard;
import com.yugioh.fm.domain.GameCharacter;
import com.yugioh.fm.domain.enums.CardType;
import com.yugioh.fm.domain.enums.GuardianStar;
import com.yugioh.fm.domain.enums.MonsterType;
import com.yugioh.fm.repositories.CardRepository;
import com.yugioh.fm.repositories.DeckCardRepository;
import com.yugioh.fm.repositories.DeckRepository;
import com.yugioh.fm.repositories.GameCharacterRepository;

@Service
public class MockDatabase {
	
	// FIELDS
	
	private GameCharacterRepository gameCharacterRepository;
	private DeckRepository deckRepository;
	private CardRepository cardRepository;
	private DeckCardRepository deckCardRepository;
	
	private final Integer NUMBER_OF_CHARACTERS = 39;
	private final Integer NUMBER_OF_CARDS = 722;
	
	// CONSTRUCTOR
	
	@Autowired
	public MockDatabase(GameCharacterRepository gameCharacterRepository, DeckRepository deckRepository, CardRepository cardRepository, DeckCardRepository deckCardRepository) {
		this.gameCharacterRepository = gameCharacterRepository;
		this.deckRepository = deckRepository;
		this.cardRepository = cardRepository;
		this.deckCardRepository = deckCardRepository;
	}
	
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
		
		System.out.println("cardDescriptions.size = " + cardDescriptions.size());

		// LISTS
		List<GameCharacter> characters = new ArrayList<>();
		List<Deck> decks = new ArrayList<>();
		List<Card> cards = new ArrayList<>();
		
		for (int index = 0; index < NUMBER_OF_CHARACTERS; index++) {
			GameCharacter character = new GameCharacter(null, null, null);
			character.setName(gameCharacterNames.get(index));
			character.setImageUrl(gameCharacterImageUrls.get(index));
			
			Deck deck = new Deck(character);
			
			characters.add(character);
			decks.add(deck);
		}
		
		for (int index = 0; index < NUMBER_OF_CARDS; index++) {

			CardType cardType = CardType.toEnum(cardTypes.get(index));
			MonsterType monsterType = (!cardMonsterTypes.get(index).contains("NULL") ? MonsterType.toEnum(cardMonsterTypes.get(index)) : null);
			Integer level = (!cardLevels.get(index).contains("NULL") ? Integer.parseInt(cardLevels.get(index)) : null);
			Integer attack = (!cardAttacks.get(index).contains("NULL") ? Integer.parseInt(cardAttacks.get(index)) : null);
			Integer defense = (!cardDefenses.get(index).contains("NULL") ? Integer.parseInt(cardDefenses.get(index)) : null);
			String password = (!cardPasswords.get(index).contains("NULL") ? cardPasswords.get(index) : null);
			Double starChipCost = (!cardStarChipCosts.get(index).contains("NULL") ? Double.parseDouble(cardStarChipCosts.get(index)) : null);
			
			Card card = new Card();
			card.setId(null);
			card.setNumber(cardNumbers.get(index));
			card.setName(cardNames.get(index));
			//card.setDescription(cardDescriptions.get(index));
			card.setDescription("");
			card.setNumber(cardNumbers.get(index));
			card.setCardType(cardType);
			card.setMonsterType(monsterType);
			card.setLevel(level);
			card.setAtk(attack);
			card.setDef(defense);
			card.setPassword(password);
			card.setStarChipCost(starChipCost);
			card.setImageUrl(String.format("assets/cards/%s.jpg", card.getNumber()));
			//card.setGuardians(guardians);
			
			System.out.println("CARD OK?");
			
			cards.add(card);
		}
		
		System.out.println("ALL CARDS?");
		
	
		// GAME CHARACTERS
	

		/*List<String> guardianStars = getContentFromFile("files/data/card/guardian-stars.txt");
		guardianStars.forEach((star) -> {
			String[] stars = star.split(",");
			if (stars.length == 2) {
				System.out.println(GuardianStar.toEnum(stars[0]));
				System.out.println(GuardianStar.toEnum(stars[1]));
			}
		}) ;*/
		
		// GAME CHARACTER --> DECK
		/*simonMuran.setDeck(deck1);
		teana1.setDeck(deck2);
		jono1.setDeck(deck3);
		villager1.setDeck(deck4);
		villager2.setDeck(deck5);
		villager3.setDeck(deck6);
		seto1.setDeck(deck7);
		heishin1.setDeck(deck8);
		rexRaptor.setDeck(deck9);
		weevilUnderwood.setDeck(deck10);
		maiValentine.setDeck(deck11);
		banditKeith.setDeck(deck12);
		shadi.setDeck(deck13);
		yamiBakura.setDeck(deck14);
		maximillionPegasus.setDeck(deck15);
		isis.setDeck(deck16);
		setoKaiba.setDeck(deck17);
		mageSoldier.setDeck(deck18);
		jono2.setDeck(deck19);
		teana2.setDeck(deck20);
		oceanMage.setDeck(deck21);
		highMageSecmeton.setDeck(deck22);
		forestMage.setDeck(deck23);
		highMageAnubisius.setDeck(deck24);
		mountainMage.setDeck(deck25);
		highMageAtenza.setDeck(deck26);
		desertMage.setDeck(deck27);
		highMageMartis.setDeck(deck28);
		meadowMage.setDeck(deck29);
		highMageKepura.setDeck(deck30);
		labyrinthMage.setDeck(deck31);
		seto2.setDeck(deck32);
		sebek.setDeck(deck33);
		neku.setDeck(deck34);
		heishin2.setDeck(deck35);
		seto3.setDeck(deck36);
		darkNite.setDeck(deck37);
		nitemare.setDeck(deck38);
		duelMasterK.setDeck(deck39);*/
		
		// LISTS

		/*List<GameCharacter> characters = new ArrayList<>();
		characters.addAll(Arrays.asList(simonMuran, teana1, jono1, villager1, villager2));
		characters.addAll(Arrays.asList(villager3, seto1, heishin1, rexRaptor, weevilUnderwood));
		characters.addAll(Arrays.asList(maiValentine, banditKeith, shadi, yamiBakura, maximillionPegasus));
		characters.addAll(Arrays.asList(isis, setoKaiba, mageSoldier, jono2, teana2));
		characters.addAll(Arrays.asList(oceanMage, highMageSecmeton, forestMage, highMageAnubisius, mountainMage));
		characters.addAll(Arrays.asList(highMageAtenza, desertMage, highMageMartis, meadowMage, highMageKepura));
		characters.addAll(Arrays.asList(labyrinthMage, seto2, sebek, neku, heishin2));
		characters.addAll(Arrays.asList(seto3, darkNite, nitemare, duelMasterK));*/
		
		// GAME CHARACTER IMAGE URL
		/*List<String> charactersImageUrls = getContentFromFile("files/game-characters-image-urls.txt");
		for (int index = 0; index < characters.size(); index++) {
			GameCharacter character = characters.get(index);
			character.setImageUrl(charactersImageUrls.get(index));
		}*/
		
		
		/*List<Deck> decks = new ArrayList<>();
		decks.addAll(Arrays.asList(deck1, deck2, deck3, deck4, deck5, deck6));
		decks.addAll(Arrays.asList(deck7, deck8, deck9, deck10, deck11, deck12));
		decks.addAll(Arrays.asList(deck13, deck14, deck15, deck16, deck17, deck18));
		decks.addAll(Arrays.asList(deck19, deck20, deck21, deck22, deck23, deck24));
		decks.addAll(Arrays.asList(deck25, deck26, deck27, deck28, deck29, deck30));
		decks.addAll(Arrays.asList(deck31, deck32, deck33, deck34, deck35, deck36));
		decks.addAll(Arrays.asList(deck37, deck38, deck39));*/
		
		/*List<Card> cards = new ArrayList<>();
		cards.addAll(Arrays.asList(c001, c002, c003, c004, c005, c006, c007, c008, c009, c010));
		cards.addAll(Arrays.asList(c011, c012, c013, c014, c015, c016, c017, c018, c019, c020));*/
		
		
		/*List<String> cardDescriptions = getContentFromFile("files/data/card/descriptions.txt");
		
		// CARD IMAGE URL - CARD DESCRIPTION - CARD GUARDIAN STARS
		for (int index = 0; index < cards.size(); index++) {
			Card card = cards.get(index);
			card.setImageUrl(String.format("assets/cards/%s.jpg", card.getNumber()));
			card.setDescription(cardDescriptions.get(index));
			
			String guardians = guardianStars.get(index);
			String[] stars = guardians.split(",");
			if (stars.length == 2) {
				GuardianStar primary = GuardianStar.toEnum(stars[0]);
				GuardianStar secondary = GuardianStar.toEnum(stars[1]);
				card.setGuardians(setGuardianStar(primary, secondary));
			}
		}*/

		gameCharacterRepository.saveAll(characters);
		deckRepository.saveAll(decks);
		cardRepository.saveAll(cards);
		
		// DECK - CARD
		/*Card[] cards1 = { c001 };
		Card[] cards2 = { c001 };
		
		List<DeckCard> deckCards1 = fillDeckCards(deck1, cards1);
		List<DeckCard> deckCards2 = fillDeckCards(deck2, cards2);
		
		// DECK --> DECK CARDS
		deck1.setDeckCards(deckCards1);
		deck2.setDeckCards(deckCards2);
		
		List<DeckCard> deckCards = new ArrayList<DeckCard>();
		deckCards.addAll(deckCards1);
		deckCards.addAll(deckCards2);
		deckCardRepository.saveAll(deckCards);*/
	}
	
	private List<DeckCard> fillDeckCards(Deck deck, Card[] cards) {
		List<DeckCard> deckCards = new ArrayList<>();
		
		for (Card card : cards) {
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
