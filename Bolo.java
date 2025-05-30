// Aluno : Nuno Guerra - RA : a2706504
public class Bolo extends Produto{

	private String sabor;
	private float peso;
	private String tipoCobertura;

	public Bolo(){
		sabor = "";
		peso = 0.0f;
		tipoCobertura = "";
		
	}

	public String getSabor(){
		return sabor;
	}

	public float getPeso(){
		return peso;
	}

	public String getTipoCobertura(){
		return tipoCobertura;
	}

	public void setSabor(String sabor){
		this.sabor = sabor;
	}

	public void setPeso(float peso){
		this.peso = peso;
	}

	public void setTipoCobertura(String tipoCobertura){
		this.tipoCobertura = tipoCobertura;
	}



}