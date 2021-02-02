package astraccion;

public class facultad {

    private String cod, nom;
    public facultad sig;

    public facultad(String nom, String cod) {
        this.cod = cod;
        this.nom = nom;
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

}
