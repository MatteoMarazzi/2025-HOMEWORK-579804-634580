package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando {
	private static final String SALUTO =
			"Giocatore: Ciao!";
	private AbstractPersonaggio personaggio;


	@Override
	public void esegui(Partita partita) {
		this.personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (this.personaggio!=null) {
			io.mostraMessaggio(SALUTO);
			this.personaggio.saluta();
		} else 
			io.mostraMessaggio(SALUTO);
			this.personaggio.saluta();
	}
}