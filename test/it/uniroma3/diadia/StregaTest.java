package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.personaggi.Strega;

public class StregaTest {
    private Strega strega;
    private Partita partita;
    private Labirinto labirinto;
    private Map<String, Stanza> map;

    @BeforeEach
    public void setUp() throws Exception {
        this.strega = new Strega("Susy", "Susy, piacere");
        this.labirinto = new Labirinto();
        this.partita = new Partita(labirinto);
        this.map = partita.getLabirinto().getListaStanze();
    }

    @Test
    public void testNonHaSalutato() {
        // NON chiamo strega.saluta(): haSalutato() resta false

    	  strega.saluta();

          // 2. Chiamo agisci per spostare la stanza corrente
          strega.agisci(partita);

          // 3. Calcolo quale stanza ha il numero massimo di attrezzi
          Stanza stanzaPeggiore = null;
          int maxAttrezzi = -1;
          for (Stanza s : this.map.values()) {
              int n = s.getAttrezzi().size();
              if (n > maxAttrezzi) {
                  maxAttrezzi = n;
                  stanzaPeggiore = s;
              }
          }
        // 3. Verifico che la stanza corrente sia proprio quella con meno attrezzi
        assertEquals(stanzaPeggiore, partita.getStanzaCorrente());
    }

    @Test
    public void testHaSalutato() {
        // 1. La Strega saluta
        strega.saluta();

        // 2. Chiamo agisci per spostare la stanza corrente
        strega.agisci(partita);

        // 3. Calcolo quale stanza ha il numero massimo di attrezzi
        Stanza stanzaMigliore = null;
        int maxAttrezzi = -1;
        for (Stanza s : this.map.values()) {
            int n = s.getAttrezzi().size();
            if (n > maxAttrezzi) {
                maxAttrezzi = n;
                stanzaMigliore = s;
            }
        }

        // 4. Controllo che la stanza corrente sia proprio quella con più attrezzi
        assertEquals(stanzaMigliore, partita.getStanzaCorrente());
    }

}
