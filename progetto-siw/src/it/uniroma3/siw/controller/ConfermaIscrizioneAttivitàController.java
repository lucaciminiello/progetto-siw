package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.model.Attivit‡;
import it.uniroma3.siw.model.ServiziFactory;
import it.uniroma3.siw.service.AllievoService;
import it.uniroma3.siw.service.Attivit‡Service;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/confermaIscrizione")
public class ConfermaIscrizioneAttivit‡Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AllievoService as = new AllievoService();
		Attivit‡Service ats = new Attivit‡Service();

		Allievo allievo = (Allievo)session.getAttribute("allievo");
		String idAttivit‡ = request.getParameter("listaAttivita");
		Long id = new Long(idAttivit‡);

		Attivit‡ attivit‡ = ats.findByPrimaryKey(id);

		allievo.getAttivit‡().add(attivit‡);

		EntityManager em = ServiziFactory.getIstanza().getEntityManager();
		EntityTransaction tx = em.getTransaction();
		if (tx.isActive()) {
			tx.rollback();
		}
		tx.begin();

		as.insertAttivit‡(id, allievo.getId());

		tx.commit();

		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/rispostaIscrizione.jsp");
		rd.forward(request, response);
	}
}
