package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	private Giocatore giocatore;
	private Partita partita;
	private Labirinto labirinto;
	
	@BeforeEach
	void setUp() throws Exception {
		this.labirinto = new Labirinto();
		this.partita = new Partita(labirinto);
		this.giocatore = new Giocatore();
	}

	@Test
	void testsetCFU() {
		this.giocatore.setCfu(5);
		assertEquals(5,giocatore.getCfu());
		
	}
	
	@Test
	void testgetCFU() {
		this.giocatore.setCfu(5);
		assertEquals(5,giocatore.getCfu());
		
	}
	@Test
	void testPartitaFINITA() {
		this.partita.getGiocatore().setCfu(0);
	assertEquals(true,this.partita.isFinita());
	}
	
}
