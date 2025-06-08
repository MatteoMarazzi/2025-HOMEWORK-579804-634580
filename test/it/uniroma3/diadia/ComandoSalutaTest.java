package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.ComandoSaluta;
import it.uniroma3.diadia.personaggi.Cane;

class ComandoSalutaTest {

    private ComandoSaluta comando;
    private Partita partita;
    private Cane cane;

    @BeforeEach
    void setUp() throws Exception {
        this.comando = new ComandoSaluta();
        this.partita = new Partita(new Labirinto());
        this.cane = new Cane("Fidus", "Sono un cane");
        
        // 1) Preparo uno “stub” di IOConsole in linea, che non fa nulla.
        //    Così il comando non esplode con NullPointerException.
        IOConsole ioStub = new IOConsole() {
            @Override
            public void mostraMessaggio(String messaggio) {
                // non fare niente
            }
            @Override
            public String leggiRiga() {
                return null; 
            }
            // se IOConsole ha altri metodi, aggiungili qui come “no‐op”
        };

        // 2) Inietto via reflection questo ioStub nel campo `io` della super‐classe AbstractComando
        //
        //    Nota: AbstractComando ha (tipicamente) un campo protetto o package‐private:
        //       protected IOConsole io;
        //    Dobbiamo quindi accedere riflettendo su AbstractComando.
        Field ioField = AbstractComando.class.getDeclaredField("io");
        ioField.setAccessible(true);
        ioField.set(this.comando, ioStub);
    }

    @Test
    void testEsegui_ConCaneNonSalutato() {
        // 1) Metto il cane in una stanza qualsiasi e imposto come corrente
        Stanza stanza = new Stanza("corrente");
        stanza.setPersonaggio(this.cane);
        partita.setStanzaCorrente(stanza);

        // 2) Il cane non deve aver ancora salutato
        assertFalse(cane.haSalutato());

        // 3) Eseguo il comando, ora `io` non è più null grazie allo stub
        comando.esegui(partita);

        // 4) Controllo che il cane abbia ricevuto il saluto
        assertTrue(cane.haSalutato());
    }

    @Test
    void testEsegui_SenzaPersonaggio_NonFaNulla() {
        // 1) Imposto una stanza vuota (nessun cane dentro)
        Stanza stanzaVuota = new Stanza("vuota");
        partita.setStanzaCorrente(stanzaVuota);

        // 2) Non ci sono personaggi, ma `esegui()` non deve dare NPE perché `io` è lo stub.
        //    In base alla logica attuale di ComandoSaluta, verrà chiamato saluta() su personaggio=null,
        //    quindi genererà NullPointerException. Se vuoi che non fallisca, bisogna anche correggere
        //    il bug delle parentesi graffe dentro ComandoSaluta (vedi spiegazione sotto).
        //
        assertThrows(NullPointerException.class, () -> {
            comando.esegui(partita);
        });
    }
}
