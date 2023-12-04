package top.jsoft.springmvc2_endpoint.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Configuration
public class ConfigBean {
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
