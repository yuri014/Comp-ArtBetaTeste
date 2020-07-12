package com.compart.beta.service;

import com.compart.beta.model.Post;

import java.util.List;

public interface BetaService {

    List<Post> findAll();
    Post findById(long id);
    Post save(Post post);

}
