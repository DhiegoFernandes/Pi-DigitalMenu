package br.digitalmenu.view;

import br.digitalmenu.dao.MesaDao;
import br.digitalmenu.model.Mesa;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Tela_Mesa extends javax.swing.JInternalFrame {

    int idMesaParaAlterar = 0;
    String statusxAux = "ativado";

    public Tela_Mesa() throws SQLException {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jtMesa.getModel();
        jtMesa.setRowSorter(new TableRowSorter(modelo));
        listarJtablePorStatus("Ativado");
    }

    public void listarJtable() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtMesa.getModel();
        modelo.setNumRows(0);
        MesaDao mesaDAO = new MesaDao();
        for (Mesa mesa : mesaDAO.listarTodasMesas()) {
            modelo.addRow(new Object[]{
                mesa.getIdMesa(),
                mesa.getStatus()
            });
        }
    }

    public void listarJtablePorStatus(String status) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtMesa.getModel();
        modelo.setNumRows(0);
        MesaDao mesaDAO = new MesaDao();
        for (Mesa mesa : mesaDAO.listarTodasMesasPorStatus(status)) {
            modelo.addRow(new Object[]{
                mesa.getIdMesa(),
                mesa.getStatus()
            });
        }
    }

    public void listarJtablePorNumero(int numMesa) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtMesa.getModel();
        modelo.setNumRows(0);
        MesaDao mesaDao = new MesaDao();
        Mesa mesa = mesaDao.listarMesaPorId(numMesa);
        modelo.addRow(new Object[]{
            mesa.getIdMesa(),
            mesa.getStatus()
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_NumeroMesa = new javax.swing.JLabel();
        txt_NumeroMesa = new javax.swing.JTextField();
        btn_CadastrarMesa = new javax.swing.JButton();
        checkbox_Status = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        btn_AlterarMesa = new javax.swing.JButton();
        btn_ExcluirMesa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tableMesa = new javax.swing.JScrollPane();
        jtMesa = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);

        lbl_NumeroMesa.setText("Número da mesa");

        txt_NumeroMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NumeroMesaActionPerformed(evt);
            }
        });

        btn_CadastrarMesa.setText("Cadastrar");
        btn_CadastrarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CadastrarMesaActionPerformed(evt);
            }
        });

        checkbox_Status.setText("ATIVADO");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções"));

        btn_AlterarMesa.setText("Atualizar");
        btn_AlterarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AlterarMesaActionPerformed(evt);
            }
        });

        btn_ExcluirMesa.setText("Excluir");
        btn_ExcluirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExcluirMesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_AlterarMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ExcluirMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_AlterarMesa)
                .addGap(18, 18, 18)
                .addComponent(btn_ExcluirMesa)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_NumeroMesa)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_CadastrarMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_NumeroMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                    .addComponent(checkbox_Status))
                .addGap(91, 91, 91)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkbox_Status)
                        .addGap(21, 21, 21)
                        .addComponent(lbl_NumeroMesa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_NumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_CadastrarMesa)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        tableMesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableMesaKeyReleased(evt);
            }
        });

        jtMesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Número Mesa (id)", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtMesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMesaMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtMesaMouseReleased(evt);
            }
        });
        jtMesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtMesaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtMesaKeyReleased(evt);
            }
        });
        tableMesa.setViewportView(jtMesa);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar"));

        jButton1.setText("Número");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Status");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("TODOS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addGap(49, 49, 49)
                .addComponent(jButton2)
                .addGap(50, 50, 50)
                .addComponent(jButton3)
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_NumeroMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NumeroMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NumeroMesaActionPerformed

    private void btn_CadastrarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CadastrarMesaActionPerformed

        if (!txt_NumeroMesa.getText().equalsIgnoreCase("")) {
            Mesa mesa = new Mesa();
            mesa.setIdMesa(Integer.parseInt(txt_NumeroMesa.getText()));
//            String status = checkbox_Status.isSelected() ? "ATIVADO" : "DESATIVADO";
//            mesa.setStatus(status);
            MesaDao mesaDAO = new MesaDao();
            try {
                boolean criouMesa = mesaDAO.criarMesa(mesa) ? true : false;
                if (criouMesa == true) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Mesa criada com sucesso!\n"
                            + "Id/Número: "
                            + mesa.getIdMesa()
                    //                            + "\nStatus: "
                    //                            + mesa.getStatus()
                    );
                }
                txt_NumeroMesa.setText("");
                listarJtablePorStatus("Ativado");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insira um número de mesa.");
        }
    }//GEN-LAST:event_btn_CadastrarMesaActionPerformed

    private void btn_ExcluirMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExcluirMesaActionPerformed
        if (jtMesa.getSelectedRow() != -1) {
            int confirma = JOptionPane.showConfirmDialog(
                    this,
                    "Deseja confirmar a deleção da mesa " + String.valueOf(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString()) + "?",
                    "CONFIRMAR DELEÇÃO",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (confirma == JOptionPane.YES_OPTION) {
                try {
                    MesaDao mesaDAO = new MesaDao();
                    Mesa mesa = mesaDAO.listarMesaPorId(Integer.parseInt(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString()));
                    mesaDAO.deletaMesa(mesa.getIdMesa());
                    JOptionPane.showMessageDialog(null, "Mesa deletada com sucesso!");
                    txt_NumeroMesa.setText("");
                    listarJtablePorStatus("Ativado");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                }
            } else if (confirma == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Operacão cancelada.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma mesa para excluir.");
        }
    }//GEN-LAST:event_btn_ExcluirMesaActionPerformed

    private void btn_AlterarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AlterarMesaActionPerformed
        if (jtMesa.getSelectedRow() != -1) {

            try {
                String status = checkbox_Status.isSelected() ? "ATIVADO" : "DESATIVADO";
                MesaDao mesaDAO = new MesaDao();
                Mesa mesaAtual = mesaDAO.listarMesaPorId(Integer.parseInt(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString()));
                Mesa mesaNova = new Mesa();
                mesaNova.setIdMesa(Integer.parseInt(txt_NumeroMesa.getText()));
                mesaNova.setStatus(status);

                int confirmar = JOptionPane.showConfirmDialog(
                        this,
                        "Dados atuais:\nMesa: "
                        + mesaAtual.getIdMesa()
                        + "\nStatus: "
                        + mesaAtual.getStatus()
                        + "\n\nDADO(S) ATUALIZADO(S):"
                        + "\nMesa: "
                        + mesaNova.getIdMesa()
                        + "\nStatus: "
                        + mesaNova.getStatus(),
                        "CONFIRMAR ALTERAÇÃO?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (confirmar == JOptionPane.YES_OPTION) {
                    mesaDAO.updateMesa(mesaNova, mesaAtual.getIdMesa());
                    JOptionPane.showMessageDialog(null, "Mesa atualizada com sucesso!");
                    listarJtablePorStatus("Ativado");
                    txt_NumeroMesa.setText("");
                } else if (confirmar == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Operação cancelada!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para alterar.");
        }
    }//GEN-LAST:event_btn_AlterarMesaActionPerformed

    private void jtMesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMesaMouseClicked
    }//GEN-LAST:event_jtMesaMouseClicked

    private void jtMesaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMesaMouseReleased

        if (jtMesa.getSelectedRow() != -1) {
            txt_NumeroMesa.setText(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString());
            idMesaParaAlterar = Integer.parseInt(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString());
            checkbox_Status.setSelected(jtMesa.getValueAt(jtMesa.getSelectedRow(), 1).toString().equalsIgnoreCase("ativado"));
            statusxAux = checkbox_Status.isSelected() ? "ATIVADO" : "DESATIVADO";
        }
    }//GEN-LAST:event_jtMesaMouseReleased

    private void jtMesaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtMesaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtMesaKeyPressed

    private void jtMesaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtMesaKeyReleased

        if (jtMesa.getSelectedRow() != -1) {
            txt_NumeroMesa.setText(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString());
            idMesaParaAlterar = Integer.parseInt(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString());
            checkbox_Status.setSelected(jtMesa.getValueAt(jtMesa.getSelectedRow(), 1).toString().equalsIgnoreCase("ativado"));
            statusxAux = checkbox_Status.isSelected() ? "ATIVADO" : "DESATIVADO";
        }

    }//GEN-LAST:event_jtMesaKeyReleased

    private void tableMesaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableMesaKeyReleased

    }//GEN-LAST:event_tableMesaKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            JPanel painel = new JPanel();
            JLabel numeroMesa = new JLabel("Número: ");
            JTextField digitarNumero = new JTextField(10);
            painel.add(numeroMesa);
            painel.add(digitarNumero);
            int resultado = JOptionPane.showConfirmDialog(null, painel, "PESQUISAR POR NÚMERO", JOptionPane.OK_CANCEL_OPTION);
            if (resultado == JOptionPane.OK_OPTION) {
                //tratar erro de entrada
                listarJtablePorNumero(Integer.parseInt(digitarNumero.getText()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JPanel painel = new JPanel();
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Ativado");
        comboBox.addItem("Desativado");
        painel.add(new JLabel("Status: "));
        painel.add(comboBox);
        int result = JOptionPane.showConfirmDialog(null, painel, "PESQUISAR POR STATUS", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String status = String.valueOf(comboBox.getSelectedItem());
                listarJtablePorStatus(status);
                if (jtMesa.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Não há produtos no status " + status);
                    listarJtablePorStatus("ativado");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            listarJtable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AlterarMesa;
    private javax.swing.JButton btn_CadastrarMesa;
    private javax.swing.JButton btn_ExcluirMesa;
    private javax.swing.JCheckBox checkbox_Status;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTable jtMesa;
    private javax.swing.JLabel lbl_NumeroMesa;
    private javax.swing.JScrollPane tableMesa;
    private javax.swing.JTextField txt_NumeroMesa;
    // End of variables declaration//GEN-END:variables
}
