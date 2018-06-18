package it.uniroma3.siw.repository.jpa;

import it.uniroma3.siw.model.Attivit‡;
import it.uniroma3.siw.model.Centro;
import it.uniroma3.siw.repository.Repository;
import java.util.List;
import javax.persistence.EntityManager;

public class Attivit‡JpaRepository implements Repository<Attivit‡> {

	private EntityManager em;

	public Attivit‡JpaRepository(EntityManager em) {
		this.em = em;
	}

	public Attivit‡ save(Attivit‡ attivit‡) {
		if (attivit‡.getId() == null) {
			em.persist(attivit‡);
		}
		else {
			Attivit‡ a = findByPrimaryKey(attivit‡.getId());

			if (a == null) {
				em.persist(attivit‡);
			} else {
				em.merge(a);
			}
		}

		return attivit‡;
	}

	public Attivit‡ findByPrimaryKey(Long id){
		return em.find(Attivit‡.class, id);
	}

	public List<Attivit‡> findAll() {
		return em.createQuery("FROM Attivit‡† attivit‡†", Attivit‡.class).getResultList();
	}

	public void update(Attivit‡ attivit‡) {
		em.merge(attivit‡);
	}

	public void delete(Attivit‡ attivit‡){
		em.remove(attivit‡);
	}

	public List<Attivit‡> findAttivit‡ByCentro(Centro centro) {
		return this.em.createQuery("SELECT attivit‡ FROM Attivit‡ attivit‡ WHERE attivit‡.centro.id =" + centro.getId(), Attivit‡.class).getResultList();
	}

	public void deleteAllievi(Long id) {
		this.em.createNativeQuery("DELETE FROM attivit‡_allievo WHERE attivit‡_id=" + id).executeUpdate();
		
	}
}
