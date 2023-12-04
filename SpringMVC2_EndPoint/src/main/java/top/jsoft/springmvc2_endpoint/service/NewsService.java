package top.jsoft.springmvc2_endpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import top.jsoft.springmvc2.model.News;
import top.jsoft.springmvc2_endpoint.config.Config;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Service
public class NewsService {
    @Autowired
    private Config config;
    @Autowired
    private RestTemplate restTemplate;

    public List<String> getNews() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<News> entity = new HttpEntity<>(httpHeaders);

        URI uri = UriComponentsBuilder.fromHttpUrl(config.host)
                .port(config.port)
                .path("/news")
                .build()
                .encode()
                .toUri();

        ResponseEntity<News> response = restTemplate.exchange(uri, HttpMethod.GET, entity, News.class);

        return Optional.of(response)
                .map(HttpEntity::getBody)
                .map(News::getNews)
                .orElseGet(Collections::emptyList);
    }
}
