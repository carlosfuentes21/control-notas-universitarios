package astraccion;

import listas.l_detalle_profesor;

public class profesor {

    private String doc, nom, ape, sexo, est;
    public programa p;
    public profesor sig;

    public profesor(String doc, String nom, String ape, String sexo, String est, programa p) {
        this.doc = doc;
        this.nom = nom;
        this.ape = ape;
        this.sexo = sexo;
        this.est = est;
        this.p = p;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }

    public programa getP() {
        return p;
    }

    public void setP(programa p) {
        this.p = p;
    }

}
