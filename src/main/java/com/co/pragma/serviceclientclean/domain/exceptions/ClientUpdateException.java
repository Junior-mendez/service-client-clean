package com.co.pragma.serviceclientclean.domain.exceptions;

import com.co.pragma.serviceclientclean.domain.model.Client;

public class ClientUpdateException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -41622420189114351L;

	public ClientUpdateException(Client client){
        super("Cliente no fue actualizado: ".concat(client.toString()));
    }
}
