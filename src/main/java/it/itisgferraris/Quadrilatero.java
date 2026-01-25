package it.itisgferraris;

public class Quadrilatero extends Poligono {
    public Quadrilatero(Punto[] vertici) throws Exception {
        super(4, vertici);
    }

    @Override
    public double calcolaArea() { //Dovrei fare una classe vector visto che li uso ovunque..
        Segmento d1 = new Segmento(lati[0].getFine(), lati[2].getFine());
        Segmento d2 = new Segmento(lati[0].getInizio(), lati[2].getInizio());
        double d1x = d1.getInizio().deltaX(d1.getFine());
        double d1y = d1.getInizio().deltaY(d1.getFine());
        double d1z = d1.getInizio().deltaZ(d1.getFine());

        double d2x = d2.getInizio().deltaX(d2.getFine());
        double d2y = d2.getInizio().deltaY(d2.getFine());
        double d2z = d2.getInizio().deltaZ(d2.getFine());

        double cpx = d1y * d2z - d1z * d2y;
        double cpy = d1z * d2x - d1x * d2z;
        double cpz = d1x * d2y - d1y * d2x;

        double area = (Math.sqrt(cpx * cpx + cpy * cpy + cpz * cpz)) / 2;
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