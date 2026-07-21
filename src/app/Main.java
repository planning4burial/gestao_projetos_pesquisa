package app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import estrutura.Grupo_de_estudo;
import estrutura.Usuario;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Usuario> usuarios = new ArrayList<>();
    static List<Grupo_de_estudo> grupos = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        do {

            System.out.println(" SISTEMA DE GESTÃO DE PESQUISA");
            System.out.println("====================================");
            System.out.println("1 - Pesquisador");
            System.out.println("2 - Coordenador");
            System.out.println("3 - Orientador");
            System.out.println("4 - Gestor");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

            case 1:
                menuPesquisador();
                break;

            case 2:
                menuCoordenador();
                break;

            case 3:
                menuOrientador();
                break;

            case 4:
                menuGestor();
                break;

            case 0:
                System.out.println("Sistema encerrado.");
                break;

            default:
                System.out.println("Opção inválida.");

            }

        } while (opcao != 0);

        scanner.close();
    }

//menu pesquisador
    public static void menuPesquisador() {
        System.out.println("\n== MENU PESQUISADOR ==");

    }
//menu coordenador
    public static void menuCoordenador() {
        System.out.println("\n== MENU COORDENADOR ==");

    }
//menu orientador
    public static void menuOrientador() {
        System.out.println("\n== MENU ORIENTADOR ==");

    }
//menu gestor
    public static void menuGestor() {
        System.out.println("\n== MENU GESTOR ==");

    }
	// lista de orientadores deve ficar aqui
		// lista de coordenadores deve ficar aqui
		// lista de gestores deve ficar aqui
		
		
		//testando cadastro/login pesquisador
		//so deve criar objeto apos usuario selecionar menu pesquisador -> cadastrar
		
		//String nome, String email, int idade, String senha, String idInstitucional
		Scanner s = new Scanner(System.in);
		
		//pesquisadores.add(Cadastro.CadastrarPesquisador(s));

}
