// Aluno : Nuno Guerra - RA : a2706504
public class Pessoa {

	private String nome;
	private String telefone;
	private String cpf;

	public Pessoa(){
		nome = "";
		telefone = "";
		cpf = "";	
	}

	// Polimorfismo por SOBRECARGA
	public Pessoa (String nome, String cpf, String telefone){
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public String getNome(){
		return nome;
	}

	public String getTelefone(){
		return telefone;
	}

	public String getCpf(){
		return cpf;
	}

	public void setNome(String nome){
		this.nome = nome;
	}	

	public void setTelefone(String telefone){
			this.telefone = telefone;
	}

	public void setCpf(String cpf){
		this.cpf = cpf;
	}


}