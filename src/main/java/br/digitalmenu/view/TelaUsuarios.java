package br.digitalmenu.view;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.digitalmenu.dao.UsuarioDAO;
import br.digitalmenu.heuristicas.Heuristica;
import br.digitalmenu.model.Usuario;
import java.sql.DataTruncation;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaUsuarios extends Heuristica {

    public TelaUsuarios() throws SQLException {
        initComponents();
        tblListaUsuarios.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
        IniciaTabela(tblListaUsuarios);//Formata a tabela e centraliza pela classe heuristicas
        ListaTabela();

    }

    public void atualizaUsuario() {
        if (tblListaUsuarios.getRowCount() != -1) {
            try {
                UsuarioDAO userDAO = new UsuarioDAO();
                Usuario user = userDAO.listarUsuariosPorId(Integer.parseInt(String.valueOf(tblListaUsuarios.getValueAt(tblListaUsuarios.getSelectedRow(), 0))));//trocar pelo TXT getTExt?
                Panel_Alterar_Usuario panel = new Panel_Alterar_Usuario(user);
                int resultado = JOptionPane.showConfirmDialog(null, panel, "ALTERAR USUÁRIO", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (resultado == JOptionPane.OK_OPTION) {
                    if (panel.getLbl_id_atual().getText().equalsIgnoreCase(panel.getTxt_id_novo().getText()) && panel.getLbl_usuario_atual().getText().equalsIgnoreCase(panel.getTxt_usuario_novo().getText())) {

                        user.setIdusuario(Integer.parseInt(panel.getTxt_id_novo().getText()));
                        user.setUsuario(panel.getTxt_usuario_novo().getText());
                        user.setSenha(panel.getTxt_senha_nova().getText());
                        user.setTipoacesso(panel.getComboBox_tipoAcesso_novo().getSelectedItem().toString());
                        user.setStatus(panel.getComboBox_status_novo().getSelectedItem().toString());
                        userDAO.atualizaUsuario(user);
                        JOptionPane.showMessageDialog(this,
                                "Usuário atualizado com sucesso!");
                        listarJTableTodosAtivos();

                    } else if (!(panel.getLbl_id().getText().equalsIgnoreCase(panel.getTxt_id_novo().getText())) && jaExiste(panel.getTxt_usuario_novo().getText()) == false) {
                        user.setIdusuario(Integer.parseInt(panel.getTxt_id_novo().getText()));
                        user.setUsuario(panel.getTxt_usuario_novo().getText());
                        user.setSenha(panel.getTxt_senha_nova().getText());
                        user.setTipoacesso(panel.getComboBox_tipoAcesso_novo().getSelectedItem().toString());
                        user.setStatus(panel.getComboBox_status_novo().getSelectedItem().toString());
                        userDAO.atualizaUsuario(user);
                        JOptionPane.showMessageDialog(this,
                                "Usuário atualizado com sucesso!");
                        listarJTableTodosAtivos();
                    } else if (jaExiste(panel.getTxt_usuario_novo().getText()) == true) {
                        JOptionPane.showMessageDialog(null, "Usuário já existente!");
                        atualizaUsuario();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Operação cancelada!");
                }
            } catch (SQLIntegrityConstraintViolationException ex) {
                JOptionPane.showMessageDialog(null, "Usuário já existente!", "\t\tERRO", HEIGHT);
                atualizaUsuario();
            } catch (DataTruncation ex) {
                JOptionPane.showMessageDialog(null, "Dado inválido, limite de 30 caracteres!", "\tErro", HEIGHT);
                atualizaUsuario();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha.");
        }
    }

    public void ListaTabela() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tblListaUsuarios.getModel();
        model.setNumRows(0);
        UsuarioDAO usuarios = new UsuarioDAO();
        for (Usuario UsuarioLocal : usuarios.listaTodosOsUsuarios()) {
            model.addRow(new Object[]{
                UsuarioLocal.getIdusuario(),
                UsuarioLocal.getUsuario(),
                UsuarioLocal.getSenha(),
                UsuarioLocal.getTipoacesso(),
                UsuarioLocal.getStatus(),});
        }
    }

    public void listarJTableTodosUsuarios() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tblListaUsuarios.getModel();
        modelo.setNumRows(0);
        UsuarioDAO userDAO = new UsuarioDAO();
        for (Usuario user : userDAO.listaTodosOsUsuarios()) {
            modelo.addRow(new Object[]{
                user.getIdusuario(),
                user.getUsuario(),
                user.getSenha(),
                user.getTipoacesso(),
                user.getStatus()
            });
        }
    }

    public void listarJTableTodosAtivos() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tblListaUsuarios.getModel();
        modelo.setNumRows(0);
        UsuarioDAO userDAO = new UsuarioDAO();
        for (Usuario user : userDAO.listarUsuariosAtivos()) {
            modelo.addRow(new Object[]{
                user.getIdusuario(),
                user.getUsuario(),
                user.getSenha(),
                user.getTipoacesso(),
                user.getStatus()
            });
        }
    }

    public void listarJTablePorId(int id) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tblListaUsuarios.getModel();
        modelo.setNumRows(0);
        UsuarioDAO userDAO = new UsuarioDAO();
        Usuario user = userDAO.listarUsuariosPorId(id);
        modelo.addRow(new Object[]{
            user.getIdusuario(),
            user.getUsuario(),
            user.getSenha(),
            user.getTipoacesso(),
            user.getStatus()
        });
    }

    public void listarJTablePorNome(String texto) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tblListaUsuarios.getModel();
        modelo.setNumRows(0);
        UsuarioDAO userDAO = new UsuarioDAO();
        for (Usuario user : userDAO.listarCategoriaPorNome(texto)) {
            modelo.addRow(new Object[]{
                user.getIdusuario(),
                user.getUsuario(),
                user.getSenha(),
                user.getTipoacesso(),
                user.getStatus()
            });
        }
    }

    public void listarJtablePorStatus(String status) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tblListaUsuarios.getModel();
        modelo.setNumRows(0);
        UsuarioDAO userDAO = new UsuarioDAO();
        for (Usuario user : userDAO.listarUsuariosPorStatus(status)) {
            modelo.addRow(new Object[]{
                user.getIdusuario(),
                user.getUsuario(),
                user.getSenha(),
                user.getTipoacesso(),
                user.getStatus()
            });
        }
    }

    public boolean jaExiste(String usuario) throws SQLException {
        boolean jaExiste = false;
        UsuarioDAO userDAO = new UsuarioDAO();
        for (Usuario user : userDAO.listaTodosOsUsuarios()) {
            if (user.getUsuario().equalsIgnoreCase(usuario)) {
                jaExiste = true;
            }
        }
        return jaExiste;

    }

    public void Limpar() {

        ((DefaultTableModel) tblListaUsuarios.getModel()).setRowCount(0);
        txt_usuario.setText("");
        txt_senha.setText("");
        rdoGrupo1.clearSelection();
        txt_usuario.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdoGrupo1 = new javax.swing.ButtonGroup();
        pnl_global_telaUsuarios = new javax.swing.JPanel();
        pnlTabelaConsulta = new javax.swing.JScrollPane();
        tblListaUsuarios = new javax.swing.JTable();
        pnl_superior = new javax.swing.JPanel();
        btn_adicionar = new javax.swing.JButton();
        lbl_usuario = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txt_senha = new javax.swing.JTextField();
        lbl_senha = new javax.swing.JLabel();
        lbl_tipo_acesso = new javax.swing.JLabel();
        rdoBTN_atendente = new javax.swing.JRadioButton();
        rdoBTN_admin = new javax.swing.JRadioButton();
        pnl_filtros = new javax.swing.JPanel();
        btn_pesquisa_id = new javax.swing.JButton();
        btn_pesquisa_nome = new javax.swing.JButton();
        btn_pesquisa_status = new javax.swing.JButton();
        brn_pesquisa_todos = new javax.swing.JButton();
        pnl_opcoes = new javax.swing.JPanel();
        btn_desativar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuários");

        pnl_global_telaUsuarios.setBackground(new java.awt.Color(255, 255, 255));

        pnlTabelaConsulta.setBackground(new java.awt.Color(246, 242, 233));

        tblListaUsuarios.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        tblListaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuário", "Senha", "Tipo de Acesso", "Status"
            }
        ));
        tblListaUsuarios.setRowHeight(30);
        pnlTabelaConsulta.setViewportView(tblListaUsuarios);

        pnl_superior.setBackground(new java.awt.Color(246, 242, 233));
        pnl_superior.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controle de Usuários", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N
        pnl_superior.setPreferredSize(new java.awt.Dimension(645, 203));

        btn_adicionar.setBackground(new java.awt.Color(255, 243, 198));
        btn_adicionar.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        btn_adicionar.setText("Cadastrar");
        btn_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarActionPerformed(evt);
            }
        });

        lbl_usuario.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        lbl_usuario.setText("Usuário");

        txt_usuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txt_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuarioActionPerformed(evt);
            }
        });

        txt_senha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        lbl_senha.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        lbl_senha.setText("Senha");

        lbl_tipo_acesso.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        lbl_tipo_acesso.setText("Tipo de acesso:");

        rdoGrupo1.add(rdoBTN_atendente);
        rdoBTN_atendente.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        rdoBTN_atendente.setText("Atendente");

        rdoGrupo1.add(rdoBTN_admin);
        rdoBTN_admin.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        rdoBTN_admin.setText("Administrador");

        javax.swing.GroupLayout pnl_superiorLayout = new javax.swing.GroupLayout(pnl_superior);
        pnl_superior.setLayout(pnl_superiorLayout);
        pnl_superiorLayout.setHorizontalGroup(
            pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_superiorLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_superiorLayout.createSequentialGroup()
                        .addComponent(lbl_tipo_acesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_superiorLayout.createSequentialGroup()
                                .addComponent(rdoBTN_atendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(38, 38, 38))
                            .addComponent(rdoBTN_admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(240, 240, 240))
                    .addGroup(pnl_superiorLayout.createSequentialGroup()
                        .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_usuario)
                            .addGroup(pnl_superiorLayout.createSequentialGroup()
                                .addComponent(lbl_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(33, 33, 33)))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_superiorLayout.createSequentialGroup()
                                .addComponent(lbl_senha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(301, 301, 301))
                            .addGroup(pnl_superiorLayout.createSequentialGroup()
                                .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_adicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(11, 11, 11))))))
        );
        pnl_superiorLayout.setVerticalGroup(
            pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_superiorLayout.createSequentialGroup()
                .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_senha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_usuario)
                    .addComponent(txt_senha)
                    .addComponent(btn_adicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoBTN_admin, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_tipo_acesso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdoBTN_atendente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnl_filtros.setBackground(new java.awt.Color(246, 242, 233));
        pnl_filtros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        btn_pesquisa_id.setBackground(new java.awt.Color(255, 243, 198));
        btn_pesquisa_id.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_pesquisa_id.setText("ID");
        btn_pesquisa_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisa_idActionPerformed(evt);
            }
        });

        btn_pesquisa_nome.setBackground(new java.awt.Color(255, 243, 198));
        btn_pesquisa_nome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_pesquisa_nome.setText("Nome");
        btn_pesquisa_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisa_nomeActionPerformed(evt);
            }
        });

        btn_pesquisa_status.setBackground(new java.awt.Color(255, 243, 198));
        btn_pesquisa_status.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_pesquisa_status.setText("Status");
        btn_pesquisa_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisa_statusActionPerformed(evt);
            }
        });

        brn_pesquisa_todos.setBackground(new java.awt.Color(255, 243, 198));
        brn_pesquisa_todos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        brn_pesquisa_todos.setText("Todos");
        brn_pesquisa_todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brn_pesquisa_todosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_filtrosLayout = new javax.swing.GroupLayout(pnl_filtros);
        pnl_filtros.setLayout(pnl_filtrosLayout);
        pnl_filtrosLayout.setHorizontalGroup(
            pnl_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_filtrosLayout.createSequentialGroup()
                .addGap(425, 425, 425)
                .addComponent(btn_pesquisa_id, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pesquisa_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pesquisa_status, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brn_pesquisa_todos, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addGap(407, 407, 407))
        );
        pnl_filtrosLayout.setVerticalGroup(
            pnl_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_filtrosLayout.createSequentialGroup()
                .addGroup(pnl_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(brn_pesquisa_todos, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pesquisa_status, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pesquisa_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pesquisa_id, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnl_opcoes.setBackground(new java.awt.Color(246, 242, 233));
        pnl_opcoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opções", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N
        pnl_opcoes.setPreferredSize(new java.awt.Dimension(645, 203));

        btn_desativar.setBackground(new java.awt.Color(255, 153, 153));
        btn_desativar.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        btn_desativar.setText("Desativar");
        btn_desativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desativarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_opcoesLayout = new javax.swing.GroupLayout(pnl_opcoes);
        pnl_opcoes.setLayout(pnl_opcoesLayout);
        pnl_opcoesLayout.setHorizontalGroup(
            pnl_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_opcoesLayout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addGroup(pnl_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_desativar, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
                .addGap(191, 191, 191))
        );
        pnl_opcoesLayout.setVerticalGroup(
            pnl_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_opcoesLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_desativar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout pnl_global_telaUsuariosLayout = new javax.swing.GroupLayout(pnl_global_telaUsuarios);
        pnl_global_telaUsuarios.setLayout(pnl_global_telaUsuariosLayout);
        pnl_global_telaUsuariosLayout.setHorizontalGroup(
            pnl_global_telaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_global_telaUsuariosLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnl_global_telaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnl_filtros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_global_telaUsuariosLayout.createSequentialGroup()
                        .addComponent(pnl_superior, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_opcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)))
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_global_telaUsuariosLayout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(pnlTabelaConsulta)
                .addGap(157, 157, 157))
        );
        pnl_global_telaUsuariosLayout.setVerticalGroup(
            pnl_global_telaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_global_telaUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_global_telaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_opcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(pnl_superior, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_filtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlTabelaConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_global_telaUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_global_telaUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1394, 807));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_desativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desativarActionPerformed
        if (tblListaUsuarios.getSelectedRow() != -1) {
            int confirma = JOptionPane.showConfirmDialog(
                    this,
                    "Deseja confirmar a desativação do usuário " + String.valueOf(tblListaUsuarios.getValueAt(tblListaUsuarios.getSelectedRow(), 0).toString()) + "?",
                    "Confirmar desativação?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (confirma == JOptionPane.YES_OPTION) {
                try {
                    UsuarioDAO userDAO = new UsuarioDAO();
                    Usuario user = new Usuario();
                    userDAO.buscaPorID((Integer.parseInt(tblListaUsuarios.getValueAt(tblListaUsuarios.getSelectedRow(), 0).toString())), user);
                    user.setStatus("DESATIVADO");//######DESATIVA O USUARIO#####
                    userDAO.atualizaUsuario(user);//chama o metodo de atualizacao
                    JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
                    Limpar();
                    ListaTabela();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                }
            } else if (confirma == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Operacão cancelada.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um usuário para excluir.");
        }
    }//GEN-LAST:event_btn_desativarActionPerformed

    private void txt_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuarioActionPerformed

    private void btn_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarActionPerformed
        Usuario user = new Usuario();
        try {
            String usuario;
            String tipoAcesso = null;
            String senha;
            boolean campo1 = this.verificarSeCampoEstaEmBranco(txt_usuario, "Usuário");
            boolean campo2 = verificarSeCampoEstaEmBranco(txt_senha, "Senha");
            if (jaExiste(txt_usuario.getText()) == false) {
                if (campo1 && campo1) {
                    if (rdoGrupo1.getSelection() == null) { //se os tipos de acessos estiverem vazios
                        JOptionPane.showMessageDialog(null, "Escolha o tipo de acesso!");
                        txt_senha.requestFocus();
                    } else {
                        if (rdoBTN_admin.isSelected()) {
                            tipoAcesso = "administrador";
                        }
                        if (rdoBTN_atendente.isSelected()) {
                            tipoAcesso = "atendente";
                        }
                        usuario = txt_usuario.getText();
                        usuario = usuario.toLowerCase();//faz o usuario ficar em letras minusculas
                        senha = txt_senha.getText();
                        user.setUsuario(usuario);
                        user.setSenha(senha);
                        user.setTipoacesso(tipoAcesso);
                        String status = "ativado";//##### COMO PADRÃO, O USUARIO SERÁ CRIADO ATIVADO  ######
                        user.setStatus(status);
                        UsuarioDAO userDAO = new UsuarioDAO();
                        userDAO.insereUsuario(user);
                        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                        Limpar();
                        ListaTabela();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário já cadastrado!");
                txt_usuario.setText("");
                txt_senha.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dados inválidos!");
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btn_adicionarActionPerformed

    private void brn_pesquisa_todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brn_pesquisa_todosActionPerformed
        try {
            listarJTableTodosUsuarios();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_brn_pesquisa_todosActionPerformed

    private void btn_pesquisa_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisa_statusActionPerformed
        JPanel painel = new JPanel();
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Ativado");
        comboBox.addItem("Desativado");
        painel.add(new JLabel("Status: "));
        painel.add(comboBox);
        int result = JOptionPane.showConfirmDialog(null, painel, "Pesquisar por Status", JOptionPane.OK_CANCEL_OPTION, -1);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String status = String.valueOf(comboBox.getSelectedItem());
                listarJtablePorStatus(status);
                if (tblListaUsuarios.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Não há produtos no status " + status);
                    listarJtablePorStatus("ativado");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_pesquisa_statusActionPerformed

    private void btn_pesquisa_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisa_nomeActionPerformed
        JPanel painel = new JPanel();
        JLabel nomeProduto = new JLabel("Palavra: ");
        JTextField digitarPalavra = new JTextField(25);
        painel.add(nomeProduto);
        painel.add(digitarPalavra);
        int result = JOptionPane.showConfirmDialog(null, painel, "Pesquisar categoria", JOptionPane.OK_CANCEL_OPTION);
        String palavraPesquisar = digitarPalavra.getText();
        if (result == JOptionPane.OK_OPTION) {
            try {
                listarJTablePorNome(palavraPesquisar);
                if (tblListaUsuarios.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Palavra não encontrada.");
                    listarJTableTodosAtivos();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_pesquisa_nomeActionPerformed

    private void btn_pesquisa_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisa_idActionPerformed
        JPanel painel = new JPanel();
        JLabel lbl_numeroId = new JLabel("Número: ");
        JTextField txt_numeroId = new JTextField(10);
        painel.add(lbl_numeroId);
        painel.add(txt_numeroId);
        int resultado = JOptionPane.showConfirmDialog(null, painel, "PESQUISA POR ID", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (resultado == JOptionPane.OK_OPTION) {
            int idPesquisar = Integer.parseInt(txt_numeroId.getText());
            try {
                listarJTablePorId(idPesquisar);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "op cancelada");
        }
    }//GEN-LAST:event_btn_pesquisa_idActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (tblListaUsuarios.getSelectedRow() != -1) {
            atualizaUsuario();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um usuário! ", "Usuário não definido!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brn_pesquisa_todos;
    private javax.swing.JButton btn_adicionar;
    private javax.swing.JButton btn_desativar;
    private javax.swing.JButton btn_pesquisa_id;
    private javax.swing.JButton btn_pesquisa_nome;
    private javax.swing.JButton btn_pesquisa_status;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lbl_senha;
    private javax.swing.JLabel lbl_tipo_acesso;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JScrollPane pnlTabelaConsulta;
    private javax.swing.JPanel pnl_filtros;
    private javax.swing.JPanel pnl_global_telaUsuarios;
    private javax.swing.JPanel pnl_opcoes;
    private javax.swing.JPanel pnl_superior;
    private javax.swing.JRadioButton rdoBTN_admin;
    private javax.swing.JRadioButton rdoBTN_atendente;
    private javax.swing.ButtonGroup rdoGrupo1;
    private javax.swing.JTable tblListaUsuarios;
    private javax.swing.JTextField txt_senha;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
