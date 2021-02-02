/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import astraccion.*;
import javax.swing.JOptionPane;
import listas.*;
import archivo.archiv;
import java.awt.event.ItemEvent;

/**
 *
 * @author USUARIO
 */
public class r_alumno extends javax.swing.JFrame {

    l_alumno la;
    l_facultad lf;
    l_programa lp;
    archiv a = new archiv();

    /**
     * Creates new form r_alumno
     */
    public r_alumno(l_alumno a, l_facultad b, l_programa c) {
        initComponents();
        this.setLocationRelativeTo(null);
        la = a;
        lf = b;
        lp = c;
        la.cargar(tabla);
        lf.cargarfacultad(facu);
        //lp.cargarprograma(prog);
        la.cargarsexo(sex);
        bor.setEnabled(false);
        mod.setEnabled(false);
        lim.setEnabled(false);
        est.setEditable(false);
    }

    public void limpiar() {
        nom.setText("");
        ape.setText("");
        doc.setText("");
        est.setText("");
        sex.removeAllItems();
        facu.removeAllItems();
        prog.removeAllItems();
        lf.cargarfacultad(facu);
        lp.cargarprograma(prog);
        la.cargarsexo(sex);
        bor.setEnabled(false);
        mod.setEnabled(false);
        lim.setEnabled(false);
    }

