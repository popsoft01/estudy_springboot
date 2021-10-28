package com.estudy.estudy.data.model;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private  String title;
    @Column(length = 1000)
    private  String description;
    private String language;
    @ElementCollection
    private List<String> imageUrls;

    private LocalDateTime dateCreated;
    private LocalDateTime datePublish;
    @UpdateTimestamp
    private LocalDateTime update;

    private boolean isPublish;

    @ManyToOne
    private Instructor instructor;

    @ManyToMany
    private List<Student> students;

}
