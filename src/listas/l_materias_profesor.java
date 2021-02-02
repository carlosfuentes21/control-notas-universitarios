package listas;

import astraccion.alumno;
import astraccion.asignaturas_del_profesor;
import astraccion.detalle_asig;
import astraccion.detalle_profesor;
import astraccion.notas_semestre;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class l_materias_profesor {

    asignaturas_del_profesor cab;
    public int size;
    private DefaultTableModel model;

    public void crear() {
        this.cab = null;
    }

    public asignaturas_del_profesor retunrcab() {
        return this.cab;
    }

    public int tamaño() {
        int n = 0;
        if (!vacia()) {
            asignaturas_del_profesor p = cab;
            while (p != null) {
                n++;
                p = p.sig;
            }
        }
        return n;
    }

    public boolean vacia() {
        if (this.cab == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(asignaturas_del_profesor a) {
        if (this.cab == null) {
            cab = a;
            size++;
        } else {
            asignaturas_del_profesor p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
            size++;
        }
    }

    public void ins_notas(asignaturas_del_profesor a) {
        if (this.cab == null) {
            cab = a;
            size++;
            JOptionPane.showMessageDialog(null, "NOTA REGISTRADA");
        } else {
            asignaturas_del_profesor p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
            size++;
            JOptionPane.showMessageDialog(null, "NOTA REGISTRADA");
        }
    }

    public void cargar(JTable a, String b) {
        String data[][] = {};
        String col[] = {"ASIGNATURA", "CODIGO"};
        model = new DefaultTableModel(data, col);
        asignaturas_del_profesor d = this.cab;
        //************************************
        if (!vacia()) {
            while (d != null) {
                if (d.getP().getDoc().equals(b)) {
                    detalle_profesor q = d.getLdp().retunrcab();
                    while (q != null) {
                        Object[] fila = new Object[2];
                        fila[0] = q.getA().getNom();
                        fila[1] = q.getA().getCod();
                        model.addRow(fila);
                        q = q.sig;
                    }
                    a.setModel(model);
                }
                d = d.sig;
            }
        }
    }
}
