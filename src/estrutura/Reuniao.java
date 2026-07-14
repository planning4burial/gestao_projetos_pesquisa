package estrutura;

public class Reuniao {
	private static int totalReuniao = 0;
	private int id;
	private String dataHora;
	private String local;
	private String pauta;
	
	
	public Reuniao(String dataHora, String local, String pauta) {
		totalReuniao++;
		this.id = totalReuniao;
		this.dataHora = dataHora;
		this.local = local;
		this.pauta = pauta;
	}
	
	public int getid() {
		return id;
	}
	
	


	
	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getPauta() {
		return pauta;
	}

	public void setPauta(String pauta) {
		this.pauta = pauta;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "[Reunião #" + id + "] " + dataHora + " em " + local + " - Pauta: " + pauta;


	}
	
	
	
	

}
