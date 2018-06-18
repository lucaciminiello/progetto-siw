package it.uniroma3.siw.repository.jpa;

import it.uniroma3.siw.model.Allievo;
import java.util.List;
import javax.persistence.EntityManager;

public class AllievoJpaRepository implements it.uniroma3.siw.repository.Repository<Allievo> {
	
  private EntityManager em;
  
  public AllievoJpaRepository(EntityManager entityManager) {
    em = entityManager;
  }
  

  public Allievo save(Allievo allievo) {
    if (allievo.getId() == null) {
      em.persist(allievo);
    }
    else {
    	
      Allievo a = findByPrimaryKey(allievo.getId());
      
      if (a == null) {
        em.persist(allievo);
      } 
      else {
        em.merge(a);
      }
    }
    
    return allievo;
  }
  
  public Allievo findByPrimaryKey(Long id) {
    return em.find(Allievo.class, id);
  }
  
  public Allievo findByEmail(String email) {
    List<Allievo> lista = em.createQuery("SELECT allievo FROM Allievo allievo WHERE allievo.email='" + email + "'", Allievo.class).getResultList();
    if (lista.size() > 0) {
      return lista.get(0);
    }
    return null;
  }
  
  public List<Allievo> findAll() {
    return em.createQuery("FROM Allievo allievo", Allievo.class).getResultList();
  }
  
  public void update(Allievo allievo) {
    em.merge(allievo);
  }
  
  public void delete(Allievo allievo) {
    em.remove(allievo);
  }
  
  public void insertAttività(Long idAttività, Long idAllievo) {
    em.createNativeQuery("INSERT INTO attività_allievo (attività_id, allievi_id) VALUES (" + idAttività + ", " + idAllievo + ")").executeUpdate();
  }
}
