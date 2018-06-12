/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daw2
 */
@Entity
@Table(name = "rate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rate.findAll", query = "SELECT r FROM Rate r")
    , @NamedQuery(name = "Rate.findByIdrate", query = "SELECT r FROM Rate r WHERE r.idrate = :idrate")
    , @NamedQuery(name = "Rate.findByDate", query = "SELECT r FROM Rate r WHERE r.date = :date")
    , @NamedQuery(name = "Rate.findByMark", query = "SELECT r FROM Rate r WHERE r.mark = :mark")
    , @NamedQuery(name = "Rate.findByComment", query = "SELECT r FROM Rate r WHERE r.comment = :comment")})
public class Rate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrate")
    private Integer idrate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mark")
    private int mark;
    @Size(max = 255)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "user", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "dish", referencedColumnName = "name")
    @ManyToOne(optional = false)
    private Dish dish;

    public Rate() {
    }

    public Rate(Integer idrate) {
        this.idrate = idrate;
    }

    public Rate(Integer idrate, Date date, int mark) {
        this.idrate = idrate;
        this.date = date;
        this.mark = mark;
    }

    public Integer getIdrate() {
        return idrate;
    }

    public void setIdrate(Integer idrate) {
        this.idrate = idrate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrate != null ? idrate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rate)) {
            return false;
        }
        Rate other = (Rate) object;
        if ((this.idrate == null && other.idrate != null) || (this.idrate != null && !this.idrate.equals(other.idrate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Rate[ idrate=" + idrate + " ]";
    }
    
}
