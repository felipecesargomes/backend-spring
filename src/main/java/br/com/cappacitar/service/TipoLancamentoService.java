package br.com.cappacitar.service;

import org.springframework.stereotype.Service;
import br.com.cappacitar.DTO.TipoLancamentoDTO;
import br.com.cappacitar.entity.TipoLancamento;
import br.com.cappacitar.repository.TipoLancamentoRepository;

@Service
public class TipoLancamentoService extends BaseService<TipoLancamento, TipoLancamentoDTO>{

	private TipoLancamentoRepository tipoLancamentoRepository;
	
	public TipoLancamentoService(TipoLancamentoRepository tipoLancamentoRepository) {		
		super(tipoLancamentoRepository, TipoLancamentoDTO.class, TipoLancamento.class);
		this.tipoLancamentoRepository = tipoLancamentoRepository;
	}
	
}