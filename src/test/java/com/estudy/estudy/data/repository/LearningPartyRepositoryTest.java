package com.estudy.estudy.data.repository;

import com.estudy.estudy.data.model.Authority;
import com.estudy.estudy.data.model.LearningParty;
import com.estudy.estudy.data.model.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
@Sql(scripts = {"/db/insert.sql"})
class LearningPartyRepositoryTest {
    @Autowired
    LearningPartyRepository learningPartyRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void createLearningPartyTest(){
        LearningParty learningParty = new LearningParty("bola@yahoo.co","your123",new Authority(Role.ROLE_STUDENT));
        learningPartyRepository.save(learningParty);
        assertThat(learningParty.getId()).isNotNull();
        assertThat(learningParty.getEmail()).isNotNull();
        assertThat(learningParty.getAuthorities().get(0).getAuthority()).isEqualTo(Role.ROLE_STUDENT);
        assertThat(learningParty.getAuthorities().get(0).getId()).isNotNull();
        log.info("After saving --> {}",learningParty);
    }
    @Test
    void canNotCreateTheDifferentUserWithTheSameEmail(){
        LearningParty user = new LearningParty("abola@yahoo.co","your123",new Authority(Role.ROLE_STUDENT));
        learningPartyRepository.save(user);
        assertThat(user.getEmail()).isEqualTo("abola@yahoo.co");
        assertThat(user.getId()).isNotNull();

        LearningParty user2 = new LearningParty("abola@yahoo.co","your123",new Authority(Role.ROLE_STUDENT));
        assertThrows(DataIntegrityViolationException.class, ()->learningPartyRepository.save(user2));
    }
    @Test
    void learningPathWithNullEmail(){
       LearningParty user = new LearningParty("","",new Authority(Role.ROLE_STUDENT));
        learningPartyRepository.save(user);
        assertThat(user.getEmail()).isEqualTo(null);
        assertThat(user.getId()).isNotNull();
        assertThrows(DataIntegrityViolationException.class, ()->learningPartyRepository.save(user));
    }

    @AfterEach
    void tearDown() {
    }
}