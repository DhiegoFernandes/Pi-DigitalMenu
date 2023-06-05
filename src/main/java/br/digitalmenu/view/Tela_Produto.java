package br.digitalmenu.view;

import br.digitalmenu.dao.CategoriaDao;
import br.digitalmenu.dao.ProdutoDao;
import br.digitalmenu.heuristicas.Heuristica;
import br.digitalmenu.model.Categoria;
import br.digitalmenu.model.Produto;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Tela_Produto extends Heuristica {

    String auxNome, auxCat, auxDesc, auxStatus;
    double auxPreco;

    Border border;

    public Tela_Produto() throws SQLException {
        initComponents();
        viewCategoria();
        txt_id.setEnabled(false);
        jtProduto.getTableHeader().setDefaultRenderer(new CorDoCabecalho());//Muda cor do header na classe heuristica
        IniciaTabela(jtProduto);//Formata a tabela e centraliza pela classe heuristicas
        listarJTableProdutosAtivados();
        border = txtformat_preco.getBorder();
    }

    public void listarJTableTodosProdutos() throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) jtProduto.getModel();
        modelo.setNumRows(0);
        ProdutoDao prodDao = new ProdutoDao();
        for (Produto prod : prodDao.listarProduto()) {
            modelo.addRow(new Object[]{
                prod.getIdProduto(),
                prod.getNome(),
                prod.getCategoria().getNomeCategoria(),
                String.format("%.2f", prod.getPreco()),
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
                prod.getCategoria().getNomeCategoria(),
                String.format("%.2f", prod.getPreco()),
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
                produto.getCategoria().getNomeCategoria(),
                String.format("%.2f", produto.getPreco()),
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
                produto.getCategoria().getNomeCategoria(),
                String.format("%.2f", produto.getPreco()),
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
                produto.getCategoria().getNomeCategoria(),
                String.format("%.2f", produto.getPreco()),
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
                produto.getCategoria().getNomeCategoria(),
                String.format("%.2f", produto.getPreco()),
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
                produto.getCategoria().getNomeCategoria(),
                String.format("%.2f", produto.getPreco()),
                produto.getDescricao(),
                produto.getStatus()
            });
        }
    }

    public void viewCategoria() throws SQLException {
        CategoriaDao catDao = new CategoriaDao();
        for (Categoria categoria : catDao.listarCategoria()) {
            cbox_categoria.addItem(categoria.getNomeCategoria());
        }
    }

    public void limparTxtFields() {
        txt_id.setText("");
        txt_nome.setText("");
        txtarea_descricao.setText("");
        txtformat_preco.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_superior = new javax.swing.JPanel();
        pnl_cadastrar_opcoes = new javax.swing.JPanel();
        pnl_cadastrar_produto = new javax.swing.JPanel();
        lbl_Id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        lbl_Nome = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        lbl_Preco = new javax.swing.JLabel();
        txtformat_preco = new javax.swing.JFormattedTextField();
        lbl_Categoria = new javax.swing.JLabel();
        cbox_categoria = new javax.swing.JComboBox<>();
        lbl_descricao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea_descricao = new javax.swing.JTextArea();
        btn_cadastrar_produto = new javax.swing.JButton();
        pnl_opcoes = new javax.swing.JPanel();
        btn_alterar_produto = new javax.swing.JButton();
        btn_deletar_produto = new javax.swing.JButton();
        pnl_filtros = new javax.swing.JPanel();
        btn_filtro_ativos = new javax.swing.JButton();
        btn_filtro_descricao = new javax.swing.JButton();
        btn_filtro_status = new javax.swing.JButton();
        btn_filtro_categoria = new javax.swing.JButton();
        btn_filtro_faixa_preco = new javax.swing.JButton();
        btn_filtro_nome = new javax.swing.JButton();
        pnl_tabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProduto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos");

        pnl_superior.setBackground(new java.awt.Color(255, 255, 255));

        pnl_cadastrar_opcoes.setBackground(new java.awt.Color(255, 255, 255));

        pnl_cadastrar_produto.setBackground(new java.awt.Color(246, 242, 233));
        pnl_cadastrar_produto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar produto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N
        pnl_cadastrar_produto.setToolTipText("");
        pnl_cadastrar_produto.setPreferredSize(new java.awt.Dimension(670, 181));

        lbl_Id.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Id.setText("ID:");

        txt_id.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        lbl_Nome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Nome.setText("Nome:");

        txt_nome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeActionPerformed(evt);
            }
        });

        lbl_Preco.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Preco.setText("Preço:");

        txtformat_preco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lbl_Categoria.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_Categoria.setText("Categoria:");

        cbox_categoria.setBackground(new java.awt.Color(255, 232, 142));
        cbox_categoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbox_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_categoriaActionPerformed(evt);
            }
        });

        lbl_descricao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbl_descricao.setText("Descrição:");

        txtarea_descricao.setColumns(20);
        txtarea_descricao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtarea_descricao.setLineWrap(true);
        txtarea_descricao.setRows(5);
        jScrollPane2.setViewportView(txtarea_descricao);

        btn_cadastrar_produto.setBackground(new java.awt.Color(255, 243, 198));
        btn_cadastrar_produto.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_cadastrar_produto.setText("Cadastrar");
        btn_cadastrar_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrar_produtoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_cadastrar_produtoLayout = new javax.swing.GroupLayout(pnl_cadastrar_produto);
        pnl_cadastrar_produto.setLayout(pnl_cadastrar_produtoLayout);
        pnl_cadastrar_produtoLayout.setHorizontalGroup(
            pnl_cadastrar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cadastrar_produtoLayout.createSequentialGroup()
                .addGroup(pnl_cadastrar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_cadastrar_produtoLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(pnl_cadastrar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_cadastrar_produtoLayout.createSequentialGroup()
                                .addComponent(lbl_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cadastrar_produtoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnl_cadastrar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_descricao, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(lbl_Categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(pnl_cadastrar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_cadastrar_produtoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnl_cadastrar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_cadastrar_produtoLayout.createSequentialGroup()
                                .addComponent(txt_id)
                                .addGap(164, 164, 164))
                            .addGroup(pnl_cadastrar_produtoLayout.createSequentialGroup()
                                .addComponent(txt_nome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_Preco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(txtformat_preco))
                    .addComponent(cbox_categoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_cadastrar_produto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(131, 131, 131))
        );
        pnl_cadastrar_produtoLayout.setVerticalGroup(
            pnl_cadastrar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cadastrar_produtoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_cadastrar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_cadastrar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Preco)
                    .addComponent(txtformat_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(pnl_cadastrar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbox_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pnl_cadastrar_produtoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(btn_cadastrar_produto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        pnl_opcoes.setBackground(new java.awt.Color(246, 242, 233));
        pnl_opcoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opções", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N
        pnl_opcoes.setPreferredSize(new java.awt.Dimension(670, 181));

        btn_alterar_produto.setBackground(new java.awt.Color(204, 255, 204));
        btn_alterar_produto.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_alterar_produto.setText("Alterar");
        btn_alterar_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alterar_produtoActionPerformed(evt);
            }
        });

        btn_deletar_produto.setBackground(new java.awt.Color(255, 153, 153));
        btn_deletar_produto.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_deletar_produto.setText("Deletar");
        btn_deletar_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deletar_produtoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_opcoesLayout = new javax.swing.GroupLayout(pnl_opcoes);
        pnl_opcoes.setLayout(pnl_opcoesLayout);
        pnl_opcoesLayout.setHorizontalGroup(
            pnl_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_opcoesLayout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addGroup(pnl_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_deletar_produto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_alterar_produto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(193, 193, 193))
        );
        pnl_opcoesLayout.setVerticalGroup(
            pnl_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_opcoesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btn_alterar_produto, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_deletar_produto, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout pnl_cadastrar_opcoesLayout = new javax.swing.GroupLayout(pnl_cadastrar_opcoes);
        pnl_cadastrar_opcoes.setLayout(pnl_cadastrar_opcoesLayout);
        pnl_cadastrar_opcoesLayout.setHorizontalGroup(
            pnl_cadastrar_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cadastrar_opcoesLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(pnl_cadastrar_produto, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_opcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );
        pnl_cadastrar_opcoesLayout.setVerticalGroup(
            pnl_cadastrar_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cadastrar_opcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_cadastrar_opcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_cadastrar_produto, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(pnl_opcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnl_filtros.setBackground(new java.awt.Color(246, 242, 233));
        pnl_filtros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        btn_filtro_ativos.setBackground(new java.awt.Color(255, 243, 198));
        btn_filtro_ativos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_filtro_ativos.setText("Listar ativos");
        btn_filtro_ativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_ativosActionPerformed(evt);
            }
        });

        btn_filtro_descricao.setBackground(new java.awt.Color(255, 243, 198));
        btn_filtro_descricao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_filtro_descricao.setText("Descrição");
        btn_filtro_descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_descricaoActionPerformed(evt);
            }
        });

        btn_filtro_status.setBackground(new java.awt.Color(255, 243, 198));
        btn_filtro_status.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_filtro_status.setText("Status");
        btn_filtro_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_statusActionPerformed(evt);
            }
        });

        btn_filtro_categoria.setBackground(new java.awt.Color(255, 243, 198));
        btn_filtro_categoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_filtro_categoria.setText("Categoria");
        btn_filtro_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_categoriaActionPerformed(evt);
            }
        });

        btn_filtro_faixa_preco.setBackground(new java.awt.Color(255, 243, 198));
        btn_filtro_faixa_preco.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_filtro_faixa_preco.setText("Faixa de preço");
        btn_filtro_faixa_preco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_faixa_precoActionPerformed(evt);
            }
        });

        btn_filtro_nome.setBackground(new java.awt.Color(255, 243, 198));
        btn_filtro_nome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_filtro_nome.setText("Nome");
        btn_filtro_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtro_nomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_filtrosLayout = new javax.swing.GroupLayout(pnl_filtros);
        pnl_filtros.setLayout(pnl_filtrosLayout);
        pnl_filtrosLayout.setHorizontalGroup(
            pnl_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_filtrosLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(btn_filtro_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_filtro_faixa_preco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_filtro_descricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_filtro_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_filtro_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_filtro_ativos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(137, 137, 137))
        );
        pnl_filtrosLayout.setVerticalGroup(
            pnl_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_filtrosLayout.createSequentialGroup()
                .addGroup(pnl_filtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_filtro_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_filtro_faixa_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_filtro_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_filtro_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_filtro_status, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_filtro_ativos, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_superiorLayout = new javax.swing.GroupLayout(pnl_superior);
        pnl_superior.setLayout(pnl_superiorLayout);
        pnl_superiorLayout.setHorizontalGroup(
            pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_superiorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(pnl_cadastrar_opcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnl_superiorLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(pnl_filtros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );
        pnl_superiorLayout.setVerticalGroup(
            pnl_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_superiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_cadastrar_opcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_filtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_tabela.setBackground(new java.awt.Color(255, 255, 255));

        jtProduto.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
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
        jtProduto.setRowHeight(30);
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
            jtProduto.getColumnModel().getColumn(0).setMinWidth(5);
            jtProduto.getColumnModel().getColumn(0).setPreferredWidth(5);
            jtProduto.getColumnModel().getColumn(1).setMinWidth(200);
            jtProduto.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtProduto.getColumnModel().getColumn(3).setMinWidth(20);
            jtProduto.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        javax.swing.GroupLayout pnl_tabelaLayout = new javax.swing.GroupLayout(pnl_tabela);
        pnl_tabela.setLayout(pnl_tabelaLayout);
        pnl_tabelaLayout.setHorizontalGroup(
            pnl_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_tabelaLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
                .addGap(173, 173, 173))
        );
        pnl_tabelaLayout.setVerticalGroup(
            pnl_tabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_superior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_tabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_superior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_tabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1414, 807));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtProdutoKeyReleased

        if (jtProduto.getSelectedRow() != -1) {
            txt_id.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 0).toString());
            txt_nome.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 1).toString());
            cbox_categoria.setSelectedItem(jtProduto.getValueAt(jtProduto.getSelectedRow(), 2).toString());
            txtarea_descricao.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 4).toString());
            txtformat_preco.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_jtProdutoKeyReleased

    private void jtProdutoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutoMouseReleased

        if (jtProduto.getSelectedRow() != -1) {
            txt_id.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 0).toString());
            txt_nome.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 1).toString());
            cbox_categoria.setSelectedItem(jtProduto.getValueAt(jtProduto.getSelectedRow(), 2).toString());
            txtarea_descricao.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 4).toString());
            txtformat_preco.setText(jtProduto.getValueAt(jtProduto.getSelectedRow(), 3).toString());
            auxNome = txt_nome.getText();
            auxPreco = Double.parseDouble(txtformat_preco.getText());
            auxCat = cbox_categoria.getSelectedItem().toString();
            auxDesc = txtarea_descricao.getText();
        }
    }//GEN-LAST:event_jtProdutoMouseReleased

    private void btn_filtro_ativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_ativosActionPerformed
        try {
            listarJTableProdutosAtivados();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_filtro_ativosActionPerformed

    private void btn_filtro_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_statusActionPerformed
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
                    JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado no status selecionado!");
                    listarJTableTodosProdutos();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_filtro_statusActionPerformed

    private void btn_filtro_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_categoriaActionPerformed
        JPanel painel = new JPanel();
        painel.add(new JLabel("Categoria: "));
        painel.add(cbox_categoria);

        int result = JOptionPane.showConfirmDialog(null, painel, "Selecione a categoria.", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String categoria = String.valueOf(cbox_categoria.getSelectedItem());
                listarJtablePorCategoria(categoria);
                if (jtProduto.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado nesta categoria!");
                    listarJTableProdutosAtivados();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_filtro_categoriaActionPerformed

    private void btn_filtro_descricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_descricaoActionPerformed
        String palavra = JOptionPane.showInputDialog("Palavra a pesquisar:");
        try {
            listarJtablePorDescricao(palavra);
            if (jtProduto.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Dados não encontrados.");
                listarJTableProdutosAtivados();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_filtro_descricaoActionPerformed

    private void btn_filtro_faixa_precoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_faixa_precoActionPerformed
        JTextField valorInicial = new JTextField(10);
        JTextField valorFinal = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("De:"));
        myPanel.add(valorInicial);
        myPanel.add(Box.createHorizontalStrut(10));
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
                    JOptionPane.showMessageDialog(null, "Nenhum produto encontrado na faixa de preço informada!");
                    listarJTableProdutosAtivados();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_filtro_faixa_precoActionPerformed

    private void btn_filtro_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtro_nomeActionPerformed
        JPanel painel = new JPanel();
        JLabel nomeProduto = new JLabel("Nome: ");
        JTextField digitarPalavra = new JTextField(15);
        painel.add(nomeProduto);
        painel.add(digitarPalavra);
        int result = JOptionPane.showConfirmDialog(null, painel, "Pesquisar produto", JOptionPane.OK_CANCEL_OPTION);
        String palavraPesquisar = digitarPalavra.getText();
        if (result == JOptionPane.OK_OPTION) {
            try {
                listarJtablePorNome(palavraPesquisar);
                if (jtProduto.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Produto não encontrado.");
                    listarJTableProdutosAtivados();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_filtro_nomeActionPerformed

    private void btn_alterar_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alterar_produtoActionPerformed
        if (jtProduto.getSelectedRow() != -1) {

            ProdutoDao produtoDao = new ProdutoDao();
            Produto produto;
            try {
                produto = produtoDao.listarProdutoPorId(Integer.parseInt(txt_id.getText()));
                Panel_Alterar_Produto pteste = new Panel_Alterar_Produto(produto);
                int opcao = JOptionPane.showConfirmDialog(null, pteste, "Alterar Produto", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (opcao == JOptionPane.OK_OPTION) {
                    Produto p = new Produto();
                    p.setIdProduto(Integer.parseInt(pteste.getLbl_Id_Valor().getText()));
                    p.setNome(pteste.getTxt_Nome_Novo().getText());
                    p.setPreco(Double.parseDouble(pteste.getTxt_Preco_Novo().getText().replace(',', '.')));
                    p.getCategoria().setNomeCategoria(pteste.getCbox_Categoria_Novo().getSelectedItem().toString());
                    p.setDescricao(pteste.getTxtarea_Descricao_Novo().getText());
                    p.setStatus(pteste.getCheckbox_Status_Novo().isSelected() ? "Ativado" : "Desativado");
                    ProdutoDao pDao = new ProdutoDao();
                    pDao.alterarProduto(p);
                    JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
                    listarJTableProdutosAtivados();
                    limparTxtFields();
                } else if (opcao == JOptionPane.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(null, "Operação cancelada!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Tela_Produto.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto! ", "Produto não selecionado!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_alterar_produtoActionPerformed

    private void btn_deletar_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deletar_produtoActionPerformed

        if (jtProduto.getSelectedRow() != -1) {
            int confirma = JOptionPane.showConfirmDialog(this,
                    "Deletar produto: "
                    + "\nID: "
                    + txt_id.getText()
                    + "\nNome: "
                    + txt_nome.getText(),
                    "CONFIRMA DELEÇÃO?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (confirma == JOptionPane.YES_OPTION) {
                Produto p = new Produto();
                p.setIdProduto(Integer.parseInt(txt_id.getText()));
                ProdutoDao pDao = new ProdutoDao();
                try {
                    pDao.deletaProduto(p);
                    JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
                    listarJTableProdutosAtivados();
                    limparTxtFields();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                }
            } else if (confirma == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha!");
        }
    }//GEN-LAST:event_btn_deletar_produtoActionPerformed

    private void btn_cadastrar_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrar_produtoActionPerformed

        boolean campo1 = verificarSeCampoEstaEmBranco(txt_nome, "Nome");
        boolean campo2 = verificarSeCampoEstaEmBranco(txtformat_preco, "Preço");

        if (campo1 && campo2 == true) {
            Produto p = new Produto();
            p.setNome(txt_nome.getText());
            p.setPreco(Double.parseDouble(txtformat_preco.getText().replace(',', '.')));
            p.setDescricao(txtarea_descricao.getText());
            p.getCategoria().setNomeCategoria(cbox_categoria.getSelectedItem().toString());
            ProdutoDao pDao = new ProdutoDao();
            try {
                pDao.createProduto(p);
                JOptionPane.showMessageDialog(null, "Produto: " + p.getNome() + " cadastrado com sucesso!");
                listarJTableProdutosAtivados();
                txtformat_preco.setBorder(border);
                txt_nome.setBorder(border);
            } catch (NumberFormatException e) {
                JOptionPane.showConfirmDialog(null, "Dados inválidos!");
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, "Dados inválidos!");
            }
            //nao ta capturando erro
        }
    }//GEN-LAST:event_btn_cadastrar_produtoActionPerformed

    private void cbox_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_categoriaActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Produto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Tela_Produto().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Tela_Produto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_alterar_produto;
    private javax.swing.JButton btn_cadastrar_produto;
    private javax.swing.JButton btn_deletar_produto;
    private javax.swing.JButton btn_filtro_ativos;
    private javax.swing.JButton btn_filtro_categoria;
    private javax.swing.JButton btn_filtro_descricao;
    private javax.swing.JButton btn_filtro_faixa_preco;
    private javax.swing.JButton btn_filtro_nome;
    private javax.swing.JButton btn_filtro_status;
    private javax.swing.JComboBox<String> cbox_categoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtProduto;
    private javax.swing.JLabel lbl_Categoria;
    private javax.swing.JLabel lbl_Id;
    private javax.swing.JLabel lbl_Nome;
    private javax.swing.JLabel lbl_Preco;
    private javax.swing.JLabel lbl_descricao;
    private javax.swing.JPanel pnl_cadastrar_opcoes;
    private javax.swing.JPanel pnl_cadastrar_produto;
    private javax.swing.JPanel pnl_filtros;
    private javax.swing.JPanel pnl_opcoes;
    private javax.swing.JPanel pnl_superior;
    private javax.swing.JPanel pnl_tabela;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextArea txtarea_descricao;
    private javax.swing.JFormattedTextField txtformat_preco;
    // End of variables declaration//GEN-END:variables

}
