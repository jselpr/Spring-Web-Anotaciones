/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modelo.Cliente;
import modelo.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author odeen
 */
@Controller
public class Home {
    /* Usamos la autoconexión para enlazar con la base de datos. */
    @Autowired
    private DAO dao;

    @ModelAttribute("clientes")
    public List<Cliente> buscarTodosLosClientes() {
        return dao.buscarTodosClientes();
    }

    @RequestMapping(value="/home.do")
    public String home(ModelMap modelo,HttpServletRequest request,String edad){
        /*
         * Usando el estilo clásico deberíamos de hacer:
            List<Cliente> clientes = dao.buscarTodosClientes();
            modelo.put("clientes", clientes);
         * para que en la vista home la variable "clientes" tenga valor, pero
         * usando @ModelAttribute hacemos que cuando le haga falta "clientes" el
         * sólo invocará el método "buscarTodosLosClientes" de esta clase.
         */
        return "home";
    }



    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }

}
