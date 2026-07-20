package estrutura;

public class Material {
	private String nome;
	private String tipoArquivo;
	private String dataUpload;
	private Pesquisador autorUpload;
	static int totalMateriais = 0;
	
	public Material(String nome, String tipoArquivo, String dataUpload) {
		this.nome = nome;
		this.tipoArquivo = tipoArquivo;
		this.dataUpload = dataUpload;
		totalMateriais++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoArquivo() {
		return tipoArquivo;
	}

	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

	public String getDataUpload() {
		return dataUpload;
	}

	public void setDataUpload(String dataUpload) {
		this.dataUpload = dataUpload;
	}

	public Pesquisador getAutorUpload() {
		return autorUpload;
	}

	public void setAutorUpload(Pesquisador autorUpload) {
		this.autorUpload = autorUpload;
	}

	public static int getTotalMateriais() {
		return totalMateriais;
	}

	public static void setTotalMateriais(int totalMateriais) {
		Material.totalMateriais = totalMateriais;
	}
}
	
	
