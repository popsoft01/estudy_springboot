package com.estudy.estudy.data.repository;

import com.estudy.estudy.data.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
