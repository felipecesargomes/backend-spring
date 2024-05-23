package br.com.cappacitar.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cappacitar.DTO.TipoLancamentoDTO;
import br.com.cappacitar.service.TipoLancamentoService;

@RestController
@RequestMapping("/api/tipolancamento")
public class TipoLancamentoController extends BaseController<TipoLancamentoDTO>{
	
	private TipoLancamentoService tipoLancamentoService;
	
	public TipoLancamentoController(TipoLancamentoService tipoLancamentoService) {
		super(tipoLancamentoService);
		this.tipoLancamentoService = tipoLancamentoService;
	}
	
}