package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
 

//classe generata e scritta solo per fare i test
public class FakePersonaggio extends AbstractPersonaggio {
	public FakePersonaggio(String nome, String presentazione) {
		super(nome, presentazione);
	}
	@Override
	public String agisci(Partita partita) {
		return "done";
	}
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		// TODO Auto-generated method stub
		return null;
	}
}
