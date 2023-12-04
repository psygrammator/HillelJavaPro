package top.jsoft.springmvc2_endpoint.controller;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import top.jsoft.springmvc2_endpoint.config.Config;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NewsControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Config config;

    private MockRestServiceServer mockRestServiceServer;

    @BeforeEach
    public void setUp()
    {
        RestAssured.port = port;
        mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void getNews()
    {
        URI uri = UriComponentsBuilder.fromHttpUrl(config.host).port(config.port).path("/news").build().encode().toUri();

        String response = "{\"news\": [\"anyString()\",\"anyString()\"]}";
        mockRestServiceServer.expect(MockRestRequestMatchers.requestTo(uri))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(response));

        Response initResponse = given().contentType(MediaType.APPLICATION_JSON_VALUE).get("/news");

        initResponse.then().statusCode(200).assertThat().body(notNullValue());

        List<String> news = initResponse.getBody().jsonPath().getList("news");
        Assertions.assertEquals(2, news.size());
    }
}
