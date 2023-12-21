package top.jsoft.springmvc2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Configuration
public class Config {
    @Value("${apikey.news}")
    public String apikey_news;

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

}
