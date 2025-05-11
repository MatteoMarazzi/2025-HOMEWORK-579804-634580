package it.uniroma3.diadia;


//import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";


	private Partita partita;
	private IO io;

	public DiaDia(IO io) {
		this.partita = new Partita();
		this.io = io;
	}

	public void gioca() {
		String istruzione; 
		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));

	}  


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	//	private boolean processaIstruzione(String istruzione) {
	//		Comando1 comandoDaEseguire = new Comando1(istruzione);
	//
	//		if (comandoDaEseguire.getNome().equals("fine")) {
	//			this.fine(); 
	//			return true;
	//		} else if (comandoDaEseguire.getNome().equals("vai"))
	//			this.vai(comandoDaEseguire.getParametro());
	//		else if (comandoDaEseguire.getNome().equals("aiuto"))
	//			this.aiuto();
	//		else if (comandoDaEseguire.getNome().equals("prendi"))
	//			prendi(comandoDaEseguire.getParametro());
	//		else if (comandoDaEseguire.getNome().equals("posa"))
	//			posa(comandoDaEseguire.getParametro());
	//		else
	//			this.console.mostraMessaggio("comando sconosciuto");
	//
	//
	//		if(this.partita.isFinita()) {
	//			if (this.partita.vinta()) {
	//				this.console.mostraMessaggio("Hai vinto!");
	//			} else {
	//				this.console.mostraMessaggio("Hai perso!");
	//
	//			}
	//			return true;
	//		}
	//		return false;
	//	}
	//

	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione,this.partita,this.io);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			this.io.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			this.io.mostraMessaggio("Hai esaurito i CFU...");
		return this.partita.isFinita();
	}


	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	//	private void aiuto() {
	//
	//	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
//	private void vai(String direzione) {
//		if(direzione==null)
//			this.io.mostraMessaggio("Dove vuoi andare ?");
//		Stanza prossimaStanza = null;
//		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
//		if (prossimaStanza == null)
//
//			this.io.mostraMessaggio("Direzione inesistente");
//		else {
//			this.partita.setStanzaCorrente(prossimaStanza);
//			int cfu = this.partita.getGiocatore().getCfu();
//			this.partita.getGiocatore().setCfu(--cfu);              //semantica --valore
//		}
//		this.io.mostraMessaggio(this.partita.toString()); //chiama il toString solo senza chiamarlo a mano
//	}

	/**
	 * Comando "prendi".
	 */

	//	public boolean prendi(String attrezzo) {
	//		if(!this.partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
	//			this.console.mostraMessaggio("Attrezzo non trovato");
	//			this.console.mostraMessaggio(this.partita.toString()); //chiama il toString solo senza chiamarlo a mano
	//			return false;
	//		} else {
	//			Attrezzo attrezzoDaPrendere = this.partita.getStanzaCorrente().getAttrezzo(attrezzo);
	//			this.partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
	//			if(!this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere)) { //se è neg non l'ha messa, se invece non stampa è perchè è stata fatta l'azione.
	//				this.console.mostraMessaggio("Borsa piena o peso max");
	//				this.console.mostraMessaggio(this.partita.toString()); //chiama il toString solo senza chiamarlo a mano
	//				return false;
	//			} else {
	//				this.console.mostraMessaggio("Hai preso : " + attrezzoDaPrendere.getNome());
	//				this.console.mostraMessaggio(this.partita.toString()); //chiama il toString solo senza chiamarlo a mano
	//				return true;
	//
	//			}
	//		}
	//
	//
	//	}

	/**
	 * Comando "posa".
	 */

	//	public boolean posa(String attrezzo) {
	//		if(!this.partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
	//			this.console.mostraMessaggio("Nella tua borsa non è presente questo attrezzo");
	//			return false;
	//		} else {
	//			Attrezzo attrezzoDaPosare = this.partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
	//			if(!this.partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare)) { //se è neg non l'ha messa, se invece non stampa è perchè è stata fatta l'azione.
	//				this.console.mostraMessaggio("Stanza piena");
	//				return false;
	//			} else {
	//				this.console.mostraMessaggio("Hai posato : " + attrezzoDaPosare.getNome());
	//				return true;
	//			}
	//		}
	//
	//
	//	}

	/**
	 * Comando "Fine".
	 */
	//	private void fine() {
	//	}
	//	

	public static void main(String[] argc) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}