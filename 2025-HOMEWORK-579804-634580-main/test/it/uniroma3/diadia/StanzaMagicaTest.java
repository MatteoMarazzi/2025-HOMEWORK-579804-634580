package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class StanzaMagicaTest {
	private Giocatore giocatore;
	private Borsa borsa;
	private Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() throws Exception {
		this.giocatore = new Giocatore();
		this.borsa = this.giocatore.getBorsa();
		this.attrezzo = new Attrezzo("Lanterna",2);
		this.borsa.addAttrezzo(this.attrezzo);
	}

	@Test
	void testStanzaMagicaSottoSoglia() {
		Stanza stanzaMagica = new StanzaMagica("Campus One",2);
		stanzaMagica.addAttrezzo(this.attrezzo);
		assertTrue(stanzaMagica.hasAttrezzo("Lanterna"));
	}
	@Test
	void testStanzaMagicaSopraSoglia() {
		Stanza stanzaMagica = new StanzaMagica("Campus One",0);
		stanzaMagica.addAttrezzo(this.attrezzo);
		assertTrue(stanzaMagica.hasAttrezzo("anretnaL"));
	}

}
