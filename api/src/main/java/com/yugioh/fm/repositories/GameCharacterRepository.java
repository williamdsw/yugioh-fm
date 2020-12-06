package com.yugioh.fm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yugioh.fm.models.GameCharacter;

@Repository
public interface GameCharacterRepository extends JpaRepository<GameCharacter, Integer> {

}
