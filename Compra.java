// Aluno : Nuno Guerra - RA : a2706504
import java.time.LocalDate;
public class Compra{

	private int idCompra;
	private Cliente cliente;
	private Pedido pedido;
	private Atendente atendente;
	private float valorTotal;
	private LocalDate dataCompra;

	public Compra(){
		idCompra = 0;
		cliente = new Cliente();
		pedido = new Pedido();
		valorTotal = 0.0f;
		dataCompra = LocalDate.now();
	}

	public int getIdCompra(){
		return idCompra;
	}

	public Cliente getCliente(){
		return cliente;
	}

	public Pedido getPedido(){
		return pedido;
	}

	public Atendente getAtendente(){
		return atendente;
	}

	public float getValorTotal(){
		return valorTotal;
	}

	public LocalDate getDataCompra(){
		return dataCompra;
	}

	public void setIdCompra(int idCompra){
		this.idCompra = idCompra;
	}

	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}

	public void setPedido(Pedido pedido){
		this.pedido = pedido;
	}

	public void setAtendente(Atendente atendente){
		this.atendente = atendente;
	}

	public void setValorTotal(float valorTotal){
		this.valorTotal = valorTotal;
	}

	public void setDataCompra(LocalDate dataCompra){
		this.dataCompra = dataCompra;
	}



}