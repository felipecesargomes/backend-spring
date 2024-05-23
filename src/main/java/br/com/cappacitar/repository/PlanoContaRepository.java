package br.com.cappacitar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cappacitar.entity.PlanoConta;

@Repository()
public interface PlanoContaRepository extends JpaRepository<PlanoConta, Integer>{

}
