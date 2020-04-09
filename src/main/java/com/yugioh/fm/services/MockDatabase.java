package com.yugioh.fm.services;

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
		
		// GAME CHARACTERS
		GameCharacter simonMuran = new GameCharacter(null, "Simon Muran", null);
		GameCharacter teana1 = new GameCharacter(null, "Teana", null);
		GameCharacter jono1 = new GameCharacter(null, "Jono", null);
		GameCharacter villager1 = new GameCharacter(null, "Villager 1", null);
		GameCharacter villager2 = new GameCharacter(null, "Villager 2", null);
		GameCharacter villager3 = new GameCharacter(null, "Villager 3", null);
		GameCharacter seto1 = new GameCharacter(null, "Seto 1", null);
		GameCharacter heishin1 = new GameCharacter(null, "Heishin", null);
		GameCharacter rexRaptor = new GameCharacter(null, "Rex Raptor", null);
		GameCharacter weevilUnderwood = new GameCharacter(null, "Weevil Underwood", null);
		GameCharacter maiValentine = new GameCharacter(null, "Mai Valentine", null);
		GameCharacter banditKeith = new GameCharacter(null, "Bandit Keith", null);
		GameCharacter shadi = new GameCharacter(null, "Shadi", null);
		GameCharacter yamiBakura = new GameCharacter(null, "Yami Bakura", null);
		GameCharacter maximillionPegasus = new GameCharacter(null, "Maximillion Pegasus", null);
		GameCharacter isis = new GameCharacter(null, "Isis", null);
		GameCharacter setoKaiba = new GameCharacter(null, "Seto Kaiba", null);
		GameCharacter mageSoldier = new GameCharacter(null, "Mage Soldier", null);
		GameCharacter jono2 = new GameCharacter(null, "Jono 2", null);
		GameCharacter teana2 = new GameCharacter(null, "Teana 2", null);
		GameCharacter oceanMage = new GameCharacter(null, "Ocean Mage", null);
		GameCharacter highMageSecmeton = new GameCharacter(null, "High Mage Secmeton", null);
		GameCharacter forestMage = new GameCharacter(null, "Forest Mage", null);
		GameCharacter highMageAnubisius = new GameCharacter(null, "High Mage Anubisius", null);
		GameCharacter mountainMage = new GameCharacter(null, "Mountain Mage", null);
		GameCharacter highMageAtenza = new GameCharacter(null, "High Mage Atenza", null);
		GameCharacter desertMage = new GameCharacter(null, "Desert Mage", null);
		GameCharacter highMageMartis = new GameCharacter(null, "High Mage Martis", null);
		GameCharacter meadowMage = new GameCharacter(null, "Meadow Mage", null);
		GameCharacter highMageKepura = new GameCharacter(null, "High Mage Kepura", null);
		GameCharacter labyrinthMage = new GameCharacter(null, "Labyrinth Mage", null);
		GameCharacter seto2 = new GameCharacter(null, "Seto 2", null);
		GameCharacter sebek = new GameCharacter(null, "Sebek", null);
		GameCharacter neku = new GameCharacter(null, "Neku", null);
		GameCharacter heishin2 = new GameCharacter(null, "Heishin 2", null);
		GameCharacter seto3 = new GameCharacter(null, "Seto 3", null);
		GameCharacter darkNite = new GameCharacter(null, "Dark Nite", null);
		GameCharacter nitemare = new GameCharacter(null, "Nitemare", null);
		GameCharacter duelMasterK = new GameCharacter(null, "Duel Master K", null);
		
		// GAME CHARACTERS IMAGE URL
		simonMuran.setImageUrl("assets/characters/simon-muran.jpg");
		teana1.setImageUrl("assets/characters/teana-1.jpg");
		jono1.setImageUrl("assets/characters/jono-1.jpg");
		villager1.setImageUrl("assets/characters/villager-1.jpg");
		villager2.setImageUrl("assets/characters/villager-2.jpg");
		villager3.setImageUrl("assets/characters/villager-3.jpg");
		seto1.setImageUrl("assets/characters/seto-1.jpg");
		heishin1.setImageUrl("assets/characters/heishin-1.jpg");
		rexRaptor.setImageUrl("assets/characters/rex-raptor.jpg");
		weevilUnderwood.setImageUrl("assets/characters/weevil-underwood.jpg");
		maiValentine.setImageUrl("assets/characters/mai-valentine.jpg");
		banditKeith.setImageUrl("assets/characters/bandit-keith.jpg");
		shadi.setImageUrl("assets/characters/shadi.jpg");
		yamiBakura.setImageUrl("assets/characters/yami-bakura.jpg");
		maximillionPegasus.setImageUrl("assets/characters/maximillion-pegasus.jpg");
		isis.setImageUrl("assets/characters/isis.jpg");
		setoKaiba.setImageUrl("assets/characters/seto-kaiba.jpg");
		mageSoldier.setImageUrl("assets/characters/mage-soldier.jpg");
		jono2.setImageUrl("assets/characters/jono-2.jpg");
		teana2.setImageUrl("assets/characters/teane-2.jpg");
		oceanMage.setImageUrl("assets/characters/ocean-mage.jpg");
		highMageSecmeton.setImageUrl("assets/characters/high-mage-secmeton.jpg");
		forestMage.setImageUrl("assets/characters/forest-mage.jpg");
		highMageAnubisius.setImageUrl("assets/characters/high-mage-anubisius.jpg");
		mountainMage.setImageUrl("assets/characters/mountain-mage.jpg");
		highMageAtenza.setImageUrl("assets/characters/high-mage-atenza.jpg");
		desertMage.setImageUrl("assets/characters/desert-mage.jpg");
		highMageMartis.setImageUrl("assets/characters/high-mage-martis.jpg");
		meadowMage.setImageUrl("assets/characters/meadow-mage.jpg");
		highMageKepura.setImageUrl("assets/characters/high-mage-kepura.jpg");
		labyrinthMage.setImageUrl("assets/characters/labyrinth-mage.jpg");
		seto2.setImageUrl("assets/characters/seto-2.jpg");
		sebek.setImageUrl("assets/characters/sebek.jpg");
		neku.setImageUrl("assets/characters/neku.jpg");
		heishin2.setImageUrl("assets/characters/heishin-2.jpg");
		seto3.setImageUrl("assets/characters/seto-3.jpg");
		darkNite.setImageUrl("assets/characters/dark-nite.jpg");
		nitemare.setImageUrl("assets/characters/nite-mare.jpg");
		duelMasterK.setImageUrl("assets/characters/duel-master-k.jpg");

		// DECK
		Deck deck1 = new Deck(simonMuran);
		Deck deck2 = new Deck(teana1);
		Deck deck3 = new Deck(jono1);
		Deck deck4 = new Deck(villager1);
		Deck deck5 = new Deck(villager2);
		Deck deck6 = new Deck(villager3);
		Deck deck7 = new Deck(seto1);
		Deck deck8 = new Deck(heishin1);
		Deck deck9 = new Deck(rexRaptor);
		Deck deck10 = new Deck(weevilUnderwood);
		Deck deck11 = new Deck(maiValentine);
		Deck deck12 = new Deck(banditKeith);
		Deck deck13 = new Deck(shadi);
		Deck deck14 = new Deck(yamiBakura);
		Deck deck15 = new Deck(maximillionPegasus);
		Deck deck16 = new Deck(isis);
		Deck deck17 = new Deck(setoKaiba);
		Deck deck18 = new Deck(mageSoldier);
		Deck deck19 = new Deck(jono2);
		Deck deck20 = new Deck(teana2);
		Deck deck21 = new Deck(oceanMage);
		Deck deck22 = new Deck(highMageSecmeton);
		Deck deck23 = new Deck(forestMage);
		Deck deck24 = new Deck(highMageAnubisius);
		Deck deck25 = new Deck(mountainMage);
		Deck deck26 = new Deck(highMageAtenza);
		Deck deck27 = new Deck(desertMage);
		Deck deck28 = new Deck(highMageMartis);
		Deck deck29 = new Deck(meadowMage);
		Deck deck30 = new Deck(highMageKepura);
		Deck deck31 = new Deck(labyrinthMage);
		Deck deck32 = new Deck(seto2);
		Deck deck33 = new Deck(sebek);
		Deck deck34 = new Deck(neku);
		Deck deck35 = new Deck(heishin2);
		Deck deck36 = new Deck(seto3);
		Deck deck37 = new Deck(darkNite);
		Deck deck38 = new Deck(nitemare);
		Deck deck39 = new Deck(duelMasterK);
		
		// CARD
		Card c001 = new Card("001", "Blue-eyes White Dragon", "", CardType.MONSTER, MonsterType.DRAGON, 8, 3000, 2500, "89631139", 999.999);
		Card c002 = new Card("002", "Mystical Elf", "", CardType.MONSTER, MonsterType.SPELLCASTER, 4, 800, 2000, "15025844", 160);
		Card c003 = new Card("003", "Hitotsu-me Giant", "", CardType.MONSTER, MonsterType.BEAST_WARRIOR, 4, 1200, 1000, "76184692", 70);
		Card c004 = new Card("004", "Baby Dragon", "", CardType.MONSTER, MonsterType.DRAGON, 3, 1200, 700, "88819587", 999.999);
		Card c005 = new Card("005", "Ryu-kishin", "", CardType.MONSTER, MonsterType.FIEND, 3, 1000, 500, "15303296", 30);
		Card c006 = new Card("006", "Feral Imp", "", CardType.MONSTER, MonsterType.FIEND, 4, 1300, 1400, "41392891", 140);
		Card c007 = new Card("007", "Winged Dragon #1", "", CardType.MONSTER, MonsterType.DRAGON, 4, 1400, 1200, "87796900", 999.999);
		Card c008 = new Card("008", "Mushroom Man", "", CardType.MONSTER, MonsterType.PLANT, 2, 800, 600, "14181608", 30);
		Card c009 = new Card("009", "Shadow Specter", "", CardType.MONSTER, MonsterType.ZOMBIE, 1, 500, 200, "40575313", 15);
		Card c010 = new Card("010", "Blackland Fire Dragon", "", CardType.MONSTER, MonsterType.DRAGON, 4, 1500, 800, "87564352", 80);
		
		// CARD DESCRIPTION
		c001.setDescription("An extremely rare card with unsurpassed attack and defense power.");
		c002.setDescription("A delicate elf that lacks in offence but has terrific defense backed by mystical power.");
		c003.setDescription("A one-eyed behemoth with thick, powerful arms made for delivering punishing blows.");
		c004.setDescription("Much more than just a child, this dragon is gifted with untapped power.");
		c005.setDescription("A very elusive creature that looks like a harmless statue until it attacks.");
		c006.setDescription("A playful little imp that lurks in the dark, waiting to attack an unwary enemy.");
		c007.setDescription("A dragon commonly found guarding mountain fortresses. Its signature attack is a sweeping dive from out of the blue.");
		c008.setDescription("Found in moist areas, this monster launches poison spores against its enemies.");
		c009.setDescription("Ghostly beast that appears in the wasteland and is particularly troublesome when faced in large numbers.");
		c010.setDescription("A dragon that dwells in the depths of darkness. Its defensive capability suffers from its poor eyesight");
		
		// CARD IMAGE URL
		c001.setImageUrl("assets/cards/001.jpg");
		c002.setImageUrl("assets/cards/002.jpg");
		c003.setImageUrl("assets/cards/003.jpg");
		c004.setImageUrl("assets/cards/004.jpg");
		c005.setImageUrl("assets/cards/005.jpg");
		c006.setImageUrl("assets/cards/006.jpg");
		c007.setImageUrl("assets/cards/007.jpg");
		c008.setImageUrl("assets/cards/008.jpg");
		c009.setImageUrl("assets/cards/009.jpg");
		c010.setImageUrl("assets/cards/010.jpg");
		
		// CARD GUARDIANS
		c001.setGuardians(setGuardianStar(GuardianStar.SUN, GuardianStar.MARS));
		c002.setGuardians(setGuardianStar(GuardianStar.SUN, GuardianStar.JUPITER));
		c003.setGuardians(setGuardianStar(GuardianStar.MOON, GuardianStar.MARS));
		c004.setGuardians(setGuardianStar(GuardianStar.URANUS, GuardianStar.SUN));
		c005.setGuardians(setGuardianStar(GuardianStar.SATURN, GuardianStar.MARS));
		c006.setGuardians(setGuardianStar(GuardianStar.MOON, GuardianStar.JUPITER));
		c007.setGuardians(setGuardianStar(GuardianStar.SATURN, GuardianStar.MOON));
		c008.setGuardians(setGuardianStar(GuardianStar.JUPITER, GuardianStar.SUN));
		c009.setGuardians(setGuardianStar(GuardianStar.MOON, GuardianStar.SATURN));
		c010.setGuardians(setGuardianStar(GuardianStar.MERCURY, GuardianStar.MOON));

		// GAME CHARACTER --> DECK
		simonMuran.setDeck(deck1);
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
		duelMasterK.setDeck(deck39);
		
		// LISTS

		List<GameCharacter> characters = new ArrayList<>();
		characters.addAll(Arrays.asList(simonMuran, teana1, jono1, villager1, villager2));
		characters.addAll(Arrays.asList(villager3, seto1, heishin1, rexRaptor, weevilUnderwood));
		characters.addAll(Arrays.asList(maiValentine, banditKeith, shadi, yamiBakura, maximillionPegasus));
		characters.addAll(Arrays.asList(isis, setoKaiba, mageSoldier, jono2, teana2));
		characters.addAll(Arrays.asList(oceanMage, highMageSecmeton, forestMage, highMageAnubisius, mountainMage));
		characters.addAll(Arrays.asList(highMageAtenza, desertMage, highMageMartis, meadowMage, highMageKepura));
		characters.addAll(Arrays.asList(labyrinthMage, seto2, sebek, neku, heishin2));
		characters.addAll(Arrays.asList(seto3, darkNite, nitemare, duelMasterK));
		
		List<Deck> decks = new ArrayList<>();
		decks.addAll(Arrays.asList(deck1, deck2, deck3, deck4, deck5, deck6));
		decks.addAll(Arrays.asList(deck7, deck8, deck9, deck10, deck11, deck12));
		decks.addAll(Arrays.asList(deck13, deck14, deck15, deck16, deck17, deck18));
		decks.addAll(Arrays.asList(deck19, deck20, deck21, deck22, deck23, deck24));
		decks.addAll(Arrays.asList(deck25, deck26, deck27, deck28, deck29, deck30));
		decks.addAll(Arrays.asList(deck31, deck32, deck33, deck34, deck35, deck36));
		decks.addAll(Arrays.asList(deck37, deck38, deck39));
		
		List<Card> cards = new ArrayList<>();
		cards.addAll(Arrays.asList(c001));
		
		gameCharacterRepository.saveAll(characters);
		deckRepository.saveAll(decks);
		cardRepository.saveAll(cards);
		
		// DECK - CARD
		Card[] cards1 = { c001 };
		Card[] cards2 = { c001 };
		
		List<DeckCard> deckCards1 = fillDeckCards(deck1, cards1);
		List<DeckCard> deckCards2 = fillDeckCards(deck2, cards2);
		
		// DECK --> DECK CARDS
		deck1.setDeckCards(deckCards1);
		deck2.setDeckCards(deckCards2);
		
		List<DeckCard> deckCards = new ArrayList<DeckCard>();
		deckCards.addAll(deckCards1);
		deckCards.addAll(deckCards2);
		deckCardRepository.saveAll(deckCards);
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
}
