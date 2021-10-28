package com.estudy.estudy.data.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    private Long Id;
    private String firstname;
    private String lastname;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany
    private List<Course> courses;
}
