package br.com.fiap.domain;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AvaliacaoId {
	
	@Column(name = "id_usuario")
	private Integer usuarioId;
	@Column(name = "id_estabelecimento")
	private Integer estabelecimentoId;
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(estabelecimentoId, usuarioId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoId other = (AvaliacaoId) obj;
		return Objects.equals(estabelecimentoId, other.estabelecimentoId) && Objects.equals(usuarioId, other.usuarioId);
	}
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Integer getEstabelecimentoId() {
		return estabelecimentoId;
	}
	public void setEstabelecimentoId(Integer estabelecimentoId) {
		this.estabelecimentoId = estabelecimentoId;
	}
	
	

}
