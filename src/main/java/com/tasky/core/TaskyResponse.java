package com.tasky.core;

import org.springframework.http.HttpStatus;

public class TaskyResponse<T> {
	
	private HttpStatus httpStatus;
	
	private T entity;
	
	private String error;

	public TaskyResponse() {}
	
	public TaskyResponse(HttpStatus httpStatus, T entity, String error) {
		super();
		this.httpStatus = httpStatus;
		this.entity = entity;
		this.error = error;
	}

	public HttpStatus getHttpCode() {
		return httpStatus;
	}

	public void setHttpCode(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
