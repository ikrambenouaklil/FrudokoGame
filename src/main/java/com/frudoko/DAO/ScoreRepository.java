package com.frudoko.DAO;


import com.frudoko.model.Score;
import com.frudoko.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Integer> {

    @Query("""
        SELECT s.user
        FROM Score s
        GROUP BY s.user.id
        ORDER BY SUM(s.points) DESC
    """)
    List<User> getLeaderboard();
}