package it.uniroma3.diadia;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {

	private ComandoVai comando;
	private Partita partita;
	private Stanza stanzaIniziale;
	private Stanza stanzaNord;
	private IO io;
	private Labirinto labirinto;

	@Before
	public void setUp() {
		this.partita = new Partita(labirinto);
		this.stanzaIniziale = new Stanza("Atrio");
		this.stanzaNord = new Stanza("Campus One");
		this.io = new IOConsole();
		this.stanzaIniziale.impostaStanzaAdiacente("nord", stanzaNord);
		this.partita.setStanzaCorrente(stanzaIniziale);
	}

	@Test
	public void testVaiDirezioneValida() {
		this.comando = new ComandoVai(this.io, "nord");
		int cfuIniziali = partita.getGiocatore().getCfu();
		
		comando.esegui(partita);
		
		assertEquals("Campus One", partita.getStanzaCorrente().getNome());
		assertEquals(cfuIniziali - 1, partita.getGiocatore().getCfu());
	}

	@Test
	public void testVaiDirezioneNonValida() {
		this.comando = new ComandoVai(new IOConsole(), "sud");
		int cfuIniziali = partita.getGiocatore().getCfu();
		
		comando.esegui(partita);
		
		// Rimane nella stanza iniziale
		assertEquals("Atrio", partita.getStanzaCorrente().getNome());
		assertEquals(cfuIniziali, partita.getGiocatore().getCfu());
	}

	@Test
	public void testVaiDirezioneNull() {
		this.comando = new ComandoVai(this.io, null);
		int cfuIniziali = partita.getGiocatore().getCfu();
		
		comando.esegui(partita);
		
		// Non dovrebbe cambiare stanza
		assertEquals("Atrio", partita.getStanzaCorrente().getNome());
		assertEquals(cfuIniziali, partita.getGiocatore().getCfu()); // anche qui c'è il decremento
	}
}
