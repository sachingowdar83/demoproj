package com.sachin.ex.demoproj.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "UserApps")
public class UserApps {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "user_id",
            insertable = true,
            updatable = true
    )
    private UserEntity user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "app_id",
            referencedColumnName = "id",
            insertable = true,
            updatable = true
    )
    private Application apps;
}
