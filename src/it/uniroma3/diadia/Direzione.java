package it.uniroma3.diadia;

public enum Direzione {
    NORD,
    EST,
    SUD,
    OVEST;

    /**
     * Restituisce l'"indice" della direzione (0=NORD, 1=EST, 2=SUD, 3=OVEST)
     */
    public int getOrdinal() {
        return this.ordinal();
    }

    /**
     * Ritorna la direzione opposta a quella corrente.
     */
    public Direzione opposta() {
        switch (this) {
            case NORD:
                return SUD;
            case EST:
                return OVEST;
            case SUD:
                return NORD;
            case OVEST:
                return EST;
            default:
                throw new IllegalStateException("Direzione sconosciuta: " + this);
        }
    }
}
