package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.personaggi.Mago;

public class MagoTest {
    
    private Partita partita;
    private Mago magoSenzaAttrezzo;

    @BeforeEach
    public void setUp() {
        // Il Mago sarà creato con attrezzo null
        this.magoSenzaAttrezzo = new Mago("Fumo", "Fantasma invisibile", null);
        
        // Creo un nuovo Labirinto (anche se di default popolerà stanze, non ci interessa)
        Labirinto labirinto = new Labirinto();
        
        // Creo una Partita a partire da quel Labirinto
        this.partita = new Partita(labirinto);
    }
    
    @Test
    public void testAgisciScuseDiretto_conStanzaVuota() {
        // 1) Creo una Stanza vuota e la imposto come corrente
        Stanza stanzaVuota = new Stanza("vuota");         // nessun attrezzo al suo interno
        partita.setStanzaCorrente(stanzaVuota);
        
        // Controllo preliminare: la stanza deve essere effettivamente vuota
        assertTrue(stanzaVuota.getAttrezzi().isEmpty(),
                   "La nuova stanza vuota (creata manualmente) non deve contenere alcun attrezzo iniziale.");
        
        // 2) Chiamo agisci() sul mago che non ha attrezzi da donare
        String risultato = magoSenzaAttrezzo.agisci(partita);
        String messaggioScuse = "Mi spiace, ma non ho piu' nulla...";
        assertEquals(messaggioScuse, risultato,
                     "Se il Mago viene creato con attrezzo null, agisci() deve restituire subito il messaggio di SCUSE.");
        
        // 3) Verifico che la stanza rimanga ancora vuota dopo agisci()
        assertTrue(stanzaVuota.getAttrezzi().isEmpty(),
                   "Con attrezzo inizialmente null, agisci() non deve aggiungere nulla alla stanza corrente.");
    }
    
    @Test
    public void testAgisciDonoPoiScuse_suStanzaVuota() {
        // In questo test voglio verificare anche che:
        // – se al mago do un attrezzo “A”, la prima chiamata a agisci() lo piazza in stanza
        // – la seconda chiamata a agisci() (quando attrezzo è già stato consumato) non aggiunga più nulla
        
        // 1) Creo una Stanza vuota e la imposto come corrente
        Stanza stanzaVuota = new Stanza("vuota");
        partita.setStanzaCorrente(stanzaVuota);
        
        // 2) Creo un nuovo attrezzo “Pozione” e un nuovo mago che la possiede
        it.uniroma3.diadia.attrezzi.Attrezzo pozione = new it.uniroma3.diadia.attrezzi.Attrezzo("Pozione", 1);
        Mago magoConPozione = new Mago("Merlino", "Vecchio e saggio", pozione);
        
        // Controllo di partenza: in stanza non deve esserci “Pozione”
        assertFalse(stanzaVuota.hasAttrezzo("Pozione"),
                    "Prima di agire, la stanza non deve contenere l'attrezzo ‘Pozione’.");

        // 3) Chiamo per la prima volta agisci(): il mago dona “Pozione”
        String messaggioDono = "Sei un vero simpaticone, con una mia magica azione, troverai un nuovo oggetto per il tuo borsone!";
        String risultatoDono = magoConPozione.agisci(partita);
        assertEquals(messaggioDono, risultatoDono,
                     "Il primo agisci() di un Mago con attrezzo deve restituire il messaggio di DONO.");

        // Ora la stanza deve contenere “Pozione”
        assertTrue(stanzaVuota.hasAttrezzo("Pozione"),
                   "Dopo il DONO, la stanza deve contenere l'attrezzo ‘Pozione’.");

        // 4) Chiamo di nuovo agisci(): stavolta il mago non ha più niente
        String risultatoScuse = magoConPozione.agisci(partita);
        String messaggioScuse = "Mi spiace, ma non ho piu' nulla...";
        assertEquals(messaggioScuse, risultatoScuse,
                     "Il secondo agisci() di un Mago (dopo aver già donato) deve restituire il messaggio di SCUSE.");

        // 5) Verifico che non sia stata aggiunta una seconda “Pozione”
        long countPozione = stanzaVuota.getAttrezzi().stream()
                                 .filter(a -> a.getNome().equals("Pozione"))
                                 .count();
        assertEquals(1, countPozione,
                     "Dopo il primo DONO, anche chiamando agisci() di nuovo, non deve apparire una seconda ‘Pozione’.");
    }
}
