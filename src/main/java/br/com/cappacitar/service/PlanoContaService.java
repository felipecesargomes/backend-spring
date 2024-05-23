package br.com.cappacitar.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import br.com.cappacitar.DTO.PlanoContaDTO;
import br.com.cappacitar.entity.PlanoConta;
import br.com.cappacitar.repository.PlanoContaRepository;

@Service
public class PlanoContaService extends BaseService<PlanoConta, PlanoContaDTO>{

	private PlanoContaRepository planoContaRepository;
	
	public PlanoContaService(PlanoContaRepository planoContaRepository) {		
		super(planoContaRepository, PlanoContaDTO.class, PlanoConta.class);
		this.planoContaRepository = planoContaRepository;
	}
	
}