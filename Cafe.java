// Aluno : Nuno Guerra - RA : a2706504
public class Cafe extends Produto{

	private String tamanho;
	private String tipo;
	private String intensidade;

	public Cafe(){
		tamanho = "";
		tipo = "";
		intensidade = "";
	}
		
	public String getTamanho(){
		return tamanho;
	}

	public String getTipo(){
		return tipo;	
	}

	public String getIntensidade(){
		return intensidade;
	}

	public void setTamanho(String tamanho){
		this.tamanho = tamanho;
	}

	public void setTipo(String tipo){
		this.tipo = tipo;
	}

	public void setIntensidade(String intensidade){
		this.intensidade = intensidade;
	}


}