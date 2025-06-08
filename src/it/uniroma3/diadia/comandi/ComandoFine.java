package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {
	public ComandoFine(IO io) {
		this.io = new IOConsole();
	}
	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

}
