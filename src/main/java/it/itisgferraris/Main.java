package it.itisgferraris;

public class Main {
    public static void main(String[] args) {
        Punto p1 = new Punto();
        Punto p2 = new Punto(5, 5, 0);

        System.out.println(p1.calcolaDistanza(p2));
        System.out.println(p1.calcolaPuntoMedio(p2));
    }
}