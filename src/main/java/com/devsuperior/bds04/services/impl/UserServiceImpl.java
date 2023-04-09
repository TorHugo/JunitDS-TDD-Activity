package com.devsuperior.bds04.services.impl;

import com.devsuperior.bds04.model.entities.UserModel;
import com.devsuperior.bds04.repositories.UserRepository;
import com.devsuperior.bds04.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("1. Searching user in the database, by user email {}", email);
        UserModel user = repository.findByEmail(email);
        if (user == null)
            throw new UsernameNotFoundException("Email not found.");

        return user;
    }
}
