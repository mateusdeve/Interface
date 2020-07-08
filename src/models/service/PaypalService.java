package models.service;

public class PaypalService implements ServicoOnlinePagamento {

	@Override
	public Double taxPagamento(Double valorTotal) {
		
		return valorTotal + valorTotal * 0.02;
	}

	@Override
	public Double jurosMensal(Double valorTotal, Integer meses) {
		
		return valorTotal + valorTotal * 0.01 * meses;
	}

}
