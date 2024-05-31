package br.com.cappacitar.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.cappacitar.entity.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Integer> {

//	@Query(value = "SELECT l FROM br.com.cappacitar.entity.Lancamento l " +
//	        "WHERE " +
//	        "((UPPER(l.descricaoLancamento) LIKE %:descricao% OR :descricao IS NULL)) " +
//	        "AND " +
//	        "((:tipoLancamento IS NULL OR l.tipoLancamento = :tipoLancamento)) " +
//	        "AND " +
//	        "(( (l.dataLancamento >= :dataLancamentoInicio) OR (:dataLancamentoInicio IS NULL) ) AND ( (l.dataLancamento <= :dataLancamentoFinal) OR (:dataLancamentoFinal IS NULL) ) ) " +
//	        "AND " +
//	        "((l.dataPagamento BETWEEN :dataPagamentoInicio AND :dataPagamentoFinal) OR (:dataPagamentoInicio IS NULL OR :dataPagamentoFinal IS NULL))")
//	List<Lancamento> listaFiltroLancamento(
//	        @Param("descricao") String descricao,
//	        @Param("tipoLancamento") TipoLancamento tipoLancamento,
//	        @Param("dataLancamentoInicio") LocalDate dataLancamentoInicio,
//	        @Param("dataLancamentoFinal") LocalDate dataLancamentoFinal,
//	        @Param("dataPagamentoInicio") LocalDate dataPagamentoInicio,
//	        @Param("dataPagamentoFinal") LocalDate dataPagamentoFinal);

	  @Query(value = "SELECT * FROM t_lancamento l, t_tipo_lancamento tl " +
	            "WHERE tl.id = l.idtipolancamento " +
	            "AND (UPPER(l.descricaolancamento) LIKE CONCAT('%', :descricao, '%') OR :descricao IS NULL) " +
	            "AND (l.datalancamento >= CAST(:dataLancamentoInicio AS DATE) OR :dataLancamentoInicio IS NULL) " +
	            "AND (l.datalancamento <= CAST(:dataLancamentoFinal AS DATE) OR :dataLancamentoFinal IS NULL) " +
	            "AND (:tipoLancamento IS NULL OR l.idtipolancamento = :tipoLancamento) " +
	            "AND (:tipoTransacao IS NULL OR tl.tipoTransacao = :tipoTransacao)",
	            nativeQuery = true)
	    List<Lancamento> listaFiltroLancamentoNative(
	            @Param("descricao") String descricao,
	            @Param("tipoLancamento") Long tipoLancamento,
	            @Param("dataLancamentoInicio") String dataLancamentoInicio,
	            @Param("dataLancamentoFinal") String dataLancamentoFinal,
	            @Param("tipoTransacao") String tipoTransacao);
	  
//	  @Query(value = "SELECT * FROM t_lancamento l, t_tipo_lancamento tl " +
//      "WHERE tl.id = l.idtipolancamento " +
//      "AND (UPPER(l.descricaolancamento) LIKE CONCAT('%', :descricao, '%') OR :descricao IS NULL) " +
//      "AND (l.datalancamento >= CAST(:dataLancamentoInicio AS DATE) OR :dataLancamentoInicio IS NULL) " +
//      "AND (l.datalancamento <= CAST(:dataLancamentoFinal AS DATE) OR :dataLancamentoFinal IS NULL) " +
//      "AND (:tipoLancamento IS NULL OR l.idtipolancamento = :tipoLancamento) " +
//      "AND (:tipoTransacao IS NULL OR tl.tipoTransacao = :tipoTransacao) ",
//      nativeQuery = true)
//List<Lancamento> listaFiltroLancamentoNative(
//      @Param("descricao") String descricao,
//      @Param("tipoLancamento") Long tipoLancamento,
//      @Param("dataLancamentoInicio") String dataLancamentoInicio,
//      @Param("dataLancamentoFinal") String dataLancamentoFinal,
//      @Param("tipoTransacao") String tipoTransacao);
}
