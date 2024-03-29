package com.ccee.projetotestejava.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Classe que representa bean equivalente ao modelo de entidade 'descontos' do Banco de Dados.
 * 
 * @author bruno.minozzi
 * @since 27/10/2019
 */
public class DescontosBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer idDesconto;
	
	private Integer idFuncionario;
     
    private BigDecimal valorDesconto;
    

	/**
	 * @return the idDesconto
	 */
	public Integer getIdDesconto() {
		return idDesconto;
	}

	/**
	 * @param idDesconto the idDesconto to set
	 */
	public void setIdDesconto(Integer idDesconto) {
		this.idDesconto = idDesconto;
	}

	/**
	 * @return the valorDesconto
	 */
	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	/**
	 * @param valorDesconto the valorDesconto to set
	 */
	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	/**
	 * @return the idFuncionario
	 */
	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	/**
	 * @param idFuncionario the idFuncionario to set
	 */
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

}
