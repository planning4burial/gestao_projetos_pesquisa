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
}