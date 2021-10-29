package com.estudy.estudy.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Authority {
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
