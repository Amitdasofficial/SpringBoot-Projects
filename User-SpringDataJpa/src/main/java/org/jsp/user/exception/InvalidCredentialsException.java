package org.jsp.user.exception;

public class InvalidCredentialsException extends RuntimeException{
      @Override
	public String getMessage()
	{
		return "Invalid Phone or Email Or Id or Password";
	}
}
