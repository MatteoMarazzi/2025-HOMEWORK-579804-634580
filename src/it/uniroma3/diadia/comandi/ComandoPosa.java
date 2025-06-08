package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando {
	private Partita partita;
	private String attrezzo;
	public ComandoPosa(IO io,Partita partita,String attrezzo) {
		this.io = io;
		this.partita = partita;
		this.attrezzo = attrezzo;
	}
	@Override
	public void esegui(Partita partita) {
		if(!this.partita.getGiocatore().getBorsa().hasAttrezzo(this.attrezzo)) {
			this.io.mostraMessaggio("Nella tua borsa non è presente questo attrezzo");
		} else {
			Attrezzo attrezzoDaPosare = this.partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
			if(!this.partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare)) { //se è neg non l'ha messa, se invece non stampa è perchè è stata fatta l'azione.
				this.io.mostraMessaggio("Stanza piena");
			} else {
				this.io.mostraMessaggio("Hai posato : " + attrezzoDaPosare.getNome());
			}
		}

	}

}



