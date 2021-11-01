package com.estudy.estudy.service.instructor;

import com.estudy.estudy.data.dto.InstructorPartyDto;
import com.estudy.estudy.data.model.Authority;
import com.estudy.estudy.data.model.Instructor;
import com.estudy.estudy.data.model.LearningParty;
import com.estudy.estudy.data.model.Role;
import com.estudy.estudy.data.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImpl implements InstructorService{

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public Instructor save(InstructorPartyDto instructorDto) {


        if(instructorDto == null){
            throw new IllegalArgumentException("Instructor cannot be null");
        }
        LearningParty learningParty
                = new LearningParty(instructorDto.getEmail()
                ,passwordEncoder.encode(instructorDto.getPassword())
                , new Authority(Role.ROLE_INSTRUCTOR));

        Instructor instructor = Instructor.builder()
                .lastname(instructorDto.getLastname())
                .firstname(instructorDto.getFirstname())
                .learningParty(learningParty).build();

        return instructorRepository.save(instructor);
    }
}
