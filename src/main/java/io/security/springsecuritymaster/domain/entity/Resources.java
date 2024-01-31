package io.security.springsecuritymaster.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "RESOURCES")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EntityListeners(value = { AuditingEntityListener.class })
@Builder
@AllArgsConstructor
public class Resources implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "resource_id")
    private Long id;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "http_method")
    private String httpMethod;

    @Column(name = "order_num")
    private int orderNum;

    @Column(name = "resource_type")
    private String resourceType;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_resources", joinColumns = {@JoinColumn(name = "resource_id") },
    inverseJoinColumns = { @JoinColumn(name = "role_id") })
    @ToString.Exclude
    private Set<Role> roleSet = new HashSet<>();

}