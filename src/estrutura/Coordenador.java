package estrutura;

public class Coordenador extends Pesquisador{
	protected String titulacao;
	protected String areaAtuacao;
	protected int limiteOrientados;


 public Coordenador(String nome, int idade, String email, String senha, String id_institucional, String titulacao, String areaAtuacao, int limiteOrientados) {
	 super(nome, idade, email, senha, id_institucional);
	 this.titulacao=titulacao;
	 this.areaAtuacao=areaAtuacao;
	 this.limiteOrientados = limiteOrientados;
 }
 
 public void criarTarefa() {
	 
 }
 
 public void agendarReuniao() {
	 
 }
 
 public void adicionarMembroSubgrupo() {
	 
 }
 
 public void removerMembroSubgrupo() {
	 
 }

 public String getTitulacao() {
	return titulacao;
 }

 public void setTitulacao(String titulacao) {
	this.titulacao = titulacao;
 }

 public String getAreaAtuacao() {
	return areaAtuacao;
 }

 public void setAreaAtuacao(String areaAtuacao) {
	this.areaAtuacao = areaAtuacao;
 }

 public int getLimiteOrientados() {
	return limiteOrientados;
 }

 public void setLimiteOrientados(int limiteOrientados) {
	this.limiteOrientados = limiteOrientados;
 }


}

 
