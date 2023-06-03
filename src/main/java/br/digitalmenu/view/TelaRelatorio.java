package br.digitalmenu.view;

import br.digitalmenu.dao.RelatorioDao;
import br.digitalmenu.heuristicas.Heuristica;
import br.digitalmenu.model.Gorgeta;
import br.digitalmenu.model.relatorio.ItemRelatorio;
import br.digitalmenu.model.relatorio.PedidoRelatorio;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TelaRelatorio extends Heuristica {

    public TelaRelatorio() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_global_telaRelatorio = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRelatorio = new javax.swing.JTable();
        pnlPesquisar = new javax.swing.JPanel();
        btn_total_pedidos = new javax.swing.JButton();
        btn_top_qtde_vendida = new javax.swing.JButton();
        btn_top_faturamento_por_produto = new javax.swing.JButton();
        btn_total_pedidos_por_mes = new javax.swing.JButton();
        btn_gorgetas = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnl_global_telaRelatorio.setBackground(new java.awt.Color(255, 255, 255));

        jTableRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTableRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableRelatorio.setRowHeight(30);
        jScrollPane1.setViewportView(jTableRelatorio);

        pnlPesquisar.setBackground(new java.awt.Color(246, 242, 233));
        pnlPesquisar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatório", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cooper Black", 0, 24))); // NOI18N

        btn_total_pedidos.setBackground(new java.awt.Color(255, 243, 198));
        btn_total_pedidos.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        btn_total_pedidos.setText("Total Pedidos");
        btn_total_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_total_pedidosActionPerformed(evt);
            }
        });

        btn_top_qtde_vendida.setBackground(new java.awt.Color(255, 243, 198));
        btn_top_qtde_vendida.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        btn_top_qtde_vendida.setText("<html> <html> <body> <h><div style=\"text-align:center\">Top quantidade vendidas</h></center> </body> </html>");
        btn_top_qtde_vendida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_top_qtde_vendidaActionPerformed(evt);
            }
        });

        btn_top_faturamento_por_produto.setBackground(new java.awt.Color(255, 243, 198));
        btn_top_faturamento_por_produto.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        btn_top_faturamento_por_produto.setText("<html> <html> <body> <h><div style=\"text-align:center\"> Top faturamento por produto</h></center> </body> </html>");
        btn_top_faturamento_por_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_top_faturamento_por_produtoActionPerformed(evt);
            }
        });

        btn_total_pedidos_por_mes.setBackground(new java.awt.Color(255, 243, 198));
        btn_total_pedidos_por_mes.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        btn_total_pedidos_por_mes.setText("Total Pedidos por Mês");
        btn_total_pedidos_por_mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_total_pedidos_por_mesActionPerformed(evt);
            }
        });

        btn_gorgetas.setBackground(new java.awt.Color(255, 243, 198));
        btn_gorgetas.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        btn_gorgetas.setText("Gorgetas");
        btn_gorgetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gorgetasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPesquisarLayout = new javax.swing.GroupLayout(pnlPesquisar);
        pnlPesquisar.setLayout(pnlPesquisarLayout);
        pnlPesquisarLayout.setHorizontalGroup(
            pnlPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPesquisarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_top_faturamento_por_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_top_qtde_vendida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btn_total_pedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(btn_total_pedidos_por_mes, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_gorgetas, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        pnlPesquisarLayout.setVerticalGroup(
            pnlPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPesquisarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPesquisarLayout.createSequentialGroup()
                        .addGroup(pnlPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_total_pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_top_qtde_vendida, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_total_pedidos_por_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_gorgetas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(pnlPesquisarLayout.createSequentialGroup()
                        .addComponent(btn_top_faturamento_por_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jButton1.setBackground(new java.awt.Color(255, 243, 198));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_global_telaRelatorioLayout = new javax.swing.GroupLayout(pnl_global_telaRelatorio);
        pnl_global_telaRelatorio.setLayout(pnl_global_telaRelatorioLayout);
        pnl_global_telaRelatorioLayout.setHorizontalGroup(
            pnl_global_telaRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_global_telaRelatorioLayout.createSequentialGroup()
                .addGroup(pnl_global_telaRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_global_telaRelatorioLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_global_telaRelatorioLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(pnl_global_telaRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1310, Short.MAX_VALUE)
                            .addComponent(pnlPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(49, 49, 49))
        );
        pnl_global_telaRelatorioLayout.setVerticalGroup(
            pnl_global_telaRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_global_telaRelatorioLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pnlPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_global_telaRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_global_telaRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1414, 807));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_top_faturamento_por_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_top_faturamento_por_produtoActionPerformed
        apagarTodasColunas(jTableRelatorio);

        DefaultTableModel modelo = (DefaultTableModel) jTableRelatorio.getModel();
        modelo.setNumRows(0);
        modelo.addColumn("Id");
        modelo.addColumn("Produto");
        modelo.addColumn("Preço");
        modelo.addColumn("Qtde Total");
        modelo.addColumn("Total vendas");

        RelatorioDao relatorioDao = new RelatorioDao();
        try {
            for (ItemRelatorio itemRelatorio : relatorioDao.listarItensPorMaiorFaturamento()) {
                modelo.addRow(new Object[]{
                    itemRelatorio.getProduto().getIdProduto(),
                    itemRelatorio.getProduto().getNome(),
                    String.format("%.2f", itemRelatorio.getProduto().getPreco()),
                    itemRelatorio.getQtdeTotalVendida(),
                    String.format("%.2f", itemRelatorio.getValorTotalVendido()),});
            }
            jTableRelatorio.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
            IniciaTabela(jTableRelatorio);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_top_faturamento_por_produtoActionPerformed


    private void btn_total_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_total_pedidosActionPerformed

        apagarTodasColunas(jTableRelatorio);
        DefaultTableModel modelo = (DefaultTableModel) jTableRelatorio.getModel();
        modelo.setNumRows(0);
        modelo.addColumn("Total de pedidos");
        modelo.addColumn("Total vendas R$");
        modelo.addColumn("Media por pedido R$");

        RelatorioDao relatorioDao = new RelatorioDao();
        try {
            PedidoRelatorio pedidoRelatorio = relatorioDao.totalPedidos();
            modelo.addRow(new Object[]{
                pedidoRelatorio.getQtdeDePedidos(),
                String.format("%.2f", pedidoRelatorio.getValorTotal()),
                String.format("%.2f", pedidoRelatorio.getMediaTotal()),});

            jTableRelatorio.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
            IniciaTabela(jTableRelatorio);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }

    }//GEN-LAST:event_btn_total_pedidosActionPerformed


    private void btn_top_qtde_vendidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_top_qtde_vendidaActionPerformed
        apagarTodasColunas(jTableRelatorio);

        DefaultTableModel modelo = (DefaultTableModel) jTableRelatorio.getModel();
        modelo.setNumRows(0);

        modelo.addColumn("Id");
        modelo.addColumn("Produto");
        modelo.addColumn("Preço");
        modelo.addColumn("Qtde Total");
        modelo.addColumn("Total vendas");

        RelatorioDao relatorioDao = new RelatorioDao();
        try {
            for (ItemRelatorio itemRelatorio : relatorioDao.listarItensMaisVendidos()) {
                modelo.addRow(new Object[]{
                    itemRelatorio.getProduto().getIdProduto(),
                    itemRelatorio.getProduto().getNome(),
                    String.format("%.2f", itemRelatorio.getProduto().getPreco()),
                    itemRelatorio.getQtdeTotalVendida(),
                    String.format("%.2f", itemRelatorio.getValorTotalVendido()),});
            }
            jTableRelatorio.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
            IniciaTabela(jTableRelatorio);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_top_qtde_vendidaActionPerformed


    private void btn_total_pedidos_por_mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_total_pedidos_por_mesActionPerformed

        JPanel painel = new JPanel();
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("1");
        comboBox.addItem("2");
        comboBox.addItem("3");
        comboBox.addItem("4");
        comboBox.addItem("5");
        comboBox.addItem("6");
        comboBox.addItem("7");
        comboBox.addItem("8");
        comboBox.addItem("9");
        comboBox.addItem("10");
        comboBox.addItem("11");
        comboBox.addItem("12");
        painel.add(new JLabel("Mês: "));
        painel.add(comboBox);
        int result = JOptionPane.showConfirmDialog(null, painel, "Selecione o Mês.", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                int mes = Integer.parseInt(comboBox.getSelectedItem().toString());
                apagarTodasColunas(jTableRelatorio);
                DefaultTableModel modelo = (DefaultTableModel) jTableRelatorio.getModel();
                modelo.setNumRows(0);
                modelo.addColumn("Total de pedidos");
                modelo.addColumn("Total vendas R$");
                modelo.addColumn("Media por pedido R$");

                RelatorioDao relatorioDao = new RelatorioDao();
                PedidoRelatorio pedidoRelatorio = relatorioDao.totalPedidosPorMes(mes);
                modelo.addRow(new Object[]{
                    pedidoRelatorio.getQtdeDePedidos(),
                    String.format("%.2f", pedidoRelatorio.getValorTotal()),
                    String.format("%.2f", pedidoRelatorio.getMediaTotal()), //pedidoRelatorio.getMediaTotal() // formatar 2 casas decimais
                });
                jTableRelatorio.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
                IniciaTabela(jTableRelatorio);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_total_pedidos_por_mesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_gorgetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gorgetasActionPerformed

        apagarTodasColunas(jTableRelatorio);
        DefaultTableModel modelo = (DefaultTableModel) jTableRelatorio.getModel();
        modelo.setNumRows(0);
        modelo.addColumn("Data");
        modelo.addColumn("Total Gorgetas");

        RelatorioDao relatorioDao = new RelatorioDao();
        
        try {
            for (Gorgeta gorgeta : relatorioDao.calculaGorgetas()) {
                modelo.addRow(new Object[]{gorgeta.getData(), gorgeta.getValor()});
            }
            jTableRelatorio.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
            IniciaTabela(jTableRelatorio);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro botão gorgetas: " + ex.getMessage());
        }
    }//GEN-LAST:event_btn_gorgetasActionPerformed

    public static void apagarTodasColunas(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableColumnModel columnModel = table.getColumnModel();
        int columnCount = columnModel.getColumnCount();
        for (int i = columnCount - 1; i >= 0; i--) {
            TableColumn column = columnModel.getColumn(i);
            columnModel.removeColumn(column);
            model.setColumnCount(model.getColumnCount() - 1);
        }
    }

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
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_gorgetas;
    private javax.swing.JButton btn_top_faturamento_por_produto;
    private javax.swing.JButton btn_top_qtde_vendida;
    private javax.swing.JButton btn_total_pedidos;
    private javax.swing.JButton btn_total_pedidos_por_mes;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRelatorio;
    private javax.swing.JPanel pnlPesquisar;
    private javax.swing.JPanel pnl_global_telaRelatorio;
    // End of variables declaration//GEN-END:variables
}
