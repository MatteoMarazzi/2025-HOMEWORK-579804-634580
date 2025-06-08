package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import it.uniroma3.diadia.Direzione;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	
	private String nome;
	private List<Attrezzo> attrezzi;
	private Map<Direzione,Stanza> stanzeAdiacenti;
	private AbstractPersonaggio  personaggio;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */

	public Stanza(String descrizione){
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new ArrayList<>();
		this.nome = descrizione;
	}


	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */

	public Stanza getStanzaAdiacente(Direzione direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

	public void impostaStanzaAdiacente(Direzione direzione,Stanza stanzaAdiacente) {
		this.stanzeAdiacenti.put(direzione,stanzaAdiacente);
	}



	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false altrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.add(attrezzo);
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		for (Direzione direzione : this.stanzeAdiacenti.keySet())
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo a : attrezzi) {
			if (a != null) {
				risultato.append(a.toString() + " ");
			}
		}
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
	    Iterator<Attrezzo> iter = this.attrezzi.iterator();
	    while (iter.hasNext()) {
	        Attrezzo a = iter.next();
	        if (a.getNome().equals(nomeAttrezzo)) {
	            return true;
	        }
	    }
	    return false;
	}


	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
	    Iterator<Attrezzo> iter = this.attrezzi.iterator();
	    Attrezzo attrezzoTrovato = null;
	    while (iter.hasNext()) {
	        Attrezzo a = iter.next();
	        if (a.getNome().equals(nomeAttrezzo)) {
	        	attrezzoTrovato = a;
	            break;
	        }
	    }
	    return attrezzoTrovato;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo wanted) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore =
				this.attrezzi.iterator();
		while (iteratore.hasNext()) {
			a = iteratore.next();
			if (a.getNome().equals(wanted)) {

				iteratore.remove();
				return true;
			}
		}
		return false;
	}


	public List<Direzione> getDirezioni() {
		List<Direzione> direzioni = new ArrayList<>(stanzeAdiacenti.keySet());
		return direzioni;
	}
	
	public void setPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio = personaggio;
		}
		public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
		}


		public Map<Direzione, Stanza> getMapStanzeAdiacenti() {
			return stanzeAdiacenti;
		}


}