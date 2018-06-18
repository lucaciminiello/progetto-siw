package it.uniroma3.siw.service;

import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.model.ServiziFactory;
import it.uniroma3.siw.repository.jpa.AllievoJpaRepository;
import java.util.List;

public class AllievoService {

	private AllievoJpaRepository ajr;

	public AllievoService() {
		this.ajr = new AllievoJpaRepository(ServiziFactory.getIstanza().getEntityManager());
	}

	public Allievo save(Allievo allievo) {
		return ajr.save(allievo);
	}

	public Allievo findByPrimaryKey(Long id) {
		return ajr.findByPrimaryKey(id);
	}

	public List<Allievo> findAll() {
		return ajr.findAll();
	}

	public void update(Allievo allievo) {
		ajr.update(allievo);
	}

	public void delete(Allievo allievo) {
		ajr.delete(allievo);
	}

	public Allievo findByEmail(String email) {
		return ajr.findByEmail(email);
	}

	public void insertAttività(Long idAttività, Long idAllievo) {
		this.ajr.insertAttività(idAttività, idAllievo);
	}
}
