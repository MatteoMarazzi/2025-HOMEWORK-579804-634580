package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	static final private String MEX_DEFAULT = "Qui c'è buio pesto";
	private Stanza stanza; 
	private Attrezzo attrezzoNecessario;

	@BeforeEach
	void setUp() throws Exception {
		this.attrezzoNecessario = new Attrezzo("Lanterna",2);
		this.stanza = new StanzaBuia("Campus One",attrezzoNecessario.getNome());
	}

	@Test
	void testStanzaSenzaAttrezzoNecessario() {
		assertEquals(MEX_DEFAULT,stanza.getDescrizione());
	}
	@Test
	void testStanzaConAttrezzoNecessario() {
		this.stanza.addAttrezzo(this.attrezzoNecessario);
		String messaggio = this.stanza.toString();
		assertEquals(messaggio,stanza.getDescrizione());
	}

}
