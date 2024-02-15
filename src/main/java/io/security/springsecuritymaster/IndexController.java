package io.security.springsecuritymaster;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IndexController {

    private final DataService dataService;

    @GetMapping("/user")
    public String user(){
        return dataService.getUser();
    }

    @GetMapping("/owner")
    public Account owner(String name){
        return dataService.getOwner(name);
    }

}
