package it.uniroma3.siw.controller;

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

import it.uniroma3.siw.model.Attivitā;
import it.uniroma3.siw.model.ServiziFactory;
import it.uniroma3.siw.service.AttivitāService;

@WebServlet("/rispostaAttivitaEliminata")
public class ConfermaCancellazioneAttivitāController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AttivitāService as = new AttivitāService();  
		Attivitā attivitā = (Attivitā)session.getAttribute("attivitā");
		Long id = new Long(attivitā.getId());

		EntityManager em = ServiziFactory.getIstanza().getEntityManager();
		EntityTransaction tx = em.getTransaction();

		if (tx.isActive()) {
			tx.rollback();
		}
		tx.begin();

		as.deleteAllievi(id);
		as.delete(attivitā);

		tx.commit();

		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/rispostaAttivitaEliminata.jsp");
		rd.forward(request, response);
	}

}
