package app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import estrutura.Pesquisador;

public class Main {
	public static void main(String[]args) {
		List<Pesquisador> pesquisadores = new ArrayList<>();
		// lista de orientadores deve ficar aqui
		// lista de coordenadores deve ficar aqui
		// lista de gestores deve ficar aqui
		
		
		//testando cadastro/login pesquisador
		//so deve criar objeto apos usuario selecionar menu pesquisador -> cadastrar
		
		//String nome, String email, int idade, String senha, String idInstitucional
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite seu nome: ");
		String nome = scanner.nextLine();
		
		System.out.println("Digite sua idade: ");
		int idade = scanner.nextInt();
		
		scanner.nextLine(); // limpando buffer
		
		System.out.println("Digite seu id institucional: ");
		String id_institucional = scanner.nextLine();
		
		System.out.println("Digite seu email: ");
		String email = scanner.nextLine();
		
		System.out.println("Crie uma senha: ");
		String senha = scanner.nextLine();
		
		
		Pesquisador p = new Pesquisador(nome, email, idade, senha, id_institucional);
		pesquisadores.add(p);
		
	}
}
