package com.compart.beta.utils;

import com.compart.beta.model.Post;
import com.compart.beta.repository.BetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    BetaRepository betaRepository;

    // @PostConstruct
    public void savePosts() {

        List<Post> postList = new ArrayList<>();
        Post post1 = new Post();
        post1.setAutor("Ziggy Nelson");
        post1.setDescricao("Meu primeiro post.");
        post1.setData(LocalDate.now());
        post1.setConteudo("Miauuu miau");

        Post post2 = new Post();
        post2.setAutor("Lola");
        post2.setDescricao("Meu texto");
        post2.setData(LocalDate.now());
        post2.setConteudo("Texto");

        postList.add(post1);
        postList.add(post2);

        for(Post post: postList){

            Post postSaved = betaRepository.save(post);
            System.out.println(postSaved.getId());

        }

    }

}
