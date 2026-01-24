package it.itisgferraris;

public abstract class Poligono {
    protected int numLati;
    protected Segmento[] lati;

    public int getNumLati() {
        return numLati;
    }

    public double getLato(int index) throws Exception{
        if (index < 0 || index >= numLati) {
            throw new Exception("Indice non valido!");
        }

        return lati[index].calcolaLunghezza();
    }

    public double calcolaPerimetro() {
        double somma = 0;
        for (Segmento lato : lati) {
            somma += lato.calcolaLunghezza();
        }
        return somma;
    }

    public abstract double calcolaArea();

    protected abstract boolean validaLati(Segmento[] lati);
}
