package br.digitalmenu.view;

import br.digitalmenu.dao.RelatorioDao;
import br.digitalmenu.heuristicas.Heuristica;
import br.digitalmenu.model.relatorio.ItemRelatorio;
import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Tela_Admin extends Heuristica {

    public Tela_Admin(String usuario, String tipoAcesso) {
        initComponents();
        jDesktopPane1.enable(false);//Deixa a cor do fundo a mostra, deixa o jDesktop desativado

        //casting para a primeira letra do tipoDeAcesso ficar maiscula
        tipoAcesso = String.valueOf(tipoAcesso);
        String s1 = tipoAcesso.substring(0, 1).toUpperCase();
        String tipoAcessoMaisculo = s1 + tipoAcesso.substring(1);

        //casting para a primeira letra do usuario ficar maiscula
        usuario = String.valueOf(usuario);
        String s2 = usuario.substring(0, 1).toUpperCase();
        String usuarioMaiusculo = s2 + usuario.substring(1);

        //Seta a label usuario e tipo de acesso
        lbl_Usuario.setText(String.valueOf(usuarioMaiusculo));
        lbl_TipoAcesso.setText(String.valueOf(tipoAcessoMaisculo));
         
        tblRelatorio.getTableHeader().setDefaultRenderer(new CorDoCabecalho());
        mostraMaisVendidos();
    }


    public static void apagarTodasColunas(JTable table) {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) table.getModel();
        TableColumnModel columnModel = table.getColumnModel();

        int columnCount = columnModel.getColumnCount();
        for (int i = columnCount - 1; i >= 0; i--) {
            TableColumn column = columnModel.getColumn(i);
            columnModel.removeColumn(column);
            model.setColumnCount(model.getColumnCount() - 1);
        }
    }

    public void mostraMaisVendidos() {
        apagarTodasColunas(tblRelatorio);

        DefaultTableModel modelo = (DefaultTableModel) tblRelatorio.getModel();
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
                    String.format("%.2f", itemRelatorio.getValorTotalVendido())
                });
            }
            IniciaTabela(tblRelatorio);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        pnl_botoes = new javax.swing.JPanel();
        lbl_Gerenciar = new javax.swing.JLabel();
        btn_categorias = new javax.swing.JButton();
        btn_mesas = new javax.swing.JButton();
        btn_listar_pedidos = new javax.swing.JButton();
        btn_produtos = new javax.swing.JButton();
        btn_usuarios = new javax.swing.JButton();
        btn_sair = new javax.swing.JButton();
        pnl_header = new javax.swing.JPanel();
        lbl_TipoAcesso = new javax.swing.JLabel();
        lbl_Usuario = new javax.swing.JLabel();
        lbl_icone = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        pnl_relatorio = new javax.swing.JPanel();
        lbl_ProdutosMaisVendidos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRelatorio = new javax.swing.JTable();
        btn_gerar_relatorio = new javax.swing.JButton();
        btn_abrir_pedido = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnu_ped = new javax.swing.JMenu();
        mnuItemPedido = new javax.swing.JMenuItem();
        mnu_mesa = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnu_categoria = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnu_produto = new javax.swing.JMenu();
        mnuitemProduto = new javax.swing.JMenuItem();
        mnu_relatorio = new javax.swing.JMenu();
        mnuRelatorio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(224, 222, 217));

        pnl_botoes.setBackground(new java.awt.Color(246, 242, 233));

        lbl_Gerenciar.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_Gerenciar.setText("Gerenciar");

        btn_categorias.setBackground(new java.awt.Color(176, 50, 39));
        btn_categorias.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btn_categorias.setForeground(new java.awt.Color(255, 255, 255));
        btn_categorias.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\categoria.png"));
        btn_categorias.setText("<html> <html> <body> <h><div style=\"text-align:center\"> Categorias de produtos</h></center> </body> </html>");
        btn_categorias.setActionCommand("<html> <html> <body> <p> Categorias de produtos</p> </body> </html>");
        btn_categorias.setPreferredSize(new java.awt.Dimension(108, 35));
        btn_categorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoriasActionPerformed(evt);
            }
        });

        btn_mesas.setBackground(new java.awt.Color(176, 50, 39));
        btn_mesas.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btn_mesas.setForeground(new java.awt.Color(255, 255, 255));
        btn_mesas.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\table.png"));
        btn_mesas.setText("Mesas");
        btn_mesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mesasActionPerformed(evt);
            }
        });

        btn_listar_pedidos.setBackground(new java.awt.Color(176, 50, 39));
        btn_listar_pedidos.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btn_listar_pedidos.setForeground(new java.awt.Color(255, 255, 255));
        btn_listar_pedidos.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\pedido.png"));
        btn_listar_pedidos.setText("Pedidos");
        btn_listar_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listar_pedidosActionPerformed(evt);
            }
        });

        btn_produtos.setBackground(new java.awt.Color(176, 50, 39));
        btn_produtos.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btn_produtos.setForeground(new java.awt.Color(255, 255, 255));
        btn_produtos.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\burguersoda.png"));
        btn_produtos.setText("Produtos");
        btn_produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_produtosActionPerformed(evt);
            }
        });

        btn_usuarios.setBackground(new java.awt.Color(176, 50, 39));
        btn_usuarios.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btn_usuarios.setForeground(new java.awt.Color(255, 255, 255));
        btn_usuarios.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\usuarios.png"));
        btn_usuarios.setText("Usuários");
        btn_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_usuariosActionPerformed(evt);
            }
        });

        btn_sair.setBackground(new java.awt.Color(234, 0, 44));
        btn_sair.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btn_sair.setForeground(new java.awt.Color(255, 255, 255));
        btn_sair.setText("Sair");
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_botoesLayout = new javax.swing.GroupLayout(pnl_botoes);
        pnl_botoes.setLayout(pnl_botoesLayout);
        pnl_botoesLayout.setHorizontalGroup(
            pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_botoesLayout.createSequentialGroup()
                        .addGroup(pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_categorias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_mesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_listar_pedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_produtos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_botoesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_botoesLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(lbl_Gerenciar)
                .addGap(69, 69, 69))
        );
        pnl_botoesLayout.setVerticalGroup(
            pnl_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botoesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbl_Gerenciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_categorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_mesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_listar_pedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_produtos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pnl_header.setBackground(new java.awt.Color(246, 242, 233));

        lbl_TipoAcesso.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_TipoAcesso.setForeground(new java.awt.Color(176, 50, 39));
        lbl_TipoAcesso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_TipoAcesso.setText("tipoAcesso");

        lbl_Usuario.setBackground(new java.awt.Color(0, 255, 204));
        lbl_Usuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Usuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_Usuario.setText("usuario");

        lbl_icone.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\administrador.png"));
        lbl_icone.setText("Icone");

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\digitalmenu2.png"));

        javax.swing.GroupLayout pnl_headerLayout = new javax.swing.GroupLayout(pnl_header);
        pnl_header.setLayout(pnl_headerLayout);
        pnl_headerLayout.setHorizontalGroup(
            pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_headerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbl_icone, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_TipoAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(170, 170, 170)
                .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(184, 184, 184))
        );
        pnl_headerLayout.setVerticalGroup(
            pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_headerLayout.createSequentialGroup()
                .addGroup(pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_headerLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_headerLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_TipoAcesso)
                            .addGroup(pnl_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_icone, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnl_relatorio.setBackground(new java.awt.Color(246, 242, 233));
        pnl_relatorio.setAutoscrolls(true);

        lbl_ProdutosMaisVendidos.setFont(new java.awt.Font("Cooper Black", 1, 48)); // NOI18N
        lbl_ProdutosMaisVendidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ProdutosMaisVendidos.setText("Produtos mais vendidos:");

        jScrollPane1.setBackground(new java.awt.Color(102, 255, 102));
        jScrollPane1.setForeground(new java.awt.Color(51, 0, 255));

        tblRelatorio.setBackground(new java.awt.Color(251, 217, 163));
        tblRelatorio.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        tblRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblRelatorio.setFocusable(false);
        tblRelatorio.setRowHeight(45);
        tblRelatorio.setRowSelectionAllowed(false);
        tblRelatorio.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblRelatorio);

        btn_gerar_relatorio.setBackground(new java.awt.Color(255, 153, 0));
        btn_gerar_relatorio.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        btn_gerar_relatorio.setForeground(new java.awt.Color(255, 255, 255));
        btn_gerar_relatorio.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\relatorio.png"));
        btn_gerar_relatorio.setText("<html> <html> <body> <h><div style=\"text-align:center\"> Gerar Relatório</h></center> </body> </html>");
        btn_gerar_relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gerar_relatorioActionPerformed(evt);
            }
        });

        btn_abrir_pedido.setBackground(new java.awt.Color(176, 50, 39));
        btn_abrir_pedido.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        btn_abrir_pedido.setForeground(new java.awt.Color(255, 255, 255));
        btn_abrir_pedido.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\pedir.png"));
        btn_abrir_pedido.setText("<html> <html> <body> <h><div style=\"text-align:center\"> Criar pedido</h></center> </body> </html>");
        btn_abrir_pedido.setMinimumSize(new java.awt.Dimension(201, 49));
        btn_abrir_pedido.setPreferredSize(new java.awt.Dimension(319, 49));
        btn_abrir_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrir_pedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_relatorioLayout = new javax.swing.GroupLayout(pnl_relatorio);
        pnl_relatorio.setLayout(pnl_relatorioLayout);
        pnl_relatorioLayout.setHorizontalGroup(
            pnl_relatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_relatorioLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnl_relatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_relatorioLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(btn_gerar_relatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                        .addGap(92, 92, 92)
                        .addComponent(btn_abrir_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                        .addGap(90, 90, 90))
                    .addComponent(jScrollPane1)
                    .addComponent(lbl_ProdutosMaisVendidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44))
        );
        pnl_relatorioLayout.setVerticalGroup(
            pnl_relatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_relatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_ProdutosMaisVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_relatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_gerar_relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_abrir_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jDesktopPane1.setLayer(pnl_botoes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(pnl_header, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(pnl_relatorio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(pnl_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(pnl_botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_relatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(pnl_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_botoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_relatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        mnu_ped.setText("Pedido");

        mnuItemPedido.setText("Pedido");
        mnuItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItemPedidoActionPerformed(evt);
            }
        });
        mnu_ped.add(mnuItemPedido);

        jMenuBar1.add(mnu_ped);

        mnu_mesa.setText("Mesa");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, 0));
        jMenuItem1.setText("Mesa");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnu_mesa.add(jMenuItem1);

        jMenuBar1.add(mnu_mesa);

        mnu_categoria.setText("Categoria");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, 0));
        jMenuItem2.setText("Categoria");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnu_categoria.add(jMenuItem2);

        jMenuBar1.add(mnu_categoria);

        mnu_produto.setText("Produto");

        mnuitemProduto.setText("Produto");
        mnuitemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuitemProdutoActionPerformed(evt);
            }
        });
        mnu_produto.add(mnuitemProduto);

        jMenuBar1.add(mnu_produto);

        mnu_relatorio.setText("Relatórios");

        mnuRelatorio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, 0));
        mnuRelatorio.setText("Relatório");
        mnuRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRelatorioActionPerformed(evt);
            }
        });
        mnu_relatorio.add(mnuRelatorio);

        jMenuBar1.add(mnu_relatorio);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        setSize(new java.awt.Dimension(1394, 807));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        try {
            new Tela_Mesa().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            new Tela_Categoria().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mnuitemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuitemProdutoActionPerformed
        try {
            new Tela_Produto().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnuitemProdutoActionPerformed

    private void mnuRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRelatorioActionPerformed

        new TelaRelatorio().setVisible(true);

    }//GEN-LAST:event_mnuRelatorioActionPerformed

    private void btn_gerar_relatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gerar_relatorioActionPerformed
        TelaRelatorio telaRelatorio = new TelaRelatorio();
        telaRelatorio.setVisible(true);

    }//GEN-LAST:event_btn_gerar_relatorioActionPerformed

    private void btn_abrir_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrir_pedidoActionPerformed
        try {
            new Tela_EscolherMesa().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_abrir_pedidoActionPerformed


    private void btn_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuariosActionPerformed
        try {
            new TelaUsuarios().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_usuariosActionPerformed

    private void btn_produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_produtosActionPerformed
        try {
            new Tela_Produto().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_produtosActionPerformed

    private void btn_listar_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listar_pedidosActionPerformed
        try {
            new Tela_Listar_Pedido().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_listar_pedidosActionPerformed

    private void btn_mesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mesasActionPerformed
        try {
            new Tela_Mesa().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_mesasActionPerformed


    private void btn_categoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoriasActionPerformed
        try {
            new Tela_Categoria().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_categoriasActionPerformed

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sairActionPerformed
        this.dispose();
        try {
            new Tela_Login().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_sairActionPerformed

    private void btnAbrirPedidoJFRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirPedidoJFRAMActionPerformed
        try {
            Tela_EscolherMesa telaEscolherMesa = new Tela_EscolherMesa();
            telaEscolherMesa.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Tela_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAbrirPedidoJFRAMActionPerformed

    private void mnuItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuItemPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuItemPedidoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_abrir_pedido;
    private javax.swing.JButton btn_categorias;
    private javax.swing.JButton btn_gerar_relatorio;
    private javax.swing.JButton btn_listar_pedidos;
    private javax.swing.JButton btn_mesas;
    private javax.swing.JButton btn_produtos;
    private javax.swing.JButton btn_sair;
    private javax.swing.JButton btn_usuarios;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lbl_Gerenciar;
    private javax.swing.JLabel lbl_ProdutosMaisVendidos;
    private javax.swing.JLabel lbl_TipoAcesso;
    private javax.swing.JLabel lbl_Usuario;
    private javax.swing.JLabel lbl_icone;
    private javax.swing.JMenuItem mnuItemPedido;
    private javax.swing.JMenuItem mnuRelatorio;
    private javax.swing.JMenu mnu_categoria;
    private javax.swing.JMenu mnu_mesa;
    private javax.swing.JMenu mnu_ped;
    private javax.swing.JMenu mnu_produto;
    private javax.swing.JMenu mnu_relatorio;
    private javax.swing.JMenuItem mnuitemProduto;
    private javax.swing.JPanel pnl_botoes;
    private javax.swing.JPanel pnl_header;
    private javax.swing.JPanel pnl_relatorio;
    private javax.swing.JTable tblRelatorio;
    // End of variables declaration//GEN-END:variables
}
