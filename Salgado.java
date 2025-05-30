// Aluno : Nuno Guerra - RA : a2706504
public class Salgado extends Produto{

	private String tipo;
	private String assadoFrito;
	private String recheio;

	public Salgado(){
		tipo = "";
		assadoFrito = "";
		recheio = "";
	}

	public String getTipo(){
		return tipo;
	}

	public String getAssadoFrito(){
		return assadoFrito;
	}

	public String getRecheio(){
		return recheio;
	}

	public void setTipo(String tipo){
		this.tipo = tipo;
	}

	public void setAssadoFrito(String assadoFrito){
		this.assadoFrito = assadoFrito;
	}

	public void setRecheio(String recheio){
		this.recheio = recheio;
	}


}