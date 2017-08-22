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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntityClientes.findAll", query = "SELECT e FROM EntityClientes e"),
    @NamedQuery(name = "EntityClientes.findByRutCli", query = "SELECT e FROM EntityClientes e WHERE e.rutCli = :rutCli"),
    @NamedQuery(name = "EntityClientes.findByDigCli", query = "SELECT e FROM EntityClientes e WHERE e.digCli = :digCli"),
    @NamedQuery(name = "EntityClientes.findByRazCli", query = "SELECT e FROM EntityClientes e WHERE e.razCli = :razCli"),
    @NamedQuery(name = "EntityClientes.findByGirCli", query = "SELECT e FROM EntityClientes e WHERE e.girCli = :girCli"),
    @NamedQuery(name = "EntityClientes.findByTelCli", query = "SELECT e FROM EntityClientes e WHERE e.telCli = :telCli"),
    @NamedQuery(name = "EntityClientes.findByCelCli", query = "SELECT e FROM EntityClientes e WHERE e.celCli = :celCli"),
    @NamedQuery(name = "EntityClientes.findByDirCli", query = "SELECT e FROM EntityClientes e WHERE e.dirCli = :dirCli"),
    @NamedQuery(name = "EntityClientes.findByRegCli", query = "SELECT e FROM EntityClientes e WHERE e.regCli = :regCli"),
    @NamedQuery(name = "EntityClientes.findByCiuCli", query = "SELECT e FROM EntityClientes e WHERE e.ciuCli = :ciuCli"),
    @NamedQuery(name = "EntityClientes.findByComCli", query = "SELECT e FROM EntityClientes e WHERE e.comCli = :comCli")})
public class EntityClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rut_cli")
    private Integer rutCli;
    @Basic(optional = false)
    @Column(name = "dig_cli")
    private Character digCli;
    @Basic(optional = false)
    @Column(name = "raz_cli")
    private String razCli;
    @Basic(optional = false)
    @Column(name = "gir_cli")
    private String girCli;
    @Basic(optional = false)
    @Column(name = "tel_cli")
    private String telCli;
    @Basic(optional = false)
    @Column(name = "cel_cli")
    private String celCli;
    @Basic(optional = false)
    @Column(name = "dir_cli")
    private String dirCli;
    @Basic(optional = false)
    @Column(name = "reg_cli")
    private String regCli;
    @Basic(optional = false)
    @Column(name = "ciu_cli")
    private String ciuCli;
    @Basic(optional = false)
    @Column(name = "com_cli")
    private String comCli;
    @Transient
    private String rutDigCli;
    
    public EntityClientes() {
    }

    public EntityClientes(Integer rutCli) {
        this.rutCli = rutCli;
    }

    public EntityClientes(Integer rutCli, Character digCli, String razCli, String girCli, String telCli, String celCli, String dirCli, String regCli, String ciuCli, String comCli) {
        this.rutCli = rutCli;
        this.digCli = digCli;
        this.razCli = razCli;
        this.girCli = girCli;
        this.telCli = telCli;
        this.celCli = celCli;
        this.dirCli = dirCli;
        this.regCli = regCli;
        this.ciuCli = ciuCli;
        this.comCli = comCli;
    }

    public Integer getRutCli() {
        return rutCli;
    }

    public void setRutCli(Integer rutCli) {
        this.rutCli = rutCli;
    }

    public Character getDigCli() {
        return digCli;
    }

    public void setDigCli(Character digCli) {
        this.digCli = digCli;
    }

    public String getRazCli() {
        return razCli;
    }

    public void setRazCli(String razCli) {
        this.razCli = razCli;
    }

    public String getGirCli() {
        return girCli;
    }

    public void setGirCli(String girCli) {
        this.girCli = girCli;
    }

    public String getTelCli() {
        return telCli;
    }

    public void setTelCli(String telCli) {
        this.telCli = telCli;
    }

    public String getCelCli() {
        return celCli;
    }

    public void setCelCli(String celCli) {
        this.celCli = celCli;
    }

    public String getDirCli() {
        return dirCli;
    }

    public void setDirCli(String dirCli) {
        this.dirCli = dirCli;
    }

    public String getRegCli() {
        return regCli;
    }

    public void setRegCli(String regCli) {
        this.regCli = regCli;
    }

    public String getCiuCli() {
        return ciuCli;
    }

    public void setCiuCli(String ciuCli) {
        this.ciuCli = ciuCli;
    }

    public String getComCli() {
        return comCli;
    }

    public void setComCli(String comCli) {
        this.comCli = comCli;
    }
    @Transient
    @Id
    public String getRutDigCli(){
        return rutDigCli;
    }
    
    @PostLoad
    public void setRutDigCli(){
        this.rutDigCli = rutCli.toString() + "-" + digCli.toString();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutCli != null ? rutCli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntityClientes)) {
            return false;
        }
        EntityClientes other = (EntityClientes) object;
        if ((this.rutCli == null && other.rutCli != null) || (this.rutCli != null && !this.rutCli.equals(other.rutCli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EntityClientes[ rutCli=" + rutCli + " ]";
    }
    
}
