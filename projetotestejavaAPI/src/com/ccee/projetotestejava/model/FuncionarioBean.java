package com.ccee.projetotestejava.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Classe que representa bean equivalente ao modelo de entidade 'funcionario' do Banco de Dados.
 * 
 * @author bruno.minozzi
 * @since 27/10/2019
 */
public class FuncionarioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer idFuncionario;
	 
    private String nomeCliente;
     
    private BigDecimal valorSalarioBruto;
     
     
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
	/**
	 * @return the nomeCliente
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}
	/**
	 * @param nomeCliente the nomeCliente to set
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	/**
	 * @return the valorSalarioBruto
	 */
	public BigDecimal getValorSalarioBruto() {
		return valorSalarioBruto;
	}
	/**
	 * @param valorSalarioBruto the valorSalarioBruto to set
	 */
	public void setValorSalarioBruto(BigDecimal valorSalarioBruto) {
		this.valorSalarioBruto = valorSalarioBruto;
	}
     
     

}
