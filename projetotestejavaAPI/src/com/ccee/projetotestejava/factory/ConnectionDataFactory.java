package com.ccee.projetotestejava.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ccee.projetotestejava.exception.ConnectionDataFactoryException;

/**
 * Classe Factory responsável pela criação de conexões com o Banco.
 * 
 * @author bruno.minozzi
 * @since 27/10/2019
 */
public class ConnectionDataFactory {
	
	 public Connection getConnection() {
         try {
             return DriverManager.getConnection(
            		 "jdbc:postgresql://127.0.0.1:5432/rh", "postgres", "admin");
         } catch (SQLException e) {
             throw new ConnectionDataFactoryException(e.getMessage(), e.getCause());
         }
     }

}
