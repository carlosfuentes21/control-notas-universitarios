package listas;

import astraccion.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class l_facultad {

    facultad cab;
    private DefaultTableModel model;

    public void crear() {
        this.cab = null;
    }

    public facultad retunrcab() {
        return this.cab;
    }

    public boolean vacia() {
        if (this.cab == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(facultad a) {
        if (this.cab == null) {
            cab = a;
        } else {
            facultad p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
        }
    }

    public void ins_fac(facultad a) {
        if (this.cab == null) {
            cab = a;
            JOptionPane.showMessageDialog(null, "FACULTAD REGISTRADA");
        } else {
            facultad p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
            JOptionPane.showMessageDialog(null, "FACULTAD REGISTRADA");
        }
    }

    public facultad buscar(String cod) {
        if (!vacia()) {
            if (cab.getCod().equals(cod)) {
                JOptionPane.showMessageDialog(null, "FACULTAD ENCONTRADA");
                return cab;
            } else {
                facultad p = cab;
                while (p != null) {
                    if (p.getCod().equals(cod)) {
                        JOptionPane.showMessageDialog(null, "FACULTAD ENCONTRADA");
                        return p;
                    }
                    p = p.sig;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "FACULTAD NO ENCONTRADA");
        return null;
    }

    public facultad buscarinicio(String cod) {
        if (!vacia()) {
            if (cab.getCod().equals(cod)) {
                return cab;
            } else {
                facultad p = cab;
                while (p != null) {
                    if (p.getCod().equals(cod)) {
                        return p;
                    }
                    p = p.sig;
                }
            }
        }
        return null;
    }

    public void borrar(String cod) {
        facultad p = this.cab;
        if (!vacia()) {
            facultad aux = this.buscar(cod);
            if (cab.getCod().equals(cod)) {
                cab = cab.sig;
                JOptionPane.showMessageDialog(null, "FACULTAD BORRADA");
            } else {
                while (p.sig != null) {
                    if (p.sig.getCod() == cod) {
                        p.sig = p.sig.sig;
                        JOptionPane.showMessageDialog(null, "FACULTAD BORRADA");
                    }
                    p = p.sig;
                }
            }
        }
    }

    public void modificar(String nombre, String cod) {
        if (!vacia()) {
            facultad aux = this.buscar(cod);

            aux.setNom(nombre);
            aux.setCod(cod);

            JOptionPane.showMessageDialog(null, "FACULTAD MODIFICADA");
        } else {
            JOptionPane.showMessageDialog(null, "FACULTAD NO MODIFICADA");
        }
    }

    public void cargar(JTable a) {
        // Creamos un objeto Table con el molde del nuestro
        String data[][] = {};
        String col[] = {"NOMBRE", "CODIGO"};
        model = new DefaultTableModel(data, col);
        facultad d = cab;
        //************************************
        if (!vacia()) {
            while (d != null) {
                Object[] fila = new Object[2];

                fila[0] = d.getNom();
                fila[1] = d.getCod();

                model.addRow(fila);
                d = d.sig;
            }
            a.setModel(model);
        }
    }
    public void cargarfacultad(JTable a,String e) {
        // Creamos un objeto Table con el molde del nuestro
        String data[][] = {};
        String col[] = {"NOMBRE", "CODIGO"};
        model = new DefaultTableModel(data, col);
        facultad d = cab;
        //************************************
        if (!vacia()) {
            while (d != null) {
                Object[] fila = new Object[2];

                fila[0] = d.getNom();
                fila[1] = d.getCod();

                model.addRow(fila);
                d = d.sig;
            }
            a.setModel(model);
        }
    }

    public String imprimir() {
        facultad c = this.cab;
        String cadena = "NOMBRE" + "\t" + "CODIGO" + "\n";
        if (!vacia()) {
            while (c != null) {
                cadena += c.getNom() + "\t" + c.getCod() + "\n";
                c = c.sig;
            }
        }
        return cadena;
    }

    public void cargarfacultad(JComboBox a) {
        facultad p = cab;

        while (p != null) {
            a.addItem(p.getCod().trim() + "-" + p.getNom().trim());
            p = p.sig;
        }
    }

    public void cargarfacultad2(JComboBox a) {
        facultad p = cab;
        a.addItem("Todos los alumnos");
        while (p != null) {
            a.addItem(p.getCod().trim() + "-" + p.getNom().trim());
            p = p.sig;
        }
    }

    

}
