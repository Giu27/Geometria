package it.itisgferraris;

public class Quadrilatero extends Poligono {
    public Quadrilatero(Punto[] vertici) throws Exception {
        super(4, vertici);
    }

    @Override
    public double calcolaArea() { //Diagonale * diagonale * seno di angolo fra le diagonali. tutto diviso 2
        Segmento d1 = new Segmento(lati[0].getFine(), lati[2].getFine());
        Segmento d2 = new Segmento(lati[0].getInizio(), lati[2].getInizio());
        Punto centro = d1.intersezione(d2);
        double angolo = centro.calcolaAngolo(lati[0].getInizio(), lati[0].getFine());
        angolo = Math.toRadians(angolo);

        double area = (d1.calcolaLunghezza() * d2.calcolaLunghezza() * Math.sin(angolo)) / 2;
        int area_approx = (int) area;

        if (Math.abs(area_approx - area) < 0.0000001) {
            area = area_approx;
        }

        return area;
    }

    public boolean hasLatiOppostiUguali() {
        return lati[0].calcolaLunghezza() == lati[2].calcolaLunghezza() && lati[1].calcolaLunghezza() == lati[3].calcolaLunghezza();
    }

    public boolean hasLatiOppostiParalleli() { //TODO Verificare i lati paralleli
        return true;
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
        if (hasLatiOppostiParalleli()) {
            return "Trapezio";
        }
        return "Generico";
    }
}