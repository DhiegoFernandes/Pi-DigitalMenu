package br.digitalmenu.view;

import br.digitalmenu.model.Categoria;
import br.digitalmenu.model.Usuario;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class Panel_Alterar_Usuario extends javax.swing.JPanel {

    public Usuario user;

    public Panel_Alterar_Usuario(Usuario user) throws SQLException {
        initComponents();
        this.user = user;
        setDados();
    }

    public void setDados() {
        lbl_id_valor.setText(String.valueOf(user.getIdusuario()));
        lbl_id_atual.setText(String.valueOf(user.getIdusuario()));
        txt_id_novo.setText(String.valueOf(user.getIdusuario()));
        lbl_usuario_atual.setText(user.getUsuario());
        txt_usuario_novo.setText(user.getUsuario());
        lbl_senha_atual.setText(String.valueOf(user.getSenha()));
        txt_senha_nova.setText(user.getSenha());
        
        lbl_tipoacesso_atual.setText(String.valueOf(user.getTipoacesso()));
        comboBox_tipoAcesso_novo.setSelectedItem(user.getTipoacesso());
        
        lbl_status_atual.setText(String.valueOf(user.getStatus()));
        comboBox_status_novo.setSelectedItem(user.getStatus());
    }

    public JComboBox<String> getComboBox_status_novo() {
        return comboBox_status_novo;
    }

    public JTextField getTxt_id_novo() {
        return txt_id_novo;
    }

    public JTextField getTxt_usuario_novo() {
        return txt_usuario_novo;
    }

    public JTextField getTxt_senha_nova() {
        return txt_senha_nova;
    }
    
    public JComboBox<String> getComboBox_tipoAcesso_novo() {
        return comboBox_tipoAcesso_novo;
    }

    public JLabel getLbl_senha() {
        return lbl_senha;
    }

    public void setLbl_senha(JLabel lbl_senha) {
        this.lbl_senha = lbl_senha;
    }

    public JLabel getLbl_senha_atual() {
        return lbl_senha_atual;
    }

    public void setLbl_senha_atual(JLabel lbl_senha_atual) {
        this.lbl_senha_atual = lbl_senha_atual;
    }

    public JLabel getLbl_usuario() {
        return lbl_usuario;
    }

    public void setLbl_usuario(JLabel lbl_usuario) {
        this.lbl_usuario = lbl_usuario;
    }

    public JLabel getLbl_usuario_atual() {
        return lbl_usuario_atual;
    }

    public void setLbl_usuario_atual(JLabel lbl_usuario_atual) {
        this.lbl_usuario_atual = lbl_usuario_atual;
    }

    public JLabel getLbl_id() {
        return lbl_id;
    }

    public void setLbl_id(JLabel lbl_id) {
        this.lbl_id = lbl_id;
    }

    public JLabel getLbl_id_atual() {
        return lbl_id_atual;
    }

    public void setLbl_id_atual(JLabel lbl_id_atual) {
        this.lbl_id_atual = lbl_id_atual;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_alterar_categoria = new javax.swing.JPanel();
        lbl_id = new javax.swing.JLabel();
        lbl_id_valor = new javax.swing.JLabel();
        lbl_dados_atuais = new javax.swing.JLabel();
        lbl_dados_novos = new javax.swing.JLabel();
        lbl_numero_id = new javax.swing.JLabel();
        lbl_id_atual = new javax.swing.JLabel();
        txt_id_novo = new javax.swing.JTextField();
        lbl_usuario = new javax.swing.JLabel();
        lbl_usuario_atual = new javax.swing.JLabel();
        txt_usuario_novo = new javax.swing.JTextField();
        lbl_status = new javax.swing.JLabel();
        lbl_status_atual = new javax.swing.JLabel();
        comboBox_status_novo = new javax.swing.JComboBox<>();
        filler24 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        lbl_senha_atual = new javax.swing.JLabel();
        lbl_senha = new javax.swing.JLabel();
        txt_senha_nova = new javax.swing.JTextField();
        lbl_tipoacesso_atual = new javax.swing.JLabel();
        lbl_tipoAcesso = new javax.swing.JLabel();
        comboBox_tipoAcesso_novo = new javax.swing.JComboBox<>();

        pnl_alterar_categoria.setBackground(new java.awt.Color(246, 242, 233));
        pnl_alterar_categoria.setBorder(javax.swing.BorderFactory.createTitledBorder("ATUALIZAR USUÁRIO"));

        lbl_id.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_id.setText("ID : ");

        lbl_id_valor.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_id_valor.setText("n.Id");

        lbl_dados_atuais.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_dados_atuais.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dados_atuais.setText("Dados Atuais");

        lbl_dados_novos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_dados_novos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dados_novos.setText("Atualizações");

        lbl_numero_id.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_numero_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_numero_id.setText("Número/Id");

        lbl_id_atual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_id_atual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_id_atual.setText("num/id");

        txt_id_novo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_id_novo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id_novo.setEnabled(false);
        txt_id_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_novoActionPerformed(evt);
            }
        });

        lbl_usuario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_usuario.setText("Usuario");

        lbl_usuario_atual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_usuario_atual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_usuario_atual.setText("Usuario");

        txt_usuario_novo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_usuario_novo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_usuario_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuario_novoActionPerformed(evt);
            }
        });
        txt_usuario_novo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuario_novoKeyPressed(evt);
            }
        });

        lbl_status.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_status.setText("Status");

        lbl_status_atual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_status_atual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_status_atual.setText("Status");

        comboBox_status_novo.setBackground(new java.awt.Color(255, 232, 142));
        comboBox_status_novo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        comboBox_status_novo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativado", "Desativado" }));

        filler24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_senha_atual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_senha_atual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_senha_atual.setText("Senha");

        lbl_senha.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_senha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_senha.setText("Senha");

        txt_senha_nova.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_senha_nova.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_senha_nova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_senha_novaActionPerformed(evt);
            }
        });
        txt_senha_nova.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_senha_novaKeyPressed(evt);
            }
        });

        lbl_tipoacesso_atual.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_tipoacesso_atual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tipoacesso_atual.setText("TipoAcesso");

        lbl_tipoAcesso.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_tipoAcesso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tipoAcesso.setText("Tipo de Acesso");

        comboBox_tipoAcesso_novo.setBackground(new java.awt.Color(255, 232, 142));
        comboBox_tipoAcesso_novo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        comboBox_tipoAcesso_novo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "administrador", "atendente" }));

        javax.swing.GroupLayout pnl_alterar_categoriaLayout = new javax.swing.GroupLayout(pnl_alterar_categoria);
        pnl_alterar_categoria.setLayout(pnl_alterar_categoriaLayout);
        pnl_alterar_categoriaLayout.setHorizontalGroup(
            pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                        .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lbl_numero_id))
                            .addComponent(lbl_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_tipoAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lbl_id_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_usuario_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_senha_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_tipoacesso_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_status_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(txt_senha_nova, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox_tipoAcesso_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox_status_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_usuario_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_id_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_alterar_categoriaLayout.createSequentialGroup()
                                .addComponent(lbl_dados_novos, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))))
                    .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                                .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(560, 560, 560))
                            .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                                .addComponent(lbl_id)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_id_valor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                .addComponent(lbl_dados_atuais, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnl_alterar_categoriaLayout.setVerticalGroup(
            pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_dados_novos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_dados_atuais, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_alterar_categoriaLayout.createSequentialGroup()
                        .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_id_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(filler24, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_id_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_id_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_numero_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_usuario_novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_usuario_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_senha_nova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_senha_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBox_tipoAcesso_novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_tipoAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_tipoacesso_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_alterar_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBox_status_novo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_status_atual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_alterar_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_alterar_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_senha_novaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_senha_novaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_senha_novaKeyPressed

    private void txt_senha_novaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_senha_novaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_senha_novaActionPerformed

    private void txt_usuario_novoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuario_novoKeyPressed

    }//GEN-LAST:event_txt_usuario_novoKeyPressed

    private void txt_usuario_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuario_novoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuario_novoActionPerformed

    private void txt_id_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_novoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_novoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBox_status_novo;
    private javax.swing.JComboBox<String> comboBox_tipoAcesso_novo;
    private javax.swing.Box.Filler filler24;
    private javax.swing.JLabel lbl_dados_atuais;
    private javax.swing.JLabel lbl_dados_novos;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_id_atual;
    private javax.swing.JLabel lbl_id_valor;
    private javax.swing.JLabel lbl_numero_id;
    private javax.swing.JLabel lbl_senha;
    private javax.swing.JLabel lbl_senha_atual;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_status_atual;
    private javax.swing.JLabel lbl_tipoAcesso;
    private javax.swing.JLabel lbl_tipoacesso_atual;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JLabel lbl_usuario_atual;
    private javax.swing.JPanel pnl_alterar_categoria;
    private javax.swing.JTextField txt_id_novo;
    private javax.swing.JTextField txt_senha_nova;
    private javax.swing.JTextField txt_usuario_novo;
    // End of variables declaration//GEN-END:variables
}
