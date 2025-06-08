package it.uniroma3.diadia.comandi;
import java.util.Scanner;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
	private IO io;
	 @Override
	public Comando costruisciComando(String istruzione,Partita partita,IO io) {
	 Scanner scannerDiParole = new Scanner(istruzione);
	 this.io = io;
	 String nomeComando = null;
	 String parametro = null;
	 Comando comando = null;

	 if (scannerDiParole.hasNext())
	 nomeComando = scannerDiParole.next();//prima parola: nome del comando
	 if (scannerDiParole.hasNext())
	 parametro = scannerDiParole.next();//seconda parola: eventuale parametro
	 try {
	 String nomeClasse = "it.uniroma3.diadia.comandi.Comando";
	 nomeClasse += Character.toUpperCase(nomeComando.charAt(0));
	 nomeClasse += nomeComando.substring(1);
	 comando = (Comando)Class.forName(nomeClasse).newInstance();
	 comando.setNome(nomeComando);
	 comando.setParametro(parametro);
	 } catch (Exception e) {
	 comando = new ComandoNonValido(io);
	 this.io.mostraMessaggio("Comando inesistente");
	 }
	 return comando;
	}
	}
