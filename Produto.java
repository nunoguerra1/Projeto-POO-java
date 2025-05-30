// Aluno : Nuno Guerra - RA : a2706504
public class Produto {

	private float preco;
	private String nome;

	public Produto(){
		preco = 0.0f;
		nome = "";
	}

	public float getPreco(){
		return preco;
	}

	public String getNome(){
		return nome;
	}

	public void setPreco(float preco){
		this.preco = preco;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

}