package com.cgi.poei.mweb;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/monitoring")
public class MonitoringServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6731267818610967027L;

	@PersistenceContext(unitName="mediatheque")
	private EntityManager entityManager;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object i = entityManager.createNativeQuery("select 1").getSingleResult();
		resp.setContentType("text/plain");
		resp.getWriter().write("Resultat " + i);
	} 

}
