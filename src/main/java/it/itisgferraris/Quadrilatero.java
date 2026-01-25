package it.itisgferraris;

public class Quadrilatero extends Poligono {
    public Quadrilatero(Punto[] vertici) throws Exception {
        super(4, vertici);
    }

    @Override
    public double calcolaArea() {
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

    @Override //TODO metodo classifica
    public String classifica() {
        return "TODO";
    }

    
}