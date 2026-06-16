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
import com.joseproject.a3_paduan.util.Conexao;
import com.joseproject.a3_paduan.model.Cliente;

/**
 *
 * @author Usuario
 */
public class ClienteDAO {

    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome) VALUES (?)";

        try (Connection conn = Conexao.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNomeCliente());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar cliente ! ", e);
        }
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection conn = Conexao.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();

                c.setIdCliente(rs.getInt("id_cliente"));
                c.setNomeCliente(rs.getString("nome"));

                lista.add(c);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar clientes", e);
        }

        return lista;
    }

    public void excluir(int id) {
        String sql = "DELETE FROM clientes WHERE id_cliente = ?";

        try (Connection conn = Conexao.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir cliente ! ", e);
        }
    }

    public void atualizar(Cliente cliente) {
        String sql = "UPDATE clientes SET nome = ? "
                + "WHERE id_cliente = ?";

        try (Connection conn = Conexao.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNomeCliente());
            stmt.setInt(2, cliente.getIdCliente());
            
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o cliente ! ", e);
        }
    }
    
    public Cliente buscarPorNome(String nome) {

        String sql =
            "SELECT * FROM clientes WHERE nome = ?";

        Cliente cliente = null;

        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                cliente = new Cliente();

                    cliente.setIdCliente(
                    rs.getInt("id_cliente"));

                     cliente.setNomeCliente(
                    rs.getString("nome"));
        }

    } catch (SQLException e) {
        throw new RuntimeException(
                "Erro ao buscar cliente!", e);
        }

        return cliente;
   }    
    
    public Cliente buscarPorId(int id) {

        String sql =
            "SELECT * FROM clientes WHERE id_cliente = ?";

        Cliente cliente = null;

        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                cliente = new Cliente();

                    cliente.setIdCliente(
                    rs.getInt("id_cliente"));

                     cliente.setNomeCliente(
                    rs.getString("nome"));
        }

    } catch (SQLException e) {
        throw new RuntimeException(
                "Erro ao buscar cliente!", e);
        }

        return cliente;
   }    
    
}
