package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import models.entities.Contract;
import models.entities.Prestacao;
import models.service.ContratoServico;
import models.service.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Insira a Data do cntrato:");
		
		System.out.print("Data (dd/mm/yyyy): ");
		Date data = sdf.parse( sc.next());
		
		System.out.print("Valor do contrato:");
		Double totalValue = sc.nextDouble();
		
		System.out.println("Digito o numero de parcelas:");
		Integer numero = sc.nextInt();
		
		System.out.println();
		System.out.println("Prestações:");
		
		Contract contrato = new Contract(numero, data, totalValue);
		
		ContratoServico cs = new ContratoServico(new PaypalService());
		
		cs.processoContrato(contrato, numero);
		
		for(Prestacao prestacao: contrato.getPrestacoes()) {
			System.out.println(
					sdf.format(prestacao.getDataVencimento())+
					" - "+
							prestacao.getQuantidade());
		}
		
		
		sc.close();
		
	}

}
