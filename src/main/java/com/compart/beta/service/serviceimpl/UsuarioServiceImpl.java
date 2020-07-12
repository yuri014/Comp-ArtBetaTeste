package com.compart.beta.service.serviceimpl;

import com.compart.beta.model.Usuario;
import com.compart.beta.model.UsuarioRole;
import com.compart.beta.repository.UsuarioRepository;
import com.compart.beta.service.UsuarioService;
import com.compart.beta.web.UsuarioRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario findByUsername(String artistname) {
        return usuarioRepository.findByUsername(artistname);
    }

    public Usuario save(UsuarioRegistrationDto registration) {

        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(registration.getNomeUsuario());
        usuario.setSobrenomeUsuario(registration.getSobrenomeUsuario());
        usuario.setUsername(registration.getUsername());
        usuario.setSenhaUsuario(passwordEncoder.encode(registration.getSenhaUsuario()));
        usuario.setPreferencia(registration.getPreferencia());
        usuario.setUsuarioRoles(Arrays.asList(new UsuarioRole("ROLE_USER")));
        return usuarioRepository.save(usuario);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário ou senha inválida.");
        }

        return new org.springframework.security.core.userdetails.User(usuario.getUsername(),
                usuario.getSenhaUsuario(), mapRolesToAuthorities(usuario.getUsuarioRoles()));

    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection <UsuarioRole> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getNomeRole()))
                .collect(Collectors.toList());
    }

}
