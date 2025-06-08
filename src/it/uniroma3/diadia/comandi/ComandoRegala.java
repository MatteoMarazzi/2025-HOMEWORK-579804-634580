package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala implements Comando{
	private Attrezzo attrezzo;
	private String nome;
	private Partita partita;
	private AbstractPersonaggio personaggio;
	private Giocatore giocatore;
	private IO io;
	public ComandoRegala(IO io,Partita partita,Attrezzo attrezzo) {
		this.io = io;
		this.partita = partita;
		this.attrezzo = attrezzo;
		this.personaggio = partita.getStanzaCorrente().getPersonaggio();
		this.giocatore = this.partita.getGiocatore();

	}
	@Override
	public void esegui(Partita partita) {
		if((this.personaggio != null) && (!this.giocatore.getBorsa().hasAttrezzo(this.attrezzo.getNome()))) {
			this.personaggio.riceviRegalo(attrezzo, partita);
		}else {
			this.io.mostraMessaggio("Non è possibile regalare " + this.attrezzo.getNome());
		}
	}

	public void setParametro(Attrezzo parametro) {
		this.attrezzo = parametro;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public void setNome(String nomeComando) {
		this.nome = nomeComando;
	}

	@Override
	public String getParametro() {
		return this.attrezzo.getNome();
	}

	@Override
	public void setParametro(String parametro) {
	}

}
