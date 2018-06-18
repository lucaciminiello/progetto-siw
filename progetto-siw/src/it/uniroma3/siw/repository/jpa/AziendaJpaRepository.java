package it.uniroma3.siw.repository.jpa;

import it.uniroma3.siw.model.Azienda;
import javax.persistence.EntityManager;

public class AziendaJpaRepository implements it.uniroma3.siw.repository.Repository<Azienda> {

	private EntityManager em;

	public AziendaJpaRepository(EntityManager em) {
		this.em = em;
	}

	public Azienda save(Azienda azienda) {
		if (azienda.getId() == null) {
			em.persist(azienda);
		}
		else {
			Azienda a = findByPrimaryKey(azienda.getId());

			if (a == null) {
				em.persist(azienda);
			} else {
				em.merge(a);
			}
		}
		return azienda;
	}

	public Azienda findByPrimaryKey(Long id) {
		return em.find(Azienda.class, id);
	}

	public java.util.List<Azienda> findAll() {
		return em.createQuery("FROM Azienda azienda", Azienda.class).getResultList();
	}

	public void update(Azienda azienda) {
		em.merge(azienda);
	}

	public void delete(Azienda azienda) {
		em.remove(azienda);
	}
}
