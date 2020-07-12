package com.compart.beta.service.serviceimpl;

import com.compart.beta.model.Artista;
import com.compart.beta.model.ArtistaRole;
import com.compart.beta.repository.ArtistaRepository;
import com.compart.beta.service.ArtistaService;
import com.compart.beta.web.ArtistaRegistrationDto;
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
public class ArtistaServiceImpl implements ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Artista findByUsername(String username) {
        return artistaRepository.findByUsername(username);
    }

    public Artista save(ArtistaRegistrationDto registrationDto) {

        Artista artista = new Artista();
        artista.setNomeArtista(registrationDto.getNomeArtista());
        artista.setUsername(registrationDto.getUsername());
        artista.setSenhaArtista(passwordEncoder.encode(registrationDto.getSenhaArtista()));
        artista.setTipoArte(registrationDto.getTipoArte());
        artista.setArtistaRoles(Arrays.asList(new ArtistaRole("ROLE_ARTIST")));
        return artistaRepository.save(artista);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Artista artista = artistaRepository.findByUsername(username);

        if (artista == null) {
            throw new UsernameNotFoundException("Usuário ou senha inválida.");
        }

        return new org.springframework.security.core.userdetails.User(artista.getUsername(),
                artista.getSenhaArtista(), mapRolesToAuthorities(artista.getArtistaRoles()));

    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<ArtistaRole> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getNomeRole()))
                .collect(Collectors.toList());
    }

}
