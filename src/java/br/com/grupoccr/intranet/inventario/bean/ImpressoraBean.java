/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupoccr.intranet.inventario.bean;

import br.com.grupoccr.intranet.inventario.dao.ImpressoraDAO;
import br.com.grupoccr.intranet.inventario.entidade.Impressora;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author notle
 */
@ManagedBean
@SessionScoped
public class ImpressoraBean extends CrudBean<Impressora, ImpressoraDAO> {

    private ImpressoraDAO impressoraDAO;

    @Override
    public ImpressoraDAO getDao() {
        if (impressoraDAO == null) {
            impressoraDAO = new ImpressoraDAO();
        }
        return impressoraDAO;
    }

    @Override
    public Impressora criarNovaEntidade() {
        return new Impressora();
    }

}
