package br.com.cappacitar.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cappacitar.DTO.LancamentoDTO;
import br.com.cappacitar.entity.Lancamento;
import br.com.cappacitar.entity.TipoLancamento;
import br.com.cappacitar.entity.TipoTransacao;
import br.com.cappacitar.service.LancamentoService;

@RestController
@RequestMapping("/api/lancamento")
public class LancamentoController extends BaseController<LancamentoDTO> {

	private LancamentoService lancamentoService;
	

	public LancamentoController(LancamentoService lancamentoService) {
		super(lancamentoService);
		this.lancamentoService = lancamentoService;
	}

	@GetMapping("/filtro")
	public ResponseEntity<List<Lancamento>> getFiltro(
	        @RequestParam(value = "descricao", required = false, defaultValue = "") String descricao,
	        @RequestParam(value = "tipoLancamento", required = false) Long tipoLancamento,
	        @RequestParam(value = "dataLancamentoInicio", required = false) String dataLancamentoInicio,
            @RequestParam(value = "dataLancamentoFinal", required = false) String dataLancamentoFinal,
            @RequestParam(value = "tipoTransacao", required = false) String tipoTransacao
	) {
	    try {
	        List<Lancamento> lancamentos = lancamentoService.listaFiltroLancamentoNative(descricao.toUpperCase(), tipoLancamento, dataLancamentoInicio, dataLancamentoFinal, tipoTransacao);
	        return ResponseEntity.status(HttpStatus.OK).body(lancamentos);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.emptyList());
	    }
	}
	
	

}