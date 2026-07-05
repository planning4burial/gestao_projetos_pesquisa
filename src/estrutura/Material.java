package estrutura;

public class Material {
	private String nome_material;
	private int id_material;
	private String tipo_arquivo;
	private String data_upload;
	
	public Material(String nome, int id, String tipo_arquivo, String data_upload) {
		this.nome_material = nome;
		this.id_material = id;
		this.tipo_arquivo = tipo_arquivo;
		this.data_upload = data_upload;
	}

	public String getNome_material() {
		return nome_material;
	}

	public void setNome_material(String nome_material) {
		this.nome_material = nome_material;
	}

	public int getId_material() {
		return id_material;
	}

	public void setId_material(int id_material) {
		this.id_material = id_material;
	}

	public String getTipo_arquivo() {
		return tipo_arquivo;
	}

	public void setTipo_arquivo(String tipo_arquivo) {
		this.tipo_arquivo = tipo_arquivo;
	}

	public String getData_upload() {
		return data_upload;
	}

	public void setData_upload(String data_upload) {
		this.data_upload = data_upload;
	}
}
