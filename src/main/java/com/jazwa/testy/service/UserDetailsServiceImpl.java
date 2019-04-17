package com.jazwa.testy.service;

import com.jazwa.testy.model.User;
import com.jazwa.testy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user  = userRepository.findByUsername(s).orElseThrow(EntityNotFoundException::new);

        GrantedAuthority admin = new SimpleGrantedAuthority("ADMIN");

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), Arrays.asList(admin));
        return userDetails;
    }
}
