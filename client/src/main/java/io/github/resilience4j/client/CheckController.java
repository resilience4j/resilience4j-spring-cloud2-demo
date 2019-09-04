package io.github.resilience4j.client;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {

    public CheckController(CheckService checkService) {
        this.checkService = checkService;
    }

    private final CheckService checkService;


    @GetMapping("/check")
    public Map<String, Number> check() {
        return checkService.check();
    }

}
