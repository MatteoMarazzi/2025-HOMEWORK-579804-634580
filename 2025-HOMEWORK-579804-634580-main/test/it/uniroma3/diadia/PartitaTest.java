package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {

	private Partita partita;
	private Stanza vincente;

	@BeforeEach
	void setUp() throws Exception {
		this.partita = new Partita();
		this.vincente=new Stanza("biblioteca");
		}

	@Test
	void testNuovaPartitaNON_FINITA() {
		assertFalse(this.partita.isFinita());
	}
	@Test
	void testNuovaPartitaNON_FINITA_E_POI_FINITA() {
		assertFalse(this.partita.isFinita());
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	@Test
	void testPartitaVINTA() {
		this.partita.setStanzaCorrente(partita.getLabirinto().getStanzaVincente()); 
		assertTrue(this.partita.vinta());
	}


}
