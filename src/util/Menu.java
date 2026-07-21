package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import estrutura.Grupo_de_estudo;
import estrutura.Usuario;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

    private List<Usuario> usuarios = new ArrayList<>();
    private List<Grupo_de_estudo> grupos = new ArrayList<>();

    public void menuPrincipal() {

        int opcao;

        do {

            System.out.println("\n==================================");
            System.out.println(" SISTEMA DE GESTÃO DE PESQUISA");
            System.out.println("==================================");
            System.out.println("1 - Pesquisador");
            System.out.println("2 - Coordenador");
            System.out.println("3 - Orientador");
            System.out.println("4 - Gestor");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {

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

        } while(opcao != 0);

    }

    public void menuPesquisador() {

        int opcao;

        do {

            System.out.println("\n===== MENU PESQUISADOR =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Login");
            System.out.println("0 - Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {

                case 1:
                    System.out.println("Cadastro do pesquisador...");
                    break;

                case 2:
                    System.out.println("Login do pesquisador...");
                    break;

            }

        } while(opcao != 0);

    }

    public void menuCoordenador() {

        System.out.println("\n===== MENU COORDENADOR =====");

    }

    public void menuOrientador() {

        System.out.println("\n===== MENU ORIENTADOR =====");

    }

    public void menuGestor() {

        System.out.println("\n===== MENU GESTOR =====");

    }

}