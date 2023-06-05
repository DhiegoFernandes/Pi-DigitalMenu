package br.digitalmenu.dao;

import br.digitalmenu.connection.ConnectionFactory;
import br.digitalmenu.model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PedidoDao {

    private Connection connection;
    public int numeroPedido;
    public int numeroMesa;

    public void adicionarPedido(Pedido pedido) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql
                = "INSERT INTO pedido (idpedido, id_mesa, total, data, status) "
                + "VALUES (DEFAULT, ?, DEFAULT, DEFAULT, DEFAULT)";

        try {
            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedido.getMesa().getIdMesa());
            ps.execute();
            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                numeroPedido = rs.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Pedido criado!, Nº: " + numeroPedido,"Pedido criado com sucesso!", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            throw ex;
        } finally {
            rs.close();
            ps.close();
            connection.close();
        }
    }

    public List<Pedido> listarPedido() throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        List<Pedido> listaDePedido = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql
                = "SELECT idpedido, id_mesa, total, DATE_FORMAT(data,'%d/%m/%Y') AS data, "
                + "DATE_FORMAT(data,'%H:%i:%s') AS horario, status "
                + "FROM pedido order by data desc";

        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idpedido"));
                pedido.getMesa().setIdMesa(rs.getInt("id_mesa"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setData(rs.getString("data"));
                pedido.setHorario(rs.getString("horario"));
                pedido.setStatus(rs.getString("status"));
                listaDePedido.add(pedido);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDePedido;
    }

    public Pedido listarPedidoPorId(Integer p) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pedido pedido = null;

        String sql
                = "SELECT idpedido, id_mesa, total, DATE_FORMAT(data,'%d/%m/%Y') AS data, "
                + "DATE_FORMAT(data,'%H:%i:%s') AS horario, status "
                + "FROM pedido "
                + "WHERE idpedido = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, p);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idpedido"));
                pedido.getMesa().setIdMesa(rs.getInt("id_mesa"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setData(rs.getString("data"));
                pedido.setHorario(rs.getString("horario"));
                pedido.setStatus(rs.getString("status"));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return pedido;
    }

    public List<Pedido> listarPedidoPorMesa(Integer p) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pedido> pedidos = new ArrayList<>();
        Pedido pedido = null;

        String sql
                = "SELECT idpedido, id_mesa, total, DATE_FORMAT(data,'%d/%m/%Y') AS data, "
                + "DATE_FORMAT(data,'%H:%i:%s') AS horario, status "
                + "FROM pedido "
                + "WHERE id_mesa = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, p);
            rs = ps.executeQuery();

            while (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idpedido"));
                pedido.getMesa().setIdMesa(rs.getInt("id_mesa"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setData(rs.getString("data"));
                pedido.setHorario(rs.getString("horario"));
                pedido.setStatus(rs.getString("status"));
                pedidos.add(pedido);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return pedidos;
    }

    public List<Pedido> listarPedidoPorStatus(String status) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pedido> pedidos = new ArrayList<>();
        Pedido pedido = null;

        String sql
                = "SELECT idpedido, id_mesa, total, DATE_FORMAT(data,'%d/%m/%Y') AS data, "
                + "DATE_FORMAT(data,'%H:%i:%s') AS horario, status "
                + "FROM pedido "
                + "WHERE status = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            rs = ps.executeQuery();

            while (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idpedido"));
                pedido.getMesa().setIdMesa(rs.getInt("id_mesa"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setData(rs.getString("data"));
                pedido.setHorario(rs.getString("horario"));
                pedido.setStatus(rs.getString("status"));
                pedidos.add(pedido);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return pedidos;
    }

    public List<Pedido> listarProdutoPorFaixaDePreco(double valorInicial, double valorFinal) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pedido> listaDePedidos = new ArrayList<>();

        String sql
                = "SELECT idpedido, id_mesa, total, DATE_FORMAT(data, '%d/%m/%Y') AS data, "
                + "DATE_FORMAT(data,'%H:%i:%s') AS horario, status "
                + "FROM pedido "
                + "WHERE total BETWEEN ? AND ? "
                + "ORDER BY total";
        try {
            ps = connection.prepareStatement(sql);
            ps.setDouble(1, valorInicial);
            ps.setDouble(2, valorFinal);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idpedido"));
                p.getMesa().setIdMesa(rs.getInt("id_mesa"));
                p.setTotal(rs.getDouble("total"));
                p.setData(rs.getString("data"));
                p.setHorario(rs.getString("horario"));
                p.setStatus(rs.getString("status"));
                listaDePedidos.add(p);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDePedidos;
    }

    public List<Pedido> listarProdutoPorDia(String data) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pedido> listaDePedidos = new ArrayList<>();

        String sql
                = "SELECT idpedido, id_mesa, total, DATE_FORMAT(data, '%d/%m/%Y') AS data, "
                + "DATE_FORMAT(data,'%H:%i:%s') AS horario, status "
                + "FROM pedido "
                + "WHERE DATE_FORMAT(data, '%d/%m/%Y') = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, data);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idpedido"));
                p.getMesa().setIdMesa(rs.getInt("id_mesa"));
                p.setTotal(rs.getDouble("total"));
                p.setData(rs.getString("data"));
                p.setHorario(rs.getString("horario"));
                p.setStatus(rs.getString("status"));
                listaDePedidos.add(p);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDePedidos;
    }

    public List<Pedido> listarProdutoPorFaixaDia(String dataInicial, String dataFinal) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Pedido> listaDePedidos = new ArrayList<>();

        String sql
                = "SELECT idpedido, id_mesa, total, DATE_FORMAT(data, '%d/%m/%Y') AS data, "
                + "DATE_FORMAT(data,'%H:%i:%s') AS horario, status "
                + "FROM pedido "
                + "WHERE DATE_FORMAT(data, '%d/%m/%Y') >= ? AND DATE_FORMAT(data, '%d/%m/%Y') <= ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, dataInicial);
            ps.setString(2, dataFinal);
            rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idpedido"));
                p.getMesa().setIdMesa(rs.getInt("id_mesa"));
                p.setTotal(rs.getDouble("total"));
                p.setData(rs.getString("data"));
                p.setHorario(rs.getString("horario"));
                p.setStatus(rs.getString("status"));
                listaDePedidos.add(p);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            rs.close();
            connection.close();
        }
        return listaDePedidos;
    }

    public void atualizaPedido(Pedido pedido) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql
                = "UPDATE pedido p INNER JOIN item i "
                + "ON p.idpedido = i.id_pedido "
                + "SET p.total = (SELECT SUM(subtotal) "
                + "FROM item WHERE id_pedido = ?), p.status = ? "
                + "WHERE p.idpedido = ? AND i.status = 'confirmado'";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, pedido.getIdPedido());
            ps.setString(2, pedido.getStatus());
            ps.setInt(3, pedido.getIdPedido());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }
    }

    public void atualizaPedidoItemAlterado(int numeroPedido) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql
                = "UPDATE pedido p INNER JOIN item i ON p.idpedido = i.id_pedido "
                + "SET p.total = IFNULL((SELECT SUM(i.subtotal) "
                + "FROM item i "
                + "WHERE i.id_pedido = ? AND i.status = 'confirmado'), 0.0) "
                + "WHERE p.idpedido = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, numeroPedido);
            ps.setInt(2, numeroPedido);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }
    }

    public void cancelarPedido(int numeroPedido, String status) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql
                = "UPDATE pedido "
                + "SET status = ? "
                + "WHERE idpedido = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, numeroPedido);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }
    }

    public boolean deletarPedido(int numeroMesaDeletar) throws SQLException {

        boolean deletado;
        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql
                = "DELETE FROM pedido "
                + "WHERE idpedido = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, numeroMesaDeletar);
            deletado = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }
        return deletado;
    }

    public List<Pedido> vendasPorDia() {

        connection = new ConnectionFactory().recuperarConexao();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        PreparedStatement psmt = null;
        ResultSet rst = null;

        String sql
                = "SELECT sum(total) AS Total, DATE_FORMAT(data,'%d/%m/%Y') AS Data "
                + "FROM pedido "
                + "GROUP BY DATE_FORMAT(data,'%d/%m/%Y')";

        try {
            psmt = connection.prepareStatement(sql);
            psmt.execute();
            rst = psmt.getResultSet();
            while (rst.next()) {
                Pedido pedido = new Pedido();
                pedido.setTotal(rst.getDouble(1));
                pedido.setData(rst.getString(2));
                pedidos.add(pedido);
            }
            rst.close();
            psmt.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedidos;
    }
    
    public void atualizaPedidoVazio(int pedido) throws SQLException {

        connection = new ConnectionFactory().recuperarConexao();
        PreparedStatement ps = null;

        String sql
                = "UPDATE pedido "
                + "SET status = 'encerrado' "
                + "WHERE idpedido = ?";
      
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, pedido);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            ps.close();
            connection.close();
        }
    }
}
