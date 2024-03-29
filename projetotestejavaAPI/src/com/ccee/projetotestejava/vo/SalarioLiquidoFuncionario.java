package com.ccee.projetotestejava.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Bean com as informa��es b�sicas a serem retornadas pela aplica��o de
 * C�lculo de sal�rio Liquido.
 * 
 * @author bruno.minozzi
 * @since 27/10/2019
 */
public class SalarioLiquidoFuncionario implements Serializable{
	
		
		private static final long serialVersionUID = 1L;

		private Integer idFuncionario;
		 
	    private String nomeCliente;
	     
	    private BigDecimal valorSalarioLiquido;

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
		 * @return the valorSalarioLiquido
		 */
		public BigDecimal getValorSalarioLiquido() {
			return valorSalarioLiquido;
		}

		/**
		 * @param valorSalarioLiquido the valorSalarioLiquido to set
		 */
		public void setValorSalarioLiquido(BigDecimal valorSalarioLiquido) {
			this.valorSalarioLiquido = valorSalarioLiquido;
		}

		@Override
		public String toString() {
			return "[Id: " + idFuncionario + ", Nome: " + nomeCliente
					+ ", Sal�rio L�quido: " + valorSalarioLiquido + "]";
		}
	    
}
