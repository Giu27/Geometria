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
    public double deltaX(Punto altro) {
        double delta = altro.x - x;
        int delta_approx = (int) delta;
        if (Math.abs(delta_approx - delta) < 0.0000001) {
            delta = delta_approx;
        }
        return delta;
    }

    public double deltaY(Punto altro) {
        double delta = altro.y - y;
        int delta_approx = (int) delta;
        if (Math.abs(delta_approx - delta) < 0.0000001) {
            delta = delta_approx;
        }
        return delta;
    }

    public double deltaZ(Punto altro) {
        double delta = altro.z - z;
        int delta_approx = (int) delta;
        if (Math.abs(delta_approx - delta) < 0.0000001) {
            delta = delta_approx;
        }
        return delta;
    }

    public double calcolaDistanza(Punto altro) { //Calcola la distanza fra sè e un altro punto
        return Math.sqrt(Math.pow(deltaX(altro), 2) + Math.pow(deltaY(altro), 2) + Math.pow(deltaZ(altro), 2));
    }

    public Punto calcolaPuntoMedio(Punto altro) { //Restituisce il punto medio fra sè e un altro punto
        return new Punto((x + altro.x) / 2, (y + altro.y) / 2, (z + altro.z) / 2);
    }

    public double calcolaAngolo(Punto a, Punto c){//Calcola l'angolo, in gradi, fra tre punti, considerando sè stesso il vertice B in due vettori BA e BC
        double dotProduct = (deltaX(a) * deltaX(c)) + (deltaY(a) * deltaY(c)) + (deltaZ(a) * deltaZ(c));
        double moduloBA = calcolaDistanza(a);
        double moduloBC = calcolaDistanza(c);

        if (moduloBA == 0 || moduloBC == 0) {
            return 0; //Uno dei punti è coincidente
        }

        double coseno = dotProduct / (moduloBA * moduloBC);
        coseno = Math.max(-1, Math.min(coseno, 1)); //Limita il risultato per evitare errori

        double angle = Math.acos(coseno);
        angle = Math.toDegrees(angle);
        int angle_approx = (int) angle;

        if (Math.abs(angle_approx - angle) < 0.000001) {
            angle = angle_approx;
        }
        return angle;
    }

    @Override
    public String toString(){
        return "X: " + x + "\nY: " + y + "\nZ: " + z;
    }
}
