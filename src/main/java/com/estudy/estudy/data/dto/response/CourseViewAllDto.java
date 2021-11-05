package com.estudy.estudy.data.dto.response;

import com.estudy.estudy.data.model.Instructor;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CourseViewAllDto {
    private Long Id;
    private  String title;
    private  String description;
    private List<String> imageUrls;
    private LocalDateTime dateCreated;
    private Instructor instructor;
}
