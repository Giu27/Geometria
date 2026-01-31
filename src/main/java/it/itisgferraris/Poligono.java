package it.itisgferraris;

public abstract class Poligono {
    protected int numLati;
    protected Segmento[] lati;

    public Poligono(int numLati, Punto[] vertici) throws Exception{
        if (numLati < 3) {
            throw new Exception("Troppi pochi vertici!");
        }
        this.numLati = numLati;
        this.lati = new Segmento[this.numLati];
        if (vertici.length != this.numLati) {
            throw new Exception("Troppi vertici!");
        }

        if (!validaVertici(vertici)) {
            throw new Exception("Vertici non validi!");
        }

        for (int i = 0; i < vertici.length - 1; i++) {
            lati[i] = new Segmento(vertici[i], vertici[i + 1]);
        }
        lati[lati.length - 1] = new Segmento(vertici[vertici.length - 1], vertici[0]);
        if (!validaLati(lati)){
            throw new Exception("Vertici non validi!");
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

    public Segmento[] getLati() {
        return lati;
    }

    public double calcolaPerimetro() {
        double somma = 0;
        for (Segmento lato : lati) {
            somma += lato.calcolaLunghezza();
        }
        return somma;
    }

    public boolean isRegolare() {
        if (hasAngoliUguali() && hasLatiUguali()) {
            return true;
        }
        return false;
    }

    public boolean hasLatiUguali() {
        Segmento base = lati[0];
        for (int i = 0; i < lati.length - 1; i++){
            if (lati[i].calcolaLunghezza() != base.calcolaLunghezza()) {
                return false;
            }
        }

        if (lati[lati.length - 1].calcolaLunghezza() != base.calcolaLunghezza()) {
            return false;
        }

        return true;
    }

    public boolean hasAngoliUguali() {
        Segmento base = lati[0];
        double angle = base.calcolaAngolo(lati[1]);

        for (int i = 0; i < lati.length - 1; i++){
            if (lati[i].calcolaAngolo(lati[i + 1]) != angle) {
                return false;
            }
        }

        if (lati[lati.length - 1].calcolaAngolo(base) != angle) {
            return false;
        }

        return true;
    }

    public abstract double calcolaArea();

    public abstract String classifica();

    protected boolean validaVertici(Punto[] vertici) { //Controlla che dei vertici non si sovrappongano
        for (int i = 0; i < numLati; i++) {
            for (int j = 0; j < numLati; j++) {
                if (vertici[i].equals(vertici[j]) && i != j) {
                    return false;
                }
            }
        }

        return true;
    }

    protected boolean validaLati(Segmento[] lati) {
        double sommaLati = 0;
        double maggiore = lati[0].calcolaLunghezza();
        
        for (int i = 0; i < numLati; i++){
            sommaLati += lati[i].calcolaLunghezza();

            if (lati[i].calcolaLunghezza() > maggiore) {
                maggiore = lati[i].calcolaLunghezza();
            }
        }

        if (maggiore >= (sommaLati) - maggiore) {
            return false;
        }

        return true;
    }
    
    @Override
    public String toString(){
        return getClass().getName().substring(17) + ":\nTipo: " + classifica() + "\nPerimetro: " + calcolaPerimetro() + "\nArea: " + calcolaArea() + "\nRegolare: " + isRegolare();
    }
}
