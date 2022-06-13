package br.com.fiap.testando;

import br.com.fiap.domain.Estabelecimento;
import br.com.fiap.domain.TipoEstabelecimento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class JPATest {

	public static void main(String[] args) {
		EntityManager em = null;

		try {

			em = Persistence.createEntityManagerFactory("estudando-orm").createEntityManager();
			em.getTransaction().begin();

			Estabelecimento novo = new Estabelecimento();
			novo.setNome("Escola vai 04");

			em.persist(novo);

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
