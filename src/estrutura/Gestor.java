import java.util.List;

public class Gestor extends Orientador {

    public Gestor(String nome, int idade, String email, String senha,String idInstitucional, String titulacao,String areaAtuacao, int limiteOrientados,String siape, String institutoVinculado) {

        super(nome, idade, email, senha, idInstitucional,titulacao, areaAtuacao, limiteOrientados,siape, institutoVinculado);
    }
    //Alocar bolsas para grupos de pesquisa
    public void alocacaoBolsa(Grupo_de_estudo grupo,double valorRecurso,int quantidadeBolsas) {

        System.out.println("\n == ALOCAÇÃO DE BOLSAS ==");
        System.out.println("Gestor: " + getNome());
        System.out.println("Grupo: " + grupo.getNomeGrupo());
        System.out.printf("Recurso Financeiro: R$ %.2f%n", valorRecurso);
        System.out.println("Quantidade de Bolsas: " + quantidadeBolsas);
        System.out.println("Status: Alocação realizada com sucesso.");
    }

    //Consultar grupos de pesquisa cadastrados
    public void consultarGrupos(List<Grupo_de_estudo> grupos) {

        System.out.println("\n == GRUPOS DE PESQUISA ==");

        if (grupos == null || grupos.isEmpty()) {
            System.out.println("Nenhum grupo cadastrado.");
            return;
        }

        for (Grupo_de_estudo grupo : grupos) {
            System.out.println("--------------------------------");
            System.out.println("ID: " + grupo.getGrupoInt());
            System.out.println("Nome: " + grupo.getNomeGrupo());
            System.out.println("Área: " + grupo.getAreaDeEstudo());
        }
    }

    // Acessar métricas institucionais
    public void acessarMetricas(List<Grupo_de_estudo> grupos) {  
        System.out.println("\n == DASHBOARD INSTITUCIONAL == ");

        if (grupos == null || grupos.isEmpty()) {
            System.out.println("Nenhum grupo de pesquisa cadastrado.");
            return;
        }
        System.out.println("Quantidade de grupos: " + grupos.size());
        
        int totalPesquisadores = 0;
        
        for (Grupo_de_estudo grupo : grupos) {
            totalPesquisadores += grupo.getPesquisadores().size();
        }
        System.out.println("Quantidade total de pesquisadores: " + totalPesquisadores);
        
        System.out.println("\nResumo dos grupos:");
        for (Grupo_de_estudo grupo : grupos) {

            System.out.println("----------------------------------------");
            System.out.println("ID: " + grupo.getGrupoInt());
            System.out.println("Grupo: " + grupo.getNomeGrupo());
            System.out.println("Área: " + grupo.getAreaDeEstudo());
            System.out.println("Responsável: " + grupo.getPesquisadorResponsavelDiscente());
            System.out.println("Pesquisadores: " + grupo.getPesquisadores().size());

        }

        System.out.println("==========================================");
}
}
