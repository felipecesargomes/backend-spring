package br.com.cappacitar.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cappacitar.DTO.UsuarioDTO;
import br.com.cappacitar.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController extends BaseController<UsuarioDTO>{
	
	private UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		super(usuarioService);
		this.usuarioService = usuarioService;
	}
	
}