/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupoccr.intranet.inventario.dao;

import br.com.grupoccr.intranet.inventario.entidade.Notebook;
import br.com.grupoccr.intranet.inventario.util.FabricaConexao;
import br.com.grupoccr.intranet.inventario.util.exception.ErroSistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notle
 */
public class NotebookDAO implements CrudDAO<Notebook> {

    @Override
    public void salvar(Notebook notebook) throws ErroSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if (notebook.getId() == null) {
                ps = conexao.prepareStatement("INSERT INTO `notebook` (`fabricante`, `modelo`, `hostName`, `serialNumber`, `bp`, `site`, `localidade`, `usuario`, `chapa`, `ramal`) VALUES (?,?,?,?,?,?,?,?,?,?)");
            } else {
                ps = conexao.prepareStatement("update notebook set fabricante=?, modelo=?, hostName=?, serialNumber=?, bp=?, site=?, localidade=?, usuario=?, chapa=?, ramal=? where id=?");
                ps.setInt(11, notebook.getId());
            }
            ps.setString(1, notebook.getFabricante());
            ps.setString(2, notebook.getModelo());
            ps.setString(3, notebook.getHostName());
            ps.setString(4, notebook.getSerialNumber());
            ps.setInt(5, notebook.getBp());
            ps.setString(6, notebook.getSite());
            ps.setString(7, notebook.getLocalidade());
            ps.setString(8, notebook.getUsuario());
            ps.setString(9, notebook.getChapa());
            ps.setString(10, notebook.getRamal());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }

    @Override
    public void deletar(Notebook notebook) throws ErroSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from notebook where id=?");
            ps.setInt(1, notebook.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o notebook!", ex);
        }
    }

    @Override
    public List<Notebook> buscar() throws ErroSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from notebook");
            ResultSet resultSet = ps.executeQuery();
            List<Notebook> notebooks = new ArrayList<>();
            while (resultSet.next()) {
                Notebook notebook = new Notebook();
                notebook.setId(resultSet.getInt("id"));
                notebook.setFabricante(resultSet.getString("fabricante"));
                notebook.setModelo(resultSet.getString("modelo"));
                notebook.setHostName(resultSet.getString("hostName"));
                notebook.setSerialNumber(resultSet.getString("serialNumber"));
                notebook.setBp(resultSet.getInt("bp"));
                notebook.setSite(resultSet.getString("site"));
                notebook.setLocalidade(resultSet.getString("localidade"));
                notebook.setUsuario(resultSet.getString("usuario"));
                notebook.setChapa(resultSet.getString("chapa"));
                notebook.setRamal(resultSet.getString("ramal"));
                notebooks.add(notebook);
            }
            FabricaConexao.fecharConexao();
            return notebooks;
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar os notebooks!", ex);
        }
    }

}
