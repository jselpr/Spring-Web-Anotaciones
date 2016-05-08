/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import modelo.Cliente;
import modelo.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author odeen
 */
@Controller
public class Editar {
    /* Usamos la autoconexión para enlazar con la base de datos. */
    @Autowired
    private DAO dao;

    @RequestMapping(value="/editar.do",method=RequestMethod.GET)
    public String rellenarFormulario(@RequestParam("id") Integer id,ModelMap modelo){
        modelo.addAttribute("cliente",dao.buscarClientePorId(id));
        return "editarCliente";
    }
    @RequestMapping(value="/editar.do",method=RequestMethod.POST)
    public String procesarFormulario(Cliente cliente){
        dao.actualizar(cliente);
        return "clienteEditado";
    }



    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }

}
