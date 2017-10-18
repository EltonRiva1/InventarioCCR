/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupoccr.intranet.inventario.dao;

import br.com.grupoccr.intranet.inventario.entidade.Computador;
import br.com.grupoccr.intranet.inventario.util.exception.ErroSistema;
import br.com.grupoccr.intranet.inventario.util.FabricaConexao;
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
public class ComputadorDAO implements CrudDAO<Computador> {

    @Override
    public void salvar(Computador computador) throws ErroSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if (computador.getId() == null) {
                ps = conexao.prepareStatement("INSERT INTO `computador` (`fabricante`, `modelo`, `hostName`, `serialNumber`, `bp`, `site`, `localidade`, `usuario`, `chapa`, `ramal`) VALUES (?,?,?,?,?,?,?,?,?,?)");
            } else {
                ps = conexao.prepareStatement("update computador set fabricante=?, modelo=?, hostName=?, serialNumber=?, bp=?, site=?, localidade=?, usuario=?, chapa=?, ramal=? where id=?");
                ps.setInt(11, computador.getId());
            }
            ps.setString(1, computador.getFabricante());
            ps.setString(2, computador.getModelo());
            ps.setString(3, computador.getHostName());
            ps.setString(4, computador.getSerialNumber());
            ps.setInt(5, computador.getBp());
            ps.setString(6, computador.getSite());
            ps.setString(7, computador.getLocalidade());
            ps.setString(8, computador.getUsuario());
            ps.setString(9, computador.getChapa());
            ps.setString(10, computador.getRamal());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }

    @Override
    public void deletar(Computador computador) throws ErroSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from computador where id=?");
            ps.setInt(1, computador.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o computador!", ex);
        }
    }

    @Override
    public List<Computador> buscar() throws ErroSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from computador");
            ResultSet resultSet = ps.executeQuery();
            List<Computador> computadores = new ArrayList<>();
            while (resultSet.next()) {
                Computador computador = new Computador();
                computador.setId(resultSet.getInt("id"));
                computador.setFabricante(resultSet.getString("fabricante"));
                computador.setModelo(resultSet.getString("modelo"));
                computador.setHostName(resultSet.getString("hostName"));
                computador.setSerialNumber(resultSet.getString("serialNumber"));
                computador.setBp(resultSet.getInt("bp"));
                computador.setSite(resultSet.getString("site"));
                computador.setLocalidade(resultSet.getString("localidade"));
                computador.setUsuario(resultSet.getString("usuario"));
                computador.setChapa(resultSet.getString("chapa"));
                computador.setRamal(resultSet.getString("ramal"));
                computadores.add(computador);
            }
            FabricaConexao.fecharConexao();
            return computadores;
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar os computadores!", ex);
        }
    }

}
