// Aluno : Nuno Guerra - RA : a2706504
import java.time.LocalDate;
public class Principal {

	private static Cliente[] cliente = new Cliente[50];
	private static Atendente[] atendente = new Atendente[50];
	private static Produto[] produto = new Produto[50];
	private static Compra[] compras = new Compra[50];
	private static int quantidadeAtendentes = 0;
	private static int quantidadeClientes = 0;
	private static int quantidadeProdutos = 0;
	private static int quantidadeCompra = 0;

	public static void main(String arg[]) {

	Leitura l = new Leitura();
	boolean continua = true;
	int opcao = 0;

	while (continua) {
		System.out.println("\n+----------------------------------------------------------------------+");
		System.out.println("|   _____          ______ ______ _______ ______ _____  _____           |");
		System.out.println("|  / ____|   /\\   |  ____|  ____|__   __|  ____|  __ \\|_   _|   /\\     |");
		System.out.println("| | |       /  \\  | |__  | |__     | |  | |__  | |__) | | |    /  \\    |");
		System.out.println("| | |      / /\\ \\ |  __| |  __|    | |  |  __| |  _  /  | |   / /\\ \\   |");
		System.out.println("| | |____ / ____ \\| |    | |____   | |  | |____| | \\ \\ _| |_ / ____ \\  |");
		System.out.println("|  \\_____/_/    \\_\\_|    |______|  |_|  |______|_|  \\_\\_____/_/    \\_\\ |");
		System.out.println("|                                                                      |");
		System.out.println("+----------------------------------------------------------------------+");
		System.out.println("\n+--------------------------------- MENU -------------------------------+");
		System.out.println("|                                                                      |");
		System.out.println("|    [1] - Cadastrar Atendente                                         |");
		System.out.println("|    [2] - Consultar Atendente                                         |");
		System.out.println("|    [3] - Cadastrar Cliente                        ( (                |");
		System.out.println("|    [4] - Consultar Cliente                         ) )               |");
		System.out.println("|    [5] - Cadastrar Produto                     ........              |");
		System.out.println("|    [6] - Vender                                |      |]             |");
		System.out.println("|    [7] - Relatório de Vendas                   |      /              |");
		System.out.println("|    [0] - Sair                                   `----'               |");
		System.out.println("|                                                                      |");
		System.out.println("+----------------------------------------------------------------------+");

		try {
			opcao = Integer.parseInt(l.entDados("\nEscolha uma opção: "));
		} catch (NumberFormatException nfe) {
			System.out.println("Você deve digitar um valor inteiro - pressione <ENTER>");
			l.entDados("");
			continue;
		}

		switch (opcao) {
			case 1:
				System.out.println("+----------------------+");
				System.out.println("|CADASTRO DE ATENDENTE!|");
				System.out.println("+----------------------+");
				cadastrarAtendente(l);
				break;
			case 2:
				System.out.println("+---------------------+");
				System.out.println("| CONSULTAR ATENDENTE |");
				System.out.println("+---------------------+");
				consultarAtendente(l);
				break;
			case 3:
				System.out.println("+--------------------+");
				System.out.println("|CADASTRO DE CLIENTE!|");
				System.out.println("+--------------------+");
				cadastrarCliente(l);
				break;
			case 4:
				System.out.println("+--------------------+");
				System.out.println("| CONSULTAR CLIENTE  |");
				System.out.println("+--------------------+");
				consultarCliente(l);
				break;
			case 5:
				System.out.println("+----------------------+");
				System.out.println("| CADASTRO DE PRODUTO  |");
				System.out.println("+----------------------+");
				cadastrarProduto(l);
				break;
			case 6:
				System.out.println("+------------------+");
				System.out.println("| VENDA DE PRODUTO |");
				System.out.println("+------------------+");
				vendaProduto(l);
				break;
			case 7:
				System.out.println("+---------------------+");
				System.out.println("| RELATÓRIO DE VENDAS |");
				System.out.println("+---------------------+");
				relatorioVendas(l);
				break;
			case 0:
				continua = false;
				System.out.println("Encerrando o programa...");
				break;
			default:
				System.out.println("Digite uma opção valida!");
				break;
		}
	}
	}

