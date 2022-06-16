package br.com.fiap.testando;

import java.util.Calendar;

import br.com.fiap.domain.Avaliacao;
import br.com.fiap.domain.AvaliacaoId;
import br.com.fiap.domain.Estabelecimento;
import br.com.fiap.domain.TipoEstabelecimento;
import br.com.fiap.domain.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class AvaliacaoTeste {

	public static void main(String[] args) {

		EntityManager em = null;

		try {

			em = Persistence.createEntityManagerFactory("estudando-orm").createEntityManager();
			em.getTransaction().begin();

			// Recuperar um Estabelecimento
			Estabelecimento estabelecimentoRecuperado = em.find(Estabelecimento.class, 2);
			// Recuperar um usuario
			Usuario usuarioRecuperado = em.find(Usuario.class, 1);
			// Gerar uma AvaliacaoId - Chave composta
			AvaliacaoId avaliacaoId = new AvaliacaoId();
			avaliacaoId.setEstabelecimentoId(estabelecimentoRecuperado.getId());
			avaliacaoId.setUsuarioId(usuarioRecuperado.getId());

			// Avaliação
			Avaliacao novaAvaliacao = new Avaliacao();
			novaAvaliacao.setId(avaliacaoId);
			novaAvaliacao.setEstabelecimento(estabelecimentoRecuperado);
			novaAvaliacao.setUsuario(usuarioRecuperado);
			novaAvaliacao.setNota(100);
			novaAvaliacao.setDataAvaliacao(Calendar.getInstance());

			em.persist(novaAvaliacao);

			em.getTransaction().commit();

		} catch (Exception e) {
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

		System.exit(0);

	}

}
