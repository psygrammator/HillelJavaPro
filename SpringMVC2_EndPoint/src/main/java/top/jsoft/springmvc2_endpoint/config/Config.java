package top.jsoft.springmvc2_endpoint.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@Configuration
public class Config {
    @Value("http://localhost")
    public String host;
    @Value("8181")
    public int port;
}
