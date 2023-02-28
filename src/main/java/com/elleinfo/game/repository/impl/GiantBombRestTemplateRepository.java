package com.elleinfo.game.repository.impl;

import com.elleinfo.game.entity.GiantBombGame;
import com.elleinfo.game.entity.GiantBombResponse;
import com.elleinfo.game.repository.GiantBombQueryOptions;
import com.elleinfo.game.repository.GiantBombRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Component
public class GiantBombRestTemplateRepository implements GiantBombRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(GiantBombRestTemplateRepository.class);

    private RestTemplate restTemplate;

    public GiantBombRestTemplateRepository(RestTemplateBuilder builder2) {
        restTemplate = builder2.build();
    }

    @Cacheable("giantBombGamesSearch")
    public GiantBombResponse<GiantBombGame> getGames(GiantBombQueryOptions options) {
        try {
            final HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent", "elle-game-demo");
            final HttpEntity<String> entity = new HttpEntity<String>(headers);
            LOGGER.info("Search by "+ options);
            String uri = BASE_URL + "/games/?api_key={apikey}&format=json&limit={limit}&offset={offset}&field_list={field_list}&sort={sort}&filter={filter}";
            ResponseEntity<GiantBombResponse<GiantBombGame>> responseEntity = restTemplate
                    .exchange(
                            uri,
                            HttpMethod.GET,
                            entity,
                            new ParameterizedTypeReference<GiantBombResponse<GiantBombGame>>() {
                            },
                            API_KEY, options.getLimit(), options.getOffset(), options.getFieldListString(), options.getSort(), options.getFilterString());

            GiantBombResponse<GiantBombGame> response = responseEntity
                    .getBody();
            LOGGER.info("Response :" + response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            ;
            throw e;
        }
    }

    @Cacheable("giantBombGame")
    @Override
    public Optional<GiantBombGame> findById(Integer id) {
        try {
            final HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent", "elle-game-demo");
            final HttpEntity<String> entity = new HttpEntity<String>(headers);
            LOGGER.info("findById "+ id);
            String uri = BASE_URL + "/games/?api_key={apikey}&format=json&filter=id:{id}";
            ResponseEntity<GiantBombResponse<GiantBombGame>> responseEntity = restTemplate
                    .exchange(
                            uri,
                            HttpMethod.GET,
                            entity,
                            new ParameterizedTypeReference<GiantBombResponse<GiantBombGame>>() {
                            },
                            API_KEY, id);

            List<GiantBombGame> results = responseEntity
                    .getBody().getResults();
            return results.stream().findFirst();
        } catch (Exception e) {
            e.printStackTrace();
            ;
            throw e;
        }
    }
}
