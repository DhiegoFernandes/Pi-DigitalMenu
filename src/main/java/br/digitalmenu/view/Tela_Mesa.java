package br.digitalmenu.view;

import br.digitalmenu.dao.MesaDao;
import br.digitalmenu.heuristicas.Heuristica;
import br.digitalmenu.model.Mesa;
import static java.awt.image.ImageObserver.HEIGHT;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Tela_Mesa extends Heuristica {

    int idMesaParaAlterar = 0;
    String statusxAux = "ativado";

    public Tela_Mesa() throws SQLException {
        initComponents();

        jtMesa.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
        IniciaTabela(jtMesa);//Formata a tabela e centraliza pela classe heuristicas
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

    public void limparTxtFields() {
        txt_numero_mesa.setText("");
    }

    public void atualizaMesa() {
        if (jtMesa.getRowCount() != -1) {
            try {
                MesaDao mesaDao = new MesaDao();
                Mesa mesa = mesaDao.listarMesaPorId(Integer.parseInt(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString()));
                Panel_Alterar_Mesa panel = new Panel_Alterar_Mesa(mesa);
                int resultado = JOptionPane.showConfirmDialog(null, panel, "ATUALIZAR MESA", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (resultado == JOptionPane.OK_OPTION && panel.getTxt_numero_Novo().getText().length() <= 10) {
                    mesa.setIdMesa(Integer.valueOf(panel.getTxt_numero_Novo().getText()));
                    mesa.setIdMesa(Integer.parseInt(panel.getTxt_numero_Novo().getText()));
                    mesa.setStatus(panel.getComboBox_status_novo().getSelectedItem().toString());
                    mesaDao.updateMesa(mesa, Integer.parseInt(panel.getLbl_Id_Valor().getText()));
                    JOptionPane.showMessageDialog(this,
                            "Mesa atualizada com sucesso!");
                    listarJtablePorStatus("Ativado");
                    limparTxtFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Operacão cancelada!");
                }
            } catch (SQLIntegrityConstraintViolationException ex) {
                JOptionPane.showMessageDialog(null, "Mesa já cadastrada!", "ERRO", HEIGHT);
                atualizaMesa();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Número inválido, use número inteiro de até 10 dígitos!", "ERRO", HEIGHT);
                atualizaMesa();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_tela_mesa = new javax.swing.JPanel();
        pnl_cadastro = new javax.swing.JPanel();
        lbl_NumeroMesa = new javax.swing.JLabel();
        txt_numero_mesa = new javax.swing.JTextField();
        btn_cadastrar_mesa = new javax.swing.JButton();
        pnl_opcoes = new javax.swing.JPanel();
        btn_alterar_mesa = new javax.swing.JButton();
        btn_excluir_mesa = new javax.swing.JButton();
        pnl_filtro_tabela = new javax.swing.JPanel();
        btn_filtro_status = new javax.swing.JButton();
        btn_filtro_numero = new javax.swing.JButton();
        btn_filtro_todos = new javax.swing.JButton();
        tableMesa = new javax.swing.JScrollPane();
        jtMesa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mesas");

        pnl_tela_mesa.setBackground(new java.awt.Color(255, 255, 255));

        pnl_cadastro.setBackground(new java.awt.Color(246, 242, 233));
        pnl_cadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N
        pnl_cadastro.setPreferredSize(new java.awt.Dimension(670, 159));

        lbl_NumeroMesa.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbl_NumeroMesa.setText("Número da mesa:");

        txt_numero_mesa.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        txt_numero_mesa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_numero_mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numero_mesaActionPerformed(evt);
            }
        });
        txt_numero_mesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_numero_mesaKeyPressed(evt);
            }
        });

        btn_cadastrar_mesa.setBackground(new java.awt.Color(255, 243, 198));
        btn_cadastrar_mesa.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btn_cadastrar_mesa.setText("Cadastrar");
        btn_cadastrar_mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrar_mesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_cadastroLayout = new javax.swing.GroupLayout(pnl_cadastro);
        pnl_cadastro.setLayout(pnl_cadastroLayout);
        pnl_cadastroLayout.setHorizontalGroup(
            pnl_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cadastroLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lbl_NumeroMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_numero_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cadastrar_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(73, 73, 73))
        );
        pnl_cadastroLayout.setVerticalGroup(
            pnl_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cadastroLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnl_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_NumeroMesa)
                    .addComponent(txt_numero_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cadastrar_mesa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_opcoes.setBackground(new java.awt.Color(246, 242, 233));
        pnl_opcoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opções", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N
        pnl_opcoes.setPreferredSize(new java.awt.Dimension(670, 181));

        btn_alterar_mesa.setBackground(new java.awt.Color(204, 255, 204));
        btn_alterar_mesa.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_alterar_mesa.setText("Atualizar");
        btn_alterar_mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterar_mesaActionPerformed(evt);
            }
        });

        btn_excluir_mesa.setBackground(new java.awt.Color(255, 153, 153));
        btn_excluir_mesa.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_excluir_mesa.setText("Excluir");
        btn_excluir_mesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluir_mesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_opcoesLayout = new javax.swing.GroupLayout(pnl_opcoes);
        pnl_opcoes.setLayout(pnl_opcoesLayout);
        pnl_opcoesLayout.setHorizontalGroup(
            pnl_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_opcoesLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(btn_alterar_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_excluir_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addGap(78, 78, 78))
        );
        pnl_opcoesLayout.setVerticalGroup(
            pnl_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_opcoesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnl_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_alterar_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_excluir_mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pnl_filtro_tabela.setBackground(new java.awt.Color(246, 242, 233));
        pnl_filtro_tabela.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N

        btn_filtro_status.setBackground(new java.awt.Color(255, 243, 198));
        btn_filtro_status.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btn_filtro_status.setText("Status");
        btn_filtro_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_statusActionPerformed(evt);
            }
        });

        btn_filtro_numero.setBackground(new java.awt.Color(255, 243, 198));
        btn_filtro_numero.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btn_filtro_numero.setText("Número");
        btn_filtro_numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_numeroActionPerformed(evt);
            }
        });

        btn_filtro_todos.setBackground(new java.awt.Color(255, 243, 198));
        btn_filtro_todos.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btn_filtro_todos.setText("Todos");
        btn_filtro_todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_todosActionPerformed(evt);
            }
        });

        tableMesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableMesaKeyReleased(evt);
            }
        });

        jtMesa.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jtMesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Número Mesa (ID)", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtMesa.setRowHeight(30);
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

        javax.swing.GroupLayout pnl_filtro_tabelaLayout = new javax.swing.GroupLayout(pnl_filtro_tabela);
        pnl_filtro_tabela.setLayout(pnl_filtro_tabelaLayout);
        pnl_filtro_tabelaLayout.setHorizontalGroup(
            pnl_filtro_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_filtro_tabelaLayout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(btn_filtro_status, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_filtro_numero, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_filtro_todos, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addGap(371, 371, 371))
            .addGroup(pnl_filtro_tabelaLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(tableMesa)
                .addGap(187, 187, 187))
        );
        pnl_filtro_tabelaLayout.setVerticalGroup(
            pnl_filtro_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_filtro_tabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_filtro_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_filtro_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_filtro_status, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_filtro_todos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tableMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnl_tela_mesaLayout = new javax.swing.GroupLayout(pnl_tela_mesa);
        pnl_tela_mesa.setLayout(pnl_tela_mesaLayout);
        pnl_tela_mesaLayout.setHorizontalGroup(
            pnl_tela_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tela_mesaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_tela_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_tela_mesaLayout.createSequentialGroup()
                        .addComponent(pnl_cadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(pnl_opcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE))
                    .addComponent(pnl_filtro_tabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_tela_mesaLayout.setVerticalGroup(
            pnl_tela_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tela_mesaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnl_tela_mesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_cadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(pnl_opcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnl_filtro_tabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_opcoes.getAccessibleContext().setAccessibleName("OPCOES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_tela_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_tela_mesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1394, 807));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_numero_mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numero_mesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numero_mesaActionPerformed

    private void btn_cadastrar_mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrar_mesaActionPerformed

        if (verificarSeCampoEstaEmBranco(txt_numero_mesa, "Número da mesa") && txt_numero_mesa.getText().length() <= 10) {
            Mesa mesa = new Mesa();
            mesa.setIdMesa(Integer.parseInt(txt_numero_mesa.getText()));
            MesaDao mesaDAO = new MesaDao();
            try {
                boolean criouMesa = mesaDAO.criarMesa(mesa) ? true : false;
                if (criouMesa == true) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Mesa cadastrada com sucesso!\n"
                            + "Nº mesa: "
                            + mesa.getIdMesa()
                    );
                    this.txt_numero_mesa.setText("");
                }
                limparTxtFields();
                listarJtablePorStatus("Ativado");
            } catch (SQLIntegrityConstraintViolationException ex) {
                JOptionPane.showMessageDialog(null, "Mesa já cadastrada!", "ERRO", HEIGHT);
                txt_numero_mesa.setText("");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Número inválido, use número inteiro de até 10 dígitos!", "ERRO", HEIGHT);
                txt_numero_mesa.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Número inválido, use número inteiro de até 10 dígitos!");
        }

    }//GEN-LAST:event_btn_cadastrar_mesaActionPerformed

    private void jtMesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMesaMouseClicked

    }//GEN-LAST:event_jtMesaMouseClicked

    private void jtMesaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMesaMouseReleased

        if (jtMesa.getSelectedRow() != -1) {
            txt_numero_mesa.setText(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString());
            idMesaParaAlterar = Integer.parseInt(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jtMesaMouseReleased

    private void jtMesaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtMesaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtMesaKeyPressed

    private void jtMesaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtMesaKeyReleased

        if (jtMesa.getSelectedRow() != -1) {
            txt_numero_mesa.setText(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString());
            idMesaParaAlterar = Integer.parseInt(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jtMesaKeyReleased

    private void tableMesaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableMesaKeyReleased

    }//GEN-LAST:event_tableMesaKeyReleased

    private void btn_filtro_numeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_numeroActionPerformed

        if (jtMesa.getRowCount() != -1) {
            try {

                JPanel painel = new JPanel();
                JLabel numeroMesa = new JLabel("Número: ");
                JTextField digitarNumero = new JTextField(10);
                painel.add(numeroMesa);
                painel.add(digitarNumero);
                int resultado = JOptionPane.showConfirmDialog(null, painel, "Pesquisar por número.", JOptionPane.OK_CANCEL_OPTION, -1);
                if (resultado == JOptionPane.OK_OPTION) {
                    listarJtablePorNumero(Integer.parseInt(digitarNumero.getText()));
                }
            } catch (Exception e) {
                //JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Mesa não cadastrada!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma mesa cadastrada!");
        }

    }//GEN-LAST:event_btn_filtro_numeroActionPerformed

    private void btn_filtro_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_statusActionPerformed
        JPanel painel = new JPanel();
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Ativado");
        comboBox.addItem("Desativado");
        painel.add(new JLabel("Status: "));
        painel.add(comboBox);
        int result = JOptionPane.showConfirmDialog(null, painel, "Filtrar por status da mesa.", JOptionPane.OK_CANCEL_OPTION, -1);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String status = String.valueOf(comboBox.getSelectedItem());
                listarJtablePorStatus(status);
                if (jtMesa.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Não há mesas no status " + status);
                    listarJtablePorStatus("ativado");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_filtro_statusActionPerformed

    private void btn_filtro_todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_todosActionPerformed
        try {
            listarJtable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_filtro_todosActionPerformed

    private void btn_excluir_mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluir_mesaActionPerformed
        if (String.valueOf(jtMesa.getValueAt(jtMesa.getSelectedRow(), 1).toString()).equalsIgnoreCase("Desativado")) {
            JOptionPane.showMessageDialog(null, "Mesa já se encontra desativada!");
        } else {

            if (jtMesa.getSelectedRow() != -1) {
                int confirma = JOptionPane.showConfirmDialog(
                        this,
                        "Deseja deletar a mesa " + String.valueOf(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString()) + "?",
                        "CONFIRMAR DELEÇÃO",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (confirma == JOptionPane.YES_OPTION) {
                    try {
                        MesaDao mesaDAO = new MesaDao();
                        Mesa mesa = mesaDAO.listarMesaPorId(Integer.parseInt(jtMesa.getValueAt(jtMesa.getSelectedRow(), 0).toString()));
                        mesaDAO.deletaMesa(mesa.getIdMesa());
                        JOptionPane.showMessageDialog(null, "Mesa excluída com sucesso!");
                        limparTxtFields();
                        listarJtablePorStatus("Ativado");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                } else if (confirma == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Operacão cancelada!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma mesa para excluir.");
            }
        }
    }//GEN-LAST:event_btn_excluir_mesaActionPerformed

    private void btn_alterar_mesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterar_mesaActionPerformed
        if (jtMesa.getSelectedRow() != -1) {
            atualizaMesa();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma mesa! ", "Mesa não selecionada!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_alterar_mesaActionPerformed

    private void txt_numero_mesaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_numero_mesaKeyPressed
        numerosApenas(txt_numero_mesa, evt);
    }//GEN-LAST:event_txt_numero_mesaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alterar_mesa;
    private javax.swing.JButton btn_cadastrar_mesa;
    private javax.swing.JButton btn_excluir_mesa;
    private javax.swing.JButton btn_filtro_numero;
    private javax.swing.JButton btn_filtro_status;
    private javax.swing.JButton btn_filtro_todos;
    private javax.swing.JTable jtMesa;
    private javax.swing.JLabel lbl_NumeroMesa;
    private javax.swing.JPanel pnl_cadastro;
    private javax.swing.JPanel pnl_filtro_tabela;
    private javax.swing.JPanel pnl_opcoes;
    private javax.swing.JPanel pnl_tela_mesa;
    private javax.swing.JScrollPane tableMesa;
    private javax.swing.JTextField txt_numero_mesa;
    // End of variables declaration//GEN-END:variables
}
