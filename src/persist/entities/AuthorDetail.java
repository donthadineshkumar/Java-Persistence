
package persist.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "AUTHOR_DETAIL")
public class AuthorDetail  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "author_detail_s_generator", 
             sequenceName = "author_detail_s",
             initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "author_detail_s_generator")
    @NotNull
    @Column(name = "ID")
    private Integer id;
    
    @Size(max = 200)
    @Column(name = "ADDR_1")
    private String Address1;
    
    @Size(max = 200)
    @Column(name = "ADDR_2")
    private String Address2;

    @Size(max = 2)
    @Column(name = "STATE")
    private String state;
    
    @Size(max = 10)
    @Column(name = "CITY")
    private String city;
        
   @Size(max = 10)
   @Column(name = "ZIPCODE")
    private String zipcode;

    public AuthorDetail() {
    }

    public AuthorDetail(String Address1, String Address2, String state, String city, String zipcode) {
        this.Address1 = Address1;
        this.Address2 = Address2;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
    }

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress1() {
        return Address1;
    }

    public void setAddress1(String Address1) {
        this.Address1 = Address1;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String Address2) {
        this.Address2 = Address2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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
        if (!(object instanceof AuthorDetail)) {
            return false;
        }
        AuthorDetail other = (AuthorDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    
}
