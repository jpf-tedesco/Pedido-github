/* João Pedro Farias Tedesco */

package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.StatusPedido;

public class Pedido {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date momento;
	private StatusPedido status;
	
	private Cliente cliente;
	private List<ItemPedido> itens = new ArrayList<>();
	
	public Pedido(Date momento, StatusPedido status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItem() {
		return itens;
	}
	
	public void addItem(ItemPedido item) {
		itens.add(item);
	}
	
	public void removeItem(ItemPedido item) {
		itens.remove(item);
	}
	
	public double total() {
		double soma = 0.0;
		for (ItemPedido ip : itens) {
			soma += ip.SubTotal();
		}
		return soma;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("RESUMO DO PEDIDO:\n");
		sb.append("Momento Pedido: " + sdf.format(momento) + "\n");
		sb.append("Status Pedido: " + status + "\n");
		sb.append(cliente + "\n");
		for (ItemPedido ip : itens) {
			sb.append(ip + "\n");
		}
		sb.append("Preco Total: R$" + String.format("%.2f", total()));
		
		return sb.toString();
	}

}
