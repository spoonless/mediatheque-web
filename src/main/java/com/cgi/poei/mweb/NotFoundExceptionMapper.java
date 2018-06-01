package com.cgi.poei.mweb;

import javax.ejb.EJBTransactionRolledbackException;
import javax.persistence.NoResultException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<EJBTransactionRolledbackException> {

	@Override
	public Response toResponse(EJBTransactionRolledbackException exception) {
		if (exception.getCause() instanceof NoResultException) {
			return Response.status(404).build();
		} else {
			return Response.status(500).entity(exception.getCause()).build();
		}
	}

}
