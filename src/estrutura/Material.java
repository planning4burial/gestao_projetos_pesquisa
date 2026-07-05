package estrutura;

import java.util.ArrayList;
import java.util.List;
public class Material {
	private String nomeMaterial;
	private int idMaterial;
	private String tipoArquivo;
	private String dataUpload;
	private Pesquisador autorUpload;
	static List<Material> listaMateriais = new ArrayList<>();
	static int totalMateriais = 0;
	
	public Material(String nome, String tipoArquivo, String dataUpload) {
		this.nomeMaterial = nome;
		this.tipoArquivo = tipoArquivo;
		this.dataUpload = dataUpload;
		totalMateriais++;
		this.idMaterial = totalMateriais;
	}

	public String getNomeMaterial() {
		return nomeMaterial;
	}

	public void setNomeMaterial(String nomeMaterial) {
		this.nomeMaterial = nomeMaterial;
	}

	public int getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
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
