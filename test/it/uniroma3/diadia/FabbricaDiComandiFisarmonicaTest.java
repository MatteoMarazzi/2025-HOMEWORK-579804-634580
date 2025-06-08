package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;
import it.uniroma3.diadia.giocatore.Borsa;

class FabbricaDiComandiFisarmonicaTest {
//	private Comando comando;
	private IO io;
//	private String parametro;
	private FabbricaDiComandi factory;
	private Partita partita;
	private Stanza stanza;
	private Attrezzo attrezzo;
	private Attrezzo attrezzoBorsa;
	private Borsa borsa;
	private String istruzione;
	private Comando comando;
	private Labirinto labirinto;
	@BeforeEach
	void setUp() throws Exception {
		this.io = new IOConsole();
		this.labirinto = new Labirinto();
		this.partita = new Partita(labirinto);
		this.stanza = new Stanza("Campus One");
		this.attrezzo = new Attrezzo("Lanterna",2);
		this.attrezzoBorsa = new Attrezzo("Spada",3);
		this.stanza.addAttrezzo(attrezzo);
		this.borsa = this.partita.getGiocatore().getBorsa();
		this.borsa.addAttrezzo(attrezzoBorsa);
		this.factory = new FabbricaDiComandiRiflessiva();
	}

	@Test
	void testComandoVai() {
		this.istruzione = "vai nord";
		this.comando = this.factory.costruisciComando(this.istruzione, this.partita, this.io);
		assertEquals("vai",this.comando.getNome());
		assertEquals("nord",this.comando.getParametro());
	}
	
	@Test
	void testComandoNonValido() {
		this.istruzione = "no";
		this.comando = this.factory.costruisciComando(this.istruzione, this.partita, this.io);
		assertEquals(null,this.comando.getNome());
		assertEquals(null,this.comando.getParametro());
	}
	
	@Test
	void testComandoPosa() {
		this.istruzione = "posa Spada";
		this.comando = this.factory.costruisciComando(this.istruzione, this.partita, this.io);
		assertEquals("posa",this.comando.getNome());
		assertEquals("Spada",this.comando.getParametro());
	}
	
	@Test
	void testComandoPrendi() {
		this.istruzione = "prendi Lanterna";
		this.comando = this.factory.costruisciComando(this.istruzione, this.partita, this.io);
		assertEquals("prendi",this.comando.getNome());
		assertEquals("Lanterna",this.comando.getParametro());
	}

	@Test
	void testComandoAiuto() {
		this.istruzione = "aiuto";
		this.comando = this.factory.costruisciComando(this.istruzione, this.partita, this.io);
		assertEquals("aiuto",this.comando.getNome());
		assertEquals(null,this.comando.getParametro());
	}
	
	@Test
	void testComandoFine() {
		this.istruzione = "fine";
		this.comando = this.factory.costruisciComando(this.istruzione, this.partita, this.io);
		assertEquals("fine",this.comando.getNome());
		assertEquals(null,this.comando.getParametro());
	}
	
	@Test
	void testComandoGuarda() {
		this.istruzione = "guarda";
		this.comando = this.factory.costruisciComando(this.istruzione, this.partita, this.io);
		assertEquals("guarda",this.comando.getNome());
		assertEquals(null,this.comando.getParametro());
	}
}
