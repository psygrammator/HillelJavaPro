package top.jsoft.springsecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import top.jsoft.springsecurity.config.SecurityConfiguration;
import top.jsoft.springsecurity.controller.ProductController;

@SpringBootApplication
public class SpringSecurityApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringSecurityApplication.class, args);
		//SecurityConfiguration securityConfiguration = applicationContext.getBean(SecurityConfiguration.class);
		//LOGGER.info(securityConfiguration.passwordEncoder().encode("123"));
	}

}
