package io.security.springsecuritymaster.admin.service.impl;

import com.example.springsecuritylearn.domain.entity.Resources;
import com.example.springsecuritylearn.repository.ResourcesRepository;
import com.example.springsecuritylearn.service.ResourcesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ResourcesServiceImpl implements ResourcesService  {
    private ResourcesRepository ResourcesRepository;

    @Autowired
    private void setResourcesServiceImpl(ResourcesRepository ResourcesRepository) {
        this.ResourcesRepository = ResourcesRepository;
    }

    @Transactional
    public Resources getResources(long id) {
        return ResourcesRepository.findById(id).orElse(new Resources());
    }

    @Transactional
    public List<Resources> getResources() {
        return ResourcesRepository.findAll(Sort.by(Sort.Order.asc("orderNum")));
    }

    @Transactional
    public void createResources(Resources resources){
        ResourcesRepository.save(resources);
    }

    @Transactional
    public void deleteResources(long id) {
        ResourcesRepository.deleteById(id);
    }
}