package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Direzione;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {
private Direzione direzione;
public ComandoVai(IO io,Direzione direzione) {
 this.direzione = direzione;
 this.io = io;
}
/**
 * esecuzione del comando
 */
@Override
public void esegui(Partita partita) {
    Stanza stanzaCorrente = partita.getStanzaCorrente();
    Stanza prossimaStanza = null;
    if (direzione == null) {
    	this.io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
    	return;
    }
    prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
    if (prossimaStanza == null) {
    	this.io.mostraMessaggio("Direzione inesistente");
    	return;
    }

    partita.setStanzaCorrente(prossimaStanza);
    this.io.mostraMessaggio(partita.getStanzaCorrente().getNome());
    partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
}


}