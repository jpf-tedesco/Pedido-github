package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.ItemPedido;
import entities.Pedido;
import entities.Produto;
import entities.enums.StatusPedido;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		
		System.out.println("Entre com os dados do Cliente:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de Nascimento: ");
		Date dataNascimento = sdf.parse(sc.next());
		
		Cliente cliente = new Cliente(nome, email, dataNascimento);
		
		System.out.println("Entre com os dados do Pedido:");
		System.out.print("Status: ");
		StatusPedido status = StatusPedido.valueOf(sc.next());
		
		Pedido pedido = new Pedido(new Date(), status, cliente);
		
		System.out.print("Qual a quantidade de itens a serem inseridos no produto? ");
		int cont = sc.nextInt();
		
		for(int i=1; i<=cont; i++) {
			System.out.println("Entre #" + i + " com os dados do Item:");
			System.out.print("Nome Produto: ");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			System.out.print("Preço Produto: ");
			double precoProduto = sc.nextDouble();
			
			Produto produto = new Produto(nomeProduto, precoProduto);
			
			System.out.print("Quantidade: ");
			int quantidade = sc.nextInt();
			
			ItemPedido itemPedido = new ItemPedido(quantidade, precoProduto, produto);
			
			pedido.addItem(itemPedido);
			
		}
		
		System.out.println();
		System.out.println(pedido);
		
		sc.close();
		
	}

}
