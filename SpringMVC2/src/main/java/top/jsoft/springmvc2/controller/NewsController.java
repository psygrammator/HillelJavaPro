package top.jsoft.springmvc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.jsoft.springmvc2.model.News;
import top.jsoft.springmvc2.service.NewsService;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    public NewsService newsService;

    @GetMapping
    public News getNews()
    {
        return new News(newsService.getNews());
    }

}
