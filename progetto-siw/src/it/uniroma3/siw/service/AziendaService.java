package it.uniroma3.siw.service;

import it.uniroma3.siw.model.Azienda;
import it.uniroma3.siw.model.ServiziFactory;
import it.uniroma3.siw.repository.jpa.AziendaJpaRepository;

public class AziendaService {

	private AziendaJpaRepository ajr;

	public AziendaService() {
		ajr = new AziendaJpaRepository(ServiziFactory.getIstanza().getEntityManager());
	}

	public Azienda save(Azienda azienda) {
		return ajr.save(azienda);
	}

	public Azienda findByPrimaryKey(Long id) {
		return ajr.findByPrimaryKey(id);
	}

	public void update(Azienda azienda) {
		ajr.update(azienda);
	}

	public void delete(Azienda azienda) {
		ajr.delete(azienda);
	}
}
