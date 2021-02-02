package astraccion;

import listas.l_detalle_profesor;

public class asignaturas_del_profesor {

    public profesor p;
    public l_detalle_profesor ldp = new l_detalle_profesor();
    public asignaturas_del_profesor sig;

    public asignaturas_del_profesor(profesor p) {
        this.p = p;
    }

    public profesor getP() {
        return p;
    }

    public void setP(profesor p) {
        this.p = p;
    }

    public l_detalle_profesor getLdp() {
        return ldp;
    }

    public void setLdp(l_detalle_profesor ldp) {
        this.ldp = ldp;
    }

}
