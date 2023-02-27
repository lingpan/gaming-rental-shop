package com.elleinfo.game.service;

import com.elleinfo.game.model.Game;
import com.elleinfo.game.model.GameFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GameServiceTest {

    @Autowired
    GameService gameService;

    @Test
    void testGetGames() {
        Pageable pageable = PageRequest.of(0, 3);
        Page<Game> games = gameService.findGames(new GameFilter(), pageable);
        games.forEach(System.out::println);
        assertNotNull(games);
    }
}