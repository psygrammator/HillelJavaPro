package top.jsoft.springmvc2.service;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jsoft.springmvc2.config.Config;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Getter
@Service
public class NewsService {
    @Autowired
    public Config config;

    private List<String> news = new CopyOnWriteArrayList<>();

    public void setNews(List<String> news) {
        this.news = news;
    }

    public List<String> getNews()
    {
        NewsApiClient newsApiClient = new NewsApiClient(config.apikey_news);

        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .q("Ukraine")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        setNews(response.getArticles()
                                .stream()
                                .map(c -> "Glory to Ukraine: " + c.getTitle())
                                .toList());
                        response.getArticles().forEach(c -> System.out.println("Glory to Ukraine: " + c.getTitle()));
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );
        try {
            Thread.sleep(500); // для заполнения массива данными хватает 0.5 секунды
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return news;
    }


}
