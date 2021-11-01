package com.estudy.estudy.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue
    private Long id;

//    @ManyToOne()
//    private LearningParty user;
    @Enumerated(EnumType.STRING)
    private Role authority;




    public Authority(Role role) {
        this.authority = role;
    }


}
