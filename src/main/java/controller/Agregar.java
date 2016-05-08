/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import modelo.Cliente;
import modelo.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author odeen
 */
@Controller
public class Agregar {
    /* Usamos la autoconexión para enlazar con la base de datos. */
    @Autowired
    private DAO dao;
    /* crea el valor para el atributo llamado "cliente" que se propagará a la vista */
    @ModelAttribute("cliente")
    public Cliente crearClienteVacio() {
        Cliente cliente = new Cliente();
        return cliente;
    }
    
    /* crea el valor para el atributo llamado "clientesTipicos" que se propagará a la vista */
    @ModelAttribute("clientesTipicos")
    public List<String> buscarClientesTipicos() {
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Jose");
        lista.add("Luis");
        lista.add("Paco");
        return lista;
    }
    
    



    public DAO getDao() {
        return dao;
    }

    public void setDao(DAO dao) {
        this.dao = dao;
    }

}
