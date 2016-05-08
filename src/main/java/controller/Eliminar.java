/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.List;
import modelo.Cliente;
import modelo.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author odeen
 */
@Controller
public class Eliminar {
    /* Usamos la autoconexión para enlazar con la base de datos. */
    @Autowired
    private DAO dao;
    /*
    @ModelAttribute("clientes")
    public List<Cliente> buscarTodosLosClientes() {
        return dao.buscarTodosClientes();
    }
    */
    @RequestMapping(value="/eliminar.do",method=RequestMethod.GET)
    public String eliminar(@RequestParam("id") Integer id,ModelMap modelo){
        dao.borrar(dao.buscarClientePorId(id));
        modelo.addAttribute("clientes",dao.buscarTodosClientes());
        return "home";
    }


    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }

}
