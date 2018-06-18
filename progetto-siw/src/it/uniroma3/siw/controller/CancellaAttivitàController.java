package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Attivit‡;
import it.uniroma3.siw.service.Attivit‡Service;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/confermaAttivitaCancellata")
public class CancellaAttivit‡Controller extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		String att = request.getParameter("listaAttivita");
		Attivit‡Service as = new Attivit‡Service();
		Long idAttivit‡ = new Long(att);
		Attivit‡ attivit‡ = as.findByPrimaryKey(idAttivit‡);

		session.setAttribute("attivit‡", attivit‡);

		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher("/attivitaDaCancellare.jsp");
		rd.forward(request, response);
	}

}
