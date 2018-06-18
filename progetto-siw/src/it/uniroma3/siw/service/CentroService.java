package it.uniroma3.siw.service;

import it.uniroma3.siw.model.Centro;
import it.uniroma3.siw.model.ServiziFactory;
import it.uniroma3.siw.repository.jpa.CentroJpaRepository;
import java.util.List;

public class CentroService {

	private CentroJpaRepository cjr;

	public CentroService() {
		cjr = new CentroJpaRepository(ServiziFactory.getIstanza().getEntityManager());
	}

	public Centro save(Centro centro) {
		return cjr.save(centro);
	}

	public Centro findByPrimaryKey(Long id) {
		return cjr.findByPrimaryKey(id);
	}

	public List<Centro> findAll() {
		return cjr.findAll();
	}

	public void update(Centro centro) {
		cjr.update(centro);
	}

	public void delete(Centro centro) {
		cjr.delete(centro);
	}

	public Centro findById(Long id) {
		return cjr.findById(id);
	}

	public Centro findCentroByResponsabile(String nomeResponsabile) {
		return this.cjr.findCentroByResponsabile(nomeResponsabile);
	}
}
