package com.compart.beta.service;

import com.compart.beta.model.Artista;
import com.compart.beta.web.ArtistaRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ArtistaService extends UserDetailsService {

    Artista findByUsername(String username);

    Artista save(ArtistaRegistrationDto registrationDto);

}
