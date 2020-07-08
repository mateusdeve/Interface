package models.service;

import java.util.Calendar;

import models.entities.Contract;
import models.entities.Prestacao;

public class ContratoServico {
		
	private ServicoOnlinePagamento servicoOnlinePagamento;
	
	public ContratoServico(ServicoOnlinePagamento servicoOnlinePagamento) {
		this.servicoOnlinePagamento = servicoOnlinePagamento;
	}
	
	Calendar cal = Calendar.getInstance();
	
	public void processoContrato(Contract contrato, Integer meses) {
		
		Double valorBasico = contrato.getTotalValue() / meses;
		
		for(int i = 1; i <= meses; i++) {
			
			cal.setTime(contrato.getDate());
			
			Double valorAtualizado = servicoOnlinePagamento.jurosMensal(valorBasico, i);
			
			Double valorTotal = servicoOnlinePagamento.taxPagamento(valorAtualizado);
			
			cal.add(Calendar.MONTH, i);
			
			contrato.addPrestacao(new Prestacao(cal.getTime(), valorTotal));
			
		}
		
		
	}
}
