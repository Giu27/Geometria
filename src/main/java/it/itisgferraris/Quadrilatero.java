package it.itisgferraris;

public class Quadrilatero extends Poligono {
    public Quadrilatero(Punto[] vertici) throws Exception {
        super(4, vertici);
    }

    @Override
    public double calcolaArea() { //Dovrei fare una classe vector visto che li uso ovunque..
        Segmento d1 = new Segmento(lati[0].getFine(), lati[2].getFine());
        Segmento d2 = new Segmento(lati[0].getInizio(), lati[2].getInizio());
        Vettore vd1 = new Vettore(d1);
        Vettore vd2 = new Vettore(d2);

        Vettore c = vd1.cross(vd2);

        double area = c.magnitudo() / 2;
        int area_approx = (int) area;

        if (Math.abs(area_approx - area) < 0.0000001) {
            area = area_approx;
        }

        return area;
    }

    public boolean hasLatiOppostiUguali() {
        return lati[0].calcolaLunghezza() == lati[2].calcolaLunghezza() && lati[1].calcolaLunghezza() == lati[3].calcolaLunghezza();
    }

    public boolean hasAlcuniLatiOppostiParalleli() { //Controlla se almeno una coppia di lati opposti è paralleli, necessario per il trapezio
        return lati[0].paralleli(lati[2]) || lati[1].paralleli(lati[3]);
    }

    @Override
    public String classifica() {
        if (isRegolare()) {
            return "Quadrato";
        };
        if (hasAngoliUguali()) {
            return "Rettangolo";
        }
        if (hasLatiUguali()) {
            return "Rombo";
        }
        if (hasLatiOppostiUguali()) {
            return "Parallelogramma";
        }
        if (hasAlcuniLatiOppostiParalleli()) {
            return "Trapezio";
        }
        return "Generico";
    }
}