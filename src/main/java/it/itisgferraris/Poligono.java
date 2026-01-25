package it.itisgferraris;

public abstract class Poligono {
    protected int numLati;
    protected Segmento[] lati;

    public Poligono(int numLati, Punto[] vertici) throws Exception{
        if (numLati < 3) {
            throw new Exception("Troppi pochi vertici!");
        }
        this.numLati = numLati;
        if (vertici.length != this.numLati) {
            throw new Exception("Troppi vertici!");
        }

    }

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

    public boolean isRegolare(){
        Segmento base = lati[0];
        double angle = base.calcolaAngolo(lati[1]);
        for (int i = 0; i < lati.length - 1; i++){
            if (lati[i].calcolaLunghezza() != base.calcolaLunghezza()) {
                return false;
            }
            if (lati[i].calcolaAngolo(lati[i + 1]) != angle) {
                return false;
            }
        }

        if (lati[-1].calcolaLunghezza() != base.calcolaLunghezza() || lati[-1].calcolaAngolo(base) != angle) {
            return false;
        }

        return true;
    }

    public abstract double calcolaArea();

    public abstract String classifica();

    protected boolean validaVertici(Punto[] vertici) { //Controlla che dei vertici non si sovrappongano
        for (int i = 0; i < numLati - 1; i++) {
            for (int j = i + 1; j < numLati; j++) {
                if (vertici[i].equals(vertici[j])) {
                    return false;
                }
            }
        }

        return true;
    }   
}
