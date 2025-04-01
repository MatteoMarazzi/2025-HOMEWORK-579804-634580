package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class LabirintoTest {
	
	private Stanza stanzaCorrente;
	private Partita partita;
	//private Stanza stanzaIniziale;


	@BeforeEach
	void setUp() throws Exception {
		this.partita = new Partita();
		this.stanzaCorrente = this.partita.getLabirinto().getStanzaVincente(); //notare la stanza corrente è quella vincente

	}

	
	@Test
	void testPARTITA_FINISCE_IN_STANZA_VINCENTE() {
		this.partita.setStanzaCorrente(this.stanzaCorrente);

		assertTrue(this.partita.isFinita());
	}
	
	

}
