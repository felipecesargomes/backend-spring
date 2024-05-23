package br.com.cappacitar.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import br.com.cappacitar.DTO.CnpjDTO;
import br.com.cappacitar.entity.Cnpj;
import br.com.cappacitar.repository.CnpjRepository;

@Service
public class CnpjService extends BaseService<Cnpj, CnpjDTO>{

	private CnpjRepository cnpjRepository;
	
	public CnpjService(CnpjRepository cnpjRepository) {		
		super(cnpjRepository, CnpjDTO.class, Cnpj.class);
		this.cnpjRepository = cnpjRepository;
	}
	
}