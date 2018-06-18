package it.uniroma3.siw.repository.jpa;

import it.uniroma3.siw.model.Responsabile;
import it.uniroma3.siw.repository.Repository;
import java.util.List;
import javax.persistence.EntityManager;

public class ResponsabileJpaRepository implements Repository<Responsabile> {

	private EntityManager em;

	public ResponsabileJpaRepository(EntityManager em) {
		this.em = em;
	}

	public Responsabile save(Responsabile responsabile) {
		if (responsabile.getId() == null) {
			em.persist(responsabile);
		}
		else {
			Responsabile a = findByPrimaryKey(responsabile.getId());

			if (a == null) {
				em.persist(responsabile);
			} else {
				em.merge(a);
			}
		}

		return responsabile;
	}

	public Responsabile findByPrimaryKey(Long id) {
		return em.find(Responsabile.class, id);
	}

	public List<Responsabile> findAll() {
		return em.createQuery("FROM Responsabile responsabile", Responsabile.class).getResultList();
	}

	public void update(Responsabile responsabile) {
		em.merge(responsabile);
	}

	public void delete(Responsabile responsabile) {
		em.remove(responsabile);
	}
}
