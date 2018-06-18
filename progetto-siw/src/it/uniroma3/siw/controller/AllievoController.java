package it.uniroma3.siw.controller;

import it.uniroma3.siw.controller.validator.AllievoValidator;
import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.service.AllievoService;
import java.io.IOException;
import java.util.GregorianCalendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/allievo")
public class AllievoController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String luogoNascita = request.getParameter("luogoNascita");
		String giorno = request.getParameter("giorno");
		String mese = request.getParameter("mese");
		String anno = request.getParameter("anno");
		String numeroTelefono = request.getParameter("numeroTelefono");

		HttpSession session = request.getSession();
		session.setAttribute("nome", nome);
		session.setAttribute("cognome", cognome);
		session.setAttribute("email", email);
		session.setAttribute("luogoNascita", luogoNascita);
		session.setAttribute("giorno", giorno);
		session.setAttribute("mese", mese);
		session.setAttribute("anno", anno);
		session.setAttribute("numeroTelefono", numeroTelefono);

		AllievoValidator validator = new AllievoValidator();
		String nextPage;

		if (!validator.validate(request)) {
			nome = request.getParameter("nome").toUpperCase();
			cognome = request.getParameter("cognome").toUpperCase();
			email = request.getParameter("email").toUpperCase();
			luogoNascita = request.getParameter("luogoNascita").toUpperCase();
			giorno = request.getParameter("giorno");
			mese = request.getParameter("mese");
			anno = request.getParameter("anno");
			numeroTelefono = request.getParameter("numeroTelefono");

			nome = nome.trim();
			cognome = cognome.trim();
			email = email.trim();
			luogoNascita = luogoNascita.trim();
			giorno = giorno.trim();
			mese = mese.trim();
			anno = anno.trim();
			numeroTelefono = numeroTelefono.trim();


			Allievo allievo = new Allievo();
			allievo.setNome(nome);
			allievo.setCognome(cognome);
			allievo.setEmail(email);
			allievo.setLuogoNascita(luogoNascita);
			allievo.setGiorno(giorno);
			allievo.setMese(mese);
			allievo.setAnno(anno);
			allievo.setDataNascita(new GregorianCalendar(new Integer(anno), new Integer(mese), new Integer(giorno)));
			allievo.setNumeroTelefono(new Long(numeroTelefono));

			AllievoService as = new AllievoService();
			Allievo all = as.findByEmail(allievo.getEmail());
			session.removeAttribute("allievo");

			if (all == null) {
				session.setAttribute("allievo", allievo);
				nextPage = "/allievo.jsp";
			}
			else {
				session.setAttribute("allievo", all);
				nextPage = "/rispostaAllievo.jsp";
			}
		}
		else {
			nextPage = "/newAllievo.jsp";
		}

		ServletContext application = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}
