package util;

import java.util.Scanner;

import estrutura.Coordenador;
import estrutura.Gestor;
import estrutura.Orientador;
import estrutura.Pesquisador;

public class Cadastro {
	
	public static Pesquisador CadastrarPesquisador(Scanner s) {
		
		System.out.println("Digite seu nome: ");
		String nome = s.nextLine();
	
		System.out.println("Digite sua idade: ");
		int idade = s.nextInt();
	
		s.nextLine(); // limpando buffer
	
		System.out.println("Digite seu id institucional: ");
		String id_institucional = s.nextLine();
	
		System.out.println("Digite seu email: ");
		String email = s.nextLine();
	
		System.out.println("Crie uma senha: ");
		String senha = s.nextLine();
	
		return new Pesquisador(nome, email, idade, senha, id_institucional);
	
	}

	public static Coordenador CadastrarCoordenador(Scanner s) {
		
		System.out.println("Digite seu nome: ");
		String nome = s.nextLine();
	
		System.out.println("Digite sua idade: ");
		int idade = s.nextInt();
	
		s.nextLine(); // limpando buffer
	
		System.out.println("Digite seu id institucional: ");
		String id_institucional = s.nextLine();
		
		System.out.println("Digite sua titulacao: ");
		String titulacao = s.nextLine();
		
		System.out.println("Digite sua area de atuacao: ");
		String areaAtuacao = s.nextLine();
		
		System.out.println("Digite o limite de orientados: ");
		int limiteOrientados = s.nextInt();
		
		s.nextLine(); // limpando buffer
	
		System.out.println("Digite seu email: ");
		String email = s.nextLine();
	
		System.out.println("Crie uma senha: ");
		String senha = s.nextLine();
	
		return new Coordenador(nome, email, idade, senha, id_institucional, titulacao, areaAtuacao, limiteOrientados);
	
	}
	
	public static Orientador CadastrarOrientador(Scanner s) {

		System.out.println("Digite seu nome: ");
		String nome = s.nextLine();

		System.out.println("Digite sua idade: ");
		int idade = s.nextInt();
		
		s.nextLine(); // limpando buffer

		System.out.println("Digite seu id institucional: ");
		String id_institucional = s.nextLine();

		System.out.println("Digite sua titulacao: ");
		String titulacao = s.nextLine();

		System.out.println("Digite sua area de atuacao: ");
		String areaAtuacao = s.nextLine();

		System.out.println("Digite seu limite de orientados: ");
		int limiteOrientados = s.nextInt();
		
		s.nextLine(); // limpando buffer

		System.out.println("Digite seu SIAPE: ");
		String siape = s.nextLine();

		System.out.println("Digite seu instituto vinculado: ");
		String institutoVinculado = s.nextLine();

		System.out.println("Digite seu email: ");
		String email = s.nextLine();

		System.out.println("Crie uma senha: ");
		String senha = s.nextLine();

		return new Orientador(nome, idade, email, senha, id_institucional, titulacao, areaAtuacao, limiteOrientados, siape, institutoVinculado);
	
	}

	public static Gestor CadastrarGestor(Scanner s) {

		System.out.println("Digite seu nome: ");
		String nome = s.nextLine();

		System.out.println("Digite sua idade: ");
		int idade = s.nextInt();
		
		s.nextLine(); // limpando buffer

		System.out.println("Digite seu id institucional: ");
		String id_institucional = s.nextLine();

		System.out.println("Digite sua titulacao: ");
		String titulacao = s.nextLine();

		System.out.println("Digite sua area de atuacao: ");
		String areaAtuacao = s.nextLine();

		System.out.println("Digite seu limite de orientados: ");
		int limiteOrientados = s.nextInt();
		
		s.nextLine(); // limpando buffer

		System.out.println("Digite seu SIAPE: ");
		String siape = s.nextLine();

		System.out.println("Digite seu instituto vinculado: ");
		String institutoVinculado = s.nextLine();

		System.out.println("Digite seu email: ");
		String email = s.nextLine();

		System.out.println("Crie uma senha: ");
		String senha = s.nextLine();

		return new Gestor(nome, idade, email, senha, id_institucional, titulacao, areaAtuacao, limiteOrientados, siape, institutoVinculado);
	
	}
}
