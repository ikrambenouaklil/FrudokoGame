package com.frudoko.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Score — records the result of each completed game.
 * Used to display the global scoreboard.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "scores")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    /** Points earned = base score - time penalty */
    @Column(nullable = false)
    private int points;

    /** Total game duration in seconds */
    @Column(name = "time_in_seconds")
    private long timeInSeconds;

    /** EASY / MEDIUM / HARD */
    @Column(length = 10)
    private String level;

    @Column(name = "played_at")
    private LocalDateTime playedAt;
}
