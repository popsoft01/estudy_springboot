package com.estudy.estudy.utilities;

import com.estudy.estudy.data.dto.request.CourseRequestDto;
import com.estudy.estudy.data.dto.request.CourseRequestUpdateDto;
import com.estudy.estudy.data.dto.response.CourseViewAllDto;
import com.estudy.estudy.data.model.Course;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CourseMapper {
//    @BeanMapping(nullValueCheckStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Course createCourse(CourseRequestDto courseRequestDto);
    CourseViewAllDto courseViewDto(Course course);
    Course updateCourse(CourseRequestUpdateDto courseRequestUpdateDto);
//    CourseViewAlllDto courseviewDto(Course course);
}
