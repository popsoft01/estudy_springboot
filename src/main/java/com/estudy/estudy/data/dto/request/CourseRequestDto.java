package com.estudy.estudy.data.dto.request;

import com.estudy.estudy.data.model.Instructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.List;

@Data
public class CourseRequestDto {
    private  String title;
    private  String description;
    private String language;
    private List<String> imageUrls;
    private Instructor instructor;

}
