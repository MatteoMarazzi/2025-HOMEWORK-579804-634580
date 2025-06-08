package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class TestStanzaBloccata {

	private Stanza stanza; 
	private Attrezzo attrezzoNecessario;
	private String messaggio;
	private String direzioneBloccata;

	@BeforeEach
	void setUp() throws Exception {
		this.attrezzoNecessario = new Attrezzo("Chiave",2);
		this.direzioneBloccata = "nord";
		this.stanza = new StanzaBloccata("Campus One",attrezzoNecessario.getNome(),this.direzioneBloccata);
	}

	@Test
	void testStanzaSenzaAttrezzoNecessario() {
		assertEquals(this.stanza,this.stanza.getStanzaAdiacente(this.direzioneBloccata));
	}
	@Test
	void testStanzaConAttrezzoNecessario() {
		this.stanza.addAttrezzo(this.attrezzoNecessario);
		Stanza stanzaAdiacente = new Stanza("Atrio");
		this.stanza.impostaStanzaAdiacente(direzioneBloccata, stanzaAdiacente);
		assertEquals(stanzaAdiacente,this.stanza.getStanzaAdiacente(this.direzioneBloccata));
	}

}
