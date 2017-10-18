/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupoccr.intranet.inventario.bean;

import br.com.grupoccr.intranet.inventario.dao.NotebookDAO;
import br.com.grupoccr.intranet.inventario.entidade.Notebook;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author notle
 */
@ManagedBean
@SessionScoped
public class NotebookBean extends CrudBean<Notebook, NotebookDAO> {

    private NotebookDAO notebookDAO;

    @Override
    public NotebookDAO getDao() {
        if (notebookDAO == null) {
            notebookDAO = new NotebookDAO();
        }
        return notebookDAO;
    }

    @Override
    public Notebook criarNovaEntidade() {
        return new Notebook();
    }

}
