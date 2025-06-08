package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public interface FabbricaDiComandi {
	 public Comando costruisciComando(String istruzione,Partita partita,IO io);
	}
