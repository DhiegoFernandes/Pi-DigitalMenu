package br.digitalmenu.view;

import br.digitalmenu.dao.PedidoDao;
import br.digitalmenu.model.Pedido;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

public class TelaDeEspera extends javax.swing.JFrame {

    private int numeroMesa;

    public TelaDeEspera(int numeroMesa) {
        initComponents();
        this.numeroMesa = numeroMesa;
        this.lblNumeroMesa.setText(String.valueOf(this.numeroMesa));
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);    
        setResizable(false);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnIniciarPedido = new javax.swing.JButton();
        lblNumeroMesa = new javax.swing.JLabel();
        btn_Voltar = new javax.swing.JButton();
        btnIniciarPedido2 = new javax.swing.JButton();
        lbl_logo = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Tela de Espera - Digital Menu");

        jPanel1.setBackground(new java.awt.Color(246, 242, 233));

        btnIniciarPedido.setBackground(new java.awt.Color(176, 50, 39));
        btnIniciarPedido.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        btnIniciarPedido.setForeground(new java.awt.Color(246, 242, 217));
        btnIniciarPedido.setText("Iniciar Pedido");
        btnIniciarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarPedidoActionPerformed(evt);
            }
        });

        lblNumeroMesa.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        lblNumeroMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumeroMesa.setText("Mesa");
        lblNumeroMesa.setEnabled(false);

        btn_Voltar.setBackground(new java.awt.Color(255, 243, 198));
        btn_Voltar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_Voltar.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\voltar.png"));
        btn_Voltar.setText("Voltar");
        btn_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VoltarActionPerformed(evt);
            }
        });

        btnIniciarPedido2.setBackground(new java.awt.Color(176, 50, 39));
        btnIniciarPedido2.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        btnIniciarPedido2.setForeground(new java.awt.Color(246, 242, 217));
        btnIniciarPedido2.setText("Cardápio");
        btnIniciarPedido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarPedido2ActionPerformed(evt);
            }
        });

        lbl_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_logo.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\digitalmenu2.png"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 232, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnIniciarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNumeroMesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIniciarPedido2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(223, 223, 223))
                    .addComponent(lbl_logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIniciarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIniciarPedido2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(btn_Voltar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(747, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarPedidoActionPerformed
        PedidoDao pedidoDao = new PedidoDao();
        Pedido pedido = new Pedido();
        pedido.getMesa().setIdMesa(numeroMesa);
        try {
            pedidoDao.adicionarPedido(pedido);
            Tela_Menu telaMenu = new Tela_Menu(pedidoDao.numeroPedido, numeroMesa, false);
            telaMenu.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnIniciarPedidoActionPerformed

    private void btn_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VoltarActionPerformed
       
      String senha = (JOptionPane.showInputDialog(null, "Digite a senha: ", "Digite a senha para sair:", JOptionPane.INFORMATION_MESSAGE));
        if ("admin".equalsIgnoreCase(senha)) {
            this.dispose();
          try {
              new Tela_Login().setVisible(true);
          } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
          }
        }else{
            JOptionPane.showMessageDialog(null, "Senha inválida!", "Dados inválidos!", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btn_VoltarActionPerformed

    private void btnIniciarPedido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarPedido2ActionPerformed
        // TODO add your handling code here:
        Tela_VerCardapio telaCardapio = null;
        try {
            telaCardapio = new Tela_VerCardapio();
        } catch (SQLException ex) {
            Logger.getLogger(TelaDeEspera.class.getName()).log(Level.SEVERE, null, ex);
        }
        telaCardapio.setVisible(true);
    }//GEN-LAST:event_btnIniciarPedido2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDeEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarPedido;
    private javax.swing.JButton btnIniciarPedido2;
    private javax.swing.JButton btn_Voltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblNumeroMesa;
    private javax.swing.JLabel lbl_logo;
    // End of variables declaration//GEN-END:variables
}
