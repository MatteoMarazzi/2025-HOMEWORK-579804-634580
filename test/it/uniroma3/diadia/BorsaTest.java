package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import  org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class BorsaTest {
	private Giocatore giocatore;
	private Borsa borsa;
	private Attrezzo DieciKili;
	private Attrezzo TreKili;
	private Attrezzo DueKili;
	private Attrezzo TremilaGrammi;
	private Attrezzo Kilo;


	@BeforeEach
	void setUp() throws Exception {
		this.giocatore = new Giocatore();
		this.borsa = this.giocatore.getBorsa();
		this.DueKili = new Attrezzo("2KG",2);
		this.TreKili = new Attrezzo("3KG",3);
		this.TremilaGrammi = new Attrezzo("3MILA_G",3);
		this.DieciKili = new Attrezzo("10KG", 10);
		this.Kilo = new Attrezzo("1KG",1);
}

	/**
	 * Test che verifica l'aumento di peso della borsa
	 *  mettendo un oggetto di peso massimo controlla anche
	 *  se all'inizio è vuota
	 */
	
	@Test
	void testAUMENTO_PESO_BORSA_E_BORSA_VUOTA() {
		//Controllo del metodo isEmpty, borsa generata e vuota
		assertTrue(this.borsa.isEmpty());
		this.borsa.addAttrezzo(this.DieciKili);
		//Controllo di correttezza nel calcolo del peso della borsa (corrisponde a peso oggetto aggiunto
		assertEquals(10,this.borsa.getPeso());
	}
	
	@Test
	void testADD_ATTREZZO_FALLIMENTARE_PER_PESO_LIMITE() {
		this.borsa.addAttrezzo(this.DieciKili);
		Attrezzo attrezzoEccesso = new Attrezzo("Dolce",2);
		//Controllo che se abbiammo una borsa piena e venga aggiunto un altro oggetto ci venga impedito, con restituzione a metodo invocante del valore bolleano False
		assertFalse(this.borsa.addAttrezzo(attrezzoEccesso));
	}
	
	@Test
	void testADD_E_REMOVE_ATTREZZO() {
		//Controllo che la il metodo addAttrezzo aggiunga effetivamente oggetti alla borsa
		assertTrue(this.borsa.addAttrezzo(DieciKili));
		//Controllo che effettivamente il metodo removeAttrezzo rimuova l'attrezzo dalla borsa e lo restituisca a chi l'ha invocato
		assertEquals(this.DieciKili,this.borsa.removeAttrezzo("10KG"));
	}
	
	@Test
	void test_GET_CONTENUTO_ORDINATO_PER_PESO(){
		this.borsa.addAttrezzo(this.TreKili);
		this.borsa.addAttrezzo(this.Kilo);
		this.borsa.addAttrezzo(this.DueKili);
		List<Attrezzo> lista = this.borsa.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> i = lista.iterator();
		assertEquals(this.Kilo,i.next());
		assertEquals(this.DueKili,i.next());
		assertEquals(this.TreKili,i.next());
		}
	
	@Test
	void test_GET_CONTENUTO_ORDINATO_PER_NOME(){
		this.borsa.addAttrezzo(Kilo);
		this.borsa.addAttrezzo(TreKili);
		this.borsa.addAttrezzo(DueKili);
		Set<Attrezzo> set = this.borsa.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> it = set.iterator();
		assertEquals(this.Kilo,it.next());
		assertEquals(this.DueKili,it.next());
		assertEquals(this.TreKili,it.next());
	}
	@Test
	void test_GET_CONTENUTO_RAGGRUPPATO_PER_PESO(){
		this.borsa.addAttrezzo(TreKili);
		this.borsa.addAttrezzo(DueKili);
		this.borsa.addAttrezzo(TremilaGrammi);
		Map<Integer,Set<Attrezzo>> map = this.borsa.getContenutoRaggruppatoPerPeso();
		Set<Attrezzo> s1 = new HashSet<>();	
		s1.add(TreKili);
		s1.add(TremilaGrammi);
		Set<Attrezzo> s2 = new HashSet<>();
		s2.add(DueKili);
		assertEquals(s1,map.get(3));
		assertEquals(s2,map.get(2));

	}
	@Test
	void test_GET_CONTENUTO_ORDINATO_PER_PESO_E_NOME(){
		this.borsa.addAttrezzo(TreKili);
		this.borsa.addAttrezzo(DueKili);
		this.borsa.addAttrezzo(TremilaGrammi);
		SortedSet<Attrezzo> sort = this.borsa.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> it = sort.iterator();
		assertEquals(this.DueKili,it.next());
		assertEquals(this.TreKili,it.next());
		assertEquals(this.TremilaGrammi,it.next());
		
	}

}
