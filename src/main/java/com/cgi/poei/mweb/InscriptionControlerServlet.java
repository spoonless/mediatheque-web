package com.cgi.poei.mweb;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cgi.poei.mediatheque.InscripteurUsager;
import com.cgi.poei.mediatheque.Usager;
import com.cgi.poei.mediatheque.exception.InscriptionException;

@WebServlet("/usager/inscription")
public class InscriptionControlerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@EJB
	private InscripteurUsager inscripteurUsager;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forwardFormulaire(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		LocalDate dateNaissance = null;
		if (req.getParameter("dateNaissance") != null && ! "".equals(req.getParameter("dateNaissance"))) {
			dateNaissance = LocalDate.parse(req.getParameter("dateNaissance"), DATE_FORMATTER);
		}

		try {
			Usager usager = inscripteurUsager.inscrire(nom, prenom, dateNaissance);
			req.setAttribute("usager", usager);
			forwardSucces(req, resp);
		} catch (InscriptionException e) {
			req.setAttribute("erreurs", e.getRaisons());
			forwardFormulaire(req, resp);
		}
	}

	private void forwardSucces(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forward(req, resp, "/WEB-INF/jsp/inscription/succes.jsp");
	}

	private void forwardFormulaire(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		forward(req, resp, "/WEB-INF/jsp/inscription/formulaire.jsp");
	}

	private void forward(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher(path);
		dispatcher.forward(req, resp);
	}
}

