package it.uniroma3.siw.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ServiziFactory {

	private static ServiziFactory istanza;
	protected EntityManagerFactory emf;
	protected EntityManager em;

	public ServiziFactory() {}

	public static ServiziFactory getIstanza() {
		if (istanza == null)
			istanza = new ServiziFactory();
		return istanza;
	}

	public EntityManager getEntityManager() {
		if (em == null)
			createEntityManager();
		return em;
	}

	public void createEntityManager() { 
		emf = Persistence.createEntityManagerFactory("azienda-unit");
		em = emf.createEntityManager();
	}

	public void closeEntityManager() {
		if (emf != null) {
			em.close();
			emf.close();
		}
	}
}
