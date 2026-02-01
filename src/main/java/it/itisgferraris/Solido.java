package it.itisgferraris;

import java.util.HashMap; //Whoops, tanti import che hanno bisogno di spiegazioni ahah
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class Solido {
    protected Poligono[] facce;
    protected int[] numVerticiFacce; //Indica il numero di vertici di ogni faccia
    protected int numFacce;
    protected int numVertici; //Indica il numero di vertici complessivo
    protected int numSpigoli;

    protected abstract double calcolaVolume();
    protected abstract String classifica();

    protected double calcolaArea() {
        double area = 0;
        for (Poligono faccia : facce) {
            area += faccia.calcolaArea();
        }
        return area;
    }

    protected boolean verificaNumFacceVertici() { //Verifica che ogni vertice appartiene allo stesso numero di facce, viva le strutture dati
        Map<Punto, Integer> contoFacce = new HashMap<>();
        for (Poligono faccia : facce) {
            Set<Punto> verticiFaccia = new HashSet<>();
            for (Segmento s : faccia.getLati()) {
                verticiFaccia.add(s.getInizio());
                verticiFaccia.add(s.getFine());
            }
            for (Punto v : verticiFaccia) {
                contoFacce.put(v, contoFacce.getOrDefault(v, 0) + 1);
            }
        }

        if (contoFacce.isEmpty()) { //Non dovrebbe nemmeno essere possibile creare un solido vuoto, ma si sa mai
            return false;
        }

        Iterator<Integer> counts = contoFacce.values().iterator();
        int firstCount = counts.next();
        while (counts.hasNext()) {
            if (counts.next() != firstCount) {
                return false;
            }
        }

        return true;
    }

    public boolean facceUguali() {
        Poligono base = facce[0];
        for (Poligono faccia : facce) {
            if (!faccia.equals(base)) {
                return false;
            }
        }
        return true;
    }

    public boolean facceStessoTipo() {
        String base = facce[0].classifica();
        for (Poligono faccia : facce) {
            if (faccia.classifica() != base) {
                return false;
            }
        }
        return true;
    }

    public boolean isRegolare() {
        if (!facce[0].isRegolare()) {
            return false;
        }
        if (!facceUguali()){
            return false;
        }
        if (!verificaNumFacceVertici()) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return getClass().getName().substring(17) + ":\nTipo: " + classifica() + "\nNumero facce: " + numFacce + "\nArea: " + calcolaArea() + "\nRegolare: " + isRegolare();
    }
}