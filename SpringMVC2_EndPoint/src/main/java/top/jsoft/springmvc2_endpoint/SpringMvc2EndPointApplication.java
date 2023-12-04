package top.jsoft.springmvc2_endpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import top.jsoft.springmvc2_endpoint.service.NewsService;

@SpringBootApplication
public class SpringMvc2EndPointApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMvc2EndPointApplication.class, args);
        NewsService newsService = applicationContext.getBean(NewsService.class);
        newsService.getNews().forEach(System.out::println);
    }

}
