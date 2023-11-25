package top.jsoft.springmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by psygrammator
 * group jsoft.top
 */
@RestController
public class PingController {
    @GetMapping("/ping")
    public boolean getPing()
    {
        return true;
    }
}
