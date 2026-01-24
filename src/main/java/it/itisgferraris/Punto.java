package it.itisgferraris;

public class Punto {
    private double x;
    private double y;
    private double z;

    public Punto(double x, double y) { //Punto di una figura piana
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public Punto(double x, double y, double z) { //Punto di una figura solida
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Punto(double[] coords){ //Inizializza da array
        x = coords[0];
        y = coords[1];
        z = coords[2];
    }

    public Punto(int[] coords){
        x = coords[0];
        y = coords[1];
        z = coords[2];
    }

    public Punto(){ //Origine
        x = 0;
        y = 0;
        z = 0;
    }

    //Get e Set individuali e non
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double[] getCoords() {
        return new double[]{x, y, z};
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setCoords(double[] coords) {
        x = coords[0];
        y = coords[1];
        z = coords[2];
    }

    public void setCoords(int[] coords) {
        x = coords[0];
        y = coords[1];
        z = coords[2];
    }

    //Operazioni con altri punti
    public double calcolaDistanza(Punto altro) { //Calcola la distanza fra sè e un altro punto
        return Math.sqrt(Math.pow(altro.x - x, 2) + Math.pow(altro.y - y, 2) + Math.pow(altro.z - z, 2));
    }

    public Punto calcolaPuntoMedio(Punto altro) { //Restituisce il punto medio fra sè e un altro punto
        return new Punto((x + altro.x) / 2, (y + altro.y) / 2, (z + altro.z) / 2);
    }

    @Override
    public String toString(){
        return "X: " + x + "\nY: " + y + "\nZ: " + z;
    }
}
