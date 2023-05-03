package br.digitalmenu.view;

import br.digitalmenu.dao.CategoriaDao;
import br.digitalmenu.model.Categoria;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Tela_Categoria extends javax.swing.JInternalFrame {

    int idCategoriaInicial = 0;
    String statusInicial = "";

    public Tela_Categoria() throws SQLException {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jtCategoria.getModel();
        jtCategoria.setRowSorter(new TableRowSorter(modelo));
        listarJTable();
        txt_Numero_IdCategoria.setEnabled(false);
    }

    public void listarJTable() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtCategoria.getModel();
        modelo.setNumRows(0);
        CategoriaDao catDao = new CategoriaDao();
        for (Categoria categoria : catDao.listarCategoria()) {
            modelo.addRow(new Object[]{
                categoria.getIdCategoria(),
                categoria.getNomeCategoria()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbl_IdCategoria = new javax.swing.JLabel();
        txt_Numero_IdCategoria = new javax.swing.JTextField();
        lbl_NomeCategoria = new javax.swing.JLabel();
        txt_NomeCategoria = new javax.swing.JTextField();
        btn_Cadastrar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btn_Atualizar = new javax.swing.JButton();
        btn_Deletar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tableCategoria = new javax.swing.JScrollPane();
        jtCategoria = new javax.swing.JTable();

        setClosable(true);
        setResizable(true);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("CADASTRO"));

        lbl_IdCategoria.setText("Id da Categoria:");

        lbl_NomeCategoria.setText("Nome categoria:");

        btn_Cadastrar.setText("Cadastrar");
        btn_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_NomeCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_IdCategoria)
                            .addComponent(lbl_NomeCategoria)))
                    .addComponent(txt_Numero_IdCategoria, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(5, 5, 5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(btn_Cadastrar)
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_IdCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Numero_IdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_NomeCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_NomeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Cadastrar)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("OPÇOES"));

        btn_Atualizar.setText("Atualizar");
        btn_Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AtualizarActionPerformed(evt);
            }
        });

        btn_Deletar.setText("Deletar");
        btn_Deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Atualizar))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btn_Atualizar)
                .addGap(28, 28, 28)
                .addComponent(btn_Deletar)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jtCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id Categoria", "Nome"
            }
        ));
        jtCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtCategoriaMouseReleased(evt);
            }
        });
        jtCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtCategoriaKeyReleased(evt);
            }
        });
        tableCategoria.setViewportView(jtCategoria);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tableCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tableCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CadastrarActionPerformed

        if (txt_NomeCategoria.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Erro: Deve ter ao menos 1 caractere!");
        } else {
            Categoria categoria = new Categoria();
            categoria.setNomeCategoria(txt_NomeCategoria.getText());
            CategoriaDao catDao = new CategoriaDao();
            try {
                catDao.criarCategoria(categoria);
                listarJTable();
                JOptionPane.showMessageDialog(this,
                        "Categoria adicionada com sucesso!\nNome: "
                        + categoria.getNomeCategoria());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_CadastrarActionPerformed

    private void jtCategoriaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCategoriaMouseReleased
        if (jtCategoria.getSelectedRow() != -1) {
            txt_Numero_IdCategoria.setText(jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 0).toString());
            txt_NomeCategoria.setText(jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 1).toString());
            idCategoriaInicial = Integer.parseInt(txt_Numero_IdCategoria.getText());
            statusInicial = txt_NomeCategoria.getText();
        }
    }//GEN-LAST:event_jtCategoriaMouseReleased

    private void jtCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCategoriaKeyReleased
        if (jtCategoria.getSelectedRow() != -1) {
            txt_Numero_IdCategoria.setText(jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 0).toString());
            txt_NomeCategoria.setText(jtCategoria.getValueAt(jtCategoria.getSelectedRow(), 1).toString());
            idCategoriaInicial = Integer.parseInt(txt_Numero_IdCategoria.getText());
            statusInicial = txt_NomeCategoria.getText();
        }
    }//GEN-LAST:event_jtCategoriaKeyReleased

    private void btn_AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AtualizarActionPerformed
        
        if (jtCategoria.getSelectedRow() != -1) {
            int confirma = JOptionPane.showConfirmDialog(
                    this,
                    "Dados atuais:\nId: "
                    + idCategoriaInicial
                    + "\nNome: "
                    + statusInicial
                    + "\nDADOS ATUALIZADOS:"
                    + "\nID: "
                    + txt_Numero_IdCategoria.getText()
                    + "\nNome: "
                    + txt_NomeCategoria.getText(),
                    "CONFIRMAR ALTERÃ‡ÃƒO(Ã•ES)",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
//
            if (confirma == JOptionPane.YES_OPTION) {
//
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(Integer.parseInt(txt_Numero_IdCategoria.getText()));
                categoria.setNomeCategoria(txt_NomeCategoria.getText());
                CategoriaDao catDao = new CategoriaDao();
                try {
                    catDao.updateCategoria(categoria, idCategoriaInicial);
                    txt_Numero_IdCategoria.setText("");
                    txt_NomeCategoria.setText("");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
                }
                try {
                    listarJTable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
                }
            } else if (confirma == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "OperaÃ§Ã£o cancelada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        }
    }//GEN-LAST:event_btn_AtualizarActionPerformed

    private void btn_DeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeletarActionPerformed

        if (jtCategoria.getSelectedRow() != -1) {

            int confirma = JOptionPane.showConfirmDialog(this,
                    "Dados da categoria a deletar:\n ID: "
                    + txt_Numero_IdCategoria.getText()
                    + "\nNome: "
                    + txt_NomeCategoria.getText(),
                    "Confirmar deleÃ§Ã£o?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (confirma == JOptionPane.YES_OPTION) {
                Categoria cat = new Categoria();
                cat.setIdCategoria(Integer.parseInt(txt_Numero_IdCategoria.getText()));
                cat.setNomeCategoria(txt_NomeCategoria.getText());
                CategoriaDao catDao = new CategoriaDao();
                try {
                    catDao.deleteCategoria(cat);
                    JOptionPane.showMessageDialog(null, "Categoria deletada com sucesso!");
                    listarJTable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                }
            } else if (confirma == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Operacão cancelada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        }
    }//GEN-LAST:event_btn_DeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Atualizar;
    private javax.swing.JButton btn_Cadastrar;
    private javax.swing.JButton btn_Deletar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTable jtCategoria;
    private javax.swing.JLabel lbl_IdCategoria;
    private javax.swing.JLabel lbl_NomeCategoria;
    private javax.swing.JScrollPane tableCategoria;
    private javax.swing.JTextField txt_NomeCategoria;
    private javax.swing.JTextField txt_Numero_IdCategoria;
    // End of variables declaration//GEN-END:variables
}
