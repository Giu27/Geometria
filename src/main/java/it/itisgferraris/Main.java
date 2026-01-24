package it.itisgferraris;

public class Main {
    public static void main(String[] args) {
        Punto p1 = new Punto();
        Punto p2 = new Punto(5, 0, 0);
        Punto p3 = new Punto(5, 0, 0);
        Punto p4 = new Punto(5, 5, 0);
        Segmento s1 = new Segmento(p1, p2);
        Segmento s2 = new Segmento(p3, p4);

        System.out.println(s1.calcolaAngolo(s2));
    }
}