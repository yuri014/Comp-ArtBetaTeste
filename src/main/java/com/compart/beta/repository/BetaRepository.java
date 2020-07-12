package com.compart.beta.repository;

import com.compart.beta.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BetaRepository extends JpaRepository<Post, Long> {
}
