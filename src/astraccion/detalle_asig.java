package astraccion;

public class detalle_asig {

    public asignatura asig;
    private String def;
    public detalle_asig sig;

    public detalle_asig(asignatura asig, String def) {
        this.asig = asig;
        this.def = def;
    }

    public asignatura getAsig() {
        return asig;
    }

    public void setAsig(asignatura asig) {
        this.asig = asig;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }
}
