package estrutura;

public abstract class Usuario {
	protected String nome;
	protected String email;
	protected int idade;
	protected String senha;
	protected String idInstitucional;
	
	public Usuario (String nome, String email, int idade, String senha, String idInstitucional) {
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.senha = senha;
		this.idInstitucional = idInstitucional;
	}
	
	public boolean realizarLogin(String emailDigitado, String senhaDigitada) {
		if (this.email.equals(emailDigitado) && this.senha.equals(senhaDigitada)) {
			System.out.println("Login realizado com sucesso!");
			return true;
		}
		System.out.println("Email ou senha incorretos. ");
		return false;	
		
	}
	
	public abstract void exibirPainel();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
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

	public void setIdInstitucional(String idInstitucional) {
		this.idInstitucional = idInstitucional;
	}

}
