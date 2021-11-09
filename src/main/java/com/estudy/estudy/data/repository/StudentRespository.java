package com.estudy.estudy.data.repository;

import com.estudy.estudy.data.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRespository extends JpaRepository<Student, Long> {
}
