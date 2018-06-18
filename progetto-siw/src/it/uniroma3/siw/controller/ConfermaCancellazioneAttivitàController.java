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

import it.uniroma3.siw.model.Attivit‡;
import it.uniroma3.siw.model.ServiziFactory;
import it.uniroma3.siw.service.Attivit‡Service;

@WebServlet("/rispostaAttivitaEliminata")
public class ConfermaCancellazioneAttivit‡Controller extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Attivit‡Service as = new Attivit‡Service();  
		Attivit‡ attivit‡ = (Attivit‡)session.getAttribute("attivit‡");
		Long id = new Long(attivit‡.getId());

		EntityManager em = ServiziFactory.getIstanza().getEntityManager();
		EntityTransaction tx = em.getTransaction();

		if (tx.isActive()) {
			tx.rollback();
		}
		tx.begin();

		as.deleteAllievi(id);
		as.delete(attivit‡);

		tx.commit();

		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/rispostaAttivitaEliminata.jsp");
		rd.forward(request, response);
	}

}
