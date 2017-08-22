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
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntityProductos.findAll", query = "SELECT e FROM EntityProductos e"),
    @NamedQuery(name = "EntityProductos.findByIdProd", query = "SELECT e FROM EntityProductos e WHERE e.idProd = :idProd"),
    @NamedQuery(name = "EntityProductos.findByCodProd", query = "SELECT e FROM EntityProductos e WHERE e.codProd = :codProd"),
    @NamedQuery(name = "EntityProductos.findByNomProd", query = "SELECT e FROM EntityProductos e WHERE e.nomProd = :nomProd"),
    @NamedQuery(name = "EntityProductos.findByPrecProd", query = "SELECT e FROM EntityProductos e WHERE e.precProd = :precProd"),
    @NamedQuery(name = "EntityProductos.findByDesProd", query = "SELECT e FROM EntityProductos e WHERE e.desProd = :desProd"),
    @NamedQuery(name = "EntityProductos.findByCantProd", query = "SELECT e FROM EntityProductos e WHERE e.cantProd = :cantProd")})
public class EntityProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prod")
    private Integer idProd;
    @Basic(optional = false)
    @Column(name = "cod_prod")
    private String codProd;
    @Basic(optional = false)
    @Column(name = "nom_prod")
    private String nomProd;
    @Column(name = "prec_prod")
    private Integer precProd;
    @Basic(optional = false)
    @Column(name = "des_prod")
    private String desProd;
    @Basic(optional = false)
    @Column(name = "cant_prod")
    private int cantProd;

    public EntityProductos() {
    }

    public EntityProductos(Integer idProd) {
        this.idProd = idProd;
    }

    public EntityProductos(Integer idProd, String codProd, String nomProd, String desProd, int cantProd) {
        this.idProd = idProd;
        this.codProd = codProd;
        this.nomProd = nomProd;
        this.desProd = desProd;
        this.cantProd = cantProd;
    }

    public Integer getIdProd() {
        return idProd;
    }

    public void setIdProd(Integer idProd) {
        this.idProd = idProd;
    }

    public String getCodProd() {
        return codProd;
    }

    public void setCodProd(String codProd) {
        this.codProd = codProd;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public Integer getPrecProd() {
        return precProd;
    }

    public void setPrecProd(Integer precProd) {
        this.precProd = precProd;
    }

    public String getDesProd() {
        return desProd;
    }

    public void setDesProd(String desProd) {
        this.desProd = desProd;
    }

    public int getCantProd() {
        return cantProd;
    }

    public void setCantProd(int cantProd) {
        this.cantProd = cantProd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProd != null ? idProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityProductos)) {
            return false;
        }
        EntityProductos other = (EntityProductos) object;
        if ((this.idProd == null && other.idProd != null) || (this.idProd != null && !this.idProd.equals(other.idProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EntityProductos[ idProd=" + idProd + " ]";
    }
    
}