    public void mostrarprogramas() {
        String a = (String) facu.getSelectedItem();
        String vf[] = a.split("-");
        prog.removeAllItems();
        programa aux = lp.retunrcab();
        while (aux != null) {
            if (aux.getFac().getCod().equals(vf[0])) {
                prog.addItem(aux.getCod() + "-" + aux.getNom());
            }
            aux = aux.sig;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ape = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        doc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        sex = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        facu = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        prog = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        est = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        reg = new javax.swing.JButton();
        bus = new javax.swing.JButton();
        bor = new javax.swing.JButton();
        mod = new javax.swing.JButton();
        lim = new javax.swing.JButton();
        sal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("UNIPAMPLONA");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REGISTRAR ALUMNO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N

        jLabel1.setText("NOMBRE:");

        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });
        nom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomKeyTyped(evt);
            }
        });

        jLabel2.setText("APELLIDO:");

        ape.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apeKeyTyped(evt);
            }
        });

        jLabel3.setText("DOCUMENTO:");

        doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docActionPerformed(evt);
            }
        });
        doc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                docKeyTyped(evt);
            }
        });

        jLabel4.setText("GENERO:");

        jLabel5.setText("FACULTAD:");

        facu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                facuItemStateChanged(evt);
            }
        });

        jLabel6.setText("PROGRAMA:");

        jLabel7.setText("ESTADO:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nom, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(ape)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doc, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(est))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(prog, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(facu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sex, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(facu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(doc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(prog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(est, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 11))); // NOI18N

        reg.setText("REGISTRAR");
        reg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reg.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        reg.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regActionPerformed(evt);
            }
        });

        bus.setText("BUSCAR");
        bus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bus.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bus.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busActionPerformed(evt);
            }
        });

        bor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/a9.png"))); // NOI18N
        bor.setText("ACTIVAR/DESACTIVAR");
        bor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borActionPerformed(evt);
            }
        });

        mod.setText("MODIFICAR");
        mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modActionPerformed(evt);
            }
        });

        lim.setText("LIMPIAR");
        lim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limActionPerformed(evt);
            }
        });

        sal.setText("SALIR");
        sal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(mod, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(reg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bus, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(lim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mod)
                    .addComponent(lim)
                    .addComponent(sal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regActionPerformed
        // TODO add your handling code here:
        String q = (String) sex.getSelectedItem();
        String z = (String) facu.getSelectedItem();
        String s = (String) prog.getSelectedItem();
        String vf[] = z.split("-");
        String vp[] = s.split("-");
        if (!nom.getText().equals("") && !ape.getText().equals("") && !doc.getText().equals("")
                && !q.equals("Seleccione:")) {
            alumno e = la.retunrcab();
            boolean esta = false;
            while (e != null) {
                if (e.getNom().equals(nom.getText())
                        || e.getApe().equals(ape.getText()) && e.getDoc().equals(doc.getText())) {
                    esta = true;
                    JOptionPane.showMessageDialog(null, "NO SE PUEDE REGISTRAR EL ALUMNO");
                }
                e = e.sig;
            }
            if (esta == false) {
                facultad f = lf.buscar(vf[0]);
                programa p = lp.buscar(vp[0]);
                alumno x = new alumno(nom.getText(), ape.getText(), doc.getText(), q, f, p, "activo", "0");
                la.ins_alum(x);
                a.GenerarArchivo("listadealumnos.xls", la.imprimir());
                la.cargar(tabla);
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "HAY ESPACIOS SIN LLENAR");
        }

    }//GEN-LAST:event_regActionPerformed

    private void busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busActionPerformed
        // TODO add your handling code here:
        if (doc.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "DIGITE EL DOCUMENTO");
        } else {
            alumno a = la.buscar(doc.getText());
            if (a != null) {
                if (a.getDoc().equals(doc.getText())) {
                    nom.setText(a.getNom());
                    ape.setText(a.getApe());
                    sex.setSelectedItem(a.getSexo());
                    facu.setSelectedItem(a.getFac().getCod() + "-" + a.getFac().getNom());
                    prog.setSelectedItem(a.getPro().getCod() + "-" + a.getPro().getNom());
                    est.setText(a.getest());
                    mod.setEnabled(true);
                    bor.setEnabled(true);
                    lim.setEnabled(true);
                    reg.setEnabled(false);

                } else {
                    JOptionPane.showMessageDialog(null, "ALUMNO NO ENCONTRADO");
                }
            }
        }
    }//GEN-LAST:event_busActionPerformed

    private void borActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borActionPerformed
        // TODO add your handling code here:
        if (est.getText().equals("activo")) {
            int n = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DESEA DESACTIVAR ESTE ALUMNO");
            if (n == 0) {
                la.desactivar(doc.getText());
                mod.setEnabled(false);
                bor.setEnabled(false);
                lim.setEnabled(false);
                reg.setEnabled(true);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "EL ALUMNO NO FUE DESACTIVADO");
            }
        } else {
            int n = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DESEA ACTIVAR ESTE ALUMNO");
            if (n == 0) {
                la.activar(doc.getText());
                mod.setEnabled(false);
                bor.setEnabled(false);
                lim.setEnabled(false);
                reg.setEnabled(true);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "EL ALUMNO NO FUE ACTIVADO");
            }

        }
        la.cargar(tabla);
        a.GenerarArchivo("listadealumnos.xls", la.imprimir());
    }//GEN-LAST:event_borActionPerformed

    private void modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modActionPerformed
        // TODO add your handling code here:
        int n = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE MODIFICAR ESTE ALUMNO");
        if (n == 0) {
            String z = (String) facu.getSelectedItem();
            String q = (String) prog.getSelectedItem();
            String s = (String) sex.getSelectedItem();
            String vf[] = z.split("-");
            String vp[] = q.split("-");
            facultad f = lf.buscar(vf[0]);
            programa p = lp.buscar(vp[0]);
            la.modificar(nom.getText(), ape.getText(), doc.getText(), s, f, p);
            mod.setEnabled(false);
            bor.setEnabled(false);
            lim.setEnabled(false);
            reg.setEnabled(true);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "EL ALUMNO NO FUE MODIFICADO");
        }
        la.cargar(tabla);
        a.GenerarArchivo("listadealumnos.xls", la.imprimir());
    }//GEN-LAST:event_modActionPerformed

    private void limActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_limActionPerformed

    private void salActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_salActionPerformed

    private void nomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESE SOLO LETRAS");
        }
    }//GEN-LAST:event_nomKeyTyped

    private void apeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apeKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "INGRESE SOLO LETRAS");
        }
    }//GEN-LAST:event_apeKeyTyped

    private void docKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_docKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "DIGITE SOLO NUMEROS");
        }
    }//GEN-LAST:event_docKeyTyped

    private void facuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_facuItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (this.facu.getSelectedIndex() >= 0) {
                this.mostrarprogramas();
            }
        }
    }//GEN-LAST:event_facuItemStateChanged

    private void docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docActionPerformed

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ape;
    private javax.swing.JButton bor;
    private javax.swing.JButton bus;
    private javax.swing.JTextField doc;
    private javax.swing.JTextField est;
    private javax.swing.JComboBox facu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lim;
    private javax.swing.JButton mod;
    private javax.swing.JTextField nom;
    private javax.swing.JComboBox prog;
    private javax.swing.JButton reg;
    private javax.swing.JButton sal;
    private javax.swing.JComboBox sex;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}