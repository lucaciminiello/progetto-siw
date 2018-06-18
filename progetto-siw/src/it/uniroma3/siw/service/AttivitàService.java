package it.uniroma3.siw.service;

import it.uniroma3.siw.model.Attivit‡;
import it.uniroma3.siw.model.Centro;
import it.uniroma3.siw.model.ServiziFactory;
import it.uniroma3.siw.repository.jpa.Attivit‡JpaRepository;
import java.util.List;

public class Attivit‡Service{

	private Attivit‡JpaRepository ajr;

	public Attivit‡Service(){
		this.ajr = new Attivit‡JpaRepository(ServiziFactory.getIstanza().getEntityManager());
	}

	public Attivit‡ save(Attivit‡ attivit‡) {
		return ajr.save(attivit‡);
	}

	public Attivit‡ findByPrimaryKey(Long id) {
		return ajr.findByPrimaryKey(id);
	}

	public List<Attivit‡> findAll() {
		return ajr.findAll();
	}

	public void update(Attivit‡ attivit‡) {
		ajr.update(attivit‡);
	}

	public void delete(Attivit‡ attivit‡) {
		ajr.delete(attivit‡);
	}

	public List<Attivit‡> findAttivit‡ByCentro(Centro centro) {
		return this.ajr.findAttivit‡ByCentro(centro);
	}

	public void deleteAllievi(Long id) {
		this.ajr.deleteAllievi(id);
		
	}
}
