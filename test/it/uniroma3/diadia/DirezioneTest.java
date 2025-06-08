package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.Direzione.EST;
import it.uniroma3.diadia.Direzione.NORD;
import it.uniroma3.diadia.Direzione.OVEST;
import it.uniroma3.diadia.Direzione.SUD;

public class DirezioneTest {
	@Test
	public void testOrdinal() {
		assertEquals(0, NORD.getOrdinal());
		assertEquals(1, EST.getOrdinal());
		assertEquals(2, SUD.getOrdinal());
		assertEquals(3, OVEST.getOrdinal());
	}
//	@Test
//	 public void testTuttiSingleton() {
//	 assertSame(NORD, Direzione.valueOf("NORD"));
//	 final Direzione singleton = Direzione.valueOf("NORD");
//	 assertSame(singleton, NORD);
//	 assertNotSame(EST, NORD);
//	}
//	@Test
//	 public void testCompareTo() {
//	 assertTrue(NORD.compareTo(EST)<0);
//	 assertTrue(EST.compareTo(SUD)<0);
//	 assertTrue(SUD.compareTo(OVEST)<0);
//	 assertTrue(OVEST.compareTo(NORD)>0);
//	 } 
}