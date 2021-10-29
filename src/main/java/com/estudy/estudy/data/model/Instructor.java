package com.estudy.estudy.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotNull
    private String firstname;
    @NotBlank
    @NotNull
    private String lastname;
    @Column(length = 1000)
    private String bio;
    @NotBlank
    @NotNull
    private String specialization;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToOne
    private LearningParty learningParty;

    @OneToMany
    private List<Course> courses;

}
