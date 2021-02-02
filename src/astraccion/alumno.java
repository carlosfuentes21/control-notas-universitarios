package astraccion;

public class alumno {

    private String doc, nom, ape, sexo, est, semestre;
    public programa pro;
    public facultad fac;
    public alumno sig;

    public alumno(String nom, String ape, String doc, String sexo, facultad fac, programa pro, String est, String semestre) {
        this.doc = doc;
        this.nom = nom;
        this.ape = ape;
        this.sexo = sexo;
        this.pro = pro;
        this.fac = fac;
        this.est = est;
        this.semestre = semestre;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getest() {
        return est;
    }

    public void setest(String est) {
        this.est = est;
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

    public programa getPro() {
        return pro;
    }

    public void setPro(programa pro) {
        this.pro = pro;
    }

    public facultad getFac() {
        return fac;
    }

    public void setFac(facultad fac) {
        this.fac = fac;
    }

    public String getSem() {
        return semestre;
    }

    public void setSem(String semestre) {
        this.semestre = semestre;
    }

}
