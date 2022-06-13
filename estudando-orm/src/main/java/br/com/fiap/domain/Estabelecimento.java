package br.com.fiap.domain;

import java.util.Calendar;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_estabelecimento")
public class Estabelecimento {
	//id_estabelecimento, nome_estabelecimento, dh_criacao
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "est_seq")
	@SequenceGenerator(name = "est_seq", sequenceName = "TB_ESTABELECIMENTO_SEQ", allocationSize = 1)
	@Column(name = "id_estabelecimento")
	private Integer id;

	@Column(name = "nome_estabelecimento")
	private String nome;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_criacao")
	private Calendar dataHoraCriacao;
	
	@JoinColumn(name="ID_TIPO_ESTABELECIMENTO")
	@ManyToOne
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

	public Calendar getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public void setDataHoraCriacao(Calendar dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
	}

	@Override
	public String toString() {
		return id + " - " + nome + " - " + tipo.getNome();
	}

}
