package com.estudy.estudy.data.model;

import com.estudy.estudy.data.repository.InstructorRepository;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Builder
@Slf4j
@Sql(scripts={"/db/insert.sql"})
class InstructorTest {
        @Autowired
       private InstructorRepository instructorRepository;

        @BeforeEach
        void beforeEach(){

        }
        @Test
        void saveInstructorAsLearningPartyTest(){
            // create a learning party
            LearningParty user =new LearningParty("trainer@gmail.com",
                    "1234pass",new Authority(Role.ROLE_INSTRUCTOR));
            //create instructor
            //map instructor with learning party
            Instructor instructor=Instructor.builder()
                    .firstname("John")
                    .lastname("Alao")
                    .learningParty(user).build();
            //save instructor
            instructorRepository.save(instructor);
            log.info("Instructor before saving->{}",instructor);
            assertThat(instructor.getId()).isNotNull();
            assertThat(instructor.getLearningParty().getId()).isNotNull();
            log.info("Instructor after saving->{}",instructor);
        }
        @Test
        void testThatFirstNameAndLastNameCannotBeNullInTheInstructor(){
            // create a learning party
            LearningParty user =new LearningParty("trainer@gmail.com",
                    "1234pass",new Authority(Role.ROLE_INSTRUCTOR));
            //create instructor
            //map instructor with learning party
            Instructor instructor=Instructor.builder()
                    .firstname(null)
                    .lastname(null)
                    .learningParty(user).build();

            assertThrows(ConstraintViolationException.class,
                    ()->instructorRepository.save(instructor));
        }

        @Test
        void testThatFirstNameAndLastNameCannotBeBlankInTheInstructor(){
            // create a learning party
            LearningParty user =new LearningParty("trainer@gmail.com",
                    "1234pass",new Authority(Role.ROLE_INSTRUCTOR));
            //create instructor
            //map instructor with learning party
            Instructor instructor=Instructor.builder().firstname("   ")
                    .lastname(" ")
                    .learningParty(user).build();

            assertThrows(ConstraintViolationException.class,
                    ()->instructorRepository.save(instructor));
        }
}