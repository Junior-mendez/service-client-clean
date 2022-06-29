package com.co.pragma.serviceclientclean.domain.exceptions;

public class ClientDisableException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7531873660782949805L;

	public ClientDisableException(Long id) {
		super("Error al deshabilitar cliente con id: ".concat(id.toString()));
	}

}
