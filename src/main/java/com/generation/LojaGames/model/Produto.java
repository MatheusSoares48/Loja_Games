package com.generation.LojaGames.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produto") // CREATE TABLE tb_produtos
public class Produto {

	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private Long id;
		
	@Column(length = 100) // Define o maximo
	@NotBlank(message = "O Atributo Nome é Obrigatorio ;D") // NOT NULL do SQL só que não aceita nem espaço em branco ou pode usar NOT NULL que aceita espaços em branco
	@Size(min = 5, max = 100, message = "O Atributo Nome deve conter no mínimo 5 e no máximo 100 carácteres.")
	private String nome ;
	
	@Column(precision = 7, scale = 2) // Define 10 digitos com 2 digitos de decimal do BigDecimal
    @NotNull(message = "O Atributo Preço é Obrigatorio ;D")
	private BigDecimal preco ;
	
	@Column(length = 1000) // Define o maximo 
	@NotBlank(message = "O Atributo Texto é Obrigatorio ;D") // NOT NULL do SQL só que não aceita nem espaço em branco ou pode usar NOT NULL que aceita espaços em branco
	@Size(min = 10, max = 1000, message = "O Atributo Texto deve conter no mínimo 10 e no máximo 1000 carácteres.")
	private String texto ;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return nome;
	}

	public void setTitulo(String titulo) {
		this.nome = titulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria Categoria) {
		this.categoria = Categoria;
	}
}
