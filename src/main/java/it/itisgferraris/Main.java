package it.itisgferraris;

public class Main {
    public static void main(String[] args) {
        Punto p1 = new Punto();
        Punto p2 = new Punto(5, 5);
        Punto p3 = new Punto(0, 10);

        System.out.println(p1.calcolaDistanza(p2));
        System.out.println(p1.calcolaPuntoMedio(p2));
        System.out.println(p1.calcolaAngolo(p2, p3));
        System.out.println(p2.calcolaAngolo(p1, p3));
        System.out.println(p3.calcolaAngolo(p1, p2));
    }
}