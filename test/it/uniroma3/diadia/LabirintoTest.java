package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class LabirintoTest {
	
	private Stanza stanzaCorrente;
	private Partita partita;
	//private Stanza stanzaIniziale;
	private Labirinto labirinto;


	@BeforeEach
	void setUp() throws Exception {
		this.labirinto = new Labirinto();
		this.partita = new Partita(labirinto);
		this.stanzaCorrente = this.partita.getLabirinto().getStanzaVincente(); //notare la stanza corrente è quella vincente

	}

	
	@Test
	void testPARTITA_FINISCE_IN_STANZA_VINCENTE() {
		this.partita.setStanzaCorrente(this.stanzaCorrente);

		assertTrue(this.partita.isFinita());
	}

}
