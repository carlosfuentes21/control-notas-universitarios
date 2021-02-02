
package listas;

import astraccion.alumno;
import astraccion.asignaturas_del_profesor;
import astraccion.detalle_asig;
import astraccion.detalle_profesor;
import astraccion.notas_semestre;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class l_detalle_profesor {
    detalle_profesor cab;
    public int size;
    private DefaultTableModel model;

    public void crear() {
        this.cab = null;
    }

    public detalle_profesor retunrcab() {
        return this.cab;
    }

    public int tamaño() {
        int n = 0;
        if (!vacia()) {
            detalle_profesor p = cab;
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

    public void insertar(detalle_profesor a) {
        if (this.cab == null) {
            cab = a;
            size++;
        } else {
            detalle_profesor p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
            size++;
        }
    }

    public void ins_notas(detalle_profesor a) {
        if (this.cab == null) {
            cab = a;
            size++;
            JOptionPane.showMessageDialog(null, "LA ASIGNATURA SE LE ASIGNO AL DOCENTE");
        } else {
            detalle_profesor p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
            size++;
            JOptionPane.showMessageDialog(null, "LA ASIGNATURA SE LE ASIGNO AL DOCENTE");
        }
    }

    

//    public void cargar2(JTable a, alumno b) {
//        String data[][] = {};
//        String col[] = {"CODIGO", "ASIGNATURA"};
//        model = new DefaultTableModel(data, col);
//        detalle_profesor d = this.cab;
//
//        //************************************
//        if (!vacia()) {
//            while (d != null) {
//                if (d.getA().getDoc().equals(b.getDoc())) {
//                    detalle_asig q = d.getLd().retunrcab();
//
//                    while (q != null) {
//                        Object[] fila = new Object[2];
//                        fila[0] = q.getAsig().getCod();
//                        fila[1] = q.getAsig().getNom();
//                        model.addRow(fila);
//                        q = q.sig;
//                    }
//                    a.setModel(model);
//                }
//                d = d.sig;
//            }
//        }
//    }
}
