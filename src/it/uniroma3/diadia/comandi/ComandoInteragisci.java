package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando {
	private static final String MESSAGGIO_CON_CHI =
			"Con chi dovrei interagire?...";
	private String messaggio;
	private AbstractPersonaggio personaggio;


	@Override
	public void esegui(Partita partita) {
		this.personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (this.personaggio!=null) {
			this.messaggio = this.personaggio.agisci(partita);
			io.mostraMessaggio(this.messaggio);
		} else io.mostraMessaggio(MESSAGGIO_CON_CHI);
	}

}