package com.webservices.exception;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.webservices.utils.Status;

@JsonRootName(value = "error")
public class GenericReponse {

    private int statusCode =200;
    private String statusMessage ="OK";
    private String errorMessage;
    
  public GenericReponse() {
	// TODO Auto-generated constructor stub
}

    public GenericReponse(int statusCode, String statusMessage, String errorMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

   

    public String getStatusMessage() {
		return statusMessage;
	}

	public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    
    public void setStatusMessage(String statusMessage)
	{
		this.statusMessage = statusMessage;
	}

	public void setStatusObject(Status status)
	{
		this.setStatusCode(status.getCode());
		this.setStatusMessage(status.getMessage());
		this.setErrorMessage(status.getMessage());
	}

}