/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author odeen
 */

@Transactional(propagation=Propagation.REQUIRED)
public class DAOImpl extends JpaDaoSupport implements DAO {

    public void insertar(Object objeto) {
        this.getJpaTemplate().persist(objeto);
    }

    public void actualizar(Object objeto) {
        objeto = this.getJpaTemplate().merge(objeto);
        this.getJpaTemplate().persist(objeto);
    }

    public void borrar(Object objeto) {
        objeto = this.getJpaTemplate().merge(objeto);
        this.getJpaTemplate().remove(objeto);
    }

    public Cliente buscarClientePorId(int id) {
        return this.getJpaTemplate().find(Cliente.class, id);
    }

    public List<Cliente> buscarTodosClientes() {
        Map parametros = new HashMap();
        return this.getJpaTemplate().findByNamedQueryAndNamedParams("Cliente.todos", parametros);
    }
    
}
