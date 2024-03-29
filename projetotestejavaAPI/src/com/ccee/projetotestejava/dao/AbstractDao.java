package com.ccee.projetotestejava.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.ccee.projetotestejava.exception.DaoException;
import com.ccee.projetotestejava.factory.ConnectionDataFactory;

/**
 * 
 * @author bruno.minozzi
 * @since 27/10/2019
 *
 */
public abstract class AbstractDao {
    private Connection connection;

    public AbstractDao() {
        
    }

    /**
     * M�todo respons�vel por criar a conex�o padr�o com o Banco de Dados
     * @return Connection
     */
    protected Connection getConnection() {
		try {
			if( this.connection == null || this.connection.isClosed() ) {
				this.connection = new ConnectionDataFactory().getConnection();
				this.connection.setAutoCommit( true );
			}
		} catch( Exception e ) {
			connection = null;
		}

		return this.connection;
	}
    
    /**
     * M�todo respons�vel por fechar a conex�o com Banco
     * @throws Exception
     */
	protected void closeConnection() throws DaoException {
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new DaoException(e.getMessage(), e.getCause());
			}
		}
	}
}
