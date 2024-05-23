package br.com.cappacitar.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cappacitar.DTO.CnpjDTO;
import br.com.cappacitar.service.CnpjService;

@RestController
@RequestMapping("/api/cnpj")
public class CnpjController extends BaseController<CnpjDTO>{
	
	private CnpjService cnpjService;
	
	public CnpjController(CnpjService cnpjService) {
		super(cnpjService);
		this.cnpjService = cnpjService;
	}
	
}