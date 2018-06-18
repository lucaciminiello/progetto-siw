package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Centro;
import it.uniroma3.siw.model.ServiziFactory;
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

@WebServlet("/centro")
public class MostraCentro extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CentroService cs = new CentroService();

		EntityManager em = ServiziFactory.getIstanza().getEntityManager();
		EntityTransaction tx = em.getTransaction();

		if (tx.isActive()) {
			tx.rollback();
		}
		tx.begin();

		String idCentro = request.getParameter("idCentro");
		Centro centro = cs.findById(new Long(idCentro));

		tx.commit();

		String nextPage = "/centro.jsp";
		request.setAttribute("centro", centro);

		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}
