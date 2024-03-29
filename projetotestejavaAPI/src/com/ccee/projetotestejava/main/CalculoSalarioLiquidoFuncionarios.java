package com.ccee.projetotestejava.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.ccee.projetotestejava.dao.DescontosDao;
import com.ccee.projetotestejava.dao.FuncionarioDao;
import com.ccee.projetotestejava.exception.DaoException;
import com.ccee.projetotestejava.model.DescontosBean;
import com.ccee.projetotestejava.model.FuncionarioBean;
import com.ccee.projetotestejava.vo.SalarioLiquidoFuncionario;

/**
 * Classe Main que cont�m aplica��o respons�vel pelo processo de Calculo de 
 * sal�rio liquido dos Funcionarios
 * 
 * @author bruno.minozzi
 * @since 27/10/2019
 *
 */
public class CalculoSalarioLiquidoFuncionarios {
	
	/**
	 * M�todo main com run principal para execu��o do sistema CalculoSalarioLiquidoFuncionarios
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("******IN�CIO Sistema: C�lculo de Sal�rio L�quido******");
		try {
			List<FuncionarioBean> listaFuncionarios = obterFuncionarios();
			List<DescontosBean> listaDescontos = obterDescontos();
			List<SalarioLiquidoFuncionario> listaSalariosLiquidosFuncionarios = new ArrayList<SalarioLiquidoFuncionario>();
			
			if(!listaFuncionarios.isEmpty() && !listaDescontos.isEmpty()){
				for (FuncionarioBean funcionarioBean : listaFuncionarios) {
					listaSalariosLiquidosFuncionarios.add(calcularSalarioLiquido(listaDescontos,funcionarioBean));
				}
				listaSalariosLiquidosFuncionarios.sort(Comparator.comparing(SalarioLiquidoFuncionario::getValorSalarioLiquido).reversed());
				listaSalariosLiquidosFuncionarios.stream().forEach(salarioLiquidoFuncionario -> System.out.println(salarioLiquidoFuncionario.toString()));
			}
			
		} catch (Exception e) {
			System.err.println("Falha na Execu��o de CalculoSalarioLiquidoFuncionarios" + e.getMessage());
		}finally {
			System.out.println("******FINAL  Sistema: C�lculo de Sal�rio L�quido******");
		}
		
	}
	
	/**
	 * M�todo que encapsula busca de funcionarios
	 * @return
	 * @throws DaoException
	 */
	public static List<FuncionarioBean> obterFuncionarios() throws DaoException{
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		return funcionarioDao.getListaFuncionarios();
	}
	
	/**
	 * M�todo que encapsula busca de descontos
	 * @return
	 * @throws DaoException
	 */
	public static List<DescontosBean> obterDescontos() throws DaoException{
		DescontosDao descontosDao = new DescontosDao();
		return descontosDao.getListaDescontos();
	}
	
	/**
	 * M�todo respons�vel pelo Calculo de Sal�rio L�quido do Funcionario
	 * 
	 * @param listaDescontos
	 * @param funcionarioBean
	 * @return SalarioLiquidoFuncionario
	 */
	private static SalarioLiquidoFuncionario calcularSalarioLiquido(List<DescontosBean> listaDescontos,	FuncionarioBean funcionarioBean) {
		BigDecimal somaDescontos = new BigDecimal(0.0);
		BigDecimal valorSalarioLiquido = new BigDecimal(0.0);
		
		for (DescontosBean descontosBean : listaDescontos) {
			if(funcionarioBean.getIdFuncionario() == descontosBean.getIdFuncionario()) {
				somaDescontos = somaDescontos.add(descontosBean.getValorDesconto());
			}
		}
		valorSalarioLiquido = funcionarioBean.getValorSalarioBruto().subtract(somaDescontos);
		
		SalarioLiquidoFuncionario salarioLiquidoFuncionario = new SalarioLiquidoFuncionario();
		salarioLiquidoFuncionario.setIdFuncionario(funcionarioBean.getIdFuncionario()); 
		salarioLiquidoFuncionario.setNomeCliente(funcionarioBean.getNomeCliente());
		salarioLiquidoFuncionario.setValorSalarioLiquido(valorSalarioLiquido);
		return salarioLiquidoFuncionario;
	}

}
