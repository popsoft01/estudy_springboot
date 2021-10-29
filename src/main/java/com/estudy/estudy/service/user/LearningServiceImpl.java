package com.estudy.estudy.service.user;

import com.estudy.estudy.data.repository.LearningPartyRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LearningServiceImpl implements UserDetailsService {
    private LearningPartyRepository learningPartyRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
