package it.uniroma3.siw.controller.validator;

import javax.servlet.http.HttpServletRequest;

public class Attivit‡Validator {

	public boolean validate(HttpServletRequest request) { 
		String nome = request.getParameter("nome");
		String giorno = request.getParameter("giorno");
		String oraInizio = request.getParameter("oraInizio");
		String oraFine = request.getParameter("oraFine");
		boolean errori = false;

		if ((nome == null) || (nome.equals(""))) {
			request.setAttribute("errNome", "*campo obbligatorio");
			errori = true;
		}

		if ((giorno == null) || (giorno.equals(""))) {
			request.setAttribute("errGiorno", "*campo obbligatorio");
			errori = true;
		}
		
		if ((giorno.equals("domenica")) || (giorno.equals("sabato"))) {
			request.setAttribute("errGiorno", "*giorno non valido");
			errori = true;
		}
		
		try {
			Integer mat = new Integer(oraInizio);
			Integer mat2 = new Integer(oraFine);
			if(mat2<mat) {
				request.setAttribute("errFasciaOraria", "*fascia oraria non valida");
				errori = true;
			}
		}
		catch (NumberFormatException e) {
			request.setAttribute("errFasciaOraria", "*deve essere un numero");
			errori = true;
		}

		return errori;
	}
}
