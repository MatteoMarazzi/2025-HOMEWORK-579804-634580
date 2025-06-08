package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);

	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>();

	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		return this.attrezzi.add(attrezzo);
	}
	
	public int getPesoMax() {
		return pesoMax;
	}

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
		return attrezzoTrovato;  // Se non trova nessun attrezzo con quel nome
	}



	public int getPeso() {
		Iterator<Attrezzo> iter = this.attrezzi.iterator();
		int peso = 0;
		while (iter.hasNext()) {
			peso+=iter.next().getPeso();  

		}

		return peso;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore =
				this.attrezzi.iterator();
		while (iteratore.hasNext()) {
			a = iteratore.next();
			if (a.getNome().equals(nomeAttrezzo)) {

				iteratore.remove();
				return a;
			}
		}
		return null;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			for (Attrezzo a : attrezzi) {
				if (a != null) {
					s.append(a.toString() + " ");
				}
			}
		} else {
			s.append("Borsa vuota");
		}
		return s.toString();
	}

	//ordina per peso, crescente
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> listaOrdinata = new ArrayList<>(this.attrezzi);
		Collections.sort(
				listaOrdinata,
				new Comparator<Attrezzo>() {
					@Override
					public int compare(Attrezzo a1, Attrezzo a2) {
						// confronta i due interi: peso di a1 e peso di a2
						return Integer.compare(a1.getPeso(), a2.getPeso());
					}
				}
				);
		return listaOrdinata;
	}
	public Set<Attrezzo> getContenutoOrdinatoPerNome(){
		Set<Attrezzo> setOrdinato = new TreeSet<>(new Comparator<Attrezzo>() {
			@Override
			public int compare(Attrezzo a1,Attrezzo a2) {
				return a1.getNome().compareTo(a2.getNome());
			}
		});
		setOrdinato.addAll(this.attrezzi);
		return setOrdinato;
	};
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		// 1. Creo una mappa vuota: peso -> insieme di Attrezzo
		Map<Integer, Set<Attrezzo>> mappa = new HashMap<>();

		// 2. Scorro tutti gli Attrezzo nella lista
		for (Attrezzo a : this.attrezzi) {
			int peso = a.getPeso();  // estraggo il peso
			// Se la mappa ha già una voce per questo peso, prendo il Set esistente
			if (mappa.containsKey(peso)) {
				Set<Attrezzo> insieme = mappa.get(peso);
				insieme.add(a);
			}
			// Altrimenti, non c’è ancora quel peso: creo un nuovo Set e ci metto l’Attrezzo
			else {
				Set<Attrezzo> nuovoInsieme = new HashSet<>();
				nuovoInsieme.add(a);
				mappa.put(peso, nuovoInsieme);
			}
		}
		// 3. Ritorno la mappa completa
		return mappa;
	};


	//Ordina la lista degli oggetti per peso, se hanno peso uguale allora per nome.
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		
		Comparator<Attrezzo> comp = new Comparator<Attrezzo>() {
			@Override
			public int compare(Attrezzo a1,Attrezzo a2) {
				int verifica = Integer.compare(a1.getPeso(),a2.getPeso());
				if(verifica != 0) {
					return verifica;
				}
				return a1.getNome().compareTo(a2.getNome());
			};
		};
	
		SortedSet<Attrezzo> setOrdinato = new TreeSet<Attrezzo>(comp);
		setOrdinato.addAll(this.attrezzi);
		return setOrdinato;


}
}
