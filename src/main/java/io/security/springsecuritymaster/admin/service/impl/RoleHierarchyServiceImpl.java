package io.security.springsecuritymaster.admin.service.impl;

import io.security.springsecuritymaster.admin.repository.RoleHierarchyRepository;
import io.security.springsecuritymaster.admin.service.RoleHierarchyService;
import io.security.springsecuritymaster.domain.entity.RoleHierarchy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Service
public class RoleHierarchyServiceImpl implements RoleHierarchyService {
    private RoleHierarchyRepository roleHierarchyRepository;

    @Autowired
    private void setRoleHierarchyServiceImpl(RoleHierarchyRepository roleHierarchyRepository) {
        this.roleHierarchyRepository = roleHierarchyRepository;
    }

    @Transactional
    @Override
    public String findAllHierarchy() {

        List<RoleHierarchy> rolesHierarchy = roleHierarchyRepository.findAll();

        Iterator<RoleHierarchy> itr = rolesHierarchy.iterator();
        StringBuilder hierarchyRole = new StringBuilder();

        while (itr.hasNext()) {
            RoleHierarchy roleHierarchy = itr.next();
            if (roleHierarchy.getParentName() != null) {
                hierarchyRole.append(roleHierarchy.getParentName().getChildName());
                hierarchyRole.append(" > ");
                hierarchyRole.append(roleHierarchy.getChildName());
                hierarchyRole.append("\n");
            }
        }
        return hierarchyRole.toString();
    }
}