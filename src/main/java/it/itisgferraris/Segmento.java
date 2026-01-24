package it.itisgferraris;

public class Segmento {
    private Punto inizio;
    private Punto fine;

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
}
