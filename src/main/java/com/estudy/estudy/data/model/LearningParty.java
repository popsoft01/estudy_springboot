package com.estudy.estudy.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LearningParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @NotEmpty
    @Column(unique = true, nullable = false)
    private String email;
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String password;
    private  boolean eneble;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Authority> authorities;


    public LearningParty(String email, String password, Authority authorities) {
//        if (email.strip().isEmpty() || password.strip().isBlank()){
//            throw new IllegalArgumentException("email or password cannot be null");
//        }
        this.email = email;
        this.password = password;
        addAuthority(authorities);
        this.eneble = false;

    }

    public void addAuthority(Authority authority){
        if (this.authorities == null){
            this.authorities = new ArrayList<>();
        }
        this.authorities.add(authority);
    }
}
