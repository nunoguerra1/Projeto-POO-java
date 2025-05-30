// Aluno : Nuno Guerra - RA : a2706504
import java.time.LocalDate;
public class Pedido{

	private int idPedido;
	private Produto[] produto;
	private int quantidadeProduto;
	private LocalDate dataPedido;

	public Pedido(){
		idPedido = 0;
		produto = new Produto[20];
		quantidadeProduto = 0;
		dataPedido = LocalDate.now();
	}
		
	public int getIdPedido(){
		return idPedido;
	}

	public Produto[] getProduto(){
		return produto;
	}

	public int getQuantidadeProduto(){
		return quantidadeProduto;
	}

	public LocalDate getDataPedido(){
		return dataPedido;
	}
		
	public void setIdPedido(int idPedido){
		this.idPedido = idPedido;
	}

	public void setProduto(Produto[] produto){
		this.produto = produto;
	}

	public void setQuantidadeProduto(int quantidadeProduto){
		this.quantidadeProduto = quantidadeProduto;
	}

	public void setDataPedido(LocalDate dataPedido){
		this.dataPedido = dataPedido;
	}

	public void adicionarProduto(Produto p){
		if(quantidadeProduto < produto.length){
			produto[quantidadeProduto] = p;
			quantidadeProduto++;
		} else {
			System.out.println("ERRO : Não é possivel adicionar mais produtos ao pedido! ");
		}
	}

}	