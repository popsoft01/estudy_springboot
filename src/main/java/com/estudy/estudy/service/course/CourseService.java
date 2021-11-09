package com.estudy.estudy.service.course;

import com.estudy.estudy.data.dto.request.CourseRequestDto;
import com.estudy.estudy.data.dto.request.CourseRequestUpdateDto;
import com.estudy.estudy.data.dto.response.CourseViewAllDto;
import com.estudy.estudy.data.model.Course;

import java.util.List;

public interface CourseService {
    Course create(CourseRequestDto courseRequestDto);
    List<CourseViewAllDto> viewCourses();
    Course updateCourse(CourseRequestUpdateDto courseRequestUpdateDto);
    void deleteCourse(Course course);
}
