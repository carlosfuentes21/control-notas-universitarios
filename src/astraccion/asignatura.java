package astraccion;

public class asignatura {

    private String cod, nom, est;
    public programa prog;
    public profesor p;
    public asignatura sig;

    public asignatura(String cod, String nom, programa prog, profesor p, String est) {
        this.cod = cod;
        this.nom = nom;
        this.prog = prog;
        this.p = p;
        this.est = est;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public programa getProg() {
        return prog;
    }

    public void setProg(programa prog) {
        this.prog = prog;
    }

    public profesor getP() {
        return p;
    }

    public void setP(profesor p) {
        this.p = p;
    }

    public String getEst() {
        return est;
    }

    public void setEts(String est) {
        this.est = est;
    }
}
