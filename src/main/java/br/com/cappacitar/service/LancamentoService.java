package br.com.cappacitar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cappacitar.DTO.LancamentoDTO;
import br.com.cappacitar.entity.Lancamento;
import br.com.cappacitar.entity.TipoLancamento;
import br.com.cappacitar.repository.LancamentoRepository;

@Service
public class LancamentoService extends BaseService<Lancamento, LancamentoDTO> {

	private LancamentoRepository lancamentoRepository;

	public LancamentoService(LancamentoRepository lancamentoRepository) {
		super(lancamentoRepository, LancamentoDTO.class, Lancamento.class);
		this.lancamentoRepository = lancamentoRepository;
	}

	@Transactional(readOnly = true)
	public List<Lancamento> listaFiltroLancamento(String descricao, TipoLancamento tipoLancamento,
			String dataLancamentoInicio, String dataLancamentoFinal) {

		dataLancamentoInicio = dataLancamentoInicio != null ? "'" + dataLancamentoInicio + "'" : null;
		dataLancamentoFinal = dataLancamentoFinal != null ? "'" + dataLancamentoFinal + "'" : null;

		// LocalDate dataInicioLancamento = dataLancamentoInicio != null ?
		// LocalDate.parse(dataLancamentoInicio) : null;
		// System.out.println(dataInicioLancamento);
		// LocalDate dataFinalLancamento = dataLancamentoFinal != null ?
		// LocalDate.parse(dataLancamentoFinal) : null;
		// LocalDate dataInicioPagamento = dataPagamentoInicio != null ?
		// LocalDate.parse(dataPagamentoInicio) : null;
		// LocalDate dataFinalPagamento = dataPagamentoFinal != null ?
		// LocalDate.parse(dataPagamentoFinal) : null;
		List<Lancamento> list = new ArrayList<Lancamento>();
		try {

			list = lancamentoRepository.listaFiltroLancamentoNative(
					descricao.isEmpty() ? null : descricao.toUpperCase(),
					tipoLancamento != null ? tipoLancamento.getId() : null, dataLancamentoInicio, dataLancamentoFinal);
			for (Lancamento lancamento : list) {
				System.out.println(lancamento.getDataLancamento());
			}
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}