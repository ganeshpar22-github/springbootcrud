package com.springbootcrud.springbootbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	private String fieldValue;
	private String resourceName2;
	private String fieldName2;
	private long id;
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
		super(String.format("%s not found with %s : '%s'", resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	public ResourceNotFoundException(String resourceName2, String fieldName2, long id) {
		super(String.format("%s not found with %s : '%s'", resourceName2,fieldName2,id));
		this.resourceName2 = resourceName;
		this.fieldName2 = fieldName;
		this.id = id;
	}


	public String getResourceName() {
		return resourceName;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public Object getFieldValue() {
		return fieldValue;
	}
	
	public String getResourceName2() {
		return resourceName2;
	}
	
	public String getFieldName2() {
		return fieldName2;
	}
	
	public Object getId() {
		return id;
	}

}
