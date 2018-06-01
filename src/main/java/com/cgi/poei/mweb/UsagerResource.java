package com.cgi.poei.mweb;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.cgi.poei.mediatheque.InscripteurUsager;
import com.cgi.poei.mediatheque.Usager;
import com.cgi.poei.mediatheque.exception.InscriptionException;

@Path("/usager")
@Stateless
public class UsagerResource {
	
	@EJB
	private InscripteurUsager inscripteurUsager;
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response creer(@FormParam("nom") String nom, @FormParam("prenom") String prenom, 
			              @Context UriInfo uriInfo) throws InscriptionException, URISyntaxException {
		Usager usager = inscripteurUsager.inscrire(nom, prenom, null);
		
		URI location = uriInfo.getRequestUriBuilder().path(usager.getCode()).build();
		return Response.created(location).build();
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response creer(Usager usager, @Context UriInfo uriInfo) throws InscriptionException, URISyntaxException {
		return creer(usager.getNom(), usager.getPrenom(), uriInfo);
	}
	
	@GET
	@Path("/{code}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public UsagerProxy getUsager(@PathParam("code") String code) {
		return new UsagerProxy(inscripteurUsager.getByCode(code));
	}

}
