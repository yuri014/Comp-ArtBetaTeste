package com.compart.beta.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class ArtistaRepositoryImpl implements UserDetailsService {

    @Autowired
    private ArtistaRepository artistaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return (UserDetails) artistaRepository.findByUsername(username);
    }

}
