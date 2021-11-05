package com.estudy.estudy.data.dto.request;

import com.estudy.estudy.data.model.Instructor;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CourseRequestUpdateDto {
    private Long Id;
    private  String title;
    private  String description;
    private List<String> imageUrls;
    private Instructor instructor;
    private LocalDateTime update;
}
