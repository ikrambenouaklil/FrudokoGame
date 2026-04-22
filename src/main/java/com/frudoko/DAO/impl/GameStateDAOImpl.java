package com.frudoko.DAO.impl;

import com.frudoko.DAO.GameStateDAO;
import com.frudoko.model.GameState;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Repository
public class GameStateDAOImpl implements GameStateDAO {

    @PersistenceContext
    private EntityManager em;
    @Override
    public void save(GameState gs) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public GameState findById(int id) {
        return null;
    }

    @Override
    public GameState findByUserIdAndStatus(int userId, GameState.GameStatus status) {
        return null;
    }
}
