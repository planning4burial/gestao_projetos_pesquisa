package estrutura;

import java.util.ArrayList;
import java.util.List;
public class Material {
	private String nomeMaterial;
	private int idMaterial;
	private String tipoArquivo;
	private String dataUpload;
	static List<Material> listaMateriais = new ArrayList<>();
	static int totalMateriais = 0;
	
	public Material(String nome, String tipoArquivo, String dataUpload) {
		this.nomeMaterial = nome;
		this.tipoArquivo = tipoArquivo;
		this.dataUpload = dataUpload;
		totalMateriais++;
		this.idMaterial = totalMateriais;
	}

	public String getNome_material() {
		return nomeMaterial;
	}

	public void setNome_material(String nome_material) {
		this.nomeMaterial = nome_material;
	}

	public int getId_material() {
		return idMaterial;
	}

	public void setId_material(int id_material) {
		this.idMaterial = id_material;
	}

	public String getTipo_arquivo() {
		return tipoArquivo;
	}

	public void setTipo_arquivo(String tipo_arquivo) {
		this.tipoArquivo = tipo_arquivo;
	}

	public String getData_upload() {
		return dataUpload;
	}

	public void setData_upload(String data_upload) {
		this.dataUpload = data_upload;
	}

	public static List<Material> getListaMateriais() {
		return listaMateriais;
	}

	public static void setListaMateriais(List<Material> listaMateriais) {
		Material.listaMateriais = listaMateriais;
	}

	public static int getTotalMateriais() {
		return totalMateriais;
	}

	public static void setTotalMateriais(int totalMateriais) {
		Material.totalMateriais = totalMateriais;
	}
}
