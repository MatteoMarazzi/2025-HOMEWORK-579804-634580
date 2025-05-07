package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza{
	static final private String MEX_DEFAULT = "Qui c'è buio pesto";
	private String attrezzoNecessario;
	public StanzaBuia(String nome,Attrezzo attrezzoNecessario) {
		super(nome);
		this.attrezzoNecessario = attrezzoNecessario.getNome();
	}
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(this.attrezzoNecessario)) {
			return MEX_DEFAULT;
		}else {
			return super.toString();

		}
	}
}
