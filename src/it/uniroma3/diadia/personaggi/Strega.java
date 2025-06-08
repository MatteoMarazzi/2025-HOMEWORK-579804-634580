package it.uniroma3.diadia.personaggi;

import java.util.Iterator;
import java.util.Map;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {
	private static final String MESSAGGIO_DONO = "Data la tua accortezza e gentilezza,"
			+ " ti porto un passo avanti, verso la salvezza";
	private static final String MESSAGGIO_MALUS = "Non parlo con i maleducati, che i miei poteri"
			+ " vengano scatenati";

	private Stanza stanzaStrega; // qui salvo la stanza in cui spostare il giocatore

	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		Map<String, Stanza> map = partita.getLabirinto().getListaStanze();

		if (this.haSalutato()) {
			// ======== “Dono”: scelgo la stanza con più attrezzi ========
			msg = MESSAGGIO_DONO;

			// inizializzo max a -1, così anche una stanza con 0 attrezzi lo supera
			int max = -1;
			Stanza stanzaConMassimo = null;

			for (Stanza s : map.values()) {
				int numeroAttrezzi = s.getAttrezzi().size();
				if (numeroAttrezzi > max) {
					max = numeroAttrezzi;
					stanzaConMassimo = s;
				}
			}

			this.stanzaStrega = stanzaConMassimo;
		} else {
			// ======== “Malus”: scelgo la stanza con meno attrezzi ========
			msg = MESSAGGIO_MALUS;

			// Per trovare il minimo, prendo prima la prima stanza disponibile
			Iterator<Stanza> iter = map.values().iterator();
			Stanza stanzaConMinimo = iter.next();
			int min = stanzaConMinimo.getAttrezzi().size();

			while (iter.hasNext()) {
				Stanza s = iter.next();
				int numeroAttrezzi = s.getAttrezzi().size();
				if (numeroAttrezzi < min) {
					min = numeroAttrezzi;
					stanzaConMinimo = s;
				}
			}

			this.stanzaStrega = stanzaConMinimo;
		}

		// Imposto la stanza corrente e restituisco il messaggio
		partita.setStanzaCorrente(stanzaStrega);
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if (partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo.getNome())
				&& (partita.getStanzaCorrente().getPersonaggio() != null)) {

			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
		}
		return "AHAHAHAHHAHAHA";
	}
}
