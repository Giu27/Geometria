package it.itisgferraris;

public class Main {
    public static void main(String[] args) {
        Punto p1 = new Punto();
        Punto p2 = new Punto(5, 0, 2.5);
        Punto p3 = new Punto(10, 0, 5);
        Segmento s1 = new Segmento(p1, p3);

        System.out.println(s1.appartiene(p2));
    }
}