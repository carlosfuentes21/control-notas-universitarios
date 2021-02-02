package listas;

import astraccion.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class l_asignatura {

    asignatura cab;
    private DefaultTableModel model;

    public void crear() {
        this.cab = null;
    }

    public asignatura retunrcab() {
        return this.cab;
    }

    public boolean vacia() {
        if (this.cab == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(asignatura a) {
        if (this.cab == null) {
            cab = a;
        } else {
            asignatura p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
        }
    }

    public void ins_asig(asignatura a) {
        if (this.cab == null) {
            cab = a;
            JOptionPane.showMessageDialog(null, "ASIGNATURA REGISTRADA");
        } else {
            asignatura p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
            JOptionPane.showMessageDialog(null, "ASIGNATURA REGISTRADA");
        }
    }

    public asignatura buscar(String cod) {
        if (!vacia()) {
            if (cab.getCod().equals(cod)) {
                JOptionPane.showMessageDialog(null, "ASIGNATURA ENCONTRADA");
                return cab;
            } else {
                asignatura p = cab;
                while (p != null) {
                    if (p.getCod().equals(cod)) {
                        JOptionPane.showMessageDialog(null, "ASIGNATURA ENCONTRADA");
                        return p;
                    }
                    p = p.sig;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "ASIGNATURA NO ENCONTRADA");
        return null;
    }

    public asignatura buscar2(String cod) {
        if (!vacia()) {
            if (cab.getCod().equals(cod)) {
                return cab;
            } else {
                asignatura p = cab;
                while (p != null) {
                    if (p.getCod().equals(cod)) {
                        return p;
                    }
                    p = p.sig;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "ASIGNATURA NO ENCONTRADA");
        return null;
    }

    public void borrar(String cod) {
        asignatura p = this.cab;
        if (!vacia()) {
            asignatura aux = this.buscar(cod);
            if (cab.getCod().equals(cod)) {
                cab = cab.sig;
                JOptionPane.showMessageDialog(null, "ASIGNATURA BORRADA");
            } else {
                while (p.sig != null) {
                    if (p.sig.getCod() == cod) {
                        p.sig = p.sig.sig;
                        JOptionPane.showMessageDialog(null, "ASIGNATURA BORRADA");
                    }
                    p = p.sig;
                }
            }
        }
    }

    public void modificar(String nombre, String cod, programa p) {
        if (!vacia()) {
            asignatura aux = this.buscar(cod);

            aux.setNom(nombre);
            aux.setCod(cod);
            aux.setProg(p);

            JOptionPane.showMessageDialog(null, "ASIGNATURA MODIFICADA");
        } else {
            JOptionPane.showMessageDialog(null, "ASIGNATURA NO MODIFICADA");
        }
    }

    public void cargar(JTable a) {
        // Creamos un objeto Table con el molde del nuestro
        String data[][] = {};
        String col[] = {"NOMBRE", "CODIGO"};
        model = new DefaultTableModel(data, col);
        asignatura d = cab;
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
        asignatura c = this.cab;
        String cadena = "NOMBRE" + "\t" + "CODIGO" + "\t" + "PROGRAMA" + "\t" + "ESTADO" + "\n";
        if (!vacia()) {
            while (c != null) {
                cadena += c.getNom() + "\t" + c.getCod() + "\t" + c.getProg().getCod() + "-" + c.getProg().getNom()
                        + "\t" + c.getEst() + "\n";
                c = c.sig;
            }
        }
        return cadena;
    }

    public void cargarasignatura(JComboBox a) {
        asignatura p = cab;
        while (p != null) {
            a.addItem(p.getCod().trim() + "-" + p.getNom().trim());
            p = p.sig;
        }
    }

    public void cargarasignaturaest(JComboBox a) {
        asignatura p = cab;
        while (p != null) {
            if (p.getEst().equals("activa")) {
                a.addItem(p.getCod().trim() + "-" + p.getNom().trim());
            }
            p = p.sig;
        }
    }
    public void cargarasignaturaPROF(JComboBox a,String doc) {
        asignatura p = cab;
        while (p != null) {
            if (p.getP().getDoc().equals(doc)) {
                a.addItem(p.getCod().trim() + "-" + p.getNom().trim());
            }
            p = p.sig;
        }
    }

    public void cargarasignaturafacultad(JTable a, facultad f) {
        // Creamos un objeto Table con el molde del nuestro
        String data[][] = {};
        String col[] = {"NOMBRE", "CODIGO", "FACULTAD", "PROGRAMA"};
        model = new DefaultTableModel(data, col);
        asignatura d = cab;
        //************************************
        if (!vacia()) {
            while (d != null) {
                if (f.getCod().equals(d.getProg().getFac().getCod())) {
                    Object[] fila = new Object[4];

                    fila[0] = d.getNom();
                    fila[1] = d.getCod();
                    fila[2] = d.getProg().getFac().getNom();
                    fila[3] = d.getProg().getNom();

                    model.addRow(fila);
                }
                d = d.sig;
            }
            a.setModel(model);
        }
    }

    public void cargarasignaturaprograma(JTable a, programa p) {
        // Creamos un objeto Table con el molde del nuestro
        String data[][] = {};
        String col[] = {"NOMBRE", "CODIGO", "FACULTAD", "PROGRAMA"};
        model = new DefaultTableModel(data, col);
        asignatura d = cab;

        //************************************
        if (!vacia()) {
            while (d != null) {
                if (p.getCod().equals(d.getProg().getCod())) {
                    Object[] fila = new Object[4];

                    fila[0] = d.getNom();
                    fila[1] = d.getCod();
                    fila[2] = d.getProg().getFac().getNom();
                    fila[3] = d.getProg().getNom();

                    model.addRow(fila);

                }
                d = d.sig;
            }
            a.setModel(model);
        }
    }

    public void mostrarprogramas(String codf, JComboBox prog, l_programa lp) {

        prog.removeAllItems();
        programa aux = lp.retunrcab();
        prog.addItem("Todos los alumnos");
        while (aux != null) {
            if (aux.getFac().getCod().equals(codf)) {
                System.out.println("entro");
                prog.addItem(aux.getCod() + "-" + aux.getNom());
            }
            aux = aux.sig;
        }
    }

    public void docentefacultad(JTable t, JComboBox prog, String b, l_facultad lf, l_programa lp) {
        if (b.equals("Todos los alumnos")) {
            cargar(t);
            prog.removeAllItems();
        } else {
            facultad f = lf.buscar(b);
            mostrarprogramas(b, prog, lp);
            cargarasignaturafacultad(t, f);

        }
    }

    public void docenteprograma(JTable t, JComboBox prog, String b, l_programa lp, String codf, l_facultad lf) {
        if (b.equals("Todos los alumnos")) {
            facultad f = lf.retunrcab();
            cargarasignaturafacultad(t, f);
        } else {
            programa p = lp.buscarinicio(b);
            cargarasignaturaprograma(t, p);
        }
    }

    public void verasigdoc(JTable a, String b) {
        String data[][] = {};
        String col[] = {"CODIGO", "NOMBRE"};
        model = new DefaultTableModel(data, col);
        asignatura d = cab;
        if (!vacia()) {
            while (d != null) {
                if (d.getP().getDoc().equals(b)) {
                    Object[] fila = new Object[2];

                    fila[0] = d.getNom();
                    fila[1] = d.getCod();
                    model.addRow(fila);
                }
                d = d.sig;
            }
            a.setModel(model);
        }
    }
}
