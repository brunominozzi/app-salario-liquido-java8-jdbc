package com.ccee.projetotestejava.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ccee.projetotestejava.exception.DaoException;
import com.ccee.projetotestejava.model.DescontosBean;

/**
 * Classe Dao responsável pelos acessos a tabela 'descontos'
 * 
 * @author bruno.minozzi
 * @since 26/10/2019
 *
 */
public class DescontosDao extends AbstractDao {

    /**
     * Método responsável por retornar lista de Objeto 'Descontos'
     * @return List<Descontos>
     * @throws DescontosDaoException 
     */
    public List<DescontosBean> getListaDescontos() throws DaoException {
    	List<DescontosBean> listaDescontos = new ArrayList<DescontosBean>();
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
        try {
            stmt = this.getConnection().
                    prepareStatement("select * from descontos");
            rs = stmt.executeQuery();

            while (rs.next()) {
            	DescontosBean descontos = new DescontosBean();
            	descontos.setIdDesconto(rs.getInt("id_desconto"));
            	descontos.setIdFuncionario(rs.getInt("id_funcionario"));
            	descontos.setValorDesconto(rs.getBigDecimal("vl_desconto"));

            	listaDescontos.add(descontos);
            }
        } catch (SQLException e) {
        	throw new RuntimeException(e.getMessage(), e.getCause());
        }finally{
        	try {
				if(stmt != null)
					stmt.close();
				
				if(rs != null )
					rs.close();
				
				this.closeConnection();
			} catch (SQLException e) {
				throw new DaoException(e.getMessage(), e.getCause());
			}
        }
        
        return listaDescontos;
    }
    
}