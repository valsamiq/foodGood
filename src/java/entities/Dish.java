package entities;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author daw2
 */
@Entity
@Table(name = "dish")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dish.findAll", query = "SELECT d FROM Dish d")
    , @NamedQuery(name = "Dish.findByName", query = "SELECT d FROM Dish d WHERE d.name = :name")
    , @NamedQuery(name = "Dish.findByType", query = "SELECT d FROM Dish d WHERE d.type = :type")
    , @NamedQuery(name = "Dish.findByPrice", query = "SELECT d FROM Dish d WHERE d.price = :price")})
public class Dish implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "type")
    private String type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @JoinColumn(name = "restaurant", referencedColumnName = "name")
    @ManyToOne(optional = false)
    private Restaurant restaurant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dish")
    private Collection<Rate> rateCollection;

    public Dish() {
    }

    public Dish(String name) {
        this.name = name;
    }

    public Dish(String name, String type, BigDecimal price, Restaurant restaurant) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.restaurant = restaurant;
    }
    

    public Dish(String name, String type, BigDecimal price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @XmlTransient
    public Collection<Rate> getRateCollection() {
        return rateCollection;
    }

    public void setRateCollection(Collection<Rate> rateCollection) {
        this.rateCollection = rateCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dish)) {
            return false;
        }
        Dish other = (Dish) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Dish[ name=" + name + " ]";
    }
}
