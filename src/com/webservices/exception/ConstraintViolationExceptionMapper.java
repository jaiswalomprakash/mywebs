package com.webservices.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Autowired
	private MessageSource messageResolver; 

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		StringBuilder sb = new StringBuilder();
		Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
		for (ConstraintViolation<?> constraintViolation : violations) {
			sb.append(messageResolver.getMessage(constraintViolation.getMessage(),null,null) + "\n");
		}
		return Response.status(Status.NOT_ACCEPTABLE).entity(sb.toString()).build();
	}
}