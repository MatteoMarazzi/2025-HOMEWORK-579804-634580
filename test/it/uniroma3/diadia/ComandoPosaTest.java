package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Borsa;

class ComandoPosaTest {
	private Partita partita;
	private Stanza stanza;
	private Attrezzo attrezzo;
	private ComandoPosa comando;
	private Borsa borsa;
	private IO io;
	private Labirinto labirinto;
	@BeforeEach
	public void setUp() {
		this.labirinto = new Labirinto();
		this.partita = new Partita(labirinto);
		this.stanza = new Stanza("Campus One");
		this.attrezzo = new Attrezzo("Lanterna",3);
		this.partita.setStanzaCorrente(stanza);
		this.stanza = this.partita.getStanzaCorrente();
		this.io = new IOConsole();
		this.borsa = this.partita.getGiocatore().getBorsa();
		this.borsa.addAttrezzo(this.attrezzo);

	}
	@Test
	void testPosaValido() {
		this.comando = new ComandoPosa(this.io,this.partita,this.attrezzo.getNome());
		comando.esegui(this.partita);
		assertTrue(this.stanza.hasAttrezzo(this.attrezzo.getNome()));
		assertFalse(this.borsa.hasAttrezzo(this.attrezzo.getNome()));
	}
	@Test
	void testPosaNonValido() {
		Attrezzo attrezzoNonValido = new Attrezzo("osso",2);
		this.comando = new ComandoPosa(this.io,this.partita,attrezzoNonValido.getNome());
		comando.esegui(this.partita);
		assertFalse(this.borsa.hasAttrezzo(attrezzoNonValido.getNome()));
		
	}

}
