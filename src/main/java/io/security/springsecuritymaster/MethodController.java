package io.security.springsecuritymaster;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @PostMapping("/data2")
    public Map<String, Account> processData2(@RequestBody List<Account> data) {
        Map<String, Account> dataMap = data.stream()
                .collect(Collectors.toMap(Account::getOwner, account -> account));
        return dataService.processData2(dataMap);
    }

    @GetMapping("/read")
    @PostFilter("filterObject.owner == authentication.name")
    public List<Account> readAccounts() {
        List<Account> accounts = dataService.readAccount();
        return accounts;
    }

    @GetMapping("/read2")
    @PostFilter("filterObject.value.owner == authentication.name")
    public Map<String, Account> readAccounts2() {
        Map<String, Account> accounts = dataService.readAccount2();
        return accounts;
    }
}
