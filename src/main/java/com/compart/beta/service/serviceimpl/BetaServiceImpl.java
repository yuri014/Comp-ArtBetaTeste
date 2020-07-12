package com.compart.beta.service.serviceimpl;

import com.compart.beta.model.Post;
import com.compart.beta.repository.BetaRepository;
import com.compart.beta.service.BetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetaServiceImpl implements BetaService {

    @Autowired
    BetaRepository betaRepository;

    @Override
    public List<Post> findAll() {
        return betaRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        return betaRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return betaRepository.save(post);
    }
}
