package models.service;

public interface ServicoOnlinePagamento {
	
	Double taxPagamento(Double quantidade);
	Double jurosMensal(Double valorTotal, Integer meses);

}
