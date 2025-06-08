package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;

//import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author docente di POO (da un'idea di Michael Kolling and David J. Barnes)
 * 
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""
			+ "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
			+ "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
			+ "I locali sono popolati da strani personaggi, " + "alcuni amici, altri... chissa!\n"
			+ "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
			+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
			+ "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
			+ "Per conoscere le istruzioni usa il comando 'aiuto'.";

	private Partita partita;
	private IO io;

	public DiaDia(Labirinto labirinto, IO io) {

		this.partita = new Partita(labirinto);
		this.io = io;
	}

	public void gioca() {
		String istruzione;
		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));

	}

	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiRiflessiva(); // riflessiva o fisarmonica?
		comandoDaEseguire = factory.costruisciComando(istruzione, this.partita, this.io);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			this.io.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			this.io.mostraMessaggio("Hai esaurito i CFU...");
		return this.partita.isFinita();
	}

	public static void main(String[] argc) {
		/*
		 * N.B. unica istanza di IOConsole di cui sia ammessa la creazione
		 */
		IO io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder().addStanzaIniziale("LabCampusOne").addStanzaVincente("Biblioteca")
				.addAdiacenza("LabCampusOne", "Biblioteca", Direzione.OVEST).getLabirinto();
		DiaDia gioco = new DiaDia(labirinto, io);
		gioco.gioca();
	}
}