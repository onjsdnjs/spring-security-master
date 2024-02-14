package io.security.springsecuritymaster;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MethodController {

    private final DataService dataService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/data")
    public List<Account> processData(@RequestBody List<Account> data) {
        return dataService.processData(data);
    }
}
