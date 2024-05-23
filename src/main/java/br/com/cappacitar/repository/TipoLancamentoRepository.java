package br.com.cappacitar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cappacitar.entity.TipoLancamento;

@Repository()
public interface TipoLancamentoRepository extends JpaRepository<TipoLancamento, Integer>{

}
