package br.com.fiap.testando;

import br.com.fiap.domain.Estabelecimento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class JPATesteRelacionamento {

	public static void main(String[] args) {

		EntityManager em = null;

		try {
			em = Persistence.createEntityManagerFactory("estudando-orm").createEntityManager();
			em.getTransaction().begin();

			Estabelecimento recuperado = em.find(Estabelecimento.class, 1);
			System.out.println(recuperado);

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
