package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, "
			+ "con una mia magica azione, troverai un nuovo oggetto " + "per il tuo borsone!";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	private Attrezzo attrezzo;

	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		if (this.attrezzo != null) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		} else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo.getNome())
				&& (partita.getStanzaCorrente().getPersonaggio() != null)) {
			int peso = attrezzo.getPeso();
			String nome = attrezzo.getNome();
			Attrezzo attrezzoPesoDimezzato = new Attrezzo(nome, peso/2);
			partita.getStanzaCorrente().addAttrezzo(attrezzoPesoDimezzato);
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
		}
	
		return "E' caduto un attrezzo nella stanza, penso tu lo conosca, ma ho voluto aiutarti con il suo peso";
	}
}
