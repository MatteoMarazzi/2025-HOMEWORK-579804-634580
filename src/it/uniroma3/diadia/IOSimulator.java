package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulatore di I/O per test: permette di iniettare righe di input
 * e di catturare i messaggi stampati.
 */
public class IOSimulator implements IO {

    private String[] righePreimpostate;   // input da restituire su leggiRiga()
    private int indiceLettura;             // posizione corrente nell'array di input
    private List<String> messaggiStampati; // messaggi catturati da mostraMessaggio()

    /**
     * Costruisce un simulatore con l'array di righe di input da restituire.
     * @param righePreimpostate righe da restituire in sequenza a ogni invocazione di leggiRiga()
     */
    public IOSimulator(String[] righePreimpostate) {
        this.righePreimpostate = righePreimpostate != null ? righePreimpostate : new String[0];
        this.indiceLettura = 0;
        this.messaggiStampati = new ArrayList<>();
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        // conserva il messaggio nella lista per eventuali asserzioni
        messaggiStampati.add(messaggio);
    }

    @Override
    public String leggiRiga() {
        // restituisce la riga successiva o null se non ci sono più input
        if (indiceLettura < righePreimpostate.length) {
            String riga = righePreimpostate[indiceLettura];
            indiceLettura++;
            return riga;
        }
        return null;
    }

    /**
     * Ritorna tutti i messaggi stampati finora.
     * @return lista dei messaggi passati a mostraMessaggio()
     */
    public List<String> getMessaggiStampati() {
        return new ArrayList<>(messaggiStampati);
    }

    /**
     * Resetta il simulatore: azzera indice di lettura e lista dei messaggi.
     */
    public void reset() {
        this.indiceLettura = 0;
        this.messaggiStampati.clear();
    }
}
