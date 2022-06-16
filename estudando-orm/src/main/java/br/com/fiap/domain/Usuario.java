package br.com.fiap.domain;

import jakarta.persistence.*;

public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usu_seq")
	@SequenceGenerator(name = "usu_seq", sequenceName = "USUARIO_SEQ", allocationSize = 1)
	@Column(name = "id_estabelecimento")
	private Integer id;
	
	@Column(name = "nome_usuario", length = 50)
	private String nome;
	
	@Column(name = "senha_usuario", length = 255)
	private String senha;
	
	public Usuario(Integer id, String nome, String senha) {
		
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

}
