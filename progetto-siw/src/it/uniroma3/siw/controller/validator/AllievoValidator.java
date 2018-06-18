package it.uniroma3.siw.controller.validator;

import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.service.AllievoService;
import sun.security.util.Length;

import javax.servlet.http.HttpServletRequest;

public class AllievoValidator {

	public boolean validate(HttpServletRequest request) {

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String numeroTelefono = request.getParameter("numeroTelefono");
		String luogoNascita = request.getParameter("luogoNascita");
		String giorno = request.getParameter("giorno");
		String mese = request.getParameter("mese");
		boolean errori = false;

		if ((nome == null) || (nome.equals(""))) {
			request.setAttribute("errNome", "*campo obbligatorio");
			errori = true;
		}

		if ((cognome == null) || (cognome.equals(""))) {
			request.setAttribute("errCognome", "*campo obbligatorio");
			errori = true;
		}

		AllievoService as;

		if ((email == null) || (email.equals(""))) {
			request.setAttribute("errEmail", "*campo obbligatorio");
			errori = true;
		}
		else {
			as = new AllievoService();
			Allievo a = as.findByEmail(email.toUpperCase());
			if ((a != null) && ((!a.getNome().toUpperCase().equals(nome.toUpperCase())) || (!a.getCognome().toUpperCase().equals(cognome.toUpperCase())))) {
				request.setAttribute("errEmail", "*email già esistente");
				errori = true;
			}
		}

		if (((giorno.equals("31")) && ((mese.equals("2")) || (mese.equals("4")) || (mese.equals("6")) || 
				(mese.equals("9")) || (mese.equals("11")))) || ((giorno.equals("30")) && (mese.equals("2")))) {
			request.setAttribute("errDataNascita", "*data non valida");
			errori = true;
		}

		if ((luogoNascita == null) || (luogoNascita.equals(""))) {
			request.setAttribute("errLuogoNascita", "*campo obbligatorio");
			errori = true;
		}

		if ((numeroTelefono == null) || (numeroTelefono.equals(""))) {
			request.setAttribute("errNumeroTelefono", "*campo obbligatorio");
			errori = true;
		}
		else {
			try {
				Long mat = new Long(numeroTelefono);
			}
			catch (NumberFormatException e) {
				request.setAttribute("errNumeroTelefono", "*deve essere un numero");
				errori = true;
			}
		}
		return errori;
	}
}
