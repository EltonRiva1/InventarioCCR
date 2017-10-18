/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupoccr.intranet.inventario.dao;

import br.com.grupoccr.intranet.inventario.entidade.Impressora;
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
public class ImpressoraDAO implements CrudDAO<Impressora> {

    @Override
    public void salvar(Impressora entidade) throws ErroSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if (entidade.getId() == null) {
                ps = conexao.prepareStatement("INSERT INTO `impressora` (`fila`, `ip`, `fabricante`, `modelo`, `site`, `localidade`, `toner`, `senha`, `serialNumber`) VALUES (?,?,?,?,?,?,?,?,?)");
            } else {
                ps = conexao.prepareStatement("update impressora set fila=?, ip=?, fabricante=?, modelo=?, site=?, localidade=?, toner=?, senha=?, serialNumber=? where id=?");
                ps.setInt(10, entidade.getId());
            }
            ps.setString(1, entidade.getFila());
            ps.setString(2, entidade.getIp());
            ps.setString(3, entidade.getFabricante());
            ps.setString(4, entidade.getModelo());
            ps.setString(5, entidade.getSite());
            ps.setString(6, entidade.getLocalidade());
            ps.setString(7, entidade.getToner());
            ps.setString(8, entidade.getSenha());
            ps.setString(9, entidade.getSerialNumber());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }

    @Override
    public void deletar(Impressora entidade) throws ErroSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from impressora where id=?");
            ps.setInt(1, entidade.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar a impressora!", ex);
        }
    }

    @Override
    public List<Impressora> buscar() throws ErroSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from impressora");
            ResultSet resultSet = ps.executeQuery();
            List<Impressora> impressoras = new ArrayList<>();
            while (resultSet.next()) {
                Impressora impressora = new Impressora();
                impressora.setId(resultSet.getInt("id"));
                impressora.setFila(resultSet.getString("fila"));
                impressora.setIp(resultSet.getString("ip"));
                impressora.setFabricante(resultSet.getString("fabricante"));
                impressora.setModelo(resultSet.getString("modelo"));
                impressora.setSite(resultSet.getString("site"));
                impressora.setLocalidade(resultSet.getString("localidade"));
                impressora.setToner(resultSet.getString("toner"));
                impressora.setSenha(resultSet.getString("senha"));
                impressora.setSerialNumber(resultSet.getString("serialNumber"));
                impressoras.add(impressora);
            }
            FabricaConexao.fecharConexao();
            return impressoras;
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar as impressoras!", ex);
        }
    }

}
