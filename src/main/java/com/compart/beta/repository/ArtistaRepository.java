package com.compart.beta.repository;

import com.compart.beta.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long>, UserDetailsService {
    Artista findByUsername(String username);
}
