/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupoccr.intranet.inventario.bean;

import br.com.grupoccr.intranet.inventario.dao.ComputadorDAO;
import br.com.grupoccr.intranet.inventario.entidade.Computador;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author notle
 */
@ManagedBean
@SessionScoped
public class ComputadorBean extends CrudBean<Computador, ComputadorDAO> {

    private ComputadorDAO computadorDAO;

    @Override
    public ComputadorDAO getDao() {
        if (computadorDAO == null) {
            computadorDAO = new ComputadorDAO();
        }
        return computadorDAO;
    }

    @Override
    public Computador criarNovaEntidade() {
        return new Computador();
    }

}
