package estrutura;

import java.util.ArrayList;
import java.util.List;

public class Grupo_de_estudo {
    protected int grupoInt; 
    protected String nomeGrupo; 
    protected String pesquisadorResponsavelDiscente; 
    protected String areaDeEstudo; 
    private List<Pesquisador> pesquisadores;
    // Construtor 
   public Grupo_de_estudo(int grupoInt,String nomeGrupo,String pesquisadorResponsavelDiscente,String areaDeEstudo,List<Pesquisador> pesquisadores) {

    this.grupoInt = grupoInt;
    this.nomeGrupo = nomeGrupo;
    this.pesquisadorResponsavelDiscente = pesquisadorResponsavelDiscente;
    this.areaDeEstudo = areaDeEstudo;
    this.pesquisadores = (pesquisadores != null)
            ? pesquisadores
            : new ArrayList<>();
}

    //Adicionar e remover pesquisadores do grupo
   public void adicionarPesquisador(Pesquisador pesquisador) {
        if (pesquisador != null && !this.pesquisadores.contains(pesquisador)) {
            this.pesquisadores.add(pesquisador);
            System.out.println("Pesquisador '" + pesquisador.getNome() + "' adicionado com sucesso ao grupo " + this.nomeGrupo + ".");
        }
    }
        
    public void removerPesquisador(Pesquisador pesquisador) {
        if (this.pesquisadores.contains(pesquisador)) {
            this.pesquisadores.remove(pesquisador);
            System.out.println("Pesquisador '" + pesquisador.getNome() + "' removido do grupo " + this.nomeGrupo + ".");
        } else {
            System.out.println("Este pesquisador não faz parte do grupo " + this.nomeGrupo + ".");
        }
    }
    
    //Getters e Setters
    public int getGrupoInt() {
        return grupoInt;
    }

    public void setGrupoInt(int grupoInt) {
        this.grupoInt = grupoInt;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getPesquisadorResponsavelDiscente() {
        return pesquisadorResponsavelDiscente;
    }

    public void setPesquisadorResponsavelDiscente(String pesquisadorResponsavelDiscente) {
        this.pesquisadorResponsavelDiscente = pesquisadorResponsavelDiscente;
    }

    public String getAreaDeEstudo() {
        return areaDeEstudo;
    }

    public void setAreaDeEstudo(String areaDeEstudo) {
        this.areaDeEstudo = areaDeEstudo;
    }

    public List<Pesquisador> getPesquisadores() {
        return pesquisadores;
    }

    public void setPesquisadores(List<Pesquisador> pesquisadores) {
        this.pesquisadores = pesquisadores;
    }
}
