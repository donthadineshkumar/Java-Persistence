
package persist.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "AUTHOR")
public class Author implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "author_s_generator", sequenceName = "author_s", 
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
            generator = "author_s_generator")
    @NotNull
    private Integer id;
    
    @Size(max = 30)
    @Column(name = "AUTHOR_NAME")
    private String name;
    
    @Lob
    @Column(name = "DESCRIPTION")
    private String bio;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTHOR_DETAIL_ID", referencedColumnName = "ID")
    private AuthorDetail authorDetail;

    public Author() {
    }

    public Author(Integer id) {
        this.id = id;
    }

    public Author( String name, String bio, AuthorDetail authorDetail) {
        this.name = name;
        this.bio = bio;
        this.authorDetail = authorDetail;
    }

    
    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public AuthorDetail getAuthorDetail() {
        return authorDetail;
    }

    public void setAuthorDetail(AuthorDetail authorDetail) {
        this.authorDetail = authorDetail;
    }

      @Override
    public int  hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
