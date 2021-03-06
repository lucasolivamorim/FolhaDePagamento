/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folhadepagamento;

import db.DatabaseOperationFailedException;
import enums.UserRole;
import models.Empregado.Horista;
import models.Endereco;
import models.Usuario;
import db.EmployeeDAO;
import db.SnapshotDAO;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Empregado.Assalariado;
import models.Empregado.Comissionado;
import models.Empregado.Empregado;
import util.Util;

/**
 *
 * @author lucas
 */
public class CadastraEmpregado extends javax.swing.JFrame implements ISelectUser {

    /**
     * Creates new form CadastraEmpregado
     */
    private boolean isUpdating = false;
    private Empregado emp;
    public CadastraEmpregado() {
        this(false);
    }
    public CadastraEmpregado(boolean updating) {
        initComponents();
        isUpdating = updating;
        if (!isUpdating) {
            setVisible(true);
        }
        else {
            new SelectUser(this).setVisible(true);
        }
    }
   
    
    @Override
    public void callback(Empregado e, Action a) {
        setVisible(true);
        loadData(e);
        this.emp = e;
    }
    
    private void loadData(Empregado e) {
        txtNome.setText(e.getName());
        comboTipo.setSelectedIndex(e.getType());
        comboTipoActionPerformed(null);
        if (e.getTufee() != 0.0) {
            checkSindicato.setSelected(true);
            txtTUID.setText(String.valueOf(e.getTuid()));
            txtTUfee.setText(String.valueOf(e.getTufee()));
        }
        txtUsu.setText(e.getAccess_user().getUsername());
        txtPass.setText(e.getAccess_user().getPassword());
        txtLogradouro.setText(e.getEndereco().getLogradouro());
        txtNumero.setText(e.getEndereco().getNumero());
        txtComplemento.setText(e.getEndereco().getComplemento());
        txtCEP.setText(e.getEndereco().getCep());
        comboUFs.setSelectedItem(e.getEndereco().getUf());
        txtCidade.setText(e.getEndereco().getCidade());
        comboPaymentType.setSelectedIndex(e.getPaymentType());
        txtMoney.setText(String.valueOf(e.getPayment()));
        if (e.getType() == 2) {
           txtComission.setText(String.valueOf(((Comissionado)e).getFee()));
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtLogradouro = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtCEP = new javax.swing.JTextField();
        comboUFs = new javax.swing.JComboBox<>();
        txtComplemento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        checkSindicato = new javax.swing.JCheckBox();
        comboTipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTUfee = new javax.swing.JTextField();
        txtTUID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtUsu = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtMoney = new javax.swing.JTextField();
        txtComission = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lblMoney = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        comboPaymentType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Register");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Address"));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtLogradouro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 200, 20));
        jPanel1.add(txtCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 120, -1));
        jPanel1.add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 80, -1));
        jPanel1.add(txtCEP, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 100, -1));

        comboUFs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AL", "MG", "SC", "SP", "RS" }));
        comboUFs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUFsActionPerformed(evt);
            }
        });
        jPanel1.add(comboUFs, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, 20));
        jPanel1.add(txtComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 200, -1));

        jLabel2.setText("Number:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 70, 20));

        jLabel5.setText("UF:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 70, 20));

        jLabel6.setText("CEP:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, 20));

        jLabel7.setText("City:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 70, 20));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Street:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 70, 20));

        jLabel9.setText("Complement:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 460, 140));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Personal Data"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 130, 20));

        checkSindicato.setText("Trade Union?");
        checkSindicato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSindicatoActionPerformed(evt);
            }
        });
        jPanel2.add(checkSindicato, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hourly Waged", "Monthly Waged", "Comissioned", " " }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });
        jPanel2.add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 130, -1));

        jLabel3.setText("Name:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel4.setText("Type:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 30, -1));

        txtTUfee.setEnabled(false);
        jPanel2.add(txtTUfee, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 60, 20));

        txtTUID.setEnabled(false);
        jPanel2.add(txtTUID, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 60, -1));

        jLabel13.setText("Fee:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, 20));

        jLabel14.setText("TUID:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 330, 110));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("System Info"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(txtUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 110, -1));

        jLabel11.setText("User:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 40, 20));

        jLabel12.setText("Password:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));
        jPanel3.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 110, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 210, 110));

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 120, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Payment"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(txtMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 60, -1));

        txtComission.setEnabled(false);
        jPanel4.add(txtComission, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 60, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Type:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 90, 60, 20));

        lblMoney.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMoney.setText("Salary:");
        jPanel4.add(lblMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 60, 20));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Comission:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, 20));

        comboPaymentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "By Post", "Handed", "Deposit" }));
        jPanel4.add(comboPaymentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 80, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 160, 140));

        setSize(new java.awt.Dimension(686, 416));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Empregado emp;
        int selected = comboTipo.getSelectedIndex();
        Endereco end = new Endereco();
        end.setLogradouro(txtLogradouro.getText());
        end.setNumero(txtNumero.getText());
        end.setCidade(txtCidade.getText());
        end.setUf(comboUFs.getSelectedItem().toString());
        end.setCep(txtCEP.getText());
        end.setComplemento(txtComplemento.getText());
        Usuario usuario = new Usuario(txtUsu.getText(), String.valueOf(txtPass.getPassword()), UserRole.EMPLOYEE);
        switch (selected) {
            case 0:
                Horista horista = new Horista();
                horista.setSalarioPorHora(Double.parseDouble(txtMoney.getText()));
                emp = horista;
                break;
            case 1:
                Assalariado assalariado = new Assalariado();
                assalariado.setSalarioMensal(Double.parseDouble(txtMoney.getText()));
                emp = assalariado;
                break;
            default:
                Comissionado com = new Comissionado();
                com.setSalarioMensal(Double.parseDouble(txtMoney.getText()));
                com.setTaxaComissao(Double.parseDouble(txtComission.getText()));
                emp = com;
                break;
        }
        emp.setName(txtNome.getText());
        emp.setEndereco(end);
        emp.setAccess_user(usuario);
        emp.setPaymentType(comboPaymentType.getSelectedIndex());
        if (checkSindicato.isSelected()) {
            emp.setTuid(Integer.parseInt(txtTUID.getText()));
            emp.setTufee(Double.parseDouble(txtTUfee.getText()));
        }
        String message = "created", message2 = "inserting";
        if (isUpdating) {
            emp.setId(this.emp.getId());
            message = "updated";
            message2 = "updating";
        }        
        try {
            SnapshotDAO.createSnapshot(("Before @string user " + emp.getName() + " - " + LocalDateTime.now().toString()).replace("@string", message2));
            EmployeeDAO.insertOrUpdateEmployee(emp);
            JOptionPane.showMessageDialog(null, "User " + emp.getName() + " was " + message, "OK", JOptionPane.INFORMATION_MESSAGE);
        } catch (DatabaseOperationFailedException ex) {
            Util.displayDatabaseError(ex.getMessage());
        }        
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void checkSindicatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSindicatoActionPerformed
        if (checkSindicato.isSelected()) {
            txtTUID.setEnabled(true);
            txtTUfee.setEnabled(true);
        } else {
            txtTUID.setEnabled(false);
            txtTUfee.setEnabled(false);
        }
     
    }//GEN-LAST:event_checkSindicatoActionPerformed

    private void comboUFsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUFsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboUFsActionPerformed

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        int selected = comboTipo.getSelectedIndex();
        if (selected == 2) {
            txtComission.setEnabled(true);
        } else {
            txtComission.setEnabled(false);
        }
    }//GEN-LAST:event_comboTipoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastraEmpregado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastraEmpregado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastraEmpregado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastraEmpregado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastraEmpregado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkSindicato;
    private javax.swing.JComboBox<String> comboPaymentType;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JComboBox<String> comboUFs;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblMoney;
    private javax.swing.JTextField txtCEP;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComission;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtMoney;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtTUID;
    private javax.swing.JTextField txtTUfee;
    private javax.swing.JTextField txtUsu;
    // End of variables declaration//GEN-END:variables

    
}
