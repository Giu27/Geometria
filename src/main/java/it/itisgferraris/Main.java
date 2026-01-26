package it.itisgferraris;

public class Main {
    public static void main(String[] args) {
        //I PUNTI DI UN QUADRILATERO VANNO IN ORDINE ANTI ORARIO
        Punto p1 = new Punto();
        Punto p2 = new Punto(5, 0, 0);
        Punto p3 = new Punto(5, 5, 0);
        Punto p4 = new Punto(0, 5, 0);
        Punto[] vertici = new Punto[]{p1,p2,p3,p4};
        Quadrilatero q1;

        try {
            q1 = new Quadrilatero(vertici);
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        
        System.out.println(q1);
    }
}