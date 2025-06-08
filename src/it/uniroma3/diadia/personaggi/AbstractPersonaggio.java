package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {
	private String nome;
	private String descrizione;
	private boolean haSalutato;
	public AbstractPersonaggio(String nome, String presentazione) {
		this.nome = nome;
		this.descrizione = presentazione;
		this.haSalutato = false;
	}

	public abstract String riceviRegalo(Attrezzo attrezzo, Partita partita);

	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return this.descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public boolean haSalutato() {
		return this.haSalutato;
	}
	public String saluta() {
		StringBuilder risposta =
				new StringBuilder("Ciao, io sono ");
		risposta.append(this.nome+".");
		if (!haSalutato)
			risposta.append(this.descrizione);
		else
			risposta.append("Ci siamo gia' presentati!");
		this.haSalutato = true;
		return risposta.toString();
	}
	abstract public String agisci(Partita partita);
	
	@Override
	public String toString() {
		return this.nome;
	}

}
