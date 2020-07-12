package com.compart.beta.controller;

import com.compart.beta.model.Artista;
import com.compart.beta.model.Post;
import com.compart.beta.model.Usuario;
import com.compart.beta.repository.ArtistaRepository;
import com.compart.beta.repository.UsuarioRepository;
import com.compart.beta.service.ArtistaService;
import com.compart.beta.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PerfilController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ArtistaService artistaService;

    @Autowired
    private ArtistaRepository artistaRepository;

    @RequestMapping(value = "/perfil/artista/", method = RequestMethod.GET)
    public void method(HttpServletResponse httpServletResponse, @AuthenticationPrincipal UserDetails currentArtist) throws IOException {
        Artista art = (Artista) artistaRepository.findByUsername(currentArtist.getUsername());
        String username = art.getUsername();
        httpServletResponse.sendRedirect("/perfil/artista/" + username);
    }

    @RequestMapping(value = "/perfil/artista/{username}", method = RequestMethod.GET)
    public ModelAndView getArtistaDetails(@PathVariable("username") String username) {

        ModelAndView mv = new ModelAndView("artistaPerfil");
        Artista artista = artistaService.findByUsername(username);
        mv.addObject("artist", artista);
        return mv;

    }

    @RequestMapping(value = "/perfil/usuario/", method = RequestMethod.GET)
    public void methodu(HttpServletResponse httpServletResponse, @AuthenticationPrincipal UserDetails currentUser) throws IOException {
        Usuario usuario = (Usuario) usuarioRepository.findByUsername(currentUser.getUsername());
        String username = usuario.getUsername();
        httpServletResponse.sendRedirect("/perfil/usuario/" + username);
    }

    @RequestMapping(value = "/perfil/usuario/{username}", method = RequestMethod.GET)
    public ModelAndView getUserDetails(@PathVariable("username") String username) {

        ModelAndView mv = new ModelAndView("userPerfil");
        Usuario usuario = usuarioService.findByUsername(username);
        mv.addObject("user", usuario);
        return mv;

    }

}
