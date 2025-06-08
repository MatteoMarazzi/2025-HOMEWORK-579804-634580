package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Stampa la lista dei comandi disponibili, recuperandoli via reflection
 * dal package delle implementazioni dei comandi.
 */
public class ComandoAiuto extends AbstractComando {
    
    private static final String COMMANDS_PACKAGE = "it.uniroma3.diadia.comandi";
    private static final List<String> elencoComandi;
    
    static {
        List<String> temp = new ArrayList<>();
        try {
            String path = COMMANDS_PACKAGE.replace('.', '/');
            URL url = Thread.currentThread()
                            .getContextClassLoader()
                            .getResource(path);
            if (url != null && "file".equals(url.getProtocol())) {
                File dir = new File(url.toURI());
                File[] files = dir.listFiles((d, name) -> name.startsWith("Comando") && name.endsWith(".class"));
                if (files != null) {
                    for (File f : files) {
                        String className = f.getName().replace(".class", "");
                        // escludi la classe astratta
                        if ("AbstractComando".equals(className)) continue;
                        // rimuovi prefisso "Comando" e passa a minuscolo
                        String comando = className.substring("Comando".length())
                                                  .toLowerCase();
                        temp.add(comando);
                    }
                }
            }
        } catch (Exception e) {
            // in caso di problemi di introspezione, fallback a lista vuota
            e.printStackTrace();
        }
        // ordinamento alfabetico (opzionale)
        Collections.sort(temp);
        elencoComandi = Collections.unmodifiableList(temp);
    }
    
    public ComandoAiuto(IO io) {
        this.io = io;
    }
    
    @Override
    public void esegui(Partita partita) {
        // stampa tutti i comandi uno per uno
        for (String cmd : elencoComandi) {
            io.mostraMessaggio(cmd + " ");
        }
        io.mostraMessaggio("\n");
    }
    
    @Override
    public String getNome() {
        return "aiuto";
    }
    

}
