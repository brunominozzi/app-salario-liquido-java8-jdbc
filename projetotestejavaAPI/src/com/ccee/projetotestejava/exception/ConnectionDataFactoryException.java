package com.ccee.projetotestejava.exception;

/**
 * Unchecked exception lançada quando ocorre um erro de conexão ao Banco de Dados.
 * 
 * @author bruno.minozzi
 * @since 27/10/2019
 */
public class ConnectionDataFactoryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConnectionDataFactoryException() {
		super();
	}

	public ConnectionDataFactoryException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ConnectionDataFactoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConnectionDataFactoryException(String message) {
		super(message);
	}

	public ConnectionDataFactoryException(Throwable cause) {
		super(cause);
	}
}
