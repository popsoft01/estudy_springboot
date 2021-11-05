package com.estudy.estudy.service.student;

import com.estudy.estudy.data.dto.request.CourseRequestDto;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceImpl implements StudentService{

    private CourseRequestDto courseRequestDto;

    @Autowired
    public StudentServiceImpl(CourseRequestDto courseRequestDto) {
        this.courseRequestDto = courseRequestDto;
    }
}
