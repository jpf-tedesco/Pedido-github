package entities;

public class ItemPedido {
	
	private Integer quantidade;
	private Double preco;
	
	private Produto produto;

	public ItemPedido(Integer quantidade, Double preco, Produto produto) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public double SubTotal() {
		return quantidade * preco;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(produto.getNome());
		sb.append(", R$" + String.format("%.2f", preco));
		sb.append(", Quantidade: " + quantidade);
		sb.append(", SubTotal: R$" + String.format("%.2f", SubTotal()));
		
		return sb.toString();
	}

}
