package it.uniroma3.siw.service;

import it.uniroma3.siw.model.Responsabile;
import it.uniroma3.siw.model.ServiziFactory;
import it.uniroma3.siw.repository.jpa.ResponsabileJpaRepository;
import java.util.List;

public class ResponsabileService {

	private ResponsabileJpaRepository rjr;

	public ResponsabileService() {
		rjr = new ResponsabileJpaRepository(ServiziFactory.getIstanza().getEntityManager());
	}

	public Responsabile save(Responsabile responsabile) {
		return rjr.save(responsabile);
	}

	public Responsabile findByPrimaryKey(Long id) {
		return rjr.findByPrimaryKey(id);
	}

	public List<Responsabile> findAll() {
		return rjr.findAll();
	}

	public void update(Responsabile responsabile) {
		rjr.update(responsabile);
	}

	public void delete(Responsabile responsabile) {
		rjr.delete(responsabile);
	}
}
