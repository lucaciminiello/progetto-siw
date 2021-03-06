package it.uniroma3.siw.controller;

import it.uniroma3.siw.controller.validator.AttivitāValidator;
import it.uniroma3.siw.model.Attivitā;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/attivita")
public class AttivitāController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String giorno = request.getParameter("giorno");
		String oraInizio = request.getParameter("oraInizio");
		String oraFine = request.getParameter("oraFine");

		HttpSession session = request.getSession();
		session.setAttribute("nome", nome);
		session.setAttribute("giorno", giorno);
		session.setAttribute("oraInizio", oraInizio);
		session.setAttribute("oraFine", oraFine);

		AttivitāValidator validator = new AttivitāValidator();
		String nextPage;

		if (!validator.validate(request)) {
			nome = request.getParameter("nome").toUpperCase();
			giorno = request.getParameter("giorno").toUpperCase();
			oraInizio = request.getParameter("oraInizio");
			oraFine = request.getParameter("oraFine");

			nome = nome.trim();
			giorno = giorno.trim();
			oraInizio = oraInizio.trim();
			oraFine = oraFine.trim();

			Attivitā attivitā = new Attivitā();
			attivitā.setNome(nome);
			attivitā.setGiorno(giorno);
			attivitā.setOraInizio(new Integer(oraInizio));
			attivitā.setOraFine(new Integer(oraFine));

			session.setAttribute("attivitā", attivitā);
			nextPage = "/attivita.jsp";
		}
		else {
			nextPage = "/newAttivita.jsp";
		}

		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}
