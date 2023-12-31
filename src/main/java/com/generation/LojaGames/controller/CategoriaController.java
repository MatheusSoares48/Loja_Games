package com.generation.LojaGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.LojaGames.model.Categoria;
import com.generation.LojaGames.repository.CategoriaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired 
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(categoriaRepository.findAll()); 
		
	}
	
	//Pega o id especifico 
	@GetMapping("/{id}")
	public ResponseEntity<Categoria>  getById(@PathVariable Long id){
		
		return categoriaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Categoria>> getByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(categoriaRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
		
	@PostMapping
	public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria Categoria){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(categoriaRepository.save(Categoria));
		
	}
	
	@PutMapping
	public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria Categoria){
		if(categoriaRepository.existsById(Categoria.getId())) {
			return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(Categoria));
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
				
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		if(categoriaRepository.existsById(id)) {
			categoriaRepository.deleteById(id);
		}else {	
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}		
}
