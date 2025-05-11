package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{
	private String direzioneBloccata;
	private String attrezzoNecessario;
	public StanzaBloccata(String nome,Attrezzo attrezzoNecessario,String direzioneBloccata) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoNecessario = attrezzoNecessario.getNome();
	}
	
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
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