package com.elleinfo.game.repository.impl;

import com.elleinfo.game.entity.GiantBombGame;
import com.elleinfo.game.entity.GiantBombResponse;
import com.elleinfo.game.repository.GiantBombQueryOptions;
import com.elleinfo.game.repository.GiantBombRepository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

public class GiantBombWebClientRepository  implements GiantBombRepository {

    private final WebClient webClient;

    public GiantBombWebClientRepository(WebClient.Builder builder) {
        webClient = builder.baseUrl(BASE_URL).build();
    }
    public GiantBombResponse<GiantBombGame> getGames(GiantBombQueryOptions options) {
//        try {
//            GiantBombResponse response =  webClient
//                    .get()
//                    .uri(uriBuilder -> {
//                        URI s = uriBuilder
//                                .path("/api/games/?api_key={api_key}&format=json&limit={size}")
//                                .build(API_KEY, size);
//                        System.out.println(s);
//                        return s;
//                    })
//                    .retrieve()
//                    .bodyToMono(new ParameterizedTypeReference<GiantBombResponse<GiantBombGame>>(){}).block();
//            System.out.println(response);
//            List games = response.getResults();
//            return games;
//        }catch (Exception e) {
//            e.printStackTrace();;
//            throw e;
//        }
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<GiantBombGame> findById(Integer id) {
        throw new UnsupportedOperationException();
    }
}
