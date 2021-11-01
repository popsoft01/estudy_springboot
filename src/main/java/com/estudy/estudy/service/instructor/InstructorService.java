package com.estudy.estudy.service.instructor;

import com.estudy.estudy.data.dto.InstructorPartyDto;
import com.estudy.estudy.data.model.Instructor;

public interface InstructorService {
    Instructor save(InstructorPartyDto dto);

}
