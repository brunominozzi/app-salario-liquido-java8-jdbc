package com.ccee.projetotestejava.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ccee.projetotestejava.exception.DaoException;
import com.ccee.projetotestejava.model.FuncionarioBean;

/**
 * Classe Dao responsável pelos acessos a tabela 'funcionario'
 * 
 * @author bruno.minozzi
 * @since 26/10/2019
 *
 */
public class FuncionarioDao extends AbstractDao {
    
    /**
     * Método responsável por retornar lista de Objeto 'Descontos'
     * @return List<Descontos>
     * @throws FuncionarioDaoException 
     */
    public List<FuncionarioBean> getListaFuncionarios() throws DaoException {
        List<FuncionarioBean> funcionarios = new ArrayList<FuncionarioBean>();
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
        try {
            stmt = this.getConnection().
                    prepareStatement("select * from funcionario");
            rs = stmt.executeQuery();

            while (rs.next()) {
            	FuncionarioBean funcionario = new FuncionarioBean();
            	funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
            	funcionario.setNomeCliente(rs.getString("nm_cliente"));
            	funcionario.setValorSalarioBruto(rs.getBigDecimal("vl_salario_bruto"));

            	funcionarios.add(funcionario);
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
        return funcionarios;
    }

}