package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class BorsaTest {
	private Giocatore giocatore;
	private Borsa borsa;

	@BeforeEach
	void setUp() throws Exception {
		this.giocatore = new Giocatore();
		this.borsa = this.giocatore.getBorsa();
	}

	/**
	 * Test che verifica l'aumento di peso della borsa
	 *  mettendo un oggetto di peso massimo controlla anche
	 *  se all'inizio è vuota
	 */
	
	@Test
	void testAUMENTO_PESO_BORSA_E_BORSA_VUOTA() {
		Attrezzo DieciKili = new Attrezzo("10KG", 10);
		//Controllo del metodo isEmpty, borsa generata e vuota
		assertTrue(this.borsa.isEmpty());
		this.borsa.addAttrezzo(DieciKili);
		//Controllo di correttezza nel calcolo del peso della borsa (corrisponde a peso oggetto aggiunto
		assertEquals(10,this.borsa.getPeso());
	}
	
	@Test
	void testADD_ATTREZZO_FALLIMENTARE_PER_PESO_LIMITE() {
		Attrezzo DieciKili = new Attrezzo("10KG", 10);
		this.borsa.addAttrezzo(DieciKili);
		Attrezzo attrezzoEccesso = new Attrezzo("Dolce",2);
		//Controllo che se abbiammo una borsa piena e venga aggiunto un altro oggetto ci venga impedito, con restituzione a metodo invocante del valore bolleano False
		assertFalse(this.borsa.addAttrezzo(attrezzoEccesso));
	}
	
	@Test
	void testADD_E_REMOVE_ATTREZZO() {
		Attrezzo DieciKili = new Attrezzo("10KG", 10);
		//Controllo che la il metodo addAttrezzo ggiunga effetivamente oggetti alla borsa
		assertTrue(this.borsa.addAttrezzo(DieciKili));
		//Controllo che effettivamente il metodo removeAttrezzo rimuova l'attrezzo dalla borsa e lo restituisca a chi l'ha invocato
		assertEquals(DieciKili,this.borsa.removeAttrezzo("10KG"));
	}
	
	

}
