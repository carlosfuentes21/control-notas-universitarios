package listas;

import astraccion.detalle_asig;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class l_detalle_alumno {

    detalle_asig cab;
    l_nota_semestre nt = new l_nota_semestre();
    private DefaultTableModel model;

    public void crear() {
        this.cab = null;
    }

    public detalle_asig retunrcab() {
        return this.cab;
    }

    public boolean vacia() {
        if (this.cab == null) {
            return true;
        } else {
            return false;
        }
    }

    public int tamaño() {
        int n = 0;
        if (!vacia()) {
            detalle_asig p = cab;
            while (p != null) {
                n++;
                p = p.sig;
            }
        }
        return n;
    }

    public void insertar(detalle_asig a) {
        if (this.cab == null) {
            cab = a;
        } else {
            detalle_asig p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
        }
    }

    public void ins_asig(detalle_asig a) {
        if (this.cab == null) {
            cab = a;
            JOptionPane.showMessageDialog(null, "NOTA REGISTRADA");
        } else {
            detalle_asig p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
            JOptionPane.showMessageDialog(null, "NOTA REGISTRADA");
        }
    }

    public detalle_asig buscar(String cod) {
        if (!vacia()) {
            if (cab.getAsig().getCod().equals(cod)) {
                JOptionPane.showMessageDialog(null, "NOTA ENCONTRADA");
                return cab;
            } else {
                detalle_asig p = cab;
                while (p != null) {
                    if (p.getAsig().getCod().equals(cod)) {
                        JOptionPane.showMessageDialog(null, "NOTA ENCONTRADA");
                        return p;
                    }
                    p = p.sig;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "NOTA NO ENCONTRADA");
        return null;
    }

    public detalle_asig buscar2(String cod) {
        if (!vacia()) {
            if (cab.getAsig().getCod().equals(cod)) {
                return cab;
            } else {
                detalle_asig p = cab;
                while (p != null) {
                    if (p.getAsig().getCod().equals(cod)) {
                        return p;
                    }
                    p = p.sig;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "NOTA NO ENCONTRADA");
        return null;
    }

    public void borrar(String cod) {
        detalle_asig p = this.cab;
        if (!vacia()) {
            detalle_asig aux = this.buscar(cod);
            if (cab.getAsig().getCod().equals(cod)) {
                cab = cab.sig;
                JOptionPane.showMessageDialog(null, "ASIGNAURA BORRADA");
            } else {
                while (p.sig != null) {
                    if (p.sig.getAsig().getCod() == cod) {
                        p.sig = p.sig.sig;
                        JOptionPane.showMessageDialog(null, "ASIGNATURA BORRADA");
                    }
                    p = p.sig;
                }
            }
        }
    }

//    public void modificar(detalle_asig a, String not) {
//        if (!vacia()) {
//            detalle_asig aux = this.buscar(a.getAsig().getCod());
//
//            //aux.setAsig(a);
//            aux.setDef(not);
//
//            JOptionPane.showMessageDialog(null, "ASIGNATURA MODIFICADA");
//        } else {
//            JOptionPane.showMessageDialog(null, "ASIGNATURA NO MODIFICADA");
//        }
//    }
//
//    public void cargar(JTable a) {
//        // Creamos un objeto Table con el molde del nuestro
//        String data[][] = {};
//        String col[] = {"NOMBRE", "CODIGO"};
//        model = new DefaultTableModel(data, col);
//        asignatura d = cab;
//        //************************************
//        if (!vacia()) {
//            while (d != null) {
//                Object[] fila = new Object[2];
//
//                fila[0] = d.getNom();
//                fila[1] = d.getCod();
//
//                model.addRow(fila);
//                d = d.sig;
//            }
//            a.setModel(model);
//        }
//    }
//
//    public String imprimir() {
//        asignatura c = this.cab;
//        String cadena = "NOMBRE" + "\t" + "CODIGO" + "\n";
//        if (!vacia()) {
//            while (c != null) {
//                cadena += c.getNom() + "\t" + c.getCod() + "\n";
//                c = c.sig;
//            }
//        }
//        return cadena;
//    }
//
//    public void cargarasignatura(JComboBox a) {
//        asignatura p = cab;
//        while (p != null) {
//            a.addItem(p.getCod().trim() + "-" + p.getNom().trim());
//            p = p.sig;
//        }
//    }
}
