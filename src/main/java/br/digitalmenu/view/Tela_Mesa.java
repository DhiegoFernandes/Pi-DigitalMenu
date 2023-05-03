package br.digitalmenu.view;

import br.digitalmenu.dao.MesaDao;
import br.digitalmenu.model.Mesa;
import java.sql.SQLException;
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
        jPanel4 = new javax.swing.JPanel();
        btn_ExcluirMesa = new javax.swing.JButton();
        btn_atualizar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lbl_NumeroMesa = new javax.swing.JLabel();
        txt_NumeroMesa = new javax.swing.JTextField();
        btn_CadastrarMesa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tableMesa = new javax.swing.JScrollPane();
        jtMesa = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções"));

        btn_ExcluirMesa.setText("Excluir");
        btn_ExcluirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExcluirMesaActionPerformed(evt);
            }
        });

        btn_atualizar.setText("Atualizar");
        btn_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ExcluirMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_atualizar))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_atualizar)
                .addGap(30, 30, 30)
                .addComponent(btn_ExcluirMesa)
                .addGap(15, 15, 15))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("CADASTRO"));

        lbl_NumeroMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_NumeroMesa.setText("Número da mesa");

        txt_NumeroMesa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_CadastrarMesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_NumeroMesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_NumeroMesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_NumeroMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_NumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btn_CadastrarMesa)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addGap(0, 0, 0)
                .addComponent(tableMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(12, Short.MAX_VALUE))
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBounds(0, 0, 392, 450);
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
                    JOptionPane.showMessageDialog(null, "Mesa deletada com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
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

    private void jtMesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMesaMouseClicked
    }//GEN-LAST:event_jtMesaMouseClicked

    private void jtMesaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMesaMouseReleased

        if (jtMesa.getSelectedRow() != -1) {
            txt_NumeroMesa.setText(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString());
            idMesaParaAlterar = Integer.parseInt(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString());
//            checkbox_Status.setSelected(jtMesa.getValueAt(jtMesa.getSelectedRow(), 1).toString().equalsIgnoreCase("ativado"));
//            statusxAux = checkbox_Status.isSelected() ? "ATIVADO" : "DESATIVADO";
        }
    }//GEN-LAST:event_jtMesaMouseReleased

    private void jtMesaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtMesaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtMesaKeyPressed

    private void jtMesaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtMesaKeyReleased

        if (jtMesa.getSelectedRow() != -1) {
            txt_NumeroMesa.setText(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString());
            idMesaParaAlterar = Integer.parseInt(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString());
//            checkbox_Status.setSelected(jtMesa.getValueAt(jtMesa.getSelectedRow(), 1).toString().equalsIgnoreCase("ativado"));
//            statusxAux = checkbox_Status.isSelected() ? "ATIVADO" : "DESATIVADO";
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
            int resultado = JOptionPane.showConfirmDialog(null, painel, "PESQUISAR POR NÚMERO", JOptionPane.OK_CANCEL_OPTION, -1);
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
        int result = JOptionPane.showConfirmDialog(null, painel, "ALTERAR MESA", JOptionPane.OK_CANCEL_OPTION, -1);
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

    private void btn_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atualizarActionPerformed
        // TODO add your handling code here:
        if (jtMesa.getRowCount() != -1) {
            try {
                MesaDao mesaDao = new MesaDao();
                Mesa mesa = mesaDao.listarMesaPorId(Integer.parseInt(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString()));
                Panel_Alterar_Mesa panel = new Panel_Alterar_Mesa(mesa);
                int resultado = JOptionPane.showConfirmDialog(null, panel, "ATUALIZAR MESA", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (resultado == JOptionPane.OK_OPTION) {
                    mesa.setIdMesa(Integer.parseInt(panel.getTxt_numero_Novo().getText()));
                    mesa.setStatus(panel.getComboBox_status_novo().getSelectedItem().toString());
                    mesaDao.updateMesa(mesa, Integer.parseInt(panel.getLbl_Id_Valor().getText()));
                    listarJtablePorStatus("Ativado");
                } else {
                    JOptionPane.showMessageDialog(null, "CANCELADO");

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha");
        }
    }//GEN-LAST:event_btn_atualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CadastrarMesa;
    private javax.swing.JButton btn_ExcluirMesa;
    private javax.swing.JButton btn_atualizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTable jtMesa;
    private javax.swing.JLabel lbl_NumeroMesa;
    private javax.swing.JScrollPane tableMesa;
    private javax.swing.JTextField txt_NumeroMesa;
    // End of variables declaration//GEN-END:variables
}
