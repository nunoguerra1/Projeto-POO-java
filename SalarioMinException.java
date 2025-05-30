public class SalarioMinException extends Throwable {

	Leitura l = new Leitura();

	public void impErroSalMin(){
		System.out.println("ERRO : O salário não pode ser menor que o salário minimo(1.518,00)!");
	}

	public Atendente corrigirSalMin(Atendente atn){
		try{
			atn.setSalario(Integer.parseInt(l.entDados("Digite o salário novamente, mas acima do salário minimo : ")));
		}

		catch(SalarioMinException sme){
			impErroSalMin();
			atn = corrigirSalMin(atn);
		}

		catch(NumberFormatException nfe){
			System.out.println("ERRO : O valor deve ser um numero inteiro!");
			atn = corrigirSalMin(atn);
		}

		return atn;
	}

}