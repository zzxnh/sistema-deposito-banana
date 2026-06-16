/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joseproject.a3_paduan.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.joseproject.a3_paduan.model.Cliente;
import com.joseproject.a3_paduan.model.TipoDeBanana;
import com.joseproject.a3_paduan.model.Venda;
import com.joseproject.a3_paduan.util.Conexao;

/**
 *
 * @author Usuario
 */
public class VendaDAO {

    public void salvar(Venda venda) {
        String sql = "INSERT INTO vendas (id_cliente,id_tipo,quantidade_caixas,preco_unitario,valor_total)"
                + "VALUES (?,?,?,?,?)";

        try (Connection conn = Conexao.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, venda.getCliente().getIdCliente());
            stmt.setInt(2, venda.getTipoDeBanana().getIdTipoBanana());
            stmt.setInt(3, venda.getQtdeCaixas());
            stmt.setDouble(4, venda.getPrecoUni());
            stmt.setDouble(5, venda.getValorTotal());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar a venda !");
        }
    }

    public List<Venda> listar() {

        List<Venda> lista = new ArrayList<>();

        String sql = "SELECT * FROM vendas v "
                + "INNER JOIN clientes c "
                + "ON v.id_cliente = c.id_cliente "
                + "INNER JOIN tipos_banana t "
                + "ON v.id_tipo = t.id_tipo";

        try (Connection conn = Conexao.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNomeCliente(rs.getString("nome"));

                TipoDeBanana tipo = new TipoDeBanana();
                tipo.setIdTipoBanana(rs.getInt("id_tipo"));
                tipo.setNomeTipoBanana(rs.getString("nome_tipo"));

                Venda venda = new Venda();
                venda.setIdVenda(rs.getInt("id_venda"));
                venda.setCliente(cliente);
                venda.setTipoDeBanana(tipo);
                venda.setQtdeCaixas(rs.getInt("quantidade_caixas"));
                venda.setPrecoUni(rs.getDouble("preco_unitario"));
                venda.setValorTotal(rs.getDouble("valor_total"));

                lista.add(venda);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar vendas !", e);
        }

        return lista;
    }

    public void excluir(int idVenda) {
        String sql = "DELETE FROM vendas WHERE id_venda = ?";

        try (Connection conn = Conexao.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idVenda);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir venda ! ", e);
        }
    }

    public void atualizar(Venda venda) {
        String sql = "UPDATE vendas "
                + "SET quantidade_caixas = ?, "
                + "preco_unitario = ?, "
                + "valor_total = ? "
                + "WHERE id_venda = ?";

        try (Connection conn = Conexao.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, venda.getQtdeCaixas());
            stmt.setDouble(2, venda.getPrecoUni());
            stmt.setDouble(3, venda.getValorTotal());
            stmt.setInt(4, venda.getIdVenda());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar venda!", e);
        }
    }
    
    public Venda buscarPorId(int id) {

        String sql =
            "SELECT * FROM vendas WHERE id_venda = ?";

        Venda venda = null;

        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                venda = new Venda();

                    venda.setIdVenda(
                    rs.getInt("id_venda"));

        }

    } catch (SQLException e) {
        throw new RuntimeException(
                "Erro ao buscar venda!", e);
        }

        return venda;
   }    

}
