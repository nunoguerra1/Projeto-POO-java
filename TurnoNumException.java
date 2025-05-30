public class TurnoNumException extends Throwable {

	Leitura l = new Leitura();

	public void impErroTurnoNum(){
		System.out.println("ERRO : O turno deve conter apenas letras!");
	}

	public Atendente corrigirTurnoNum(Atendente atn){
		try {
			atn.setTurno(l.entDados("Digite o turno novamente, mas contendo apenas letras : "));
		}

		catch(TurnoNumException tne){
			impErroTurnoNum();
			atn = corrigirTurnoNum(atn);
		}

		return atn;
	}

}