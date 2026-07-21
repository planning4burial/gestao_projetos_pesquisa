package util;

public class Menus {

    public void menuPrincipal() {
    
    	System.out.println("\n==================================");
    	System.out.println(" SISTEMA DE GESTÃO DE PESQUISA");
    	System.out.println("==================================");
    	System.out.println("1 - Pesquisador");
    	System.out.println("2 - Coordenador");
    	System.out.println("3 - Orientador");
    	System.out.println("4 - Gestor");
    	System.out.println("0 - Sair");
    	
    	System.out.print("Escolha: ");
    	
    }
    	
    public void menuPesquisador() {
    	
    	System.out.println("\n===== MENU PESQUISADOR =====");
    	System.out.println("1 - Cadastrar");
    	System.out.println("2 - Login");
    	System.out.println("0 - Voltar");
    	
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