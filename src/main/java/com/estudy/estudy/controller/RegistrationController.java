package com.estudy.estudy.controller;

import com.estudy.estudy.data.dto.InstructorPartyDto;
import com.estudy.estudy.service.instructor.InstructorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class RegistrationController {

    @Autowired
    InstructorServiceImpl instructorService;

    @PostMapping("/instructor")
    public ResponseEntity<?>
    registerAsInstructor(@RequestBody
                                 InstructorPartyDto instructorPartyDto){
        log.info("instructor object --> {}", instructorPartyDto);
        return
                ResponseEntity.ok()
                        .body(instructorService.save(instructorPartyDto));
    }
}