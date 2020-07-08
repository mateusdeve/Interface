package models.entities;

import java.util.Date;

public class Prestacao {

	private Date dataVencimento;
	private Double quantidade;
	
	public Prestacao() {
	}

	public Prestacao(Date dataVencimento, Double quantidade) {
		this.dataVencimento = dataVencimento;
		this.quantidade = quantidade;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