	public static void cadastrarAtendente(Leitura l){
		
		String cpf_s = l.entDados("CPF..........................: ");

		for (int count = 0; count < quantidadeAtendentes; count++){
			if(atendente[count].getCpf().equals(cpf_s)){
				System.out.println("ERRO : Atendente já cadastrado com esse CPF!");
				return;
			}
		}

		String telefone_s = l.entDados("Telefone...(ex : 24996964920): ");

		for (int count2 = 0; count2 < quantidadeAtendentes; count2++){
			if(atendente[count2].getTelefone().equals(telefone_s)){
				System.out.println("ERRO : Atendente já cadastrado com esse Telefone!");
				return;
			}
		}

		Atendente a = new Atendente();
		a.setCpf(cpf_s);
		a.setTelefone(telefone_s);

		String nome_s = l.entDados("Nome.........................: ");
		a.setNome(nome_s);
		
		
		try {
			String salario_s = l.entDados("SalárioR$....................: ");
			float salario_f = Float.parseFloat(salario_s);
			a.setSalario(salario_f);
		}

		catch(SalarioMinException sme){
			sme.impErroSalMin();
			a = sme.corrigirSalMin(a);
		}

		catch(NumberFormatException nfe){
			System.out.println("ERRO : Valor do bônus deve ser apenas números!");
			return;	
		}

		try {
			String bonus_s = l.entDados("BonusR$......................: ");
			float bonus_f = Float.parseFloat(bonus_s);
			a.setBonus(bonus_f);
		}

		catch(NumberFormatException nfe){
			System.out.println("ERRO : Valor do bônus deve ser apenas números!");
			return;
		}

		try {
			String turno_s = l.entDados("Turno........................: ");
			a.setTurno(turno_s);
		}

		catch(TurnoNumException tne){
			tne.impErroTurnoNum();
			a = tne.corrigirTurnoNum(a);
		}
		
		atendente[quantidadeAtendentes] = a;
		quantidadeAtendentes++;

		System.out.println("\n Atendente cadastrado com sucesso!");
	}

	public static void consultarAtendente(Leitura l){
		
		String cpf_s = l.entDados("Digite o cpf do atendente : ");
		
		for (int count = 0; count < quantidadeAtendentes; count++){
			if (atendente[count].getCpf().equals(cpf_s)){
				System.out.println("\n+--------------------+");
				System.out.println("| DADOS DO ATENDENTE |");
				System.out.println("+--------------------+");	
				System.out.println("Nome...........: "+atendente[count].getNome());
				System.out.println("Telefone.......: "+atendente[count].getTelefone());
				System.out.println("Cpf............: "+atendente[count].getCpf());
				System.out.println("Salario bruto..: "+atendente[count].getSalario()+"R$");
				System.out.println("Bonus..........: "+atendente[count].getBonus()+"R$");
				atendente[count].salarioTotal(); // Interfaçe 
				System.out.println("Turno..........: "+atendente[count].getTurno());
				return;
			}
			
		}

		System.out.println("ERRO : Atendente não encontrado!");
	}


