package com.elleinfo.game.repository;

import com.elleinfo.game.entity.GiantBombGame;
import com.elleinfo.game.entity.GiantBombResponse;

import java.util.Optional;

public interface GiantBombRepository {

     final String BASE_URL ="https://www.giantbomb.com/api";
     final String API_KEY="6226f77841989c0d0a6d0b63edc351340815688e";

    public GiantBombResponse<GiantBombGame> getGames(GiantBombQueryOptions options);

    Optional<GiantBombGame> findById(Integer id);
}
