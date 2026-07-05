package estrutura;

import java.time.LocalDate;
public class Evento {
	private int idEvento;
	private String descricao;
	private LocalDate prazoFinal;
	
	public Evento(int idEvento, String descricao, String prazoTexto) {
		this.idEvento = idEvento;
		this.descricao = descricao;
		this.prazoFinal = LocalDate.parse(prazoTexto);
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getPrazoFinal() {
		return prazoFinal;
	}

	public void setPrazoFinal(LocalDate prazoFinal) {
		this.prazoFinal = prazoFinal;
	}
}
