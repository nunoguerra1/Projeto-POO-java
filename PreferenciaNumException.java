public class PreferenciaNumException extends Throwable {

	Leitura l = new Leitura();

	public void impErroPrefNum(){
		System.out.println("ERRO : A preferencia deve conter apenas letras!");
	}

	public Cliente corrigirPrefNum(Cliente cli){
		try {
			cli.setPreferencia(l.entDados("Digite a preferencia novamente, mas contendo somente letras : "));
		}

		catch(PreferenciaNumException pne){
			impErroPrefNum();
			cli = corrigirPrefNum(cli);
		}

		return cli;
	}

}