package it.itisgferraris;

public class Segmento {
    private Punto inizio;
    private Punto fine;

    //Costruttori
    public Segmento(Punto inizio, Punto fine) {
        this.inizio = inizio;
        this.fine = fine;
    }

    public Segmento(double[] coordInizio, double[] coordFine){
        inizio = new Punto(coordInizio);
        fine = new Punto(coordFine);
    }

    public Segmento(int[] coordInizio, int[] coordFine){
        inizio = new Punto(coordInizio);
        fine = new Punto(coordFine);
    }

    //Get e Set
    public Punto getInizio() {
        return inizio;
    }

    public Punto getFine() {
        return fine;
    }

    public void setInizio(Punto p) {
        inizio = p;
    }

    public void setInizio(double[] coords) {
        inizio.setCoords(coords);
    }

    public void setInizio(int[] coords) {
        inizio.setCoords(coords);
    }

    public void setFine(Punto p) {
        fine = p;
    }

    public void setFine(double[] coords) {
        fine.setCoords(coords);
    }

    public void setFine(int[] coords) {
        fine.setCoords(coords);
    }

    //Operazioni
    public double calcolaLunghezza() {
        return inizio.calcolaDistanza(fine);
    }

    public Punto calcolaPuntoMedio() {
        return inizio.calcolaPuntoMedio(fine);
    }

    public boolean appartiene(Punto p) {
        double moduloAP = inizio.calcolaDistanza(p);
        
        if (inizio.calcolaAngolo(p, fine) != 0) {
            return false;
        }

        if (moduloAP > calcolaLunghezza()) {
            return false;
        }

        return true;
    }
}
