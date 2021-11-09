package com.estudy.estudy.service.course;

import com.estudy.estudy.data.dto.request.CourseRequestDto;
import com.estudy.estudy.data.dto.request.CourseRequestUpdateDto;
import com.estudy.estudy.data.dto.response.CourseViewAllDto;
import com.estudy.estudy.data.model.Course;
import com.estudy.estudy.data.repository.CourseRepository;
import com.estudy.estudy.utilities.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements  CourseService{


    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;


    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public Course create(CourseRequestDto courseRequestDto) {
        return courseRepository.save(courseMapper.createCourse(courseRequestDto));
    }

    @Override
    public List<CourseViewAllDto> viewCourses() {
        List<CourseViewAllDto> courses = new ArrayList<>();
        courseRepository.findAll()
                .forEach(course -> courses.add(courseMapper.courseViewDto(course)));
        return courses;
    }

    @Override
    public Course updateCourse(CourseRequestUpdateDto courseRequestUpdateDto) {
        return courseRepository.save(courseMapper.updateCourse(courseRequestUpdateDto));
    }

    @Override
    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }

}
