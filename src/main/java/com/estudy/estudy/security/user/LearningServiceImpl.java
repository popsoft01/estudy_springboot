package com.estudy.estudy.security.user;

import com.estudy.estudy.data.model.Authority;
import com.estudy.estudy.data.model.LearningParty;
import com.estudy.estudy.data.repository.LearningPartyRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LearningServiceImpl implements UserDetailsService {
    private LearningPartyRepository learningPartyRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      LearningParty user = learningPartyRepository.findByEmail(email);
      if (user == null){
          throw new UsernameNotFoundException("User with email does not exist");
      }
        getAuthorities(user.getAuthorities());
        return new User(user.getEmail(),user.getPassword(),
               getAuthorities( user.getAuthorities()) );
    }

    private List<SimpleGrantedAuthority> getAuthorities
        (List<Authority> authorities){
        return  authorities
                .stream()
                .map(authority -> {
                    return new SimpleGrantedAuthority
                            (authority.getAuthority().name());
                }).collect(Collectors.toList());
    }
}
