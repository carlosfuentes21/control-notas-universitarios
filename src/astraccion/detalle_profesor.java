package astraccion;

public class detalle_profesor {

    public asignatura a;
    public detalle_profesor sig;

    public detalle_profesor(asignatura a) {
        this.a = a;
    }

    public asignatura getA() {
        return a;
    }

    public void setA(asignatura a) {
        this.a = a;
    }

}
