package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public abstract class AbstractComando implements Comando {
	private String nome;
	private String parametro;
	protected IO io;
	/**
	 * esecuzione del comando
	 */
	public void esegui(Partita partita) {
		
	}
	/**
	 * set parametro del comando
	 */

	public void setParametro(String parametro) {
		this.parametro = parametro;;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
	
	public String getParametro() {
		return this.parametro;

	}
}
