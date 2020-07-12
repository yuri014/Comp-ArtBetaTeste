package com.compart.beta.controller;

import com.compart.beta.model.Artista;
import com.compart.beta.model.Post;
import com.compart.beta.model.Usuario;
import com.compart.beta.repository.ArtistaRepository;
import com.compart.beta.repository.UsuarioRepository;
import com.compart.beta.service.ArtistaService;
import com.compart.beta.service.BetaService;
import com.compart.beta.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class BetaController {

    @Autowired
    BetaService betaService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private ArtistaService artistaService;

    @Autowired
    private UsuarioService usuarioService;

    // LOGIN

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    // POSTS

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts(RedirectAttributes attributes) {

        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = betaService.findAll();
        mv.addObject("posts", posts);
        return mv;

    }


    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostsDetails(@PathVariable("id") long id) {

        ModelAndView mv = new ModelAndView("postDetails");
        Post post = betaService.findById(id);
        mv.addObject("post", post);
        return mv;

    }

    // CRIAÇÃO DE POST

    @RequestMapping(value = "/novopost", method = RequestMethod.GET)
    public String getPostForm() {
        return "postForm";
    }

    @RequestMapping(value = "/novopost", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos obrigatórios, eles podem estar em branco!");
            return "redirect:/novopost";
        }
        post.setData(LocalDate.now());
        betaService.save(post);
        return "redirect:/posts";
    }

    // BUSCAS

    @RequestMapping(value="/busca")
    public ModelAndView busca(String username) {
        ModelAndView mv = new ModelAndView("busca");
        Iterable<Artista> artistas = artistaRepository.findAll();
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        mv.addObject("artistas", artistas);
        mv.addObject("usuarios", usuarios);
        return mv;
    }

}
