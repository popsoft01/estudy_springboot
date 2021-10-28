package com.estudy.estudy.data.repository;

import com.estudy.estudy.data.model.Authority;
import com.estudy.estudy.data.model.LearningParty;
import com.estudy.estudy.data.model.Role;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class LearningPartyRepositoryTest {
    @Autowired
    LearningPartyRepository learningPartyRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createLearningPartyTest(){
        LearningParty learningParty = new LearningParty("ola@yahoo.co","your123",new Authority(Role.ROLE_STUDENT));
    }

    @AfterEach
    void tearDown() {
    }
}