package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.personaggi.Cane;


public class CaneTest {
	private Cane cane;
	private Partita partita;
	private Labirinto labirinto;
	
	@BeforeEach
	public void setUp() throws Exception {
	this.cane = new Cane("Fidus","So fidus,piacere");
	this.labirinto = new Labirinto();
	this.partita = new Partita(labirinto);
	}

	
	@Test
	public void test() {
		int cfu = this.partita.getGiocatore().getCfu();
		this.cane.agisci(this.partita);
		assertEquals(cfu- 2, this.partita.getGiocatore().getCfu());
	}

}
