package it.uniroma3.diadia.comandi;
import java.util.Scanner;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
	@Override
	public Comando costruisciComando(String istruzione,Partita partita,IO io) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // seconda parola: eventuale parametro
		if (nomeComando == null)
			comando = new ComandoNonValido(io);
		else if (nomeComando.equals("vai"))
			comando = new ComandoVai(io,parametro);
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi(io,partita,parametro);
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa(io,partita,parametro);
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto(io);
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine(io);
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda(io,partita);
		else comando = new ComandoNonValido(io);
		comando.setParametro(parametro);
		return comando;
	}
}