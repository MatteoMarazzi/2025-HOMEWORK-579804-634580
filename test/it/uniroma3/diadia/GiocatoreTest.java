package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	private Giocatore giocatore;
	private Partita partita;
	
	@BeforeEach
	void setUp() throws Exception {
		this.partita = new Partita();
		this.giocatore = new Giocatore();
	}

	@Test
	void testCFU() {
		this.giocatore.setCfu(5);
		assertEquals(5,giocatore.getCfu());
		
	}
	@Test
	void testPartitaFINITA() {
		this.partita.getGiocatore().setCfu(0);
	assertEquals(true,this.partita.isFinita());
	}
	
}
