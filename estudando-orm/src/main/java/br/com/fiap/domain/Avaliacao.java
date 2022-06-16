package br.com.fiap.domain;

import java.util.Calendar;

import jakarta.persistence.*;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {

	@EmbeddedId
	private AvaliacaoId id;
	@JoinColumn(name = "id_usuario", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Usuario usuario;
	@JoinColumn(name = "id_estabelecimento", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Estabelecimento estabelecimento;
	@Column(name = "nota")
	private Integer nota;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_avaliacao")
	private Calendar dataAvaliacao;

	public AvaliacaoId getId() {
		return id;
	}

	public void setId(AvaliacaoId id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public Calendar getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Calendar dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

}
