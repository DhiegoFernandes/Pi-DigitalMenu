package br.digitalmenu.view;

import br.digitalmenu.dao.ItemDao;
import br.digitalmenu.dao.PedidoDao;
import br.digitalmenu.dao.ProdutoDao;
import br.digitalmenu.heuristicas.Heuristica;
import br.digitalmenu.model.Item;
import br.digitalmenu.model.Produto;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Tela_ItensDoPedido extends Heuristica {

    public double valorTotal = 0;
    public int numeroPedido;
    public Tela_Listar_Pedido telaAnterior;

    public Tela_ItensDoPedido() {
        initComponents();
    }

    public Tela_ItensDoPedido(int numeroPedido, int numeroMesa, Tela_Listar_Pedido telaAnterior) throws SQLException {
        initComponents();
        this.numeroPedido = numeroPedido;
        lbl_numero_pedido.setText(String.valueOf(numeroPedido));
        lbl_numero_mesa.setText(String.valueOf(numeroMesa));
        jtItensDoPedido.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
        IniciaTabela(jtItensDoPedido);//Formata a tabela e centraliza pela classe heuristicas
        listarJTable(numeroPedido);
        lbl_valor_total.setText(String.format("%.2f", atualizaSubtotalConfirmado()));
        this.telaAnterior = telaAnterior;
    }

    public void metodoAntesDeFechar() throws SQLException {
        telaAnterior.metodoAoVoltar();
        this.dispose();
    }

    public void listarJTable(int numeroPedido) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtItensDoPedido.getModel();
        modelo.setNumRows(0);
        ItemDao itensDao = new ItemDao();
        for (Item item : itensDao.listarItensPorPedido(numeroPedido)) {
            ProdutoDao produtoDao = new ProdutoDao();
            modelo.addRow(new Object[]{
                item.getIdItem(),
                item.getProduto().getIdProduto(),
                item.getProduto().getNome(),
                String.format("%.2f", item.getProduto().getPreco()),
                item.getQtde(),
                String.format("%.2f", item.getSubtotal()),
                item.getHoraComanda(),
                item.getStatus()
            });
            valorTotal += Double.parseDouble(String.valueOf(item.getSubtotal()));
        }
    }

    public JComboBox listarProdutoNoComboBox(JComboBox cbox) throws SQLException {
        ProdutoDao prodDao = new ProdutoDao();
        for (Produto produto : prodDao.listarProduto()) {
            cbox.addItem(produto.getNome());
        }
        return cbox;
    }

    public double atualizaSubtotalConfirmado() throws SQLException {
        ItemDao itemDao = new ItemDao();
        double total = 0.0;
        for (Item item : itemDao.listarItensConfirmadosPorPedido(numeroPedido)) {
            total += item.getSubtotal();
        }
        return total;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGlobal = new javax.swing.JPanel();
        pnl_superior = new javax.swing.JPanel();
        lbl_foto_pedido = new javax.swing.JLabel();
        lbl_numero_pedido = new javax.swing.JLabel();
        lbl_foto_mesa = new javax.swing.JLabel();
        lbl_numero_mesa = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        lbl_valor_total = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtItensDoPedido = new javax.swing.JTable();
        btn_voltar = new javax.swing.JButton();
        btn_voltar1 = new javax.swing.JButton();
        btn_voltar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Itens do pedido");

        pnlGlobal.setBackground(new java.awt.Color(255, 255, 255));

        pnl_superior.setBackground(new java.awt.Color(246, 242, 233));
        pnl_superior.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Itens do pedido", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        lbl_foto_pedido.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\pedido.png"));
        lbl_foto_pedido.setText("jLabel1");

        lbl_numero_pedido.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_numero_pedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_numero_pedido.setText("jLabel1");

        lbl_foto_mesa.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\table.png"));
        lbl_foto_mesa.setText("jLabel1");

        lbl_numero_mesa.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_numero_mesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_numero_mesa.setText("jLabel1");

        lbl_total.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_total.setText("Total:");

        lbl_valor_total.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        lbl_valor_total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_valor_total.setText("jLabel1");

        javax.swing.GroupLayout pnl_superiorLayout = new javax.swing.GroupLayout(pnl_superior);
        pnl_superior.setLayout(pnl_superiorLayout);
        pnl_superiorLayout.setHorizontalGroup(
            pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_superiorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbl_foto_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_numero_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_foto_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_numero_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_total)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_valor_total)
                .addContainerGap())
        );
        pnl_superiorLayout.setVerticalGroup(
            pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_superiorLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_numero_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(lbl_foto_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_numero_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_foto_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_valor_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jtItensDoPedido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtItensDoPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Pedido", "Produto", "Preço", "Qtde", "Subtotal", "Horário", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtItensDoPedido.setRowHeight(25);
        jScrollPane1.setViewportView(jtItensDoPedido);
        if (jtItensDoPedido.getColumnModel().getColumnCount() > 0) {
            jtItensDoPedido.getColumnModel().getColumn(0).setMinWidth(5);
            jtItensDoPedido.getColumnModel().getColumn(0).setPreferredWidth(5);
            jtItensDoPedido.getColumnModel().getColumn(1).setMinWidth(8);
            jtItensDoPedido.getColumnModel().getColumn(1).setPreferredWidth(8);
            jtItensDoPedido.getColumnModel().getColumn(2).setMinWidth(200);
            jtItensDoPedido.getColumnModel().getColumn(2).setPreferredWidth(200);
            jtItensDoPedido.getColumnModel().getColumn(3).setMinWidth(20);
            jtItensDoPedido.getColumnModel().getColumn(3).setPreferredWidth(20);
            jtItensDoPedido.getColumnModel().getColumn(4).setMinWidth(10);
            jtItensDoPedido.getColumnModel().getColumn(4).setPreferredWidth(10);
            jtItensDoPedido.getColumnModel().getColumn(5).setMinWidth(23);
            jtItensDoPedido.getColumnModel().getColumn(5).setPreferredWidth(23);
        }

        btn_voltar.setBackground(new java.awt.Color(255, 243, 198));
        btn_voltar.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        btn_voltar.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\voltar.png"));
        btn_voltar.setText("Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        btn_voltar1.setBackground(new java.awt.Color(255, 153, 153));
        btn_voltar1.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        btn_voltar1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\negativo.png"));
        btn_voltar1.setText("Cancelar Item");
        btn_voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltar1ActionPerformed(evt);
            }
        });

        btn_voltar2.setBackground(new java.awt.Color(204, 255, 204));
        btn_voltar2.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        btn_voltar2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\positivo.png"));
        btn_voltar2.setText("Adicionar Item");
        btn_voltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGlobalLayout = new javax.swing.GroupLayout(pnlGlobal);
        pnlGlobal.setLayout(pnlGlobalLayout);
        pnlGlobalLayout.setHorizontalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_superior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGlobalLayout.createSequentialGroup()
                        .addComponent(btn_voltar1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addGap(36, 36, 36)
                        .addComponent(btn_voltar2, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                        .addGap(27, 27, 27)
                        .addComponent(btn_voltar, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlGlobalLayout.setVerticalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_superior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_voltar1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btn_voltar2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btn_voltar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        try {
            metodoAntesDeFechar();
        } catch (SQLException ex) {
            Logger.getLogger(Tela_ItensDoPedido.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltar1ActionPerformed
        // TODO add your handling code here:
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja cancelar o item?");

        if (confirma == JOptionPane.YES_OPTION) {

            DefaultTableModel dtm = (DefaultTableModel) jtItensDoPedido.getModel();
            if (jtItensDoPedido.getSelectedRow() != -1) {
                ItemDao itemDao = new ItemDao();
                PedidoDao pedidoDao = new PedidoDao();
                try {
                    int id = Integer.parseInt(jtItensDoPedido.getValueAt(jtItensDoPedido.getSelectedRow(), 0).toString());
                    itemDao.atualizaItem(id);
                    pedidoDao.atualizaPedidoItemAlterado(numeroPedido);
                    listarJTable(numeroPedido);
                    lbl_valor_total.setText(String.valueOf(atualizaSubtotalConfirmado()));

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", HEIGHT);
                }
            } else if (jtItensDoPedido.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Não há itens no pedido.", "ERRO", HEIGHT);
            } else {
                JOptionPane.showMessageDialog(null, "Selecione um item.", "ERRO", HEIGHT);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada.", "ERRO", HEIGHT);
        }

    }//GEN-LAST:event_btn_voltar1ActionPerformed

    private void btn_voltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltar2ActionPerformed
        // TODO add your handling code here:
        JPanel panel = new JPanel();
        JComboBox comboBox = new JComboBox();
        try {
            listarProdutoNoComboBox(comboBox);
            JLabel nome = new JLabel("Selecione o produto: ");
            JLabel lbl_qtde = new JLabel("Quantidade: ");
            JTextField digitarQtde = new JTextField(4);
            panel.add(nome);
            panel.add(Box.createHorizontalStrut(2));
            panel.add(comboBox);
            panel.add(Box.createHorizontalStrut(5));
            panel.add(lbl_qtde);
            panel.add(Box.createHorizontalStrut(5));
            panel.add(digitarQtde);

            int confirma = JOptionPane.showConfirmDialog(null, panel, "Item a adicionar.", JOptionPane.OK_CANCEL_OPTION);
            if (confirma == JOptionPane.OK_OPTION) {
                ItemDao itemDao = new ItemDao();
                Item item = new Item();
                item.getPedido().setIdPedido(numeroPedido);
                item.getProduto().setNome(comboBox.getSelectedItem().toString());
                item.setQtde(Integer.parseInt(digitarQtde.getText()));
                itemDao.adicionaItemAdmin(item);
                PedidoDao pedidoDao = new PedidoDao();
                pedidoDao.atualizaPedidoItemAlterado(numeroPedido);
                listarJTable(numeroPedido);
                lbl_valor_total.setText(String.valueOf(atualizaSubtotalConfirmado()));

            } else {
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tela_ItensDoPedido.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_voltar2ActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_ItensDoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_ItensDoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_ItensDoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_ItensDoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_ItensDoPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_voltar;
    private javax.swing.JButton btn_voltar1;
    private javax.swing.JButton btn_voltar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtItensDoPedido;
    private javax.swing.JLabel lbl_foto_mesa;
    private javax.swing.JLabel lbl_foto_pedido;
    private javax.swing.JLabel lbl_numero_mesa;
    private javax.swing.JLabel lbl_numero_pedido;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_valor_total;
    private javax.swing.JPanel pnlGlobal;
    private javax.swing.JPanel pnl_superior;
    // End of variables declaration//GEN-END:variables
}
