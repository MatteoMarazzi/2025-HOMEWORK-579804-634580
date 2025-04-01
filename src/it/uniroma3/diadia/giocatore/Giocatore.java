package it.uniroma3.diadia.giocatore;

public class Giocatore {
	
	static final private int CFU_INIZIALI = 3;
	private int cfu;
	private Borsa borsa;
	
	public Giocatore(){
		this.borsa = new Borsa();
		this.cfu=CFU_INIZIALI;
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
//	/**
//	 * Comando "prendi".
//	 */
//	
//	public boolean prendi(String attrezzo,Partita partita) {
//		if(!partita.getStanzaCorrente().hasAttrezzo(attrezzo)) {
//			System.out.println("Attrezzo non trovato");
//			return false;
//		} else {
//			Attrezzo attrezzoDaPrendere = partita.getStanzaCorrente().getAttrezzo(attrezzo);
//			partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
//			if(!partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere)) { //se è neg non l'ha messa, se invece non stampa è perchè è stata fatta l'azione.
//				System.out.println("Borsa piena o peso max");
//				return false;
//			} else {
//				System.out.println("Hai preso  : " + attrezzoDaPrendere.getNome());
//				return true;
//
//			}
//		}
//
//
//	}
//	
//	/**
//	 * Comando "posa".
//	 */
//	
//	public boolean posa(String attrezzo,Partita partita) {
//		if(!partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo)) {
//			System.out.println("Nella tua borsa non è presente questo attrezzo");
//			return false;
//		} else {
//			Attrezzo attrezzoDaPosare = partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
//			if(!partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare)) { //se è neg non l'ha messa, se invece non stampa è perchè è stata fatta l'azione.
//				System.out.println("Stanza piena");
//				return false;
//			} else {
//				System.out.println("Hai posato  : " + attrezzoDaPosare.getNome());
//				return true;
//			}
//		}
//
//
//	}
}
