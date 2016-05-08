/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package validacion;

import modelo.Cliente;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author odeen
 */
public class AgregarClienteValidacion implements Validator{

    public boolean supports(Class clazz) {
        return Cliente.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        Cliente cliente = (Cliente) target; // por si hay que verificar un valor recibido.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "requerido.nombre");
        if(cliente.getNombre().equals("PEPE")){
            errors.rejectValue("nombre", "pepe.prohibido");
        }
    }

}
