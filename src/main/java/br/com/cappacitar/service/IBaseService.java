package br.com.cappacitar.service;

import java.util.List;

public interface IBaseService <DTO>{

	public int countPages(int page, int size) throws Exception;
	
	public List<DTO> findAll() throws Exception;
	
	public DTO findById(Long id) throws Exception;
	
	public DTO save (DTO dto) throws Exception;
	
	public DTO update (Long id, DTO dto) throws Exception;
	
	public boolean delete(Long id) throws Exception;
}
