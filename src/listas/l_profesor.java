package listas;

import astraccion.alumno;
import astraccion.asignatura;
import astraccion.facultad;
import astraccion.profesor;
import astraccion.programa;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class l_profesor {

    profesor cab;
    private DefaultTableModel model;

    public void crear() {
        this.cab = null;
    }

    public profesor retunrcab() {
        return this.cab;
    }

    public boolean vacia() {
        if (this.cab == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(profesor a) {
        if (this.cab == null) {
            cab = a;
        } else {
            profesor p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
        }
    }

    public void ins_prof(profesor a) {
        if (this.cab == null) {
            cab = a;
            JOptionPane.showMessageDialog(null, "EL DOCENTE FUE REGISTRADO");
        } else {
            profesor p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
            JOptionPane.showMessageDialog(null, "EL DOCENTE FUE REGISTRADO");
        }
    }

    public profesor buscar(String doc) {
        if (!vacia()) {
            if (cab.getDoc().equals(doc)) {
                JOptionPane.showMessageDialog(null, "EL DOCENTE FUE ENCONTRADO");
                return cab;
            } else {
                profesor p = cab;
                while (p != null) {
                    if (p.getDoc().equals(doc)) {
                        JOptionPane.showMessageDialog(null, "EL DOCENTE FUE ENCONTRADO");
                        return p;
                    }
                    p = p.sig;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "EL DOCENTE NO FUE ENCONTRADO");
        return null;
    }

    public profesor buscar2(String doc) {
        if (!vacia()) {
            if (cab.getDoc().equals(doc)) {
                return cab;
            } else {
                profesor p = cab;
                while (p != null) {
                    if (p.getDoc().equals(doc)) {
                        return p;
                    }
                    p = p.sig;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "EL DOCENTE NO FUE ENCONTRADO");
        return null;
    }

    public void modificar(String nombre, String apellido, String doc, String sexo, programa p) {
        if (!vacia()) {
            profesor aux = this.buscar(doc);

            aux.setNom(nombre);
            aux.setApe(apellido);
            aux.setDoc(doc);
            aux.setP(p);
            JOptionPane.showMessageDialog(null, "EL DOCENTE FUE MODIFICADO");
        } else {
            JOptionPane.showMessageDialog(null, "EL DOCENTE NO FUE MODIFICADO");
        }
    }

    public void cargar(JTable a) {
        // Creamos un objeto Table con el molde del nuestro
        String data[][] = {};
        String col[] = {"NOMBRE", "APELLIDO", "DOCUMENTO", "SEXO", "FACULTAD", "PROGRAMA"};
        model = new DefaultTableModel(data, col);
        profesor d = cab;
        //************************************
        if (!vacia()) {
            while (d != null) {
                Object[] fila = new Object[6];

                fila[0] = d.getNom();
                fila[1] = d.getApe();
                fila[2] = d.getDoc();
                fila[3] = d.getSexo();
                fila[4] = d.getP().getFac().getNom();
                fila[5] = d.getP().getNom();

                model.addRow(fila);
                d = d.sig;
            }
            a.setModel(model);
        }
    }

    public String imprimir() {
        profesor c = this.cab;
        String cadena = "NOMBRE" + "\t" + "APELLIDO" + "\t" + "DOCUMENTO" + "\t" + "SEXO" + "\t" + "FACULTAD" + "\t"
                + "PROGRAMA" + "\t" + "ESTADO" + "\n";
        if (!vacia()) {
            while (c != null) {
                cadena += c.getNom() + "\t" + c.getApe() + "\t" + c.getDoc() + "\t" + c.getSexo() + "\t"
                        + c.getP().getFac().getCod() + "-" + c.getP().getFac().getNom()
                        + "\t" + c.getP().getCod() + "-" + c.getP().getNom()
                        + "\t" + c.getEst() + "\n";
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

    public void estado(String doc) {
        profesor a = buscar(doc);
        a.setEst("false");
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
            cargardocentefacultad(t, f);

        }
    }

    public void docenteprograma(JTable t, JComboBox prog, String b, l_programa lp, String codf, l_facultad lf) {
        if (b.equals("Todos los alumnos")) {
            facultad f = lf.retunrcab();
            cargardocentefacultad(t, f);
        } else {
            programa p = lp.buscarinicio(b);
            cargardocenteprograma(t, b);
        }
    }

    public void cargardocentefacultad(JTable a, facultad f) {
        // Creamos un objeto Table con el molde del nuestro
        String data[][] = {};
        String col[] = {"NOMBRE", "APELLIDO", "DOCUMENTO", "SEXO", "FACULTAD", "PROGRAMA"};
        model = new DefaultTableModel(data, col);
        profesor d = cab;
        //************************************
        if (!vacia()) {
            while (d != null) {
                if (d.getEst().equals("activo") && d.getP().getFac().getCod().equals(f.getCod())) {
                    Object[] fila = new Object[6];
                    System.out.println("si es igual");

                    fila[0] = d.getNom();
                    fila[1] = d.getApe();
                    fila[2] = d.getDoc();
                    fila[3] = d.getSexo();
                    fila[4] = d.getP().getFac().getNom();
                    fila[5] = d.getP().getNom();

                    model.addRow(fila);
                }
                d = d.sig;
            }
            a.setModel(model);
        }
    }

    public void cargardocenteprograma(JTable a, String p) {
        // Creamos un objeto Table con el molde del nuestro
        String data[][] = {};
        String col[] = {"NOMBRE", "APELLIDO", "DOCUMENTO", "SEXO", "FACULTAD", "PROGRAMA"};
        model = new DefaultTableModel(data, col);
        profesor d = cab;

        //************************************
        if (!vacia()) {
            while (d != null) {
                if (d.getEst().equals("activo") && d.getP().getCod().equals(p)) {
                    Object[] fila = new Object[6];
                    System.out.println("programa igual");
                    fila[0] = d.getNom();
                    fila[1] = d.getApe();
                    fila[2] = d.getDoc();
                    fila[3] = d.getSexo();
                    fila[4] = d.getP().getFac().getNom();
                    fila[5] = d.getP().getNom();

                    model.addRow(fila);
                }
                d = d.sig;
            }
            a.setModel(model);
        }
    }
    public void cargardocentegenero(JTable a, String p) {
        // Creamos un objeto Table con el molde del nuestro
        String data[][] = {};
        String col[] = {"NOMBRE", "APELLIDO", "DOCUMENTO", "SEXO", "FACULTAD", "PROGRAMA"};
        model = new DefaultTableModel(data, col);
        profesor d = cab;

        //************************************
        if (!vacia()) {
            while (d != null) {
                if (d.getEst().equals("activo") && d.getSexo().equals(p)) {
                    Object[] fila = new Object[6];
                    fila[0] = d.getNom();
                    fila[1] = d.getApe();
                    fila[2] = d.getDoc();
                    fila[3] = d.getSexo();
                    fila[4] = d.getP().getFac().getNom();
                    fila[5] = d.getP().getNom();

                    model.addRow(fila);
                }
                d = d.sig;
            }
            a.setModel(model);
        }
    }

    
}
