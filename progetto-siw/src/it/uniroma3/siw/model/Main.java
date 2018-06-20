package it.uniroma3.siw.model;

import it.uniroma3.siw.service.AttivitàService;
import it.uniroma3.siw.service.AziendaService;
import it.uniroma3.siw.service.CentroService;
import it.uniroma3.siw.service.ResponsabileService;
import java.util.List;

import javax.persistence.EntityTransaction;

public class Main {

	public static void main(String[] args) {

		Azienda azienda = new Azienda("ENEL");
		Responsabile direttore = new Responsabile();
		direttore.setNome("LUCA");
		azienda.setDirettore(direttore);

		Responsabile marco = new Responsabile();
		marco.setNome("MARCO");

		Responsabile matteo = new Responsabile();
		matteo.setNome("MATTEO");

		Attività att1 = new Attività("ASTRONOMIA", "MARTEDì", 10, 12);
		Attività att2 = new Attività("GEOLOGIA", "GIOVEDì", 13, 15);

		Centro c1 = new Centro("SCR");
		c1.setNumeroTelefono("065784330");
		c1.setEmail("scr@gmail.com");
		c1.setIndirizzo("Via Dante Alighieri 12");
		c1.getAttività().add(att1);
		c1.setResponsabile(marco);

		att1.setCentro(c1);

		Centro c2 = new Centro("SDR");
		c2.setNumeroTelefono("023456789");
		c2.setEmail("sdr@gmail.com");
		c2.setIndirizzo("Via dei Corazzieri 70");
		c2.getAttività().add(att2);
		c2.setResponsabile(matteo);

		att2.setCentro(c2);

		azienda.getCentri().add(c1);
		azienda.getCentri().add(c2);

		AziendaService as = new AziendaService();
		CentroService cs = new CentroService();
		ResponsabileService rs = new ResponsabileService();
		AttivitàService atts = new AttivitàService();

		EntityTransaction tx = ServiziFactory.getIstanza().getEntityManager().getTransaction();

		tx.begin();

		as.save(azienda);
		cs.save(c1);
		cs.save(c2);
		rs.save(direttore);
		rs.save(marco);
		rs.save(matteo);
		atts.save(att1);
		atts.save(att2);

		tx.commit();

		ServiziFactory.getIstanza().closeEntityManager();
	}
}
