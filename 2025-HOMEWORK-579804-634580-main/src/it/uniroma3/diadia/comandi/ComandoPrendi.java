package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private IO io;
	private Partita partita;
	private String attrezzo;
	public ComandoPrendi(IO io,Partita partita,String attrezzo) {
		this.io = io;
		this.partita = partita;
		this.attrezzo = attrezzo;
	}
	@Override
	public void esegui(Partita partita) {
		if(!this.partita.getStanzaCorrente().hasAttrezzo(this.attrezzo)) {
			this.io.mostraMessaggio("Attrezzo non trovato");
			this.io.mostraMessaggio(this.partita.toString()); //chiama il toString solo senza chiamarlo a mano
		} else {
			Attrezzo attrezzoDaPrendere = this.partita.getStanzaCorrente().getAttrezzo(attrezzo);
			this.partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
			if(!this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere)) { //se è neg non l'ha messa, se invece non stampa è perchè è stata fatta l'azione.
				this.io.mostraMessaggio("Borsa piena o peso max");
				this.io.mostraMessaggio(this.partita.toString()); //chiama il toString solo senza chiamarlo a mano
			} else {
				this.io.mostraMessaggio("Hai preso : " + attrezzoDaPrendere.getNome());
				this.io.mostraMessaggio(this.partita.toString()); //chiama il toString solo senza chiamarlo a mano

			}
		}

	}

	@Override
	public void setParametro(String parametro) {
		
	}
	@Override
	public String getNome() {
		return "prendi";
	}
	@Override
	public String getParametro() {
		return this.attrezzo;
	}
}
