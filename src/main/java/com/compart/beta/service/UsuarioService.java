package com.compart.beta.service;

import com.compart.beta.model.Usuario;
import com.compart.beta.web.UsuarioRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends UserDetailsService {

    Usuario findByUsername(String username);

    Usuario save(UsuarioRegistrationDto registration);

}