	public static void cadastrarCliente(Leitura l){

		String cpf_s = l.entDados("CPF..........................: ");

		for (int count = 0; count < quantidadeClientes; count++){
			if(cliente[count].getCpf().equals(cpf_s)){
				System.out.println("ERRO : Cliente já cadastrado com esse CPF!");
				return;
			}
		}
	
		String telefone_s = l.entDados("Telefone...(ex : 24996964920): ");

		for (int count2 = 0; count2 < quantidadeClientes; count2++){
			if(cliente[count2].getTelefone().equals(telefone_s)){
				System.out.println("ERRO : Cliente já cadastrado com esse Telefone!");
				return;
			}
		}

		Cliente c = new Cliente();
		c.setCpf(cpf_s);
		c.setTelefone(telefone_s);	

		String nome_s = l.entDados("Nome.........................: ");
		c.setNome(nome_s);

		try {
			String preferencia_s = l.entDados("Preferência..................: ");
			c.setPreferencia(preferencia_s);
		}

		catch(PreferenciaNumException pne){
			pne.impErroPrefNum();
			c = pne.corrigirPrefNum(c);
		}

		c.setDataCadastro(LocalDate.now());

		cliente[quantidadeClientes] = c;
		quantidadeClientes++;

		System.out.println("\n Cliente cadastrado com sucesso!");

	}

		
		public static void consultarCliente(Leitura l){
			
			String cpf_s = l.entDados("Digite o CPF do cliente : ");
			
			for (int count = 0; count < quantidadeClientes; count++){
				if(cliente[count].getCpf().equals(cpf_s)){
					System.out.println("\n+------------------+");
					System.out.println("| DADOS DO CLIENTE |");
					System.out.println("+------------------+");
					System.out.println("Nome.............: "+cliente[count].getNome());
					System.out.println("Telefone.........: "+cliente[count].getTelefone());
					System.out.println("CPF..............: "+cliente[count].getCpf());
					System.out.println("Preferencia......: "+cliente[count].getPreferencia());
					System.out.println("Data de cadastro.: "+cliente[count].getDataCadastro());
					return;
				} 	
			}
			System.out.println("ERRO : Cliente não encontrado!");
		}

		
		public static void cadastrarProduto(Leitura l){
			Produto p = new Produto();
			System.out.println("+----------------------+");
			System.out.println("|    [1] - Cafe        |");
			System.out.println("|    [2] - Bolo        |");
			System.out.println("|    [3] - Salgado     |");
			System.out.println("|    [4] - Voltar      |");
			System.out.println("+----------------------+");
			String decisao_s = l.entDados("\nEscolha uma opção : ");
			int decisao_i = Integer.parseInt(decisao_s);

			switch (decisao_i) {
				case 1:
					System.out.println("+--------------+");
					System.out.println("|CADASTRO CAFE!|");
					System.out.println("+--------------+");

					Cafe cafe = new Cafe();

					String nomecafe_s = l.entDados("Nome...........................: ");
					cafe.setNome(nomecafe_s);

					String tamanho_s = l.entDados("Tamanho (Grande/Médio/Pequeno).: ");
					cafe.setTamanho(tamanho_s);
				
					String tipo_s = l.entDados("Tipo...........................: ");
					cafe.setTipo(tipo_s);

					String intensidade_s = l.entDados("Intensidade....................: ");
					cafe.setIntensidade(intensidade_s);

					try {
						String precocafe_s = l.entDados("Preco..........................: ");
						float precocafe_f = Float.parseFloat(precocafe_s);
						cafe.setPreco(precocafe_f);
					}

					catch(NumberFormatException nfe){
						System.out.println("ERRO : O preço deve conter apenas numeros!");
						return;
					}

					System.out.println("\nCafé cadastrado com sucesso! ");

					produto[quantidadeProdutos] = cafe;
					quantidadeProdutos++;
					break;
				case 2:
					System.out.println("+--------------+");
					System.out.println("|CADASTRO BOLO!|");
					System.out.println("+--------------+");
					
					Bolo b = new Bolo();
					
					String nomebolo_s = l.entDados("Nome...........: ");
					b.setNome(nomebolo_s);
					
					String saborbolo_s = l.entDados("Sabor..........: ");
					b.setSabor(saborbolo_s);
					
					String tipocobertura_s = l.entDados("Cobertura......: ");
					b.setTipoCobertura(tipocobertura_s);
					
					try {
						String peso_s = l.entDados("Peso por fatia.: ");
						float peso_f = Float.parseFloat(peso_s);
						b.setPeso(peso_f);
					}

					catch(NumberFormatException nfe){
						System.out.println("ERRO : O peso da fatia deve conter apenas numeros!");
						return;
					}

					try {
						String precobolo_s = l.entDados("Preco..........: ");
						float precobolo_f = Float.parseFloat(precobolo_s);
						b.setPreco(precobolo_f);
					}
					
					catch(NumberFormatException nfe){
						System.out.println("ERRO : O preço deve conter apenas numeros!");
						return;
					}

					System.out.println("\nBolo cadastrado com sucesso! ");

					produto[quantidadeProdutos] = b;
					quantidadeProdutos++;
					break;	
				case 3:
					System.out.println("+-----------------+");
					System.out.println("|CADASTRO SALGADO!|");
					System.out.println("+-----------------+");
			
					Salgado s = new Salgado();
					
					String nomesalgado_s = l.entDados("Nome............: ");
					s.setNome(nomesalgado_s);
			
					String assadofrito_s = l.entDados("Assado ou frito.: ");
					s.setAssadoFrito(assadofrito_s);

					String tiposalgado_s = l.entDados("Tipo............: ");
					s.setTipo(tiposalgado_s);

					String recheio_s = l.entDados("Recheio.........: ");
					s.setRecheio(recheio_s);

					try{
						String precosalgado_s = l.entDados("Preco...........: ");
						float precosalgado_f = Float.parseFloat(precosalgado_s);
						s.setPreco(precosalgado_f);
					}

					catch(NumberFormatException nfe){
						System.out.println("ERRO : O preço deve conter apenas numeros!");
						return;
					}

					System.out.println("\nSalgado cadastrado com sucesso! ");

					produto[quantidadeProdutos] = s;
					quantidadeProdutos++;
					break;
				case 4:
					break;
				default:
					System.out.println("Digite uma opção valida!");
					break;
			}
			
		}

		public static void vendaProduto(Leitura l){
			if (quantidadeClientes == 0){
				System.out.println ("ERRO : Cadastre um cliente antes de prosseguir com a venda! ");
				return;
			}

			if (quantidadeAtendentes == 0){
				System.out.println ("ERRO : Cadastre um atendente antes de prosseguir com a venda! ");
				return;
			}
			
			String cpf_a = l.entDados("Digite o cpf do Atendente : ");
			for (int count = 0; count < quantidadeAtendentes ; count++){
				if (atendente[count].getCpf().equals(cpf_a)){
					Atendente a = atendente[count];
					String cpf_c = l.entDados("Digite o cpf do Cliente : ");
					for (int count2 = 0; count2 < quantidadeClientes ; count2++){
						if (cliente[count2].getCpf().equals(cpf_c)){
							Pedido p = new Pedido();
							float precoTotal = 0;
							String continuar;
					
					do {
						System.out.println("+--------------------+");
						System.out.println("|Produtos disponíveis|");
						System.out.println("+--------------------+");
						for (int count3 = 0; count3 < quantidadeProdutos ; count3++){
							System.out.println(count3 + " - " +produto[count3].getNome()+ " - " + produto[count3].getPreco() +"R$ ");
						}

						String nomeProduto = l.entDados("Digite o nome do produto que deseja adicionar : ");

						boolean encontrado = false;
						
						for (int count4 = 0; count4 < quantidadeProdutos ; count4++){
							if(produto[count4].getNome().equalsIgnoreCase(nomeProduto)){
								p.adicionarProduto(produto[count4]);
								precoTotal += produto[count4].getPreco();
								encontrado = true;
								break;
							} 	
						}

						if (!encontrado){
							System.out.println("ERRO : Produto não encontrado! ");
							return;
						}

						continuar = l.entDados("Deseja adicionar mais produtos? (s/n): ");
					} while (continuar.equalsIgnoreCase("s"));

					Compra novaCompra = new Compra();
					novaCompra.setIdCompra(quantidadeCompra + 1);
					novaCompra.setCliente(cliente[count]);
					novaCompra.setValorTotal(precoTotal);
					novaCompra.setDataCompra(LocalDate.now());
					novaCompra.setAtendente(a);
					a.setTotalVendas(a.getTotalVendas() + 1);
					a.setValorTotalVendas(precoTotal);

				   	compras[quantidadeCompra] = novaCompra;
					quantidadeCompra++;
				
					System.out.println("\nCompra realizada com sucesso! ");

					System.out.println("\n+-----------------------+");
					System.out.println("| Informações da compra |");
					System.out.println("+-----------------------+");
					System.out.println("Atendente......: "+novaCompra.getAtendente().getNome());
					System.out.println("ID da compra...: "+novaCompra.getIdCompra());
					System.out.println("Cliente........: "+novaCompra.getCliente().getNome());
					System.out.println("Valor total....: "+novaCompra.getValorTotal()+ "R$");
					System.out.println("Data da compra.: "+novaCompra.getDataCompra());
					return;
				}
				}
			}			
			}
				
			}

		public static void relatorioVendas(Leitura l){
			if (quantidadeCompra == 0){
				System.out.println("ERRO : Nenhuma venda foi realizada! ");
				return;
			}

			
			String cpf = l.entDados("Digite o cpf do atendente que deseja consultar : ");
			for (int count = 0; count < quantidadeAtendentes ; count++){
				if (atendente[count].getCpf().equals(cpf)){
					System.out.println("+-----------+");
					System.out.println("| RELATÓRIO |");
					System.out.println("+-----------+");
					System.out.println("Nome.........: "+atendente[count].getNome());
					System.out.println("Telefone.....: "+atendente[count].getTelefone());
					System.out.println("Cpf..........: "+atendente[count].getCpf());
					System.out.println("Vendas.......: "+atendente[count].getTotalVendas());
					System.out.println("Valor total..: "+atendente[count].getValorTotalVendas());
					return;
				}
			}
			System.out.println("ERRO : Atendente não encontrado! ");
		}
			
}