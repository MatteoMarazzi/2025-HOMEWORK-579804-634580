package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class Cane extends AbstractPersonaggio {
	private static final String MESSAGGIO = "RRRRRRRR WOOF WOOF...";
	private int cfu;
	private Attrezzo ciboPreferito;

	public Cane(String nome, String presentazione, String ciboPreferito) {
		super(nome, presentazione);
		this.ciboPreferito = new Attrezzo(ciboPreferito,1);
	}

	@Override
	public String agisci(Partita partita) {
		Giocatore g = partita.getGiocatore();
		cfu = g.getCfu();
		g.setCfu(cfu - 2);
		partita.setFinita(); // nn so se serve realmente
		return MESSAGGIO;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg = new String();
		if ((attrezzo.getNome() == "ciboPerCani") && (partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo.getNome()))
				&& (partita.getStanzaCorrente().getPersonaggio() != null)) {
			Attrezzo attrezzoRegalo = new Attrezzo("spada", 3);
			partita.getStanzaCorrente().addAttrezzo(attrezzoRegalo);
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
			msg = "Il cane ha lasciato un oggetto nella stanza, bravo cane";
		} else {
			this.agisci(partita);
			msg = "Il cane non ha gradito...";

		}
		return msg;
	}
}
