// Nome : Nuno Guerra - RA : a2706504
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Leitura{

	public String entDados(String rotulo){
		System.out.print(rotulo);
	
		InputStreamReader teclado = new InputStreamReader(System.in);
		BufferedReader buffTec = new BufferedReader(teclado);

		String ret = "";

		try{
			ret = buffTec.readLine();		
		}
		catch(IOException ioe){
			System.out.println("ERRO de JVM ou RAM");
		}

		return ret;

	}
}