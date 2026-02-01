package it.itisgferraris;

public class Main {
    public static void main(String[] args) {
        //I PUNTI DI UN POLIGONO VANNO IN ORDINE ANTI ORARIO
        /*I PUNTI DI UN SOLIDO DEVONO PRIMA SPECIFICARE LA BASE (SE PRESENTE) E SUCCESSIVAMENTE GLI EVENTUALI VERTICI DA AGGIUNGERE OLTRE QUELLI DI BASE 
          PER FORMARE LE FACCE LATERALI A PARTIRE DA QUELLA FRONTALE E A SEGUIRE QUELLE A DESTRA DELLA FACCIA CORRENTE*/
        Punto p0 = new Punto(-5, -5);
        Punto p1 = new Punto(5, -5);
        Punto p2 = new Punto(5, 5);
        Punto p3 = new Punto(-5, 5);
        Punto p4 = new Punto(3, -3, 8);
        Punto p5 = new Punto(-3, -3, 8);
        Punto p6 = new Punto(3, 3, 8);
        Punto p7 = new Punto(-3, 3, 8);

        Punto[] vertici = new Punto[]{p0,p1,p2,p3,p4,p5,p6,p7};
        EsaedroQuadrilaterale e1;

        try {
            e1 = new EsaedroQuadrilaterale(vertici);
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        
        System.out.println(e1);
    }
}