package it.uniroma3.siw.repository.jpa;

import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.model.Attività;
import it.uniroma3.siw.model.Centro;
import it.uniroma3.siw.repository.Repository;
import java.util.List;
import javax.persistence.EntityManager;

public class CentroJpaRepository implements Repository<Centro> {

	private EntityManager em;

	public CentroJpaRepository(EntityManager em) {
		this.em = em;
	}

	public Centro save(Centro centro) {
		if (centro.getId() == null) {
			em.persist(centro);
		}
		else {
			Centro c = findByPrimaryKey(centro.getId());

			if (c == null) {
				em.persist(centro);
			} else {
				em.merge(c);
			}
		}
		return centro;
	}

	public Centro findByPrimaryKey(Long id) {
		return em.find(Centro.class, id);
	}

	public List<Centro> findAll() {
		return em.createQuery("FROM Centro centro", Centro.class).getResultList();
	}

	public void update(Centro centro) {
		em.merge(centro);
	}


	public void delete(Centro centro) {
		em.remove(centro);
	}

	public Centro findById(Long id) {
		List<Allievo> allievi = em.createQuery("FROM Allievo allievo WHERE centro_id=" + id, Allievo.class).getResultList();
		List<Attività> attività = em.createQuery("FROM Attività attività WHERE centro_id=" + id, Attività.class).getResultList();

		Centro centro = findByPrimaryKey(id);
		centro.setAllievi(allievi);
		centro.setAttività(attività);

		return centro;
	}


	public Centro findCentroByResponsabile(String nomeResponsabile) {
		return this.em.createQuery("SELECT centro FROM Centro centro WHERE centro.responsabile.nome ='" + nomeResponsabile.toUpperCase() +"'", 
				Centro.class).getSingleResult();
	}
}
