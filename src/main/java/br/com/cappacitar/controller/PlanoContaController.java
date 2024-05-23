package br.com.cappacitar.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cappacitar.DTO.PlanoContaDTO;
import br.com.cappacitar.service.PlanoContaService;

@RestController
@RequestMapping("/api/planoconta")
public class PlanoContaController extends BaseController<PlanoContaDTO>{
	
	private PlanoContaService planoContaService;
	
	public PlanoContaController(PlanoContaService planoContaService) {
		super(planoContaService);
		this.planoContaService = planoContaService;
	}
	
}