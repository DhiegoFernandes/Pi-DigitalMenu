package br.digitalmenu.view;

import br.digitalmenu.dao.ItemDao;
import br.digitalmenu.dao.PedidoDao;
import br.digitalmenu.dao.ProdutoDao;
import br.digitalmenu.dao.RelatorioDao;
import br.digitalmenu.model.Item;
import br.digitalmenu.model.Pedido;
import br.digitalmenu.model.Produto;
import br.digitalmenu.model.relatorio.ItemRelatorio;
import java.awt.TextArea;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class Tela_VerCardapio extends javax.swing.JFrame {

    private double total = 0.0;
    JLabel lblId[] = new JLabel[5];
    JLabel lblNomes[] = new JLabel[5];
    JTextArea txtDescricoes[] = new JTextArea[5];
    JLabel lblPrecos[] = new JLabel[5];
    JLabel lblFotos[] = new JLabel[5];
    JLabel lblQtde[] = new JLabel[5];
    public DecimalFormat decimalFormat = new DecimalFormat("##.00");
    private int numeroPedido;
    private int numeroMesa;
    private boolean foiAdm;



    public Tela_VerCardapio() throws SQLException {
        initComponents();
        this.foiAdm = foiAdm;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        this.numeroPedido = numeroPedido;
//        this.numeroMesa = numeroMesa;
//        lbl_numero_pedido.setText("Pedido: " + String.valueOf(numeroPedido));

        setTodos();
        setCat(lblId, 1);
        setFotos(1);
        setPorCat(lblNomes, txtDescricoes, lblPrecos, lblId);
        pnl_LABELS_INDICES.setVisible(false);
        desativaBotoes();
    }
    
    
    public void desativaBotoes(){

        
    }

    public void setLblId() {
        lblId[0] = lbl_Id_1;
        lblId[1] = lbl_Id_2;
        lblId[2] = lbl_Id_3;
        lblId[3] = lbl_Id_4;
        lblId[4] = lbl_Id_5;
    }

    public void setLblNomes() {
        lblNomes[0] = lbl_nome_1;
        lblNomes[1] = lbl_nome_2;
        lblNomes[2] = lbl_nome_3;
        lblNomes[3] = lbl_nome_4;
        lblNomes[4] = lbl_nome_5;
    }

    public void setTxtAreaDescricoes() {
        txtDescricoes[0] = txt_descricao_1;
        txtDescricoes[1] = txt_descricao_2;
        txtDescricoes[2] = txt_descricao_3;
        txtDescricoes[3] = txt_descricao_4;
        txtDescricoes[4] = txt_descricao_5;
    }

    public void setLblPrecos() {
        lblPrecos[0] = lbl_preco_1;
        lblPrecos[1] = lbl_preco_2;
        lblPrecos[2] = lbl_preco_3;
        lblPrecos[3] = lbl_preco_4;
        lblPrecos[4] = lbl_preco_5;
    }

    public void setLblFotos() {
        lblFotos[0] = lbl_foto_1;
        lblFotos[1] = lbl_foto_2;
        lblFotos[2] = lbl_foto_3;
        lblFotos[3] = lbl_foto_4;
        lblFotos[4] = lbl_foto_5;
    }



    public void setTodos() {
        setLblId();
        setLblNomes();
        setTxtAreaDescricoes();
        setLblPrecos();
        setLblFotos();
    }

    public void setCat(JLabel[] labelId, int cat) {
        if (cat == 1) {
            lblId[0].setText("1");
            lblId[1].setText("2");
            lblId[2].setText("3");
            lblId[3].setText("4");
            lblId[4].setText("5");
        } else if (cat == 2) {
            lblId[0].setText("6");
            lblId[1].setText("7");
            lblId[2].setText("8");
            lblId[3].setText("9");
            lblId[4].setText("10");
        } else if (cat == 3) {
            lblId[0].setText("11");
            lblId[1].setText("12");
            lblId[2].setText("13");
            lblId[3].setText("14");
            lblId[4].setText("15");
        } else if (cat == 4) {
            lblId[0].setText("16");
            lblId[1].setText("17");
            lblId[2].setText("18");
            lblId[3].setText("19");
            lblId[4].setText("20");
        } else if (cat == 5) {
            lblId[0].setText("21");
            lblId[1].setText("22");
            lblId[2].setText("23");
            lblId[3].setText("24");
            lblId[4].setText("25");
        } else {
        }
    }

    public void setPorCat(JLabel[] labelNomes, JTextArea[] txtDescricoes, JLabel[] labelPrecos, JLabel[] labelIDs) throws SQLException {
        ProdutoDao prodDao = new ProdutoDao();
        DecimalFormat df = new DecimalFormat("0.00");
        for (int i = 0; i < labelNomes.length; i++) {
            labelNomes[i].setText(prodDao.listarProdutoPorId(Integer.parseInt(labelIDs[i].getText())).getNome());
            txtDescricoes[i].setText(prodDao.listarProdutoPorId(Integer.parseInt(labelIDs[i].getText())).getDescricao());
            labelPrecos[i].setText("R$ " + String.valueOf(df.format(prodDao.listarProdutoPorId(Integer.parseInt(labelIDs[i].getText())).getPreco())));
        }
    }

    public void setFotos(int cat) {
        if (cat == 1) {
            lbl_foto_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Entrada1.png"));
            lbl_foto_2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Entrada2.png"));
            lbl_foto_3.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Entrada3.png"));
            lbl_foto_4.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Entrada4.png"));
            lbl_foto_5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Entrada5.png"));
        } else if (cat == 2) {
            lbl_foto_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Carne1.png"));
            lbl_foto_2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Carne2.png"));
            lbl_foto_3.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Carne3.png"));
            lbl_foto_4.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Carne4.png"));
            lbl_foto_5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Carne5.png"));
        } else if (cat == 3) {
            lbl_foto_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Burg1.png"));
            lbl_foto_2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Burg2.png"));
            lbl_foto_3.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Burg3.png"));
            lbl_foto_4.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Burg4.png"));
            lbl_foto_5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Burg5.png"));
        } else if (cat == 4) {
            lbl_foto_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Suco1.png"));
            lbl_foto_2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Suco2.jpg"));
            lbl_foto_3.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Refri1.jpg"));
            lbl_foto_4.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Refri2.jpg"));
            lbl_foto_5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Refri3.jpg"));
        } else if (cat == 5) {
            lbl_foto_1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Sobremesa1.png"));
            lbl_foto_2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Sobremesa2.png"));
            lbl_foto_3.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Sobremesa3.png"));
            lbl_foto_4.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Sobremesa4.png"));
            lbl_foto_5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\Sobremesa5.png"));
        } else {
        }
    }





    public void limparQtde() {
        for (int i = 0; i < lblQtde.length; i++) {
            lblQtde[i].setText("0");
        }
    }


    public void encerrarPedidoXXX() throws SQLException {
        int confirma = JOptionPane.showConfirmDialog(
                this,
                "Deseja encerrar o pedido?",
                "ENCERRAR PEDIDO",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (confirma == JOptionPane.YES_OPTION) {

            try {
                if (pedidoVazio(numeroPedido) == true) {
                    PedidoDao pedidoDao = new PedidoDao();
                    pedidoDao.atualizaPedidoVazio(numeroPedido);
                    int novoPedido = JOptionPane.showConfirmDialog(
                            this,
                            "Deseja criar um novo pedido?",
                            "Novo pedido",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );
                    if (novoPedido == JOptionPane.YES_OPTION) {
                        // enviar para a nova tela de ver menu e abir pedido, msm assim essa ta com erro.
                        Pedido pedido = new Pedido();
                        pedido.getMesa().setIdMesa(numeroMesa);
                        pedidoDao.adicionarPedido(pedido);
                        this.dispose();
                        new TelaDeEspera(numeroMesa).setVisible(true);
                    }
                } else {
                    try {
                        Pedido pedido = new Pedido();
                        pedido.setIdPedido(numeroPedido);
                        //
                        double total = 0.0;
                        ItemDao itemDao = new ItemDao();
                        for (Item item : itemDao.listarItensPorPedido(numeroPedido)) {
                            total += item.getSubtotal();
                        }
                        //
                        pedido.setStatus("Encerrado");
                        PedidoDao pedidoDao = new PedidoDao();
                        pedidoDao.atualizaPedido(pedido);
                        JOptionPane.showMessageDialog(null, "Pedido encerrado, um atendente levará a conta até voce"); //arrumar acentuacao
                        this.dispose();

                        int novoPedido = JOptionPane.showConfirmDialog(
                                this,
                                "Deseja criar um novo pedido?",
                                "Novo pedido",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE
                        );
                        if (novoPedido == JOptionPane.YES_OPTION) {
                            // enviar para a nova tela de ver menu e abir pedido, msm assim essa ta com erro.
                            pedido.getMesa().setIdMesa(numeroMesa);
                            pedidoDao.adicionarPedido(pedido);
                            this.dispose();
                            new TelaDeEspera(numeroMesa).setVisible(true);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            }
        }
    }

    public boolean pedidoVazio(int numeroPedido) throws SQLException {
        ItemDao itemDao = new ItemDao();
        double subtotal = 0.0;
        for (Item item : itemDao.listarItensConfirmadosPorPedido(numeroPedido)) {
            subtotal += item.getSubtotal();
        }
        boolean estaVazio = (subtotal == 0);
        return estaVazio;
    }

    public void fecharAoEncerrarViaTelaResumo() {
        mostraComanda();
        this.dispose();
    }

    public void mostraComanda() {
        JPanel comanda = new JPanel();
        TextArea textoComanda = new TextArea();
        textoComanda.setSize(400, 1800);
        comanda.add(textoComanda);
        Comanda test = new Comanda();
        String texto = ("\t\tComanda\n\n");
        texto += "----------------------------------------------------------------------------------------------------------\n";
        texto += "Número do pedido: " + numeroPedido + "\n";
        texto += "Número da mesa: " + numeroMesa + "\n";
        texto += "----------------------------------------------------------------------------------------------------------\n";
        texto += "Nome\t\tPreço\tQtde\tSubtotal\n";
        texto += "----------------------------------------------------------------------------------------------------------\n";

        RelatorioDao relatorioDao = new RelatorioDao();
        DecimalFormat df = new DecimalFormat("R$ 0.00");
        try {
            total = 0.0;
            for (ItemRelatorio itemRelatorio : relatorioDao.listarItensPorPedidoAgrupado(numeroPedido)) {
                //  item = new Item();
                texto += itemRelatorio.getProduto().getNome();
                System.out.println("\n\n\n\n\n\n");
                if (itemRelatorio.getProduto().getNome().length() <= 10) {
                    texto += "\t\t";
                    System.out.println("1");
                } else if ("Classic Burger".equals(itemRelatorio.getProduto().getNome())) {
                    texto += "\t\t";
                } else if ("Suco de laranja".equals(itemRelatorio.getProduto().getNome())) {
                    texto += "\t\t";
                } else if ("Suco de maracujá".equals(itemRelatorio.getProduto().getNome())) {
                    texto += "\t";
                } else if ("Shrimp Parmesan".equals(itemRelatorio.getProduto().getNome())) {
                    texto += "\t";
                } else if ("Chicken Tender".equals(itemRelatorio.getProduto().getNome())) {
                    texto += "\t\t";
                    System.out.println("TENDDER");
                } else if ("Mozzarella Sticks".equals(itemRelatorio.getProduto().getNome())) {
                    texto += "\t";
                    System.out.println("mozza");
                } else if ("Mousse de maracujá".equals(itemRelatorio.getProduto().getNome())) {
                    texto += "\t";
                } else if ("Bolo com caramelo".equals(itemRelatorio.getProduto().getNome())) {
                    texto += "\t";
                } else if ("Bolo de Chocolate".equals(itemRelatorio.getProduto().getNome())) {
                    texto += "\t";
                } else if ("Chocolate Meltdown".equals(itemRelatorio.getProduto().getNome())) {
                    texto += "\t";
                } else if (itemRelatorio.getProduto().getNome().length() <= 13) {
                    texto += "\t\t";
                    System.out.println("2");
                } else if (itemRelatorio.getProduto().getNome().length() <= 14) {
                    texto += "\t";
                    System.out.println("3");
                } else {

                }
                texto += df.format(itemRelatorio.getProduto().getPreco())
                        + "\t"
                        + itemRelatorio.getQtde()
                        + "\t"
                        + df.format(itemRelatorio.getSubtotal());
                texto += "\n";
                total += itemRelatorio.getSubtotal();
            }

            texto += "----------------------------------------------------------------------------------------------------------\n";
            texto += "Subtotal: " + df.format(total) + "\n";
            texto += "Taxa de serviço (10%): " + df.format(total * 0.1) + "\n";
            texto += "TOTAL: " + df.format(total * 1.1) + "\n";
            texto += "----------------------------------------------------------------------------------------------------------\n";
            test.getComanda().setText(texto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
        int opcao = JOptionPane.showConfirmDialog(null, test, "PRE-CONTA", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_tela_menu = new javax.swing.JPanel();
        pnl_categoria = new javax.swing.JPanel();
        btn_categoria_sobremesas = new javax.swing.JButton();
        btn_categoria_bebidas = new javax.swing.JButton();
        btn_categoria_frutos = new javax.swing.JButton();
        btn_categoria_carnes = new javax.swing.JButton();
        btn_categoria_entradas = new javax.swing.JButton();
        btn_Voltar = new javax.swing.JButton();
        pnl_botoes_superior = new javax.swing.JPanel();
        lbl_Logo = new javax.swing.JLabel();
        pnl_LABELS_INDICES = new javax.swing.JPanel();
        lbl_Id_1 = new javax.swing.JLabel();
        lbl_Id_2 = new javax.swing.JLabel();
        lbl_Id_3 = new javax.swing.JLabel();
        lbl_Id_4 = new javax.swing.JLabel();
        lbl_Id_5 = new javax.swing.JLabel();
        lbl_Id_6 = new javax.swing.JLabel();
        lbl_Id_7 = new javax.swing.JLabel();
        lbl_Id_8 = new javax.swing.JLabel();
        lbl_Id_9 = new javax.swing.JLabel();
        lbl_Id_10 = new javax.swing.JLabel();
        lbl_Id_11 = new javax.swing.JLabel();
        lbl_Id_12 = new javax.swing.JLabel();
        lbl_Id_13 = new javax.swing.JLabel();
        lbl_Id_14 = new javax.swing.JLabel();
        lbl_Id_15 = new javax.swing.JLabel();
        lbl_Id_16 = new javax.swing.JLabel();
        lbl_Id_17 = new javax.swing.JLabel();
        lbl_Id_18 = new javax.swing.JLabel();
        lbl_Id_19 = new javax.swing.JLabel();
        lbl_Id_20 = new javax.swing.JLabel();
        lbl_Id_21 = new javax.swing.JLabel();
        lbl_Id_22 = new javax.swing.JLabel();
        lbl_Id_23 = new javax.swing.JLabel();
        lbl_Id_24 = new javax.swing.JLabel();
        lbl_Id_25 = new javax.swing.JLabel();
        pnl_Items = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pnl_ItensCardapio = new javax.swing.JPanel();
        pnl_Item1 = new javax.swing.JPanel();
        lbl_foto_1 = new javax.swing.JLabel();
        lbl_nome_1 = new javax.swing.JLabel();
        lbl_preco_1 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txt_descricao_1 = new javax.swing.JTextArea();
        pnl_Item2 = new javax.swing.JPanel();
        lbl_foto_2 = new javax.swing.JLabel();
        lbl_nome_2 = new javax.swing.JLabel();
        lbl_preco_2 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        txt_descricao_2 = new javax.swing.JTextArea();
        pnl_Item3 = new javax.swing.JPanel();
        lbl_foto_3 = new javax.swing.JLabel();
        lbl_nome_3 = new javax.swing.JLabel();
        lbl_preco_3 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        txt_descricao_3 = new javax.swing.JTextArea();
        pnl_Item4 = new javax.swing.JPanel();
        lbl_foto_4 = new javax.swing.JLabel();
        lbl_nome_4 = new javax.swing.JLabel();
        lbl_preco_4 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        txt_descricao_4 = new javax.swing.JTextArea();
        pnl_Item5 = new javax.swing.JPanel();
        lbl_foto_5 = new javax.swing.JLabel();
        lbl_nome_5 = new javax.swing.JLabel();
        lbl_preco_5 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        txt_descricao_5 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(202, 126, 40));

        pnl_tela_menu.setBackground(new java.awt.Color(153, 255, 255));
        pnl_tela_menu.setPreferredSize(new java.awt.Dimension(2100, 857));

        pnl_categoria.setBackground(new java.awt.Color(246, 242, 233));

        btn_categoria_sobremesas.setBackground(new java.awt.Color(176, 50, 39));
        btn_categoria_sobremesas.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        btn_categoria_sobremesas.setForeground(new java.awt.Color(255, 255, 255));
        btn_categoria_sobremesas.setText("Sobremesas");
        btn_categoria_sobremesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoria_sobremesasActionPerformed(evt);
            }
        });

        btn_categoria_bebidas.setBackground(new java.awt.Color(176, 50, 39));
        btn_categoria_bebidas.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        btn_categoria_bebidas.setForeground(new java.awt.Color(255, 255, 255));
        btn_categoria_bebidas.setText("Bebidas");
        btn_categoria_bebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoria_bebidasActionPerformed(evt);
            }
        });

        btn_categoria_frutos.setBackground(new java.awt.Color(176, 50, 39));
        btn_categoria_frutos.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        btn_categoria_frutos.setForeground(new java.awt.Color(255, 255, 255));
        btn_categoria_frutos.setText("Hamburguer");
        btn_categoria_frutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoria_frutosActionPerformed(evt);
            }
        });

        btn_categoria_carnes.setBackground(new java.awt.Color(176, 50, 39));
        btn_categoria_carnes.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        btn_categoria_carnes.setForeground(new java.awt.Color(255, 255, 255));
        btn_categoria_carnes.setText("Carnes");
        btn_categoria_carnes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoria_carnesActionPerformed(evt);
            }
        });

        btn_categoria_entradas.setBackground(new java.awt.Color(176, 50, 39));
        btn_categoria_entradas.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        btn_categoria_entradas.setForeground(new java.awt.Color(255, 255, 255));
        btn_categoria_entradas.setText("Entradas");
        btn_categoria_entradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoria_entradasActionPerformed(evt);
            }
        });

        btn_Voltar.setBackground(new java.awt.Color(102, 255, 102));
        btn_Voltar.setFont(new java.awt.Font("Cooper Black", 0, 26)); // NOI18N
        btn_Voltar.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\voltar.png"));
        btn_Voltar.setText("Voltar");
        btn_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_categoriaLayout = new javax.swing.GroupLayout(pnl_categoria);
        pnl_categoria.setLayout(pnl_categoriaLayout);
        pnl_categoriaLayout.setHorizontalGroup(
            pnl_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_categoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_categoria_sobremesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_categoria_bebidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_categoria_frutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_categoria_carnes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_categoria_entradas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Voltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_categoriaLayout.setVerticalGroup(
            pnl_categoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_categoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_categoria_entradas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_categoria_carnes, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_categoria_frutos, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_categoria_bebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_categoria_sobremesas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(btn_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnl_botoes_superior.setBackground(new java.awt.Color(176, 50, 39));

        lbl_Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Logo.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "\\src\\main\\java\\br\\digitalmenu\\images\\digitalmenu3.png"));

        pnl_LABELS_INDICES.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_1.setText("1");
        lbl_Id_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbl_Id_1.setPreferredSize(new java.awt.Dimension(14, 18));

        lbl_Id_2.setText("2");
        lbl_Id_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_3.setText("3");
        lbl_Id_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_4.setText("4");
        lbl_Id_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_5.setText("5");
        lbl_Id_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_6.setText("6");
        lbl_Id_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_7.setText("7");
        lbl_Id_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_8.setText("8");
        lbl_Id_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_9.setText("9");
        lbl_Id_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_10.setText("10");
        lbl_Id_10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_11.setText("11");
        lbl_Id_11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_12.setText("12");
        lbl_Id_12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_13.setText("13");
        lbl_Id_13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_14.setText("14");
        lbl_Id_14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_15.setText("15");
        lbl_Id_15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_16.setText("16");
        lbl_Id_16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_17.setText("17");
        lbl_Id_17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_18.setText("18");
        lbl_Id_18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_19.setText("19");
        lbl_Id_19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_20.setText("20");
        lbl_Id_20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_21.setText("21");
        lbl_Id_21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_22.setText("22");
        lbl_Id_22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_23.setText("23");
        lbl_Id_23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_24.setText("24");
        lbl_Id_24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_Id_25.setText("25");
        lbl_Id_25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnl_LABELS_INDICESLayout = new javax.swing.GroupLayout(pnl_LABELS_INDICES);
        pnl_LABELS_INDICES.setLayout(pnl_LABELS_INDICESLayout);
        pnl_LABELS_INDICESLayout.setHorizontalGroup(
            pnl_LABELS_INDICESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_LABELS_INDICESLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnl_LABELS_INDICESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_LABELS_INDICESLayout.createSequentialGroup()
                        .addGroup(pnl_LABELS_INDICESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnl_LABELS_INDICESLayout.createSequentialGroup()
                                .addComponent(lbl_Id_21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_Id_22, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_LABELS_INDICESLayout.createSequentialGroup()
                                .addComponent(lbl_Id_16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_LABELS_INDICESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_LABELS_INDICESLayout.createSequentialGroup()
                                .addComponent(lbl_Id_18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_19, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_20, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnl_LABELS_INDICESLayout.createSequentialGroup()
                                .addComponent(lbl_Id_23, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_24, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_25, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnl_LABELS_INDICESLayout.createSequentialGroup()
                        .addGroup(pnl_LABELS_INDICESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_LABELS_INDICESLayout.createSequentialGroup()
                                .addComponent(lbl_Id_11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_LABELS_INDICESLayout.createSequentialGroup()
                                .addComponent(lbl_Id_6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_Id_10)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnl_LABELS_INDICESLayout.createSequentialGroup()
                        .addComponent(lbl_Id_1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Id_2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Id_3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Id_4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Id_5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        pnl_LABELS_INDICESLayout.setVerticalGroup(
            pnl_LABELS_INDICESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_LABELS_INDICESLayout.createSequentialGroup()
                .addGroup(pnl_LABELS_INDICESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Id_1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_LABELS_INDICESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Id_6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_LABELS_INDICESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Id_11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_13, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_14, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_15, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_LABELS_INDICESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Id_16, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_17, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_18, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_19, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_20, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_LABELS_INDICESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Id_21, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_22, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_23, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_24, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Id_25, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_botoes_superiorLayout = new javax.swing.GroupLayout(pnl_botoes_superior);
        pnl_botoes_superior.setLayout(pnl_botoes_superiorLayout);
        pnl_botoes_superiorLayout.setHorizontalGroup(
            pnl_botoes_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_botoes_superiorLayout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(lbl_Logo, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(pnl_LABELS_INDICES, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(346, 346, 346))
        );
        pnl_botoes_superiorLayout.setVerticalGroup(
            pnl_botoes_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_botoes_superiorLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pnl_LABELS_INDICES, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jScrollPane3.setBackground(new java.awt.Color(102, 255, 204));
        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setToolTipText("");
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setAutoscrolls(true);
        jScrollPane3.setPreferredSize(new java.awt.Dimension(1005, 1800));

        pnl_ItensCardapio.setBackground(new java.awt.Color(246, 242, 233));

        pnl_Item1.setBackground(new java.awt.Color(246, 242, 233));
        pnl_Item1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_Item1.setPreferredSize(new java.awt.Dimension(1350, 405));

        lbl_foto_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_foto_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_nome_1.setFont(new java.awt.Font("Cooper Black", 0, 48)); // NOI18N
        lbl_nome_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nome_1.setText("Bufallo Wings");

        lbl_preco_1.setFont(new java.awt.Font("Cooper Black", 0, 48)); // NOI18N
        lbl_preco_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_preco_1.setText("R$ 000,00");

        txt_descricao_1.setEditable(false);
        txt_descricao_1.setBackground(new java.awt.Color(246, 242, 233));
        txt_descricao_1.setColumns(20);
        txt_descricao_1.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        txt_descricao_1.setLineWrap(true);
        txt_descricao_1.setRows(5);
        txt_descricao_1.setWrapStyleWord(true);
        txt_descricao_1.setBorder(null);
        jScrollPane8.setViewportView(txt_descricao_1);

        javax.swing.GroupLayout pnl_Item1Layout = new javax.swing.GroupLayout(pnl_Item1);
        pnl_Item1.setLayout(pnl_Item1Layout);
        pnl_Item1Layout.setHorizontalGroup(
            pnl_Item1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_foto_1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_Item1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Item1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(lbl_preco_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(190, 190, 190))
                    .addGroup(pnl_Item1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_Item1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8)
                            .addComponent(lbl_nome_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        pnl_Item1Layout.setVerticalGroup(
            pnl_Item1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_Item1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_Item1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_foto_1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_Item1Layout.createSequentialGroup()
                        .addComponent(lbl_nome_1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_preco_1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_Item2.setBackground(new java.awt.Color(246, 242, 233));
        pnl_Item2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_Item2.setPreferredSize(new java.awt.Dimension(1350, 405));

        lbl_foto_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_foto_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_nome_2.setFont(new java.awt.Font("Cooper Black", 0, 48)); // NOI18N
        lbl_nome_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nome_2.setText("Bufallo Wings");

        lbl_preco_2.setFont(new java.awt.Font("Cooper Black", 0, 48)); // NOI18N
        lbl_preco_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_preco_2.setText("R$ 000,00");

        txt_descricao_2.setEditable(false);
        txt_descricao_2.setBackground(new java.awt.Color(246, 242, 233));
        txt_descricao_2.setColumns(20);
        txt_descricao_2.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        txt_descricao_2.setLineWrap(true);
        txt_descricao_2.setRows(5);
        txt_descricao_2.setWrapStyleWord(true);
        jScrollPane11.setViewportView(txt_descricao_2);

        javax.swing.GroupLayout pnl_Item2Layout = new javax.swing.GroupLayout(pnl_Item2);
        pnl_Item2.setLayout(pnl_Item2Layout);
        pnl_Item2Layout.setHorizontalGroup(
            pnl_Item2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_foto_2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_Item2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Item2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_Item2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_nome_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane11))
                        .addContainerGap())
                    .addGroup(pnl_Item2Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(lbl_preco_2, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                        .addGap(184, 184, 184))))
        );
        pnl_Item2Layout.setVerticalGroup(
            pnl_Item2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item2Layout.createSequentialGroup()
                .addGroup(pnl_Item2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_Item2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbl_foto_2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_Item2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_nome_2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_preco_2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_Item3.setBackground(new java.awt.Color(246, 242, 233));
        pnl_Item3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_Item3.setPreferredSize(new java.awt.Dimension(1350, 405));

        lbl_foto_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_foto_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_nome_3.setFont(new java.awt.Font("Cooper Black", 0, 48)); // NOI18N
        lbl_nome_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nome_3.setText("Bufallo Wings");

        lbl_preco_3.setFont(new java.awt.Font("Cooper Black", 0, 48)); // NOI18N
        lbl_preco_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_preco_3.setText("R$ 000,00");

        txt_descricao_3.setEditable(false);
        txt_descricao_3.setBackground(new java.awt.Color(246, 242, 233));
        txt_descricao_3.setColumns(20);
        txt_descricao_3.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        txt_descricao_3.setLineWrap(true);
        txt_descricao_3.setRows(5);
        txt_descricao_3.setWrapStyleWord(true);
        jScrollPane13.setViewportView(txt_descricao_3);

        javax.swing.GroupLayout pnl_Item3Layout = new javax.swing.GroupLayout(pnl_Item3);
        pnl_Item3.setLayout(pnl_Item3Layout);
        pnl_Item3Layout.setHorizontalGroup(
            pnl_Item3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_foto_3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_Item3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Item3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_Item3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane13)
                            .addComponent(lbl_nome_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_Item3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_preco_3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167))))
        );
        pnl_Item3Layout.setVerticalGroup(
            pnl_Item3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item3Layout.createSequentialGroup()
                .addGroup(pnl_Item3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_Item3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbl_foto_3, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_Item3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_nome_3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_preco_3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_Item4.setBackground(new java.awt.Color(246, 242, 233));
        pnl_Item4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_Item4.setPreferredSize(new java.awt.Dimension(1350, 405));

        lbl_foto_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_foto_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_nome_4.setFont(new java.awt.Font("Cooper Black", 0, 48)); // NOI18N
        lbl_nome_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nome_4.setText("Bufallo Wings");

        lbl_preco_4.setFont(new java.awt.Font("Cooper Black", 0, 48)); // NOI18N
        lbl_preco_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_preco_4.setText("R$ 000,00");

        txt_descricao_4.setEditable(false);
        txt_descricao_4.setBackground(new java.awt.Color(246, 242, 233));
        txt_descricao_4.setColumns(20);
        txt_descricao_4.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        txt_descricao_4.setLineWrap(true);
        txt_descricao_4.setRows(5);
        txt_descricao_4.setWrapStyleWord(true);
        jScrollPane15.setViewportView(txt_descricao_4);

        javax.swing.GroupLayout pnl_Item4Layout = new javax.swing.GroupLayout(pnl_Item4);
        pnl_Item4.setLayout(pnl_Item4Layout);
        pnl_Item4Layout.setHorizontalGroup(
            pnl_Item4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_foto_4, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_Item4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_Item4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_Item4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane15)
                            .addComponent(lbl_nome_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_Item4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_preco_4, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176))))
        );
        pnl_Item4Layout.setVerticalGroup(
            pnl_Item4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item4Layout.createSequentialGroup()
                .addGroup(pnl_Item4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_Item4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbl_foto_4, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_Item4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_nome_4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_preco_4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_Item5.setBackground(new java.awt.Color(246, 242, 233));
        pnl_Item5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_Item5.setPreferredSize(new java.awt.Dimension(1350, 405));

        lbl_foto_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_foto_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_nome_5.setFont(new java.awt.Font("Cooper Black", 0, 48)); // NOI18N
        lbl_nome_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nome_5.setText("Bufallo Wings");

        lbl_preco_5.setFont(new java.awt.Font("Cooper Black", 0, 48)); // NOI18N
        lbl_preco_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_preco_5.setText("R$ 000,00");

        txt_descricao_5.setEditable(false);
        txt_descricao_5.setBackground(new java.awt.Color(246, 242, 233));
        txt_descricao_5.setColumns(20);
        txt_descricao_5.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        txt_descricao_5.setLineWrap(true);
        txt_descricao_5.setRows(5);
        txt_descricao_5.setWrapStyleWord(true);
        jScrollPane17.setViewportView(txt_descricao_5);

        javax.swing.GroupLayout pnl_Item5Layout = new javax.swing.GroupLayout(pnl_Item5);
        pnl_Item5.setLayout(pnl_Item5Layout);
        pnl_Item5Layout.setHorizontalGroup(
            pnl_Item5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_foto_5, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_Item5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_Item5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_preco_5, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169))
                    .addComponent(lbl_nome_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_Item5Layout.setVerticalGroup(
            pnl_Item5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_Item5Layout.createSequentialGroup()
                .addGroup(pnl_Item5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_Item5Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbl_foto_5, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_Item5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_nome_5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_preco_5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_ItensCardapioLayout = new javax.swing.GroupLayout(pnl_ItensCardapio);
        pnl_ItensCardapio.setLayout(pnl_ItensCardapioLayout);
        pnl_ItensCardapioLayout.setHorizontalGroup(
            pnl_ItensCardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ItensCardapioLayout.createSequentialGroup()
                .addGroup(pnl_ItensCardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnl_Item5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1255, Short.MAX_VALUE)
                    .addComponent(pnl_Item4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1255, Short.MAX_VALUE)
                    .addComponent(pnl_Item3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1255, Short.MAX_VALUE)
                    .addComponent(pnl_Item2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1255, Short.MAX_VALUE)
                    .addComponent(pnl_Item1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1255, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_ItensCardapioLayout.setVerticalGroup(
            pnl_ItensCardapioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ItensCardapioLayout.createSequentialGroup()
                .addComponent(pnl_Item1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_Item2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_Item3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_Item4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_Item5, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(pnl_ItensCardapio);

        javax.swing.GroupLayout pnl_ItemsLayout = new javax.swing.GroupLayout(pnl_Items);
        pnl_Items.setLayout(pnl_ItemsLayout);
        pnl_ItemsLayout.setHorizontalGroup(
            pnl_ItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ItemsLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        pnl_ItemsLayout.setVerticalGroup(
            pnl_ItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ItemsLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_tela_menuLayout = new javax.swing.GroupLayout(pnl_tela_menu);
        pnl_tela_menu.setLayout(pnl_tela_menuLayout);
        pnl_tela_menuLayout.setHorizontalGroup(
            pnl_tela_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnl_tela_menuLayout.createSequentialGroup()
                .addComponent(pnl_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_Items, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnl_botoes_superior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_tela_menuLayout.setVerticalGroup(
            pnl_tela_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_tela_menuLayout.createSequentialGroup()
                .addComponent(pnl_botoes_superior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnl_tela_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_Items, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_tela_menu, javax.swing.GroupLayout.DEFAULT_SIZE, 1468, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_tela_menu, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1482, 896));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_categoria_carnesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoria_carnesActionPerformed
        try {
            setCat(lblId, 2);
            setPorCat(lblNomes, txtDescricoes, lblPrecos, lblId);
            setFotos(2);
            //limparQtde();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_categoria_carnesActionPerformed

    private void btn_categoria_entradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoria_entradasActionPerformed
        try {
            setCat(lblId, 1);
            setPorCat(lblNomes, txtDescricoes, lblPrecos, lblId);
            setFotos(1);
            //limparQtde();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_categoria_entradasActionPerformed

    private void btn_categoria_sobremesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoria_sobremesasActionPerformed
        try {
            setCat(lblId, 5);
            setPorCat(lblNomes, txtDescricoes, lblPrecos, lblId);
            setFotos(5);
            //limparQtde();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_categoria_sobremesasActionPerformed

    private void btn_categoria_frutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoria_frutosActionPerformed
        try {
            setCat(lblId, 3);
            setPorCat(lblNomes, txtDescricoes, lblPrecos, lblId);
            setFotos(3);
            //limparQtde();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_categoria_frutosActionPerformed

    private void btn_categoria_bebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoria_bebidasActionPerformed
        try {
            setCat(lblId, 4);
            setPorCat(lblNomes, txtDescricoes, lblPrecos, lblId);
            setFotos(4);
            //limparQtde();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_categoria_bebidasActionPerformed



    private void btn_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VoltarActionPerformed
        this.dispose();

    }//GEN-LAST:event_btn_VoltarActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_VerCardapio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_VerCardapio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_VerCardapio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_VerCardapio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Tela_VerCardapio().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Tela_VerCardapio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Voltar;
    private javax.swing.JButton btn_categoria_bebidas;
    private javax.swing.JButton btn_categoria_carnes;
    private javax.swing.JButton btn_categoria_entradas;
    private javax.swing.JButton btn_categoria_frutos;
    private javax.swing.JButton btn_categoria_sobremesas;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lbl_Id_1;
    private javax.swing.JLabel lbl_Id_10;
    private javax.swing.JLabel lbl_Id_11;
    private javax.swing.JLabel lbl_Id_12;
    private javax.swing.JLabel lbl_Id_13;
    private javax.swing.JLabel lbl_Id_14;
    private javax.swing.JLabel lbl_Id_15;
    private javax.swing.JLabel lbl_Id_16;
    private javax.swing.JLabel lbl_Id_17;
    private javax.swing.JLabel lbl_Id_18;
    private javax.swing.JLabel lbl_Id_19;
    private javax.swing.JLabel lbl_Id_2;
    private javax.swing.JLabel lbl_Id_20;
    private javax.swing.JLabel lbl_Id_21;
    private javax.swing.JLabel lbl_Id_22;
    private javax.swing.JLabel lbl_Id_23;
    private javax.swing.JLabel lbl_Id_24;
    private javax.swing.JLabel lbl_Id_25;
    private javax.swing.JLabel lbl_Id_3;
    private javax.swing.JLabel lbl_Id_4;
    private javax.swing.JLabel lbl_Id_5;
    private javax.swing.JLabel lbl_Id_6;
    private javax.swing.JLabel lbl_Id_7;
    private javax.swing.JLabel lbl_Id_8;
    private javax.swing.JLabel lbl_Id_9;
    private javax.swing.JLabel lbl_Logo;
    private javax.swing.JLabel lbl_foto_1;
    private javax.swing.JLabel lbl_foto_2;
    private javax.swing.JLabel lbl_foto_3;
    private javax.swing.JLabel lbl_foto_4;
    private javax.swing.JLabel lbl_foto_5;
    private javax.swing.JLabel lbl_nome_1;
    private javax.swing.JLabel lbl_nome_2;
    private javax.swing.JLabel lbl_nome_3;
    private javax.swing.JLabel lbl_nome_4;
    private javax.swing.JLabel lbl_nome_5;
    private javax.swing.JLabel lbl_preco_1;
    private javax.swing.JLabel lbl_preco_2;
    private javax.swing.JLabel lbl_preco_3;
    private javax.swing.JLabel lbl_preco_4;
    private javax.swing.JLabel lbl_preco_5;
    private javax.swing.JPanel pnl_Item1;
    private javax.swing.JPanel pnl_Item2;
    private javax.swing.JPanel pnl_Item3;
    private javax.swing.JPanel pnl_Item4;
    private javax.swing.JPanel pnl_Item5;
    private javax.swing.JPanel pnl_Items;
    private javax.swing.JPanel pnl_ItensCardapio;
    private javax.swing.JPanel pnl_LABELS_INDICES;
    private javax.swing.JPanel pnl_botoes_superior;
    private javax.swing.JPanel pnl_categoria;
    private javax.swing.JPanel pnl_tela_menu;
    private javax.swing.JTextArea txt_descricao_1;
    private javax.swing.JTextArea txt_descricao_2;
    private javax.swing.JTextArea txt_descricao_3;
    private javax.swing.JTextArea txt_descricao_4;
    private javax.swing.JTextArea txt_descricao_5;
    // End of variables declaration//GEN-END:variables
}
