package it.itisgferraris;

public class Segmento {
    private Punto inizio;
    private Punto fine;

    //Costruttori
    public Segmento(Punto inizio, Punto fine) {
        this.inizio = inizio;
        this.fine = fine;
    }

    public Segmento(double[] coordInizio, double[] coordFine){
        inizio = new Punto(coordInizio);
        fine = new Punto(coordFine);
    }

    public Segmento(int[] coordInizio, int[] coordFine){
        inizio = new Punto(coordInizio);
        fine = new Punto(coordFine);
    }

    //Get e Set
    public Punto getInizio() {
        return inizio;
    }

    public Punto getFine() {
        return fine;
    }

    public void setInizio(Punto p) {
        inizio = p;
    }

    public void setInizio(double[] coords) {
        inizio.setCoords(coords);
    }

    public void setInizio(int[] coords) {
        inizio.setCoords(coords);
    }

    public void setFine(Punto p) {
        fine = p;
    }

    public void setFine(double[] coords) {
        fine.setCoords(coords);
    }

    public void setFine(int[] coords) {
        fine.setCoords(coords);
    }

    //Operazioni
    public double calcolaLunghezza() {
        return inizio.calcolaDistanza(fine);
    }

    public Punto calcolaPuntoMedio() {
        return inizio.calcolaPuntoMedio(fine);
    }

    public boolean appartiene(Punto p) { //Determina se un punto appartiene al segmento
        double moduloAP = inizio.calcolaDistanza(p);
        
        if (inizio.calcolaAngolo(p, fine) != 0) {
            return false;
        }

        if (moduloAP > calcolaLunghezza()) {
            return false;
        }

        return true;
    }

    public Punto intersezione(Segmento altro) { //Trova un punto di intersezione con un altro segmento. Si basa su sistemi lineari ed equazioni parametriche. Semplice su carta, meno in codice.
        double d1x = inizio.deltaX(fine);
        double d1y = inizio.deltaY(fine);
        double d1z = inizio.deltaZ(fine);

        double d2x = altro.inizio.deltaX(altro.fine);
        double d2y = altro.inizio.deltaY(altro.fine);
        double d2z = altro.inizio.deltaZ(altro.fine);

        double r31x = altro.inizio.deltaX(inizio);
        double r31y = altro.inizio.deltaY(inizio);
        double r31z = altro.inizio.deltaZ(inizio);

        //DOT PRODUCTS
        double a = d1x * d1x + d1y * d1y + d1z * d1z;
        double b = d1x * d2x + d1y * d2y + d1z * d2z;
        double e = d2x * d2x + d2y * d2y + d2z * d2z;
        double d = d1x * r31x + d1y * r31y + d1z * r31z;
        double f = d2x * r31x + d2y * r31y + d2z * r31z;

        double det = a * e - b * b; //determinante del sistema

        if (det < 1e-9) { //Rette parallele o con troppe sovrapposizioni
            return null;
        }

        double s = (b * f - d * e) / det; //s è parametro della equazione parametrica

        Punto intersz = new Punto(inizio.getX() + s * d1x, inizio.getY() + s * d1y, inizio.getZ() + s * d1z);

        if (appartiene(intersz) && altro.appartiene(intersz)) {
            return intersz;
        }
        
        return null;
    }

    public double calcolaAngolo(Segmento altro) {//Calcola l'angolo di due segmenti con un vertice comune
        if (fine.equals(altro.inizio)) {
            return fine.calcolaAngolo(inizio, altro.fine);
        } else if (inizio.equals(altro.fine)) {
            return inizio.calcolaAngolo(fine, altro.inizio);
        } else if (fine.equals(altro.fine)) {
            return fine.calcolaAngolo(inizio, altro.inizio);
        } else if (inizio.equals(altro.inizio)){
            return inizio.calcolaAngolo(fine, altro.fine);
        }
        return 0;
    }

    @Override
    public String toString(){
        return "Punto di inizio:\n" + inizio + "\nPunto di fine:\n" + fine;
    }

    @Override
    public boolean equals(Object o) { //Verifica se due segmenti hanno gli stessi punti
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Segmento segmento = (Segmento) o;

        if (inizio != segmento.inizio || fine != segmento.fine) {
            return false;
        }

        return true;
    }
}
