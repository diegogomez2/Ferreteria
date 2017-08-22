/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntityUsuarios.findAll", query = "SELECT e FROM EntityUsuarios e"),
    @NamedQuery(name = "EntityUsuarios.findByIdUser", query = "SELECT e FROM EntityUsuarios e WHERE e.idUser = :idUser"),
    @NamedQuery(name = "EntityUsuarios.findByPassUser", query = "SELECT e FROM EntityUsuarios e WHERE e.passUser = :passUser"),
    @NamedQuery(name = "EntityUsuarios.findByNameUser", query = "SELECT e FROM EntityUsuarios e WHERE e.nameUser = :nameUser")})
public class EntityUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Integer idUser;
    @Column(name = "pass_user")
    private String passUser;
    @Column(name = "name_user")
    private String nameUser;

    public EntityUsuarios() {
    }

    public EntityUsuarios(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityUsuarios)) {
            return false;
        }
        EntityUsuarios other = (EntityUsuarios) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EntityUsuarios[ idUser=" + idUser + " ]";
    }
    
}
