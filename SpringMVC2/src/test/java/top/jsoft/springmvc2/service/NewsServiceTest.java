package top.jsoft.springmvc2.service;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NewsServiceTest {
    @LocalServerPort
    private int port;
    @MockBean
    private NewsService newsService;
    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void getNews()
    {
        List<String> newsList = List.of("anyString()", "anyString()");
        Mockito.when(newsService.getNews()).thenReturn(newsList);

        Response response = given().contentType(MediaType.APPLICATION_JSON_VALUE).get("/news");
        System.out.println(response.getBody().jsonPath().get().toString());
        response.then().statusCode(200).assertThat().body(notNullValue());

        List<String> news = response.getBody().jsonPath().getList("news");
        Assertions.assertEquals(newsList, news);
        Assertions.assertEquals(2, news.size());
    }

}
