package estrutura;

import java.util.ArrayList;
import java.util.List;
public class Orientador extends Coordenador{
	protected String siape;
	protected String institutoVinculado;
	protected List<Grupo_de_estudo> gruposDeEstudo;

	public Orientador(String nome, int idade, String email, String senha, String id_institucional, String titulacao,
			String areaAtuacao, int limiteOrientados, String siape, String institutoVinculado) {
		super(nome, idade, email, senha, id_institucional, titulacao, areaAtuacao, limiteOrientados);
		this.siape = siape;
		this.institutoVinculado = institutoVinculado;
		this.gruposDeEstudo = new ArrayList<>();
		
	}
	
	

}
