package com.jazwa.testy.service;

import com.jazwa.testy.model.User;
import com.jazwa.testy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user  = userRepository.findByUsername(s).orElseThrow(EntityNotFoundException::new);

        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),encoder.encode(user.getPassword()), Arrays.asList(authority));
        return userDetails;
    }


}
