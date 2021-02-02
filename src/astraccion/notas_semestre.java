package astraccion;

import listas.l_detalle_alumno;

public class notas_semestre {

    private String sem_año, semestre, promedio;
    public alumno a;
    public l_detalle_alumno ld = new l_detalle_alumno();
    public notas_semestre sig;

    public notas_semestre(String sem_año, String semestre, String promedio, alumno a) {
        this.sem_año = sem_año;
        this.semestre = semestre;
        this.promedio = promedio;
        this.a = a;
    }

    public String getSem_año() {
        return sem_año;
    }

    public void setSem_año(String sem_año) {
        this.sem_año = sem_año;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }

    public alumno getA() {
        return a;
    }

    public void setA(alumno a) {
        this.a = a;
    }

    public l_detalle_alumno getLd() {
        return ld;
    }

    public void setLd(l_detalle_alumno ld) {
        this.ld = ld;
    }

    

}
