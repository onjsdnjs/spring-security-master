package io.security.springsecuritymaster;

import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class DataService {
    @PreFilter("filterObject.owner == authentication.name")
    public List<Account> processData(List<Account> data) {
        // 여기에서 필터링된 데이터 처리
        return data;
    }
    @PreFilter("filterObject.value.owner == authentication.name")
    public Map<String, Account> processData2(Map<String, Account> data) {
        // 여기에서 필터링된 데이터 처리
        return data;
    }
}
