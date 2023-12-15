package com.generation.LojaGames.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.LojaGames.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto , Long>{

	List<Produto> findAllByNomeContainingIgnoreCase(@Param("titulo") String nome);
	
	List<Produto> findByPrecoLessThanEqual(BigDecimal preco);
	List<Produto> findByPrecoGreaterThan(BigDecimal preco);
}
	