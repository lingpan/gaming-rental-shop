package com.elleinfo.game.service;

import com.elleinfo.game.entity.GiantBombGame;
import com.elleinfo.game.entity.GiantBombResponse;
import com.elleinfo.game.model.Game;
import com.elleinfo.game.repository.GiantBombQueryOptions;
import com.elleinfo.game.repository.impl.GiantBombRestTemplateRepository;
import com.elleinfo.game.model.GameFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GiantBombRestTemplateRepository giantBombRepository;

    private List<String> FIELD_LIST = Arrays.asList("id", "name", "deck", "image", "date_added","original_release_date","platforms");

    Function<GiantBombGame, Game> gameMapper = gGame -> {
        Game game = new Game(gGame.getId(), gGame.getName(), gGame.getDeck(), gGame.getImage_thumb_url(), gGame.getDate_added());
        return game;
    };


    public Page<Game> findGames(GameFilter filter, Pageable pageable) {
        GiantBombQueryOptions options = new GiantBombQueryOptions(pageable.getPageSize(), pageable.getOffset());
        options.setSort("date_added desc");
        options.setFieldList(FIELD_LIST);
        options.setFilter(filter.toMap());
        GiantBombResponse<GiantBombGame> gGames = giantBombRepository.getGames(options);
        List<Game> gameList = gGames.getResults()
                .stream()
                .map(gameMapper)
                .collect(Collectors.toList());

        long count = gGames.number_of_total_results;
        Page<Game> games = new PageImpl<>(gameList, pageable, count);
        return games;
    }


    public Optional<GiantBombGame> findById(Integer id) {
        return giantBombRepository.findById(id);
    }
}
