package it.itisgferraris;

public class Punto {
    private double x;
    private double y;
    private double z;

    public Punto(double x, double y) { //Punto di una figura piana
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public Punto(double x, double y, double z) { //Punto di una figura solida
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double calcolaDistanza(Punto altro) { //Calcola la distanza fra sè e un altro punto
        return Math.sqrt(Math.pow(altro.x - x, 2) + Math.pow(altro.y - y, 2) + Math.pow(altro.z - z, 2));
    }

    public Punto calcolaPuntoMedio(Punto altro) { //Restituisce il punto medio fra sè e un altro punto
        return new Punto((x + altro.x) / 2, (y + altro.y) / 2, (z + altro.z) / 2);
    }
}
