package listas;

import astraccion.facultad;
import astraccion.programa;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class l_programa {

    programa cab;
    private DefaultTableModel model;

    public void crear() {
        this.cab = null;
    }

    public programa retunrcab() {
        return this.cab;
    }

    public boolean vacia() {
        if (this.cab == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(programa a) {
        if (this.cab == null) {
            cab = a;
        } else {
            programa p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
        }
    }

    public void ins_fac(programa a) {
        if (this.cab == null) {
            cab = a;
            JOptionPane.showMessageDialog(null, "PROGRAMA REGISTRADO");
        } else {
            programa p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
            JOptionPane.showMessageDialog(null, "PROGRAMA REGISTRADO");
        }
    }

    public programa buscar(String cod) {
        if (!vacia()) {
            if (cab.getCod().equals(cod)) {
                JOptionPane.showMessageDialog(null, "PROGRAMA ENCONTRADO");
                return cab;
            } else {
                programa p = cab;
                while (p != null) {
                    if (p.getCod().equals(cod)) {
                        JOptionPane.showMessageDialog(null, "PROGRAMA ENCONTRADO");
                        return p;
                    }
                    p = p.sig;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "PROGRAMA NO ENCONTRADO");
        return null;
    }

    public programa buscarinicio(String cod) {
        if (!vacia()) {
            if (cab.getCod().equals(cod)) {
                return cab;
            } else {
                programa p = cab;
                while (p != null) {
                    if (p.getCod().equals(cod)) {
                        return p;
                    }
                    p = p.sig;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "PROGRAMA NO ENCONTRADO");
        return null;
    }

    public void borrar(String cod) {
        programa p = this.cab;
        if (!vacia()) {
            programa aux = this.buscar(cod);
            if (cab.getCod().equals(cod)) {
                cab = cab.sig;
                JOptionPane.showMessageDialog(null, "PROGRAMA BORRADO");
            } else {
                while (p.sig != null) {
                    if (p.sig.getCod() == cod) {
                        p.sig = p.sig.sig;
                        JOptionPane.showMessageDialog(null, "PROGRAMA BORRADO");
                    }
                    p = p.sig;
                }
            }
        }
    }

    public void modificar(String nombre, String cod, facultad f,String a) {
        if (!vacia()) {
            programa aux = this.buscar(a);

            aux.setNom(nombre);
            aux.setCod(cod);
            aux.setFac(f);

            JOptionPane.showMessageDialog(null, "RPOGRAMA MODIFICADO");
        } else {
            JOptionPane.showMessageDialog(null, "PROGRAMA NO MODIFICADO");
        }
    }

    public void cargar(JTable a) {
        // Creamos un objeto Table con el molde del nuestro
        String data[][] = {};
        String col[] = {"NOMBRE", "CODIGO", "FACULTAD"};
        model = new DefaultTableModel(data, col);
        programa d = cab;
        //************************************
        if (!vacia()) {
            while (d != null) {
                Object[] fila = new Object[3];

                fila[0] = d.getNom();
                fila[1] = d.getCod();
                fila[2] = d.getFac().getNom();

                model.addRow(fila);
                d = d.sig;
            }
            a.setModel(model);
        }
    }

    public String imprimir() {
        programa c = this.cab;
        String cadena = "NOMBRE" + "\t" + "CODIGO" + "\t" + "FACULTAD" + "\n";
        if (!vacia()) {
            while (c != null) {
                cadena += c.getNom() + "\t" + c.getCod() + "\t" + c.getFac().getCod() + "-" + c.getFac().getNom() + "\n";
                c = c.sig;
            }
        }
        return cadena;
    }

    public void cargarprograma(JComboBox a) {
        programa p = cab;
        while (p != null) {
            a.addItem(p.getCod().trim() + "-" + p.getNom().trim());
            p = p.sig;
        }
    }
    public void cargarprograma2(JComboBox a) {
        programa p = cab;
        a.addItem("Todos los alumnos");
        while (p != null) {
            a.addItem(p.getCod().trim() + "-" + p.getNom().trim());
            p = p.sig;
        }
    }
}
