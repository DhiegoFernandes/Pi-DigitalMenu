package br.digitalmenu.view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tela_Atendente extends javax.swing.JFrame {

    public Tela_Atendente(String usuario, String tipoAcesso) {
        initComponents();
        jDesktopPane1.enable(false);//Deixa a cor do fundo a mostra, deixa o jDesktop desativado

        //casting para a primeira letra do tipoDeAcesso ficar maiscula
        tipoAcesso = String.valueOf(tipoAcesso);
        String s1 = tipoAcesso.substring(0, 1).toUpperCase();
        String tipoAcessoMaisculo = s1 + tipoAcesso.substring(1);

        //casting para a primeira letra do usuario ficar maiscula
        usuario = String.valueOf(usuario);
        String s2 = usuario.substring(0, 1).toUpperCase();
        String usuarioMaiusculo = s2 + usuario.substring(1);

        //Seta a label usuario e tipo de acesso
        lbl_usuario.setText(String.valueOf(usuarioMaiusculo));
        lbl_tipo_acesso.setText(String.valueOf(tipoAcessoMaisculo));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        pnlTopo = new javax.swing.JPanel();
        lbl_tipo_acesso = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        lbl_foto_atendente = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        pnl_botoes = new javax.swing.JPanel();
        btn_abrir_pedido = new javax.swing.JButton();
        btn_listar_pedidos = new javax.swing.JButton();
        btn_mesas = new javax.swing.JButton();
        btn_produtos = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        lbl_menu_atendente = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnu_mesa = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnu_produto = new javax.swing.JMenu();
        mnuitemProduto = new javax.swing.JMenuItem();
        mnu_pedido = new javax.swing.JMenu();
        mnuItemPedido = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        pnlTopo.setBackground(new java.awt.Color(246, 242, 233));

        lbl_tipo_acesso.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_tipo_acesso.setForeground(new java.awt.Color(176, 50, 39));
        lbl_tipo_acesso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_tipo_acesso.setText("tipoAcesso");

        lbl_usuario.setBackground(new java.awt.Color(0, 255, 204));
        lbl_usuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_usuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_usuario.setText("usuario");

        lbl_foto_atendente.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\garcom.png"));
        lbl_foto_atendente.setText("Icone");

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\digitalmenu2.png"));

        javax.swing.GroupLayout pnlTopoLayout = new javax.swing.GroupLayout(pnlTopo);
        pnlTopo.setLayout(pnlTopoLayout);
        pnlTopoLayout.setHorizontalGroup(
            pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbl_foto_atendente, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_tipo_acesso, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTopoLayout.createSequentialGroup()
                    .addGap(349, 349, 349)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(349, 349, 349)))
        );
        pnlTopoLayout.setVerticalGroup(
            pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTopoLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_foto_atendente, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTopoLayout.createSequentialGroup()
                        .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_tipo_acesso)))
                .addGap(35, 35, 35))
            .addGroup(pnlTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTopoLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(10, 10, 10)))
        );

        pnl_botoes.setBackground(new java.awt.Color(246, 242, 233));

        btn_abrir_pedido.setBackground(new java.awt.Color(176, 50, 39));
        btn_abrir_pedido.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        btn_abrir_pedido.setForeground(new java.awt.Color(255, 255, 255));
        btn_abrir_pedido.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\waiter.png"));
        btn_abrir_pedido.setText("Abrir pedido");
        btn_abrir_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrir_pedidoActionPerformed(evt);
            }
        });

        btn_listar_pedidos.setBackground(new java.awt.Color(176, 50, 39));
        btn_listar_pedidos.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        btn_listar_pedidos.setForeground(new java.awt.Color(255, 255, 255));
        btn_listar_pedidos.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\pedido.png"));
        btn_listar_pedidos.setText("Pedidos");
        btn_listar_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listar_pedidosActionPerformed(evt);
            }
        });

        btn_mesas.setBackground(new java.awt.Color(176, 50, 39));
        btn_mesas.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        btn_mesas.setForeground(new java.awt.Color(255, 255, 255));
        btn_mesas.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\table.png"));
        btn_mesas.setText("Mesas");
        btn_mesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mesasActionPerformed(evt);
            }
        });

        btn_produtos.setBackground(new java.awt.Color(176, 50, 39));
        btn_produtos.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        btn_produtos.setForeground(new java.awt.Color(255, 255, 255));
        btn_produtos.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\burguersoda.png"));
        btn_produtos.setText("Produtos");
        btn_produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_produtosActionPerformed(evt);
            }
        });

        btn_sair.setBackground(new java.awt.Color(234, 0, 44));
        btn_sair.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btn_sair.setForeground(new java.awt.Color(255, 255, 255));
        btn_sair.setText("Sair");
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });

        lbl_menu_atendente.setFont(new java.awt.Font("Cooper Black", 1, 48)); // NOI18N
        lbl_menu_atendente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_menu_atendente.setText("Menu Atendente");

        javax.swing.GroupLayout pnl_botoesLayout = new javax.swing.GroupLayout(pnl_botoes);
        pnl_botoes.setLayout(pnl_botoesLayout);
        pnl_botoesLayout.setHorizontalGroup(
            pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botoesLayout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addGroup(pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_botoesLayout.createSequentialGroup()
                        .addComponent(btn_abrir_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_produtos, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                    .addGroup(pnl_botoesLayout.createSequentialGroup()
                        .addComponent(btn_listar_pedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_mesas, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)))
                .addGap(337, 337, 337))
            .addGroup(pnl_botoesLayout.createSequentialGroup()
                .addGap(598, 598, 598)
                .addComponent(btn_sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(612, 612, 612))
            .addGroup(pnl_botoesLayout.createSequentialGroup()
                .addGap(470, 470, 470)
                .addComponent(lbl_menu_atendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(488, 488, 488))
        );
        pnl_botoesLayout.setVerticalGroup(
            pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botoesLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lbl_menu_atendente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_mesas, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(btn_listar_pedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_abrir_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(btn_produtos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(93, 93, 93)
                .addComponent(btn_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jDesktopPane1.setLayer(pnlTopo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(pnl_botoes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(pnlTopo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_botoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(pnlTopo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_botoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mnu_mesa.setText("Mesa");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, 0));
        jMenuItem1.setText("Mesa");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnu_mesa.add(jMenuItem1);

        jMenuBar1.add(mnu_mesa);

        mnu_produto.setText("Produto");

        mnuitemProduto.setText("Produto");
        mnuitemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuitemProdutoActionPerformed(evt);
            }
        });
        mnu_produto.add(mnuitemProduto);

        jMenuBar1.add(mnu_produto);

        mnu_pedido.setText("Pedido");

        mnuItemPedido.setText("Pedido");
        mnuItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemPedidoActionPerformed(evt);
            }
        });
        mnu_pedido.add(mnuItemPedido);

        jMenuBar1.add(mnu_pedido);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        setSize(new java.awt.Dimension(1414, 762));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        try {
            new Tela_Mesa().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mnuitemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuitemProdutoActionPerformed
        try {
            new Tela_Produto().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_mnuitemProdutoActionPerformed

    private void mnuItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemPedidoActionPerformed

        try {
            new Tela_Listar_Pedido().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_mnuItemPedidoActionPerformed

    private void btn_mesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mesasActionPerformed

        try {
            new Tela_Mesa().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_mesasActionPerformed

    private void btn_abrir_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrir_pedidoActionPerformed
        try {
            new Tela_EscolherMesa().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_abrir_pedidoActionPerformed

    private void btn_listar_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listar_pedidosActionPerformed

        try {
            new Tela_Listar_Pedido().setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_listar_pedidosActionPerformed

    private void btn_produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_produtosActionPerformed

        try {
            new Tela_Produto().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_produtosActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        //Sair
        this.dispose();
        try {
            new Tela_Login().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Atendente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_sairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_abrir_pedido;
    private javax.swing.JButton btn_listar_pedidos;
    private javax.swing.JButton btn_mesas;
    private javax.swing.JButton btn_produtos;
    private javax.swing.JButton btn_sair;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lbl_foto_atendente;
    private javax.swing.JLabel lbl_menu_atendente;
    private javax.swing.JLabel lbl_tipo_acesso;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JMenuItem mnuItemPedido;
    private javax.swing.JMenu mnu_mesa;
    private javax.swing.JMenu mnu_pedido;
    private javax.swing.JMenu mnu_produto;
    private javax.swing.JMenuItem mnuitemProduto;
    private javax.swing.JPanel pnlTopo;
    private javax.swing.JPanel pnl_botoes;
    // End of variables declaration//GEN-END:variables
}
