package app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import estrutura.Pesquisador;
import util.Cadastro;

public class Main {
	public static void main(String[]args) {
		List<Pesquisador> pesquisadores = new ArrayList<>();
		// lista de orientadores deve ficar aqui
		// lista de coordenadores deve ficar aqui
		// lista de gestores deve ficar aqui
		
		
		//testando cadastro/login pesquisador
		//so deve criar objeto apos usuario selecionar menu pesquisador -> cadastrar
		
		//String nome, String email, int idade, String senha, String idInstitucional
		Scanner s = new Scanner(System.in);
		
		pesquisadores.add(Cadastro.CadastrarPesquisador(s));
		
	}
}