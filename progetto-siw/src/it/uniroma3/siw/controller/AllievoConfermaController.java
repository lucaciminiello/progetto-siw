package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.model.Centro;
import it.uniroma3.siw.model.ServiziFactory;
import it.uniroma3.siw.service.AllievoService;
import it.uniroma3.siw.service.CentroService;

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

@WebServlet("/conferma")
public class AllievoConfermaController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		AllievoService as = new AllievoService();
		Allievo allievo = (Allievo)session.getAttribute("allievo");
		
		String nomeResponsabile = request.getUserPrincipal().getName();
		CentroService cs = new CentroService();
		Centro centro = cs.findCentroByResponsabile(nomeResponsabile);
		
		centro.getAllievi().add(allievo);

		EntityManager em = ServiziFactory.getIstanza().getEntityManager();
		EntityTransaction tx = em.getTransaction();
		if (tx.isActive()) {
			tx.rollback();
		}
		tx.begin();

		as.save(allievo);

		tx.commit();

		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/rispostaAllievo.jsp");
		rd.forward(request, response);
	}
}
