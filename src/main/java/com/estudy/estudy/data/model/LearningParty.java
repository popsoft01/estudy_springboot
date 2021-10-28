package com.estudy.estudy.data.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
public class LearningParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private  boolean eneble;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @OneToMany
    private List<Authority> authorities;


    public LearningParty(String email, String password, Authority authorities) {
        this.email = email;
        this.password = password;

    }

    public void addAuthority(Authority authority){
        if (this.authorities == null){
            this.authorities = new ArrayList<>();
        }
        this.authorities.add(authority);
    }
}
