package br.com.cappacitar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.cappacitar.service.IBaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public abstract class BaseController<DTO> {

	private IBaseService service;

	public BaseController(IBaseService service) {
		this.service = service;
	}

	@GetMapping("/count")
	@Transactional
	public ResponseEntity getPageCount(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {

		try {

			return ResponseEntity.status(HttpStatus.OK).body("{\"pages\": " + service.countPages(page, size) + "}");

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"message\": \"Error. Please try again later.\"}");

		}

	}

	@GetMapping("/")
	// @Hidden Ocultar algum método especifico
	@Operation(summary = "Listar Todos", description = "Método que retorna todos os dados", method = "GET")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida ou dados fornecidos são inválidos"),
			@ApiResponse(responseCode = "401", description = "Autenticação necessária e não fornecida ou falhou"),
			@ApiResponse(responseCode = "403", description = "Acesso negado ao recurso solicitado"),
			@ApiResponse(responseCode = "404", description = "Referência a recurso não encontrado"),
			@ApiResponse(responseCode = "405", description = "Método de requisição não permitido"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
//	@Transactional
	public ResponseEntity getAll() {

		try {

			return ResponseEntity.status(HttpStatus.OK).body(service.findAll());

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"message\": \"Error. Please try again later.\"}");

		}

	}

	@GetMapping("/{id}")
	// @Hidden Ocultar algum método especifico
	@Operation(summary = "Pegar por Id", description = "Método que retorna por ID", method = "GET")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida ou dados fornecidos são inválidos"),
			@ApiResponse(responseCode = "401", description = "Autenticação necessária e não fornecida ou falhou"),
			@ApiResponse(responseCode = "403", description = "Acesso negado ao recurso solicitado"),
			@ApiResponse(responseCode = "404", description = "Referência a recurso não encontrado"),
			@ApiResponse(responseCode = "405", description = "Método de requisição não permitido"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
	@Transactional
	public ResponseEntity getOne(@PathVariable int id) {

		try {

			return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"message\": \"Error. Please check the ID, and try again later.\"}");

		}

	}

	@PostMapping("/")
	// @Hidden Ocultar algum método especifico
	@Operation(summary = "Cria", description = "Método para criar", method = "POST")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Requisição bem-sucedida"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida ou dados fornecidos são inválidos"),
			@ApiResponse(responseCode = "401", description = "Autenticação necessária e não fornecida ou falhou"),
			@ApiResponse(responseCode = "403", description = "Acesso negado ao recurso solicitado"),
			@ApiResponse(responseCode = "404", description = "Referência a recurso não encontrado"),
			@ApiResponse(responseCode = "405", description = "Método de requisição não permitido"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
//	@Transactional
	public ResponseEntity post(@RequestBody DTO dto) {

		try {

			DTO result = (DTO) service.save(dto);
			return ResponseEntity.status(HttpStatus.CREATED).body(result);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"message\": \"Erro ao tentar inserir os dados.\"}");

		}

	}

	@PutMapping("/{id}")
	// @Hidden Ocultar algum método especifico
	@Operation(summary = "Atualiza", description = "Método para atualizar", method = "PUT")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida ou dados fornecidos são inválidos"),
			@ApiResponse(responseCode = "401", description = "Autenticação necessária e não fornecida ou falhou"),
			@ApiResponse(responseCode = "403", description = "Acesso negado ao recurso solicitado"),
			@ApiResponse(responseCode = "404", description = "Referência a recurso não encontrado"),
			@ApiResponse(responseCode = "405", description = "Método de requisição não permitido"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
	@Transactional
	public ResponseEntity put(@PathVariable int id, @RequestBody DTO dto) {

		try {

			DTO result = (DTO) service.update(id, dto);
			return ResponseEntity.status(HttpStatus.OK).body(result);

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"message\": \"Error. Please check the ID or BODY request, and try again later.\"}");

		}

	}

	@DeleteMapping("/{id}")
	// @Hidden Ocultar algum método especifico
	@Operation(summary = "Deleta", description = "Método para deletar", method = "DELETE")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Requisição bem-sucedida"),
			@ApiResponse(responseCode = "400", description = "Requisição inválida ou dados fornecidos são inválidos"),
			@ApiResponse(responseCode = "401", description = "Autenticação necessária e não fornecida ou falhou"),
			@ApiResponse(responseCode = "403", description = "Acesso negado ao recurso solicitado"),
			@ApiResponse(responseCode = "404", description = "Rede não encontrada para o ID fornecido"),
			@ApiResponse(responseCode = "405", description = "Método de requisição não permitido"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
	@Transactional
	public ResponseEntity delete(@PathVariable int id) {
		try {

			service.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"message\": \"Error. Please check the ID or BODY request, and try again later.\"}");

		}

	}

}