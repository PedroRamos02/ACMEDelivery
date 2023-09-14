import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;

public class ACMEDelivery {

	private Scanner leitura = null;
	private PrintStream saidaPadrao = System.out;
	private Clientela clientela;
	private CadastroEntregas cadastroEntregas;

	public ACMEDelivery() {
		cadastroEntregas = new CadastroEntregas();
		clientela = new Clientela();

		try {
			BufferedReader streamEntrada = new BufferedReader(new FileReader("arquivoentrada.txt"));
			leitura = new Scanner(streamEntrada); // Usa como entrada um arquivo
			PrintStream streamSaida = new PrintStream(new File("arquivosaida.txt"), Charset.forName("UTF-8"));
			System.setOut(streamSaida); // Usa como saida um arquivo
		} catch (Exception e) {
			System.out.println(e);
		}
		Locale.setDefault(Locale.ENGLISH); // Ajusta para ponto decimal
		leitura.useLocale(Locale.ENGLISH);
	}

	public void executa() {
		cadastraNovoCliente();
		infoEntregas();
	}

	public void cadastraNovoCliente() {
		String email;
		String nome;
		String endereco;
		email = leitura.nextLine();

		while (!email.equals("-1")) {
			email = leitura.nextLine();
			nome = leitura.nextLine();
		 	endereco = leitura.nextLine();
			Cliente c = new Cliente(email, nome, endereco);
			clientela.cadastraCliente(c);
			System.out.println("1 " + ";" + email + ";" + nome + ";" + endereco);
			email = leitura.nextLine();
		}
	}

	private void infoEntregas() {
		String email = leitura.nextLine();
		Integer codigo = leitura.nextInt();
		double valor = leitura.nextDouble();
		String descricao = leitura.nextLine();
		Entrega e = new Entrega(codigo, valor, descricao);
		if (cadastroEntregas.cadastraEntrega(e)) {
			System.out.println("2 " + ";" + codigo + ";" + valor + ";" + descricao);
		} else {
			System.out.println("Erro no carregamento do pedido.");
		}

	}

	/*
	 * public void executa() {
	 * 
	 * int opcao = 0;
	 * do {
	 * menu();
	 * System.out.print("Digite a opcao desejada: ");
	 * opcao = leitura.nextInt();
	 * leitura.nextLine();
	 * switch(opcao) {
	 * case 0:
	 * break;
	 * case 1:
	 * cadastraNovoCliente();
	 * break;
	 * case 2:
	 * consultarClientePeloEmail();
	 * break;
	 * default:
	 * System.out.println("Opcao invalida! Redigite!");
	 * }
	 * } while(opcao != 0);
	 * }
	 * 
	 * // Mostra o menu de opcoes
	 * private void menu() {
	 * System.out.println("=====================================");
	 * System.out.println("Menu de opcoes: ");
	 * System.out.println("[0] Sair do sistema");
	 * System.out.println("[1] Cadastrar novo cliente");
	 * System.out.println("[2] Consultar cliente pelo endereço de E-mail");
	 * System.out.println("=====================================");
	 * }
	 */
}
