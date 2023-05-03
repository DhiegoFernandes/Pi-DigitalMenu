package br.digitalmenu.view;

import br.digitalmenu.dao.CategoriaDao;
import br.digitalmenu.model.Categoria;
import br.digitalmenu.model.Produto;
import java.sql.SQLException;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel_Alterar_Produto extends javax.swing.JPanel {

    public Produto produto;
   

    public Panel_Alterar_Produto(Produto produto) throws SQLException {
        initComponents();
        this.produto = produto;
        viewCategoria();
        setDados();
        
    }

    public void viewCategoria() throws SQLException {
        CategoriaDao catDao = new CategoriaDao();
        for (Categoria categoria : catDao.listarCategoria()) {
            cbox_Categoria_Novo.addItem(categoria.getNomeCategoria());
        }
    }

    public void setDados() throws SQLException {
        lbl_Id_Valor.setText(String.valueOf(produto.getIdProduto()));
        lbl_Nome_Atual.setText(String.valueOf(produto.getNome()));
        txt_Nome_Novo.setText(String.valueOf(produto.getNome()));
        lbl_Preco_Atual.setText(String.valueOf(produto.getPreco()));
        txt_Preco_Novo.setText(String.valueOf(produto.getPreco()));
        lbl_Categoria_Atual.setText(String.valueOf(produto.getNomeCategoria()));
        cbox_Categoria_Novo.setSelectedItem(produto.getNomeCategoria());
        txtarea_Descricao_Atual.setText(String.valueOf(produto.getDescricao()));
        txtarea_Descricao_Novo.setText(String.valueOf(produto.getDescricao()));
//        System.out.println(produto.getStatus());
//        String status = produto.getStatus().equalsIgnoreCase("Ativado") ? "Ativado" : "Desativado";
        x.setText(produto.getStatus());
        if (produto.getStatus().equalsIgnoreCase("Ativado")) {
//            checkbox_Status_Atual.doClick();
            checkbox_Status_Novo.doClick();
        }
//        checkbox_Status_Atual.setEnabled(false);
        txtarea_Descricao_Atual.setEditable(false);
    }

    public JComboBox<String> getCbox_Categoria_Novo() {
        return cbox_Categoria_Novo;
    }

    public JCheckBox getCheckbox_Status_Novo() {
        return checkbox_Status_Novo;
    }

    public JTextField getTxt_Nome_Novo() {
        return txt_Nome_Novo;
    }

    public JTextField getTxt_Preco_Novo() {
        return txt_Preco_Novo;
    }

    public JTextArea getTxtarea_Descricao_Novo() {
        return txtarea_Descricao_Novo;
    }

    public JLabel getLbl_IdProduto1() {
        return lbl_IdProduto1;
    }

    public JLabel getLbl_Id_Valor() {
        return lbl_Id_Valor;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_Nome = new javax.swing.JLabel();
        lbl_Nome_Atual = new javax.swing.JLabel();
        txt_Nome_Novo = new javax.swing.JTextField();
        lbl_Preco = new javax.swing.JLabel();
        lbl_Preco_Atual = new javax.swing.JLabel();
        txt_Preco_Novo = new javax.swing.JTextField();
        lbl_Categoria = new javax.swing.JLabel();
        lbl_Categoria_Atual = new javax.swing.JLabel();
        cbox_Categoria_Novo = new javax.swing.JComboBox<>();
        lbl_Descricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea_Descricao_Atual = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea_Descricao_Novo = new javax.swing.JTextArea();
        lbl_Status = new javax.swing.JLabel();
        checkbox_Status_Novo = new javax.swing.JCheckBox();
        filler18 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        filler21 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        filler22 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        lbl_IdProduto = new javax.swing.JLabel();
        lbl_IdProduto1 = new javax.swing.JLabel();
        filler24 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        lbl_Id = new javax.swing.JLabel();
        lbl_Id_Valor = new javax.swing.JLabel();
        x = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Atual"));

        lbl_Nome.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_Nome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Nome.setText("Nome:");

        lbl_Nome_Atual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Nome_Atual.setText("jLabel1");

        txt_Nome_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Nome_NovoActionPerformed(evt);
            }
        });

        lbl_Preco.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_Preco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Preco.setText("Preço:");

        lbl_Preco_Atual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Preco_Atual.setText("jLabel1");

        lbl_Categoria.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_Categoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Categoria.setText("Categoria:");

        lbl_Categoria_Atual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Categoria_Atual.setText("jLabel1");

        lbl_Descricao.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_Descricao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Descricao.setText("Descrição:");

        txtarea_Descricao_Atual.setColumns(20);
        txtarea_Descricao_Atual.setRows(5);
        jScrollPane1.setViewportView(txtarea_Descricao_Atual);

        txtarea_Descricao_Novo.setColumns(20);
        txtarea_Descricao_Novo.setRows(5);
        jScrollPane2.setViewportView(txtarea_Descricao_Novo);

        lbl_Status.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_Status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Status.setText("Status:");

        checkbox_Status_Novo.setText("Ativado");
        checkbox_Status_Novo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        filler18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        filler19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        filler21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        filler22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_IdProduto.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_IdProduto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_IdProduto.setText("Atualizações");

        lbl_IdProduto1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_IdProduto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_IdProduto1.setText("Dados Atuais");

        filler24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_Id.setText("ID : ");

        lbl_Id_Valor.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbl_Id_Valor.setText("ID : ");

        x.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x.setText("Status");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbl_Preco_Atual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbl_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbl_Categoria_Atual, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbl_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(lbl_Id)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lbl_Id_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbl_IdProduto1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbl_Nome_Atual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbox_Categoria_Novo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_Preco_Novo)
                                            .addComponent(txt_Nome_Novo)
                                            .addComponent(lbl_IdProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbl_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(checkbox_Status_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbl_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filler18, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filler19, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filler21, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filler22, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(filler24, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_IdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_IdProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_Id_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(filler24, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Nome_Atual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Nome_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(filler18, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Preco_Atual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Preco_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(filler19, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Categoria_Atual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbox_Categoria_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(filler21, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(filler22, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkbox_Status_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Nome_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Nome_NovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Nome_NovoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbox_Categoria_Novo;
    private javax.swing.JCheckBox checkbox_Status_Novo;
    private javax.swing.Box.Filler filler18;
    private javax.swing.Box.Filler filler19;
    private javax.swing.Box.Filler filler21;
    private javax.swing.Box.Filler filler22;
    private javax.swing.Box.Filler filler24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Categoria;
    private javax.swing.JLabel lbl_Categoria_Atual;
    private javax.swing.JLabel lbl_Descricao;
    private javax.swing.JLabel lbl_Id;
    private javax.swing.JLabel lbl_IdProduto;
    private javax.swing.JLabel lbl_IdProduto1;
    private javax.swing.JLabel lbl_Id_Valor;
    private javax.swing.JLabel lbl_Nome;
    private javax.swing.JLabel lbl_Nome_Atual;
    private javax.swing.JLabel lbl_Preco;
    private javax.swing.JLabel lbl_Preco_Atual;
    private javax.swing.JLabel lbl_Status;
    private javax.swing.JTextField txt_Nome_Novo;
    private javax.swing.JTextField txt_Preco_Novo;
    private javax.swing.JTextArea txtarea_Descricao_Atual;
    private javax.swing.JTextArea txtarea_Descricao_Novo;
    private javax.swing.JLabel x;
    // End of variables declaration//GEN-END:variables
}
