package org.jsp.merpro.exception;

public class MerchantNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Merchant Not found";
	}

}
