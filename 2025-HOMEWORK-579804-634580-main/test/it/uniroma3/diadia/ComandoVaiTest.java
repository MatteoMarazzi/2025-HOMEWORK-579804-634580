package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.ComandoVai;


class ComandoVaiTest {
	String direzione = "nord";
	IO io = new IOConsole();
	ComandoVai c = new ComandoVai(io,direzione);
	@BeforeEach
	void setUp() throws Exception {
	}
	@Test
	void testSetParametro() {		
	}
}
