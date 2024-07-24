package com.sachin.ex.demoproj.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table (name = "Dept")
public class DeptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dept_id")
    private Long deptId;
    private String name;
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="fk_user_id", referencedColumnName = "dept_id")
    private Set<UserEntity> users;


}
