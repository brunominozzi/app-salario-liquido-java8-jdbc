package com.ccee.projetotestejava.exception;

/**
 * Checked exception lançada na classe 'DescontosDao' 
 * quando ocorre um erro de conexão ao Banco de Dados.
 * 
 * @author bruno.minozzi
 * @since 27/10/2019
 */
public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DaoException() {
		super();
	}

	public DaoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}
	
}