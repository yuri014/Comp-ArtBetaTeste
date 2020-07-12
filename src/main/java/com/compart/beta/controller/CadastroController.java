package com.compart.beta.controller;

import com.compart.beta.model.Artista;
import com.compart.beta.model.Usuario;
import com.compart.beta.repository.ArtistaRepository;
import com.compart.beta.repository.UsuarioRepository;
import com.compart.beta.service.ArtistaService;
import com.compart.beta.service.UsuarioService;
import com.compart.beta.web.ArtistaRegistrationDto;
import com.compart.beta.web.UsuarioRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class CadastroController {

    // USUARIOS

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @ModelAttribute("user")
    public UsuarioRegistrationDto usuarioRegistrationDto() {
        return new UsuarioRegistrationDto();
    }

    // ARTISTA

    @Autowired
    private ArtistaService artistaService;

    @Autowired
    private ArtistaRepository artistaRepository;

    @ModelAttribute("artist")
    public ArtistaRegistrationDto artistaRegistrationDto() {
        return new ArtistaRegistrationDto();
    }

    // CADASTROS

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/usuario")
    public String formUser(Model model) {
        return "usuario";
    }

    @GetMapping("/artista")
    public String formArt(Model model) {
        return "artista";
    }

    @PostMapping("/usuario")
    public String formUser(@ModelAttribute("user") UsuarioRegistrationDto usuarioDto, BindingResult result) {

        Usuario existing = usuarioService.findByUsername(usuarioDto.getUsername());
        if (existing != null) {
            result.rejectValue("username", null, "Essa conta já existe!");
        }

        if (result.hasErrors()) {
            return "/usuario";
        }

        usuarioService.save(usuarioDto);
        return "redirect:/login";
    }

    @PostMapping("/artista")
    public String formArt(@ModelAttribute("artist") ArtistaRegistrationDto artistaDto, BindingResult result) {

        Artista existing = artistaService.findByUsername(artistaDto.getUsername());
        if (existing != null) {
            result.rejectValue("username", null, "Essa conta já existe!");
        }

        if (result.hasErrors()) {
            return "/artista";
        }

        artistaService.save(artistaDto);
        return "redirect:/login";

    }

}
