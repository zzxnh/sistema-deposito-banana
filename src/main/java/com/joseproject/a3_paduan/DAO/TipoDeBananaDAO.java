/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joseproject.a3_paduan.DAO;

import com.joseproject.a3_paduan.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.joseproject.a3_paduan.model.TipoDeBanana;
import com.joseproject.a3_paduan.util.Conexao;

/**
 *
 * @author Usuario
 */
public class TipoDeBananaDAO {

    public void salvar(TipoDeBanana tipo) {

        String sql = "INSERT INTO tipos_banana (nome_tipo) VALUES (?)";

        try (Connection conn = Conexao.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tipo.getNomeTipoBanana());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar tipo de banana ! ", e);
        }
    }

    public List<TipoDeBanana> listar() {
        List<TipoDeBanana> lista = new ArrayList<>();

        String sql = "SELECT * FROM tipos_banana";

        try (Connection conn = Conexao.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                TipoDeBanana t = new TipoDeBanana();

                t.setIdTipoBanana(rs.getInt("id_tipo"));
                t.setNomeTipoBanana(rs.getString("nome_tipo"));

                lista.add(t);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os tipos de bananas ! ", e);
        }

        return lista;
    }

    public void excluir(int id) {
        String sql = "DELETE FROM tipos_banana WHERE id = ?";

        try (Connection conn = Conexao.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir tipo de banana ! ", e);
        }
    }

    public void atualizar(TipoDeBanana tipoDeBanana) {
        String sql = "UPDATE tipos_banana SET nome_tipo = ? "
                + "WHERE id_tipo = ?";

        try (Connection conn = Conexao.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tipoDeBanana.getNomeTipoBanana());
            stmt.setInt(2, tipoDeBanana.getIdTipoBanana());

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o tipo de banana ! ", e);
        }
    }

    public TipoDeBanana buscarPorNome(String nomeTipo) {

        String sql
                = "SELECT * FROM tipos_banana "
                + "WHERE nome_tipo = ?";

        TipoDeBanana tipo = null;

        try (Connection conn = Conexao.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nomeTipo);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                tipo = new TipoDeBanana();

                tipo.setIdTipoBanana(
                        rs.getInt("id_tipo"));

                tipo.setNomeTipoBanana(
                        rs.getString("nome_tipo"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao buscar tipo de banana!", e);
        }

        return tipo;
    }
    
    public TipoDeBanana buscarPorId(int idTipo) {

        String sql
                = "SELECT * FROM tipos_banana "
                + "WHERE id_tipo = ?";

        TipoDeBanana tipo = null;

        try (Connection conn = Conexao.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idTipo);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                tipo = new TipoDeBanana();

                tipo.setIdTipoBanana(
                        rs.getInt("id_tipo"));

                tipo.setNomeTipoBanana(
                        rs.getString("nome_tipo"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao buscar tipo de banana!", e);
        }

        return tipo;
    }
}
