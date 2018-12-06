package br.edu.ufcg.pharma.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "VENDA_PRODUTO")
public class VendaProduto implements Serializable {
	
	
	@Id
	@NotNull
	@ManyToOne
	@JoinColumn(name = "VENDA_ID")
	private Venda venda;

	@Id
	@NotNull
	@ManyToOne
	@JoinColumn(name = "PRODUTO_ID")
	private Produto produto;
	
	@NotNull
	@Column(name = "VALOR_UNITARIO")
	private double valorUnitario;
	
	@NotNull
	@Column(name = "VALOR_SUBTOTAL")
	private double valorSubtotal;
	
	@NotNull
	@Column(name = "VALOR_TOTAL")
	private double valorTotal;
	
	@NotNull
	@Column(name = "QUANTIDADE")
	private Integer quantidade;

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public double getValorSubtotal() {
		return valorSubtotal;
	}

	public void setValorSubtotal(double valorSubtotal) {
		this.valorSubtotal = valorSubtotal;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((venda == null) ? 0 : venda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendaProduto other = (VendaProduto) obj;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (venda == null) {
			if (other.venda != null)
				return false;
		} else if (!venda.equals(other.venda))
			return false;
		return true;
	}
}
