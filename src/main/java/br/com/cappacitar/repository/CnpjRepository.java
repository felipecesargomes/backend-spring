package br.com.cappacitar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cappacitar.entity.Cnpj;

@Repository()
public interface CnpjRepository extends JpaRepository<Cnpj, Integer>{

}
