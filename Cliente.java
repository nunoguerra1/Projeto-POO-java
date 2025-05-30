// Aluno : Nuno Guerra - RA : a2706504
import java.time.LocalDate;
public class Cliente extends Pessoa{

	private String preferencia;
	private LocalDate dataCadastro;

	public Cliente(){
		preferencia = "";
		dataCadastro = LocalDate.now();
	}

	// Polimorfismo por SOBRESCRITA
	public String getNome(){
		return super.getNome();
	}

	public String getPreferencia(){
		return preferencia;
	}	

	public LocalDate getDataCadastro(){
		return dataCadastro;
	}
		
	public void setPreferencia(String preferencia) throws PreferenciaNumException{
		if (preferencia.matches(".*\\d.*")) {
			throw new PreferenciaNumException();
		}

		this.preferencia = preferencia;
	}

	public void setDataCadastro(LocalDate dataCadastro){
		this.dataCadastro = dataCadastro;
	}



}