package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.Direzione;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto {

    private Stanza stanzaVincente;
    private Stanza stanzaIniziale;
    private Map<String,Stanza> listaStanze = new HashMap<>();

    // Costruttore privato: forzato uso del builder
    private Labirinto() {}

    /**
     * Factory method per ottenere un nuovo builder.
     */
    public static LabirintoBuilder newBuilder() {
        return new LabirintoBuilder();
    }

    public Stanza getStanzaVincente() {
        return stanzaVincente;
    }

    public Stanza getStanzaIniziale() {
        return stanzaIniziale;
    }

    public Map<String,Stanza> getListaStanze() {
        return this.listaStanze;
    }

    public static class LabirintoBuilder {
        private String nomeStanzaIniziale;
        private String nomeStanzaVincente;
        private String nomeStanzaCorrente;
        private Map<String,Stanza> listaStanze = new HashMap<>();
        private Set<Attrezzo> listaAttrezzi = new HashSet<>();

        public LabirintoBuilder() {}

        public LabirintoBuilder addStanza(String nome) {
            if (!listaStanze.containsKey(nome))
                listaStanze.put(nome, new Stanza(nome));
            nomeStanzaCorrente = nome;
            return this;
        }

        public LabirintoBuilder addStanzaIniziale(String nome) {
            addStanza(nome);
            nomeStanzaIniziale = nome;
            return this;
        }

        public LabirintoBuilder addStanzaVincente(String nome) {
            addStanza(nome);
            nomeStanzaVincente = nome;
            return this;
        }

        public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
            Attrezzo att = new Attrezzo(nomeAttrezzo, peso);
            if (listaAttrezzi.add(att)) {
                Stanza s = listaStanze.get(nomeStanzaCorrente);
                if (s != null)
                    s.addAttrezzo(att);
            }
            return this;
        }

        public LabirintoBuilder addAdiacenza(String from, String to, Direzione dir) {
            Stanza s1 = listaStanze.get(from);
            Stanza s2 = listaStanze.get(to);
            if (s1 != null && s2 != null)
                s1.impostaStanzaAdiacente(dir, s2);
            return this;
        }

        public LabirintoBuilder addStanzaMagica(String nome, int soglia) {
            StanzaMagica sm = new StanzaMagica(nome, soglia);
            listaStanze.putIfAbsent(nome, sm);
            nomeStanzaCorrente = nome;
            return this;
        }

        public LabirintoBuilder addStanzaBuia(String nome, String attNecessario) {
            StanzaBuia sb = new StanzaBuia(nome, attNecessario);
            listaStanze.putIfAbsent(nome, sb);
            nomeStanzaCorrente = nome;
            return this;
        }

        public LabirintoBuilder addStanzaBloccata(String nome, String att, Direzione dir) {
            StanzaBloccata sb = new StanzaBloccata(nome, dir, att);
            listaStanze.putIfAbsent(nome, sb);
            nomeStanzaCorrente = nome;
            return this;
        }

        public LabirintoBuilder addPersonaggio(Cane cane, String stanza) {
            Stanza s = listaStanze.get(stanza);
            if (s != null) s.setPersonaggio(cane);
            return this;
        }

        public void addMago(String nomePersonaggio, String presentazionePersonaggio, String nomeAttrezzo, int peso,
				String stanza) {
			Attrezzo attrezzo = null;
			for(Attrezzo a : this.listaAttrezzi) {
				if(a.getNome() == nomeAttrezzo) {
					attrezzo = a;
				}
			}
				Mago mago = new Mago(nomePersonaggio,presentazionePersonaggio,attrezzo);
				this.getStanza(stanza).setPersonaggio(mago);
		}

		public void addStrega(String nomeStrega, String presentazioneStrega, String nomeStanza) {

				Strega strega = new Strega(nomeStrega,presentazioneStrega);
				this.getStanza(nomeStanza).setPersonaggio(strega);
		}

		public void addCane(String nomeCane, String presentazioneCane, String ciboPreferito, String nomeStanza) {
			Cane cane = new Cane(nomeCane,presentazioneCane,ciboPreferito);
			this.getStanza(nomeStanza).setPersonaggio(cane);
		}

		public Stanza getStanza(String nomeStanza) {
			// TODO Auto-generated method stub
			return this.listaStanze.get(nomeStanza);
		}


        /**
         * Costruisce l'istanza finale di Labirinto.
         */
		public Labirinto getLabirinto() {
            Labirinto lab = new Labirinto();
            lab.listaStanze = this.listaStanze;
            lab.stanzaIniziale = listaStanze.get(nomeStanzaIniziale);
            lab.stanzaVincente = listaStanze.get(nomeStanzaVincente);
            return lab;
        }
	}



    }

