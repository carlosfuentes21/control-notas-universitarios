package listas;

import astraccion.alumno;
import astraccion.asignatura;
import astraccion.detalle_asig;
import astraccion.facultad;
import astraccion.notas_semestre;
import astraccion.programa;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class l_nota_semestre {

    notas_semestre cab;
    public int size;
    private DefaultTableModel model;

    public void crear() {
        this.cab = null;
    }

    public notas_semestre retunrcab() {
        return this.cab;
    }

    public int tamaño() {
        int n = 0;
        if (!vacia()) {
            notas_semestre p = cab;
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

    public void insertar(notas_semestre a) {
        if (this.cab == null) {
            cab = a;
            size++;
        } else {
            notas_semestre p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
            size++;
        }
    }

    public void ins_notas(notas_semestre a) {
        if (this.cab == null) {
            cab = a;
            size++;
            JOptionPane.showMessageDialog(null, "NOTA REGISTRADA");
        } else {
            notas_semestre p = this.cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = a;
            size++;
            JOptionPane.showMessageDialog(null, "NOTA REGISTRADA");
        }
    }

    public notas_semestre buscaralum(String cod) {
        if (!vacia()) {
            if (cab.getA().getDoc() == cod) {
                JOptionPane.showMessageDialog(null, "alumno ENCONTRADA");
                return cab;
            } else {
                notas_semestre p = cab;
                while (p != null) {
                    if (p.getA().getDoc().equals(cod)) {
                        JOptionPane.showMessageDialog(null, "alumno ENCONTRADA");
                        return p;
                    }
                    p = p.sig;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "alumno NO ENCONTRADA");
        return null;
    }

    public notas_semestre buscarasig(String cod) {
        if (!vacia()) {
            if (cab.getA().getDoc() == cod) {
                JOptionPane.showMessageDialog(null, "alumno ENCONTRADA");
                return cab;
            } else {
                notas_semestre p = cab;
                while (p != null) {
                    if (p.getA().getDoc().equals(cod)) {
                        JOptionPane.showMessageDialog(null, "alumno ENCONTRADA");
                        return p;
                    }
                    p = p.sig;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "alumno NO ENCONTRADA");
        return null;
    }

    public void cargar2(JTable a, alumno b) {
        String data[][] = {};
        String col[] = {"CODIGO", "ASIGNATURA"};
        model = new DefaultTableModel(data, col);
        notas_semestre d = this.cab;

        //************************************
        if (!vacia()) {
            while (d != null) {
                if (d.getA().getDoc().equals(b.getDoc())) {
                    detalle_asig q = d.getLd().retunrcab();

                    while (q != null) {
                        Object[] fila = new Object[2];
                        fila[0] = q.getAsig().getCod();
                        fila[1] = q.getAsig().getNom();
                        model.addRow(fila);
                        q = q.sig;
                    }
                    a.setModel(model);
                }
                d = d.sig;
            }
        }
    }

    public void cargar(JTable a, alumno b) {
        String data[][] = {};
        String col[] = {"ASIGNATURA", "NOTA"};
        model = new DefaultTableModel(data, col);
        notas_semestre d = this.cab;
        //************************************
        if (!vacia()) {
            while (d != null) {
                if (d.getA().getDoc().equals(b.getDoc())) {
                    detalle_asig q = d.getLd().retunrcab();
                    while (q != null) {
                        Object[] fila = new Object[2];
                        fila[0] = q.getAsig().getNom();
                        fila[1] = q.getDef();
                        model.addRow(fila);
                        q = q.sig;
                    }
                    a.setModel(model);
                }
                d = d.sig;
            }
        }
    }

    public void asignarnota(alumno a, String b, String c) {
        notas_semestre d = this.cab;
        //************************************
        float prom = 0;
        if (!vacia()) {
            while (d != null) {
                if (d.getA().getDoc().equals(a.getDoc())) {
                    detalle_asig q = d.getLd().retunrcab();
                    while (q != null) {
                        if (q.getAsig().getCod().equals(b)) {
                            q.setDef(c);
                            System.out.println("modificado");
                        }
                        q = q.sig;
                    }
                }
                d = d.sig;
            }
        }

    }

    public float promedio(alumno a) {
        notas_semestre d = this.cab;
        float prom = 0;
        float pro = 0;
        if (!vacia()) {
            while (d != null) {
                if (d.getA().equals(a)) {
                    detalle_asig q = d.getLd().retunrcab();
                    detalle_asig p = d.getLd().retunrcab();
                    int n = 0;
                    while (q != null) {
                        n++;
                        q = q.sig;
                    }
                    while (p != null) {
                        float x = Float.parseFloat(p.getDef());
                        prom = prom + x;
                        p = p.sig;
                    }
                    prom = prom / n;
                    pro = prom;
                }
                d = d.sig;
            }
        }
        return pro;
    }

    public String cargarnota(alumno a, asignatura b) {

        notas_semestre d = this.cab;
        String z = "";
        //************************************
        if (!vacia()) {
            while (d != null) {
                if (d.getA().equals(a)) {
                    detalle_asig q = d.getLd().retunrcab();
                    while (q != null) {
                        if (q.getAsig().equals(b)) {
                            z = q.getDef();
                        }
                        q = q.sig;
                    }
                }
                d = d.sig;
            }
        }
        return z;
    }

    public void alumnofacultad(JTable t, JComboBox prog, String b, l_facultad lf, l_programa lp, l_alumno al) {
        if (b.equals("Todos los alumnos")) {
            recorrertodos(t, al);
            prog.removeAllItems();
        } else {
            facultad f = lf.buscarinicio(b);
            al.mostrarprogramas(b, prog, lp);
            recorrerfacultad(t, al, f);
        }
    }

    public void parcial(JTable t, String b, l_facultad lf, l_programa lp, l_alumno al) {
        recorrertodosparcial(t, al);
    }

    public void alumnoprograma(JTable t, JComboBox prog, String b, l_programa lp, String codf, l_facultad lf, l_alumno al) {
        if (b.equals("Todos los alumnos")) {
            facultad f = lf.retunrcab();
            recorrerfacultad(t, al, f);
        } else {
            programa p = lp.buscarinicio(b);
            recorrerprograma(t, al, p);
        }
    }

    public void recorrertodos(JTable t, l_alumno aa) {
        notas_semestre a = this.cab;
        int i = 0;
        float vp[] = new float[50];
        String vn[] = new String[50];
        while (a != null) {
            float n = Float.parseFloat(a.getPromedio());
            System.out.println(n);
            vp[i] = n;
            vn[i] = a.getA().getDoc();
            i++;
            a = a.sig;
        }
        ordenar(vp, vn, t, aa);
    }

    public void recorrertodosparcial(JTable t, l_alumno aa) {
        notas_semestre a = this.cab;
        int i = 0;
        float vp[] = new float[50];
        String vn[] = new String[50];
        while (a != null) {
            float n = Float.parseFloat(a.getPromedio());
            System.out.println(n);
            vp[i] = n;
            vn[i] = a.getA().getDoc();
            i++;
            a = a.sig;
        }
        ordenarparcial(vp, vn, t, aa);
    }

    public void recorrerfacultad(JTable t, l_alumno aa, facultad f) {
        notas_semestre a = this.cab;
        float vp[] = new float[50];
        String vn[] = new String[50];
        int i = 0;
        while (a != null) {
            if (a.getA().getFac().equals(f)) {
                vp[i] = Float.parseFloat(a.getPromedio());
                vn[i] = a.getA().getDoc();
                i++;
            }
            a = a.sig;

        }
        ordenar(vp, vn, t, aa);
    }

    public void recorrerprograma(JTable t, l_alumno aa, programa p) {
        notas_semestre a = this.cab;
        float vp[] = new float[50];
        String vn[] = new String[50];
        int i = 0;
        while (a != null) {
            if (a.getA().getPro().equals(p)) {
                vp[i] = Float.parseFloat(a.getPromedio());
                vn[i] = a.getA().getDoc();
                i++;
            }
            a = a.sig;

        }
        ordenar(vp, vn, t, aa);
    }

    public void ordenar(float[] vp, String[] vn, JTable t, l_alumno a) {
        for (int k = 0; k < vp.length; k++) {
            for (int f = 0; f < vp.length - 1 - k; f++) {
                if (vp[f] < vp[f + 1]) {
                    float auxpromedio;
                    auxpromedio = vp[f];
                    vp[f] = vp[f + 1];
                    vp[f + 1] = auxpromedio;
                    String auxcodigo;
                    auxcodigo = vn[f];
                    vn[f] = vn[f + 1];
                    vn[f + 1] = auxcodigo;
                }
            }
        }
        cargarordenado(t, vp, vn, a);
    }

    public void ordenarparcial(float[] vp, String[] vn, JTable t, l_alumno a) {
        for (int k = 0; k < vp.length; k++) {
            for (int f = 0; f < vp.length - 1 - k; f++) {
                if (vp[f] < vp[f + 1]) {
                    float auxpromedio;
                    auxpromedio = vp[f];
                    vp[f] = vp[f + 1];
                    vp[f + 1] = auxpromedio;
                    String auxcodigo;
                    auxcodigo = vn[f];
                    vn[f] = vn[f + 1];
                    vn[f + 1] = auxcodigo;
                }
            }
        }
        cargarordenadoparcial(t, vp, vn, a);
    }

    public void cargarordenadoparcial(JTable a, float vp[], String vn[], l_alumno ll) {
        float vprom[] = vp;
        String vdoc[] = vn;
        String data[][] = {};
        String col[] = {"NOMBRE", "APELLIDO", "DOCUMENTO", "SEXO", "FACULTAD", "PROGRAMA", "PROMEDIO"};
        model = new DefaultTableModel(data, col);
        for (int i = 0; i < 2; i++) {
            alumno al = ll.buscarinicio(vdoc[i]);
            if (al != null) {
                Object[] fila = new Object[7];
                fila[0] = al.getNom();
                fila[1] = al.getApe();
                fila[2] = al.getDoc();
                fila[3] = al.getSexo();
                fila[4] = al.getFac().getNom();
                fila[5] = al.getPro().getNom();
                fila[6] = vprom[i];
                model.addRow(fila);
            }
        }
        a.setModel(model);
    }

    public void cargarordenado(JTable a, float vp[], String vn[], l_alumno ll) {
        float vprom[] = vp;
        String vdoc[] = vn;
        String data[][] = {};
        String col[] = {"NOMBRE", "APELLIDO", "DOCUMENTO", "SEXO", "FACULTAD", "PROGRAMA", "PROMEDIO"};
        model = new DefaultTableModel(data, col);
        for (int i = 0; i < vprom.length; i++) {
            alumno al = ll.buscarinicio(vdoc[i]);
            if (al != null) {
                Object[] fila = new Object[7];
                fila[0] = al.getNom();
                fila[1] = al.getApe();
                fila[2] = al.getDoc();
                fila[3] = al.getSexo();
                fila[4] = al.getFac().getNom();
                fila[5] = al.getPro().getNom();
                fila[6] = vprom[i];
                model.addRow(fila);
            }
        }
        a.setModel(model);
    }
//    public void ordenarb() {
//        for (int k = 0; k < puntosb.size(); k++) {
//            for (int f = 0; f < puntosb.size() - 1 - k; f++) {
//                if (puntosb.get(f) < puntosb.get(f + 1)) {
//                    int auxpuntos;
//                    auxpuntos = puntosb.get(f);
//                    puntosb.set(f, puntosb.get(f + 1));
//                    puntosb.set(f + 1, auxpuntos);
//                    String auxnombres;
//                    auxnombres = equipos_b.get(f);
//                    equipos_b.set(f, equipos_b.get(f + 1));
//                    equipos_b.set(f + 1, auxnombres);
//                }
//            }
//        }
//    }
////
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
