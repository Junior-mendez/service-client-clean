package com.co.pragma.serviceclientclean.domain.exceptions;


public class ClientNotFoundDocumentException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3849650433121666234L;

	public ClientNotFoundDocumentException(String typeDocument, String numberDocument){
        super("Cliente no encontrado con Tipo de Documento:".concat(typeDocument).concat(" y Número de Documento: ").concat(numberDocument));
    }

}
