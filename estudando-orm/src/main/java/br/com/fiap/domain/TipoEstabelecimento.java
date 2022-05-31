package br.com.fiap.domain;

import jakarta.persistence.*;


@Entity
@Table(name="tipo_estabelecimento")
public class TipoEstabelecimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_est_seq")
	@SequenceGenerator(name = "tipo_est_seq", sequenceName = "TIPO_ESTABELECIMENTO_SEQ", allocationSize = 1)
	@Column(name = "id_tipo_estabelecimento")
	private Integer id;
	
	@Column(name="nome_tipo_estabelecimento")
	private String nome;
	
	private TipoEstabelecimento tipo;

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
/*
	public TipoEstabelecimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEstabelecimento tipo) {
		this.tipo = tipo;
	}

	*/
	

}
