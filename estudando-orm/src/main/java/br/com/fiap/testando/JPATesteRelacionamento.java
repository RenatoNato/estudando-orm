package br.com.fiap.testando;

import br.com.fiap.domain.Estabelecimento;
import br.com.fiap.domain.TipoEstabelecimento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class JPATesteRelacionamento {

	public static void main(String[] args) {

		EntityManager em = null;

		try {
			em = Persistence.createEntityManagerFactory("estudando-orm").createEntityManager();
			em.getTransaction().begin();

			
			TipoEstabelecimento tipo = em.find(TipoEstabelecimento.class, 4);
			System.out.println(tipo.getEstabelecimentos());
			
			//Estabelecimento recuperado = em.find(Estabelecimento.class, 4);

			//System.out.println(recuperado);

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
