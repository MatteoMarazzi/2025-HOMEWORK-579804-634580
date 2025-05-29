package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	    for (Attrezzo a : attrezzi) {
	        if (a.getNome().equals(nomeAttrezzo)) {
	            return a;  // Ritorna subito l'attrezzo trovato
	        }
	    }
	    return null;  // Se non trova nessun attrezzo con quel nome
	}



	public int getPeso() {
		int peso = 0;
		 for (Attrezzo a : attrezzi) {
			 peso+=a.getPeso();  
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


}
