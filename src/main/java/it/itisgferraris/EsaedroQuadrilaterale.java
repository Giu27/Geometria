package it.itisgferraris;

public class EsaedroQuadrilaterale extends Solido{ //Un esaedro ha 6 facce, le piramidi incollate una sull'altra o altre simili eccezioni vanno gestite separatemente vista la loro specificità
    public EsaedroQuadrilaterale(Punto[] vertici) throws Exception{
        numFacce = 6;
        facce = new Poligono[numFacce];
        numVertici = vertici.length;
        numSpigoli = numFacce + numVertici - 2;
        if (numSpigoli <= 0 || numSpigoli > 12) {
            throw new Exception("Numero di vertici non valido!");
        } //Hard coded, lo so, ma generalizzare i solidi è maledettamente più difficile dei poligoni piani
        facce[0] = new Quadrilatero(new Punto[]{vertici[0],vertici[1],vertici[2],vertici[3]});
        facce[1] = new Quadrilatero(new Punto[]{vertici[0],vertici[1],vertici[4],vertici[5]});
        facce[2] = new Quadrilatero(new Punto[]{vertici[1],vertici[2],vertici[6],vertici[4]});
        facce[3] = new Quadrilatero(new Punto[]{vertici[3],vertici[2],vertici[6],vertici[7]});
        facce[4] = new Quadrilatero(new Punto[]{vertici[3],vertici[0],vertici[5],vertici[7]});
        facce[5] = new Quadrilatero(new Punto[]{vertici[5],vertici[4],vertici[6],vertici[7]});
    }

    public String classifica() {
        if (isRegolare()) {
            return "Cubo";
        }
        if (tuttiAngoliRetti() && (facce[0].classifica() == "Quadrato" || facce[0].classifica() == "Rettangolo")) {
            return "Parallelepipedo Rettangolo";
        }
        if (facceStessoTipo() && facce[0].classifica() == "Parallelogramma") {
            return "Parallelepipedo";
        }
        if (facceUguali() && facce[0].classifica() == "Rombo") {
            return "Romboedro";
        }
        if (tuttiAngoliRetti()) {
            return "Prisma Retto";
        }
        if (facceLateraliStessoTipo() && facceBasiStessoTipo() && facce[1].classifica() == "Parallelogramma") {
            return "Prisma Obliquo";
        }
        if (facceLateraliStessoTipo() && facceBasiStessoTipo() && facce[1].classifica() == "Trapezio") {
            return "Tronco di Piramide";
        }
        return "Generico/altro"; 
    }

    public double calcolaVolume() {
        String tipo = classifica();
        try {
            if (tipo == "Cubo") {
                return facce[0].calcolaArea() * facce[0].getLato(0);
            }
            if (tipo == "Parallelepipedo Rettangolo" || tipo == "Prisma Retto") {
                return facce[0].calcolaArea() * facce[1].getLato(1);
            }
            if (tipo == "Romboedro" || tipo == "Prisma Obliquo" || tipo == "Parallelepipedo") {
                return facce[0].calcolaArea() * new Vettore(new Punto(0,0, facce[1].getLati()[1].getFine().deltaZ(facce[1].getLati()[1].getInizio()))).magnitudo();
            }
            if (tipo == "Tronco di Piramide") {
                return new Vettore(new Punto(0,0, facce[1].getLati()[1].getFine().deltaZ(facce[1].getLati()[1].getInizio()))).magnitudo() / 3 * (facce[0].calcolaArea() + facce[5].calcolaArea() + Math.sqrt(facce[0].calcolaArea() * facce[5].calcolaArea()));
            }
        } catch (Exception e) {
                System.out.println("Qualcosa è andato molto storto");
            }
        return -1;
    }

    public boolean facceLateraliStessoTipo() {
        String base = facce[1].classifica();
        for (int i = 2; i < facce.length - 1; i++) {
            if (facce[i].classifica() != base) {
                return false;
            }
        }
        return true;
    }

    public boolean facceBasiStessoTipo() {
        return facce[0].classifica() == facce[5].classifica();
    }

    public boolean tuttiAngoliRetti() {
        Object[] verticiBase0 = facce[0].getVertici();
        Object[] verticiBase5 = facce[5].getVertici();
        for (int i = 0; i < verticiBase0.length; i++) {
            Punto a = (Punto)verticiBase0[i];
            Punto b = (Punto)verticiBase5[i];
            if (a.deltaX(b) != 0) {
                return false;
            }
            if (a.deltaY(b) != 0) {
                return false;
            }
            if (a.deltaZ(b) == 0) {
                return false;
            }
        }
        return true;
    }
}