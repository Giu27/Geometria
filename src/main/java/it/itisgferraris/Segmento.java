package it.itisgferraris;

public class Segmento {
    private Punto a;
    private Punto b;

    public Segmento(Punto a, Punto b) {
        this.a = a;
        this.b = b;
    }

    public Segmento(double[] coordInizio, double[] coordFine){
        a = new Punto(coordInizio);
        b = new Punto(coordFine);
    }

    public Segmento(int[] coordInizio, int[] coordFine){
        a = new Punto(coordInizio);
        b = new Punto(coordFine);
    }

    public Segmento(){
        this.a= new Punto();
        this.b = new Punto();
    }

    //metodi get per prendere i punti 
    public Punto Get_a(){
        return this.a;
    }
    public Punto Get_b(){
        return this.b;
    }

    public void Set_a(Punto c){
        this.a = c;
    }
    public void Set_b(Punto c){
        this.b = c;
    }
    // distanza tra a ed b
    public double calcoladistanza_segmento(){
        return a.calcolaDistanza(b);
    }

    // punti in radianti delle ascisse rispetto alla diagonale (potrebbero servirci)

    //Cos(x)
    public double Cos_segmento(){
        return a.distanze_x(b) / calcoladistanza_segmento();
    }

    //Sin(x)
    public double Sin_segmento(){
        return a.distanze_y(b) / calcoladistanza_segmento();
    }

    //per avere gli angoli useremo le funzioni inverse da Math
}
