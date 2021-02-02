package listas;

import astraccion.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class l_alumno {

    alumno cab;

    private DefaultTableModel model;

    public void crear() {
        this.cab = null;
    }

    public alumno retunrcab() {
        return this.cab;
    }

    public boolean vacia() {
        if (this.cab == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(alumno a) {
        if (this.cab == null) {
            cab = a;
        } else {
            alumno p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
        }
    }

    public void ins_alum(alumno a) {
        if (this.cab == null) {
            cab = a;
            JOptionPane.showMessageDialog(null, "EL ALUMNO FUE MATRICULADO");
        } else {
            alumno p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
            JOptionPane.showMessageDialog(null, "EL ALUMNO FUE MATRICULADO");
        }
    }

    public alumno buscar(String doc) {
        if (!vacia()) {
            if (cab.getDoc().equals(doc)) {
                JOptionPane.showMessageDialog(null, "EL ALUMNO FUE ENCONTRADO");
                return cab;
            } else {
                alumno p = cab;
                while (p != null) {
                    if (p.getDoc().equals(doc)) {
                        JOptionPane.showMessageDialog(null, "EL ALUMNO FUE ENCONTRADO");
                        return p;
                    }
                    p = p.sig;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "EL ALUMNO NO FUE ENCONTRADO");
        return null;
    }

    public alumno buscarinicio(String doc) {
        if (!vacia()) {
            if (cab.getDoc().equals(doc)) {
                return cab;
            } else {
                alumno p = cab;
                while (p != null) {
                    if (p.getDoc().equals(doc)) {
                        return p;
                    }
                    p = p.sig;
                }
            }
        }
        return null;
    }

    public void borrar(String doc) {
        alumno p = this.cab;
        if (!vacia()) {
            alumno aux = this.buscar(doc);
            if (cab.getDoc().equals(doc)) {
                cab = cab.sig;
                JOptionPane.showMessageDialog(null, "EL ALUMNO FUE BORRADO");
            } else {
                while (p.sig != null) {
                    if (p.sig.getDoc() == doc) {
                        p.sig = p.sig.sig;
                        JOptionPane.showMessageDialog(null, "EL ALUMNO FUE BORRADO");
                    }
                    p = p.sig;
                }
            }
        }
    }

    public void modificar(String nombre, String apellido, String doc, String sexo, facultad fac, programa pro) {
        if (!vacia()) {
            alumno aux = this.buscar(doc);

            aux.setNom(nombre);
            aux.setApe(apellido);
            aux.setDoc(doc);
            aux.setPro(pro);
            aux.setFac(fac);
            JOptionPane.showMessageDialog(null, "EL ALUMNO FUE MODIFICADO");
        } else {
            JOptionPane.showMessageDialog(null, "EL ALUMNO NO FUE MODIFICADO");
        }
    }

    public void cargar(JTable a) {
        // Creamos un objeto Table con el molde del nuestro
        String data[][] = {};
        String col[] = {"NOMBRE", "APELLIDO", "DOCUMENTO", "SEXO", "FACULTAD", "PROGRAMA"};
        model = new DefaultTableModel(data, col);
        alumno d = cab;
        //************************************
        if (!vacia()) {
            while (d != null) {
                if (d.getest().equals("activo")) {
                    Object[] fila = new Object[6];

                    fila[0] = d.getNom();
                    fila[1] = d.getApe();
                    fila[2] = d.getDoc();
                    fila[3] = d.getSexo();
                    fila[4] = d.getFac().getNom();
                    fila[5] = d.getPro().getNom();

                    model.addRow(fila);

                }
                d = d.sig;
            }
            a.setModel(model);
        }
    }

    public void cargaralumnofacultad(JTable a, facultad f) {
        // Creamos un objeto Table con el molde del nuestro
        String data[][] = {};
        String col[] = {"NOMBRE", "APELLIDO", "DOCUMENTO", "SEXO", "FACULTAD", "PROGRAMA"};
        model = new DefaultTableModel(data, col);
        alumno d = cab;
        //************************************
        if (!vacia()) {
            while (d != null) {
                if (d.getest().equals("activo") && f.getCod().equals(d.getFac().getCod())) {
                    Object[] fila = new Object[6];

                    fila[0] = d.getNom();
                    fila[1] = d.getApe();
                    fila[2] = d.getDoc();
                    fila[3] = d.getSexo();
                    fila[4] = d.getFac().getNom();
                    fila[5] = d.getPro().getNom();

                    model.addRow(fila);
                }
                d = d.sig;
            }
            a.setModel(model);
        }
    }

    public void cargaralumnoprograma(JTable a, programa p) {
        // Creamos un objeto Table con el molde del nuestro
        String data[][] = {};
        String col[] = {"NOMBRE", "APELLIDO", "DOCUMENTO", "SEXO", "FACULTAD", "PROGRAMA"};
        model = new DefaultTableModel(data, col);
        alumno d = cab;

        //************************************
        if (!vacia()) {
            while (d != null) {
                if (d.getest().equals("activo") && p.getCod().equals(d.getPro().getCod())) {
                    Object[] fila = new Object[6];

                    fila[0] = d.getNom();
                    fila[1] = d.getApe();
                    fila[2] = d.getDoc();
                    fila[3] = d.getSexo();
                    fila[4] = d.getFac().getNom();
                    fila[5] = d.getPro().getNom();

                    model.addRow(fila);

                }
                d = d.sig;
            }
            a.setModel(model);
        }
    }

    public String imprimir() {
        alumno c = this.cab;
        String cadena = "NOMBRE" + "\t" + "APELLIDO" + "\t" + "DOCUMENTO"
                + "\t" + "SEXO" + "\t" + "FACULTAD" + "\t" + "PROGRARMA" + "\t" + "ESTADO" + "\t" + "SEMESTRE" + "\n";
        if (!vacia()) {
            while (c != null) {
                cadena += c.getNom() + "\t" + c.getApe() + "\t" + c.getDoc()
                        + "\t" + c.getSexo() + "\t"
                        + c.getFac().getCod() + "-" + c.getFac().getNom() + "\t" + c.getPro().getCod() + "-" + c.getPro().getNom() + "\t" + c.getest() + "\t" + c.getSem() + "\n";
                c = c.sig;
            }
        }
        return cadena;
    }

    public void cargarsexo(JComboBox a) {
        a.addItem("Seleccione:");
        a.addItem("Masculino");
        a.addItem("Femenino");
    }

    public void desactivar(String doc) {
        alumno a = buscar(doc);
        a.setest("desactivado");
    }

    public void activar(String doc) {
        alumno a = buscar(doc);
        a.setest("activo");
    }

    public void cargaralumno(JComboBox a) {
        alumno p = cab;
        while (p != null) {
            a.addItem(p.getDoc() + "-" + p.getNom().trim());
            p = p.sig;
        }
    }

    public void mostrarprogramas(String codf, JComboBox prog, l_programa lp) {

        prog.removeAllItems();
        programa aux = lp.retunrcab();
        prog.addItem("Todos los alumnos");
        while (aux != null) {
            if (aux.getFac().getCod().equals(codf)) {
                prog.addItem(aux.getCod() + "-" + aux.getNom());
            }
            aux = aux.sig;
        }
    }

    public void alumnofacultad(JTable t, JComboBox prog, String b, l_facultad lf, l_programa lp) {
        if (b.equals("Todos los alumnos")) {
            cargar(t);
            prog.removeAllItems();
        } else {
            facultad f = lf.buscarinicio(b);
            mostrarprogramas(b, prog, lp);
            cargaralumnofacultad(t, f);

        }
    }

    public void alumnoprograma(JTable t, JComboBox prog, String b, l_programa lp, String codf, l_facultad lf) {
        if (b.equals("Todos los alumnos")) {
            facultad f = lf.retunrcab();
            cargaralumnofacultad(t, f);
        } else {
            programa p = lp.buscarinicio(b);
            cargaralumnoprograma(t, p);
        }
    }
}
