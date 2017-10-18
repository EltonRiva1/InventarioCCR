/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupoccr.intranet.inventario.dao;

import br.com.grupoccr.intranet.inventario.util.exception.ErroSistema;
import java.util.List;

/**
 *
 * @author notle
 */
public interface CrudDAO<E> {

    public void salvar(E entidade) throws ErroSistema;

    public void deletar(E entidade) throws ErroSistema;

    public List<E> buscar() throws ErroSistema;

}
