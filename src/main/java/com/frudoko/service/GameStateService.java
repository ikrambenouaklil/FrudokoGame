package com.frudoko.service;


import com.frudoko.Repository.GameStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class GameStateService {
    @Autowired
    private GameStateRepository repo;
}
