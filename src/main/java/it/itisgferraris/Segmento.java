package it.itisgferraris;

public class Segmento {
    private Punto inizio;
    private Punto fine;

    //Costruttori
    public Segmento(Punto inizio, Punto fine) {
        this.inizio = inizio;
        this.fine = fine;
    }

    public Segmento(double[] coordInizio, double[] coordFine) throws Exception{
        inizio = new Punto(coordInizio);
        fine = new Punto(coordFine);
    }

    public Segmento(int[] coordInizio, int[] coordFine) throws Exception{
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

    public void setInizio(double[] coords) throws Exception{
        inizio.setCoords(coords);
    }

    public void setInizio(int[] coords) throws Exception{
        inizio.setCoords(coords);
    }

    public void setFine(Punto p) {
        fine = p;
    }

    public void setFine(double[] coords) throws Exception{
        fine.setCoords(coords);
    }

    public void setFine(int[] coords) throws Exception{
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
        Vettore d1 = new Vettore(inizio, fine);
        Vettore d2 = new Vettore(altro.inizio, altro.fine);
        Vettore r31 = new Vettore(altro.inizio, inizio);

        //DOT PRODUCTS
        double a = d1.dot(d1);
        double b = d1.dot(d2);
        double e = d2.dot(d2);
        double d = d1.dot(r31);
        double f = d2.dot(r31);

        double det = a * e - b * b; //determinante del sistema

        if (det < 1e-9) { //Rette parallele o con troppe sovrapposizioni
            return null;
        }

        double s = (b * f - d * e) / det; //s è parametro della equazione parametrica

        Punto intersz = new Punto(inizio.getX() + s * d1.getX(), inizio.getY() + s * d1.getY(), inizio.getZ() + s * d1.getZ());

        if (appartiene(intersz) && altro.appartiene(intersz)) {
            return intersz;
        }
        
        return null;
    }

    public boolean paralleli(Segmento altro) {//Verifica se due segmenti sono paralleli
        Vettore d1 = new Vettore(inizio, fine);
        Vettore d2 = new Vettore(altro.inizio, altro.fine);

        Vettore c = d1.cross(d2);

        return Math.abs(c.getX()) < 0.0000001 && Math.abs(c.getY()) < 0.0000001 && Math.abs(c.getZ()) < 0.0000001;
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
