package estrutura;

public class Pesquisador {
	protected String nome;
	protected int idade;
	protected String email;
	protected String senha;
	protected String idInstitucional;
	
	public Pesquisador(String nome, int idade, String email, String senha, String idInstitucional) {
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.senha = senha;
		this.idInstitucional = idInstitucional;
	}
	
	public void realizarLogin(String email, String senha) {
		
	}
	
	public void realizarCadastro(String email, String senha) {
		
	}
	
	public void visualizaTarefa() {
		
	}
	
	public void atualizarStatusTarefa() {
		
	}
	
	public void fazerUploadMaterial(String nome, String tipoArquivo, String dataUpload) {
		Material m = new Material(nome, tipoArquivo, dataUpload);
		Material.getListaMateriais().add(m);
	}
	
	public void enviarRelatorioTarefa() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getIdInstitucional() {
		return idInstitucional;
	}

	public void setIdInstitucional(String id_institucional) {
		this.idInstitucional = id_institucional;
	}
}