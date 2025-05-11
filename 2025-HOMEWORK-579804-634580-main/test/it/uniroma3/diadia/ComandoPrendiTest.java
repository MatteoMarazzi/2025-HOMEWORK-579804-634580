package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Borsa;

class ComandoPrendiTest {
	private Partita partita;
	private Stanza stanza;
	private Attrezzo attrezzo;
	private ComandoPrendi comando;
	private Borsa borsa;
	private IO io;
	@BeforeEach
	public void setUp() {
		this.partita = new Partita();
		this.stanza = new Stanza("Campus One");
		this.attrezzo = new Attrezzo("Lanterna",3);
		this.partita.setStanzaCorrente(stanza);
		this.stanza = this.partita.getStanzaCorrente();
		this.partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
		this.io = new IOConsole();
		this.borsa = this.partita.getGiocatore().getBorsa();

	}
	@Test
	void testPrendiValido() {
		this.comando = new ComandoPrendi(this.io,this.partita,this.attrezzo.getNome());
		comando.esegui(this.partita);
		assertFalse(this.stanza.hasAttrezzo(this.attrezzo.getNome()));
		assertTrue(this.borsa.hasAttrezzo(this.attrezzo.getNome()));
	}
	@Test
	void testPrendiNonValido() {
		Attrezzo attrezzoNonValido = new Attrezzo("osso",2);
		this.comando = new ComandoPrendi(this.io,this.partita,attrezzoNonValido.getNome());
		comando.esegui(this.partita);
		assertFalse(this.borsa.hasAttrezzo(attrezzoNonValido.getNome()));

	}

}
