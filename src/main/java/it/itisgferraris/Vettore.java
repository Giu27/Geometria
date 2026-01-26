package it.itisgferraris;

public class Vettore { //Tanto vale implementarli qui, visto che li suo ovunque..
    Punto componenti; //Qui il punto è usato più come contenitore che altro, per evitare di riscrivere getter e setter identici. Non faccio ereditare però per evitare che il vettore erediti metodi di cui non ha bisogno

    public Vettore(){
        this.componenti = new Punto();
    }

    public Vettore(Punto componenti) {
        this.componenti = componenti;
    }

    public Vettore(double x, double y) {
        componenti = new Punto(x, y);
    }

    public Vettore(double x, double y, double z) {
        componenti = new Punto(x, y, z);
    }

    public Vettore(Punto inizio, Punto fine) {
        double x = inizio.deltaX(fine);
        double y = inizio.deltaY(fine);
        double z = inizio.deltaZ(fine);
        componenti = new Punto(x, y, z);
    }

    public Vettore(Segmento s){
        double x = s.getInizio().deltaX(s.getFine());
        double y = s.getInizio().deltaY(s.getFine());
        double z = s.getInizio().deltaZ(s.getFine());
        componenti = new Punto(x, y, z);
    }

    public double getX() {
        return componenti.getX();
    }

    public double getY() {
        return componenti.getY();
    }

     public double getZ() {
        return componenti.getZ();
    }

    public double[] getCoords() {
        return componenti.getCoords();
    }

    public void setX(double x) {
        componenti.setX(x);
    }

    public void setY(double y) {
        componenti.setY(y);
    }

    public void setZ(double z) {
        componenti.setZ(z);
    }

    public void setCoords(double[] coords) throws Exception{
        componenti.setCoords(coords);
    }

    public void setCoords(int[] coords) throws Exception{
        componenti.setCoords(coords);
    }

    public double dot(Vettore v) { //Prodotto scalare 
        return getX() * v.getX() + getY() * v.getY() + getZ() * v.getZ();
    }

    public Vettore cross(Vettore v) {
        return new Vettore(getY() * v.getZ() - getZ() * v.getY(), getZ() * v.getX() - getX() * v.getZ(), getX() * v.getY() - getY() * v.getX());
    }

    public double magnitudo() { //Lunghezza del vettore
        return Math.sqrt(dot(this));
    }

    public Vettore normalizza() { //Restituisce un vettore di lunghezza 1
        double m = magnitudo();
        if (m == 0) { //Se il vettore è nullo ritorna, per evitare una divisione per 0
            return new Vettore();
        }
        return new Vettore(getX() / m, getY() / m, getZ() / m);
    } 

    public Vettore moltiplica(double scalare) {//Restituisce un vettore riscalato in base allo scalare
        return new Vettore(getX() * scalare, getY() * scalare, getZ() * scalare);
    }

    public Vettore somma(Vettore v) {
        return new Vettore(getX() + v.getX(), getY() + v.getY(), getZ() + v.getZ());
    }

    public Vettore sottrai(Vettore v) {
        return new Vettore(getX() - v.getX(), getY() - v.getY(), getZ() - v.getZ());
    }
}