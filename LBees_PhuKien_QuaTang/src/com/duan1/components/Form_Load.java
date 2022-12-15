
package com.duan1.components;

import com.duan1.ui.MainJFrame;
import com.duan1.ui.loginJFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class Form_Load extends javax.swing.JFrame {

    public Form_Load() {
        initComponents();
        this.setBackground(new Color(0,0,0,0));
         intit();
    }

     String check = "";
    void intit() {
        new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLocationRelativeTo(null);
                int value = jProgressBar1.getValue();
                int a = 0;

                if (value < 100) {
                    jProgressBar1.setValue(value + 5);
                    a = value + 5;
                 //   lbln.setText(a + "%");

                    if (value < 30) {
                       lblLoad.setText("ĐẶT QUÀ LIỀN TAY - NHẬN QUÀ HÔM NAY");
                    } else {
                       lblLoad.setText("ĐẶT QUÀ LIỀN TAY - NHẬN QUÀ HÔM NAY");
                    }
                    if (value > 60) {
                       lblLoad.setText("Sắp xong xin vui lòng đợi");
                    }
                    if (value > 90) {
                    lblLoad.setText("Wellcom");
                    }
                } else {
                    check += "Stop";
                    checkwwin();
                    Form_Load.this.dispose();

                }
            }
        }).start();
        checkwwin();

    }

    void checkwwin() {
        if (check.equals("Stop")) {
            openWelcome();
        }
    }

    void openWelcome() {
        new loginJFrame().setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        lblLoad = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLoad.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblLoad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoad.setText("0");
        getContentPane().add(lblLoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 320, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/duan1/icon/02.gif"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 800, 350));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Form_Load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Load.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Load().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblLoad;
    // End of variables declaration//GEN-END:variables
}
