package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Attivit‡;
import it.uniroma3.siw.model.Centro;
import it.uniroma3.siw.model.ServiziFactory;
import it.uniroma3.siw.service.Attivit‡Service;
import it.uniroma3.siw.service.CentroService;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/attivitaDaCancellare")
public class MostraAttivit‡DaCancellareController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Attivit‡Service as = new Attivit‡Service();
		String nomeResponsabile = request.getUserPrincipal().getName();
		CentroService cs = new CentroService();
		Centro centro = cs.findCentroByResponsabile(nomeResponsabile);
		String nextPage;

		EntityManager em = ServiziFactory.getIstanza().getEntityManager();
		EntityTransaction tx = em.getTransaction();
		if (tx.isActive()) {
			tx.rollback();
		}
		tx.begin();

		List<Attivit‡> attivit‡ = as.findAttivit‡ByCentro(centro);

		tx.commit();

		if(attivit‡.size()>0) {
			nextPage = "/cancellaAttivita.jsp";
			request.setAttribute("attivit‡", attivit‡);
		}
		else
			nextPage = "/noAttivita.jsp";

		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}
