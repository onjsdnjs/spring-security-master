package io.security.springsecuritymaster;

import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {
    @PreFilter("filterObject.owner == authentication.name")
    public List<Account> processData(List<Account> data) {
        // 여기에서 필터링된 데이터 처리
        return data;
    }
}
