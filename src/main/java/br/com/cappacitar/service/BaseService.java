package br.com.cappacitar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cappacitar.DTO.BaseDTO;
import br.com.cappacitar.entity.Base;

public abstract class BaseService<ENTITY extends Base, DTO extends BaseDTO> implements IBaseService<DTO> {

	private JpaRepository repository;
	private Class dtoClass;
	private Class entityClass;

	public BaseService(JpaRepository repository, Class dtoClass, Class entityClass) {
		this.repository = repository;
		this.dtoClass = dtoClass;
		this.entityClass = entityClass;
	}

	public int countPages(int page, int size) throws Exception {
		try {

			Pageable pageable = PageRequest.of(page, size);
			return repository.findAll(pageable).getTotalPages();

		} catch (Exception e) {

			throw new Exception();

		}
	}

	@Transactional(readOnly = true)
	public List<DTO> findAll() throws Exception {
		List<DTO> dtos = new ArrayList<>();

		try {
			ModelMapper modelMapper = new ModelMapper();
			// modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
			List<ENTITY> entities = repository.findAll();

			for (ENTITY item : entities) {
				DTO dto = (DTO) modelMapper.map(item, dtoClass);
				dtos.add(dto);
			}

		} catch (Exception e) {
			throw new Exception("Error fetching all entities", e);
		}

		return dtos;
	}

	@Transactional(readOnly = true)
	public DTO findById(Long id) throws Exception {

		Optional<ENTITY> entityOptional = repository.findById(id);

		try {

			ENTITY entity = entityOptional.get();
			ModelMapper modelMapper = new ModelMapper();
			//modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
			return (DTO) modelMapper.map(entity, dtoClass);

		} catch (Exception e) {

			throw new Exception();

		}

	}
	
	@Transactional
	public DTO save(DTO dto) throws Exception {

		ENTITY entity;
		ModelMapper modelMapper = new ModelMapper();
		// modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);

		try {

			entity = (ENTITY) modelMapper.map(dto, entityClass);
			entity = (ENTITY) repository.save(entity);

			return (DTO) modelMapper.map(entity, dtoClass);

		} catch (Exception e) {

			throw e; // Relança a exceção original

		}

	}



	@Transactional
	public DTO update(Long id, DTO dto) throws Exception {

		Optional<ENTITY> entityOptional = repository.findById(id);
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);

		try {

			ENTITY entity = entityOptional.get();
			ENTITY entityParams = (ENTITY) modelMapper.map(dto, entityClass);

			try {

				if (repository.existsById(id)) {

					entityParams.setId(id);
					entity = (ENTITY) repository.save(entityParams);
					return (DTO) modelMapper.map(entity, dtoClass);

				} else {

					throw new Exception();

				}

			} catch (Exception e) {

				throw new Exception();

			}

		} catch (Exception e) {

			throw new Exception();

		}

	}

	@Transactional
	public boolean delete(Long id) throws Exception {

		try {

			if (repository.existsById(id)) {

				repository.deleteById(id);
				return true;

			}

			else {

				throw new Exception();

			}

		} catch (Exception e) {

			throw new Exception();

		}

	}

	
//	@Transactional
//	public DTO save(DTO dto) throws Exception {
//
//		ENTITY entity;
//		ModelMapper modelMapper = new ModelMapper();
//		// modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
//
//		try {
//
//			entity = (ENTITY) modelMapper.map(dto, entityClass);
//			if (entity.getId() > 0) {
//				Optional<ENTITY> existingEntity = repository.findById(entity.getId());
//				if (existingEntity.isPresent()) {
//					ENTITY updatedEntity = existingEntity.get();
//					modelMapper.map(dto, updatedEntity); // Atualiza os campos necessários
//					entity = (ENTITY) repository.save(updatedEntity);
//				} else {
//					throw new Exception("ID não encontrado para atualização");
//				}
//			} else {
//				// Criação de nova entidade
//				entity.setId(0); // Assegura que ID seja 0 para a criação
//				entity = (ENTITY) repository.save(entity);
//			}
//
//			return (DTO) modelMapper.map(entity, dtoClass);
//
//		} catch (Exception e) {
//
//			throw e; // Relança a exceção original
//
//		}
//
//	}

}
