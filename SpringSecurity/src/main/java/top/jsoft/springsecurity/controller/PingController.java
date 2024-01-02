package top.jsoft.springsecurity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author psygrammator
 */
@RestController
public class PingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PingController.class);

    @GetMapping("/ping")
    public String ping(Authentication authentication) {
        LOGGER.info("User {} use /ping", authentication.getName());
        return "OK";
    }

}