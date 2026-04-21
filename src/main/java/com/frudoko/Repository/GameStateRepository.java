package com.frudoko.Repository;

import com.frudoko.model.GameState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameStateRepository extends JpaRepository <GameState, Integer> {
    
    Optional<GameState> findByUserIdAndStatus(int uerId , GameState.GameStatus status);
}
