package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.Direzione;

public class StanzaBloccata extends Stanza{
	private Direzione direzioneBloccata;
	private String attrezzoNecessario;
	public StanzaBloccata(String nome,Direzione dir,String attrezzoNecessario) {
		super(nome);
		this.direzioneBloccata = dir;
		this.attrezzoNecessario = attrezzoNecessario;
	}
	
	
	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if((!this.hasAttrezzo(attrezzoNecessario)) && direzione.equals(direzioneBloccata)) {
			return this;
		}
			return super.getStanzaAdiacente(direzione);
	}
	
	
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(this.attrezzoNecessario)) {
			return "Stanza bloccata nella direzione: "+ direzioneBloccata+"\nPrendi il " + attrezzoNecessario + " e posalo nella stanza\n";
		}
		return  super.getDescrizione();
	}
}