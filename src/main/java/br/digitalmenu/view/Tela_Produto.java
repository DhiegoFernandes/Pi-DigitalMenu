package br.digitalmenu.view;

import br.digitalmenu.dao.CategoriaDao;
import br.digitalmenu.dao.ProdutoDao;
import br.digitalmenu.model.Categoria;
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
import javax.swing.table.TableRowSorter;

public class Tela_Produto extends javax.swing.JInternalFrame {

    String auxNome, auxCat, auxDesc, auxStatus;
    double auxPreco;

    public Tela_Produto() throws SQLException {
        initComponents();
        viewCategoria();
        txtId.setEnabled(false);
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        jtProduto.setRowSorter(new TableRowSorter(modelo));
        listarJTableProdutosAtivados();

    }

    public void listarJTableTodosProdutos() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);
        ProdutoDao prodDao = new ProdutoDao();
        for (Produto prod : prodDao.listarProduto()) {
            modelo.addRow(new Object[]{
                prod.getIdProduto(),
                prod.getNome(),
                prod.getNomeCategoria(),
                prod.getPreco(),
                prod.getDescricao(),
                prod.getStatus()
            });
        }
    }

    public void listarJTableProdutosAtivados() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);
        ProdutoDao prodDao = new ProdutoDao();
        for (Produto prod : prodDao.listarProdutosAtivos()) {
            modelo.addRow(new Object[]{
                prod.getIdProduto(),
                prod.getNome(),
                prod.getNomeCategoria(),
                prod.getPreco(),
                prod.getDescricao(),
                prod.getStatus()
            });
        }
    }

    public void listarJtablePorNome(String texto) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);
        ProdutoDao produtoDao = new ProdutoDao();
        for (Produto produto : produtoDao.listarProdutoPorNome(texto)) {
            modelo.addRow(new Object[]{
                produto.getIdProduto(),
                produto.getNome(),
                produto.getNomeCategoria(),
                produto.getPreco(),
                produto.getDescricao(),
                produto.getStatus()
            });
        }
    }

    public void listarJtablePorFaixaDePreco(double valor1, double valor2) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);
        ProdutoDao produtoDao = new ProdutoDao();
        for (Produto produto : produtoDao.listarProdutoPorFaixaDePreco(valor1, valor2)) {
            modelo.addRow(new Object[]{
                produto.getIdProduto(),
                produto.getNome(),
                produto.getNomeCategoria(),
                produto.getPreco(),
                produto.getDescricao(),
                produto.getStatus()
            });
        }
    }

    public void listarJtablePorDescricao(String palavra) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);
        ProdutoDao produtoDao = new ProdutoDao();
        for (Produto produto : produtoDao.listarProdutoPorDescricacao(palavra)) {
            modelo.addRow(new Object[]{
                produto.getIdProduto(),
                produto.getNome(),
                produto.getNomeCategoria(),
                produto.getPreco(),
                produto.getDescricao(),
                produto.getStatus()
            });
        }
    }

    public void listarJtablePorCategoria(String nomeCategoria) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);
        ProdutoDao produtoDao = new ProdutoDao();
        for (Produto produto : produtoDao.listarProdutoPorCategoria(nomeCategoria)) {
            modelo.addRow(new Object[]{
                produto.getIdProduto(),
                produto.getNome(),
                produto.getNomeCategoria(),
                produto.getPreco(),
                produto.getDescricao(),
                produto.getStatus()
            });
        }
    }

    public void listarJtablePorStatus(String status) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);
        ProdutoDao produtoDao = new ProdutoDao();
        for (Produto produto : produtoDao.listarProdutoPorStatus(status)) {
            modelo.addRow(new Object[]{
                produto.getIdProduto(),
                produto.getNome(),
                produto.getNomeCategoria(),
                produto.getPreco(),
                produto.getDescricao(),
                produto.getStatus()
            });
        }
    }

    public void viewCategoria() throws SQLException {
        CategoriaDao catDao = new CategoriaDao();
        for (Categoria categoria : catDao.listarCategoria()) {
            cboxCategoria.addItem(categoria.getNomeCategoria());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        cboxCategoria = new javax.swing.JComboBox<>();
        lblDescricao = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        txtformatPreco = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea_Descricao = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        btnDeletar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_Pesquisa_Nome = new javax.swing.JButton();
        btn_Pesquisa_Preco = new javax.swing.JButton();
        btn_Pesquisa_Descricao = new javax.swing.JButton();
        btn_Pesquisa_Categoria = new javax.swing.JButton();
        btn_Pesquisa_Status = new javax.swing.JButton();
        btn_ListarTodosAtvios = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProduto = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro"));

        lblId.setText("ID:");

        lblNome.setText("Nome:");

        lblCategoria.setText("Categoria");

        cboxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCategoriaActionPerformed(evt);
            }
        });

        lblDescricao.setText("Descrição:");

        lblPreco.setText("Preço:");

        btnSalvar.setText("Cadastrar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtarea_Descricao.setColumns(20);
        txtarea_Descricao.setLineWrap(true);
        txtarea_Descricao.setRows(5);
        jScrollPane2.setViewportView(txtarea_Descricao);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Alterar"));

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCategoria)
                                .addComponent(lblNome)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(lblId)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNome)
                                .addComponent(cboxCategoria, 0, 169, Short.MAX_VALUE))
                            .addGap(24, 24, 24)
                            .addComponent(lblPreco)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtformatPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(lblDescricao)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPreco)
                    .addComponent(txtformatPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(cboxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescricao)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("PESQUISAR POR"));

        btn_Pesquisa_Nome.setText("Nome");
        btn_Pesquisa_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Pesquisa_NomeActionPerformed(evt);
            }
        });

        btn_Pesquisa_Preco.setText("Faixa de preço");
        btn_Pesquisa_Preco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Pesquisa_PrecoActionPerformed(evt);
            }
        });

        btn_Pesquisa_Descricao.setText("Descrição");
        btn_Pesquisa_Descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Pesquisa_DescricaoActionPerformed(evt);
            }
        });

        btn_Pesquisa_Categoria.setText("Categoria");
        btn_Pesquisa_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Pesquisa_CategoriaActionPerformed(evt);
            }
        });

        btn_Pesquisa_Status.setText("Status");
        btn_Pesquisa_Status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Pesquisa_StatusActionPerformed(evt);
            }
        });

        btn_ListarTodosAtvios.setText("Listar todos ativos");
        btn_ListarTodosAtvios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ListarTodosAtviosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btn_Pesquisa_Nome)
                .addGap(20, 20, 20)
                .addComponent(btn_Pesquisa_Preco)
                .addGap(20, 20, 20)
                .addComponent(btn_Pesquisa_Descricao)
                .addGap(20, 20, 20)
                .addComponent(btn_Pesquisa_Categoria)
                .addGap(20, 20, 20)
                .addComponent(btn_Pesquisa_Status)
                .addGap(20, 20, 20)
                .addComponent(btn_ListarTodosAtvios)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_ListarTodosAtvios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Pesquisa_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Pesquisa_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Pesquisa_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Pesquisa_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Pesquisa_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Categoria", "Preço", "Descrição", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtProdutoMouseReleased(evt);
            }
        });
        jtProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtProdutoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtProduto);
        if (jtProduto.getColumnModel().getColumnCount() > 0) {
            jtProduto.getColumnModel().getColumn(0).setPreferredWidth(10);
            jtProduto.getColumnModel().getColumn(5).setPreferredWidth(15);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed

        if (jtProduto.getSelectedRow() != -1) {
            int confirma = JOptionPane.showConfirmDialog(this,
                    "Deletar produto: "
                    + "\nID: "
                    + txtId.getText()
                    + "\nNome: "
                    + txtNome.getText(),
                    "CONFIRMA DELEÇÃO?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (confirma == JOptionPane.YES_OPTION) {
                Produto p = new Produto();
                p.setIdProduto(Integer.parseInt(txtId.getText()));
                ProdutoDao pDao = new ProdutoDao();
                try {
                    pDao.deletaProduto(p);
                    JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
                    listarJTableProdutosAtivados();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                }
            } else if (confirma == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "operação cancelada!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        }

    }//GEN-LAST:event_btnDeletarActionPerformed

    private void cboxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxCategoriaActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        Produto p = new Produto();
        p.setNome(txtNome.getText());
        p.setPreco(Double.parseDouble(txtformatPreco.getText().replace(',', '.')));
        p.setDescricao(txtarea_Descricao.getText());
        p.setNomeCategoria(cboxCategoria.getSelectedItem().toString());
//        p.setStatus(checkboxStatus.isSelected() ? "Ativado" : "Desativado");
        ProdutoDao pDao = new ProdutoDao();
        try {
            pDao.createProduto(p);
            JOptionPane.showMessageDialog(null, "PRODUTO (" + p.getNome() + ") CRIADO COM SUCESSO!");
            listarJTableProdutosAtivados();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jtProdutoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutoMouseReleased

        if (jtProduto.getSelectedRow() != -1) {
            txtId.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 0).toString());
            txtNome.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 1).toString());
            cboxCategoria.setSelectedItem(jtProduto.getValueAt(jtProduto.getSelectedRow(), 2).toString());
            txtarea_Descricao.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 4).toString());
            txtformatPreco.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 3).toString());
//            checkboxStatus.setSelected(jtProduto.getValueAt(jtProduto.getSelectedRow(), 5).toString().equalsIgnoreCase("ativado"));
            auxNome = txtNome.getText();
            auxPreco = Double.parseDouble(txtformatPreco.getText());
            auxCat = cboxCategoria.getSelectedItem().toString();
            auxDesc = txtarea_Descricao.getText();
//            auxStatus = checkboxStatus.isSelected() ? "Ativado" : "Desativado";
        }
    }//GEN-LAST:event_jtProdutoMouseReleased

    private void jtProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtProdutoKeyReleased

        if (jtProduto.getSelectedRow() != -1) {
            txtId.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 0).toString());
            txtNome.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 1).toString());
            cboxCategoria.setSelectedItem(jtProduto.getValueAt(jtProduto.getSelectedRow(), 2).toString());
            txtarea_Descricao.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 4).toString());
            txtformatPreco.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 3).toString());
//            checkboxStatus.setSelected(jtProduto.getValueAt(jtProduto.getSelectedRow(), 5).toString().equalsIgnoreCase("ativado"));
        }
    }//GEN-LAST:event_jtProdutoKeyReleased

    private void btn_Pesquisa_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Pesquisa_NomeActionPerformed
        JPanel painel = new JPanel();
        JLabel nomeProduto = new JLabel("Palavra: ");
        JTextField digitarPalavra = new JTextField(25);
        painel.add(nomeProduto);
        painel.add(digitarPalavra);
        int result = JOptionPane.showConfirmDialog(null, painel, "Pesquisar produto", JOptionPane.OK_CANCEL_OPTION);
        String palavraPesquisar = digitarPalavra.getText();
        if (result == JOptionPane.OK_OPTION) {
            try {
                listarJtablePorNome(palavraPesquisar);
                if (jtProduto.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Palavra não encontrada.");
                    listarJTableProdutosAtivados();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_Pesquisa_NomeActionPerformed

    private void btn_Pesquisa_PrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Pesquisa_PrecoActionPerformed
        // TODO add your handling code here:
        JTextField valorInicial = new JTextField(10);
        JTextField valorFinal = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("De:"));
        myPanel.add(valorInicial);
        myPanel.add(Box.createHorizontalStrut(10)); // a spacer
        myPanel.add(new JLabel("Até:"));
        myPanel.add(valorFinal);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Informe a faixa de preço", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                double valor1 = Double.parseDouble(valorInicial.getText().replace(',', '.'));
                double valor2 = Double.parseDouble(valorFinal.getText().replace(',', '.'));
                listarJtablePorFaixaDePreco(valor1, valor2);
                if (jtProduto.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Faixa de preço não encontrada.");
                    listarJTableProdutosAtivados();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_Pesquisa_PrecoActionPerformed

    private void btn_Pesquisa_DescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Pesquisa_DescricaoActionPerformed
        // TODO add your handling code here:
        String palavra = JOptionPane.showInputDialog("Palavra a pesquisar:");
        try {
            listarJtablePorDescricao(palavra);
            if (jtProduto.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Palavra não encontrada.");
                listarJTableProdutosAtivados();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_Pesquisa_DescricaoActionPerformed

    private void btn_Pesquisa_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Pesquisa_CategoriaActionPerformed
        JPanel painel = new JPanel();
        painel.add(new JLabel("Categoria: "));
        painel.add(cboxCategoria);

        int result = JOptionPane.showConfirmDialog(null, painel, "Selecione a categoria.", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String categoria = String.valueOf(cboxCategoria.getSelectedItem());
                listarJtablePorCategoria(categoria);
                if (jtProduto.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Não há produtos da categoria: " + categoria);
                    listarJTableProdutosAtivados();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_btn_Pesquisa_CategoriaActionPerformed

    private void btn_Pesquisa_StatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Pesquisa_StatusActionPerformed
        JPanel painel = new JPanel();
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Ativado");
        comboBox.addItem("Desativado");
        painel.add(new JLabel("Status: "));
        painel.add(comboBox);
        int result = JOptionPane.showConfirmDialog(null, painel, "Selecione o status.", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String status = String.valueOf(comboBox.getSelectedItem());
                listarJtablePorStatus(status);
                if (jtProduto.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Não há produtos no status " + status);
                    listarJTableTodosProdutos();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_Pesquisa_StatusActionPerformed

    private void btn_ListarTodosAtviosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ListarTodosAtviosActionPerformed
        try {
            listarJTableProdutosAtivados();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_ListarTodosAtviosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto;
        try {
            produto = produtoDao.listarProdutoPorId(Integer.parseInt(txtId.getText()));
            Panel_Alterar_Produto pteste = new Panel_Alterar_Produto(produto);
            int opcao = JOptionPane.showConfirmDialog(null, pteste, "ALTERAR PRODUTO", JOptionPane.OK_CANCEL_OPTION);
            if (opcao == JOptionPane.OK_OPTION) {
                Produto p = new Produto();
                p.setIdProduto(Integer.parseInt(pteste.getLbl_Id_Valor().getText()));
                p.setNome(pteste.getTxt_Nome_Novo().getText());
                p.setPreco(Double.parseDouble(pteste.getTxt_Preco_Novo().getText().replace(',', '.')));
                p.setNomeCategoria(pteste.getCbox_Categoria_Novo().getSelectedItem().toString());
                p.setDescricao(pteste.getTxtarea_Descricao_Novo().getText());
                p.setStatus(pteste.getCheckbox_Status_Novo().isSelected() ? "Ativado" : "Desativado");
                ProdutoDao pDao = new ProdutoDao();
                pDao.alterarProduto(p);
                listarJTableProdutosAtivados();
            } else if (opcao == JOptionPane.CANCEL_OPTION){
               JOptionPane.showMessageDialog(null, "cancelado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btn_ListarTodosAtvios;
    private javax.swing.JButton btn_Pesquisa_Categoria;
    private javax.swing.JButton btn_Pesquisa_Descricao;
    private javax.swing.JButton btn_Pesquisa_Nome;
    private javax.swing.JButton btn_Pesquisa_Preco;
    private javax.swing.JButton btn_Pesquisa_Status;
    private javax.swing.JComboBox<String> cboxCategoria;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtProduto;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextArea txtarea_Descricao;
    private javax.swing.JFormattedTextField txtformatPreco;
    // End of variables declaration//GEN-END:variables
}
