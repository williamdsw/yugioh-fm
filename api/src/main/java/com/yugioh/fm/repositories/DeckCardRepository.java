package com.yugioh.fm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yugioh.fm.model.DeckCard;

@Repository
public interface DeckCardRepository extends JpaRepository<DeckCard, Integer> {

}
