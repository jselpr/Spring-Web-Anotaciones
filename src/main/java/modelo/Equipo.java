/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author odeen
 */
@Entity
@Table(name = "Equipo", catalog = "test", schema = "")
@NamedQueries({ 
                @NamedQuery(name="Equipo.existeNombre",query="select count(reg) from Equipo reg JOIN reg.cliente c where c.id=:id and reg.nombre=:nombre"),
                @NamedQuery(name="Equipo.todos",query="select reg from Equipo reg JOIN reg.cliente c where c.id=:id"),
                @NamedQuery(name="Equipo.todosCount",query="select count(reg) from Equipo reg JOIN reg.cliente c where c.id=:id"),

                @NamedQuery(name="Equipo.findByMacAndBios",query="select reg from Equipo reg where reg.mac=:mac and reg.bios=:bios")
                })
public class Equipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Column(name = "ipFija", nullable = false)
    private boolean ipFija;
    @Column(name = "ip", nullable = false, length = 20)
    private String ip;
    @Column(name = "ultimaIp", nullable = false, length = 20)
    private String ultimaIp;
    @Column(name = "ultimaConexion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaConexion;
    @Column(name = "mac", nullable = false, length = 255)
    private String mac;
    @Column(name = "bios", nullable = false, length = 255)
    private String bios;
    @JoinColumn(name = "idCliente", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    

    public Equipo() {
    }

    public Equipo(Integer id) {
        this.id = id;
    }

    public Equipo(Integer id, String nombre, boolean ipFija, String ip, String ultimaIp, String mac) {
        this.id = id;
        this.nombre = nombre;
        this.ipFija = ipFija;
        this.ip = ip;
        this.ultimaIp = ultimaIp;
        this.mac = mac;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getIpFija() {
        return ipFija;
    }

    public void setIpFija(boolean ipFija) {
        this.ipFija = ipFija;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUltimaIp() {
        return ultimaIp;
    }

    public void setUltimaIp(String ultimaIp) {
        this.ultimaIp = ultimaIp;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getBios() {
        return bios;
    }

    public void setBios(String bios) {
        this.bios = bios;
    }

    public Date getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(Date ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servidor.logica.Equipo[id=" + id + "]";
    }

}
