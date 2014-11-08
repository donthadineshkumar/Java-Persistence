/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persist.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dinesh
 */
@Entity
@Table(name = "BOOK_AUTHOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookAuthor.findAll", query = "SELECT b FROM BookAuthor b"),
    @NamedQuery(name = "BookAuthor.findByBookAuthorId", query = "SELECT b FROM BookAuthor b WHERE b.bookAuthorId = :bookAuthorId"),
    @NamedQuery(name = "BookAuthor.findByLastName", query = "SELECT b FROM BookAuthor b WHERE b.lastName = :lastName"),
    @NamedQuery(name = "BookAuthor.findByFirstName", query = "SELECT b FROM BookAuthor b WHERE b.firstName = :firstName")})
public class BookAuthor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BOOK_AUTHOR_ID")
    private Integer bookAuthorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "BIO")
    private String bio;

    public BookAuthor() {
    }

    public BookAuthor(Integer bookAuthorId) {
        this.bookAuthorId = bookAuthorId;
    }

    public BookAuthor(Integer bookAuthorId, String lastName, String firstName) {
        this.bookAuthorId = bookAuthorId;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Integer getBookAuthorId() {
        return bookAuthorId;
    }

    public void setBookAuthorId(Integer bookAuthorId) {
        this.bookAuthorId = bookAuthorId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookAuthorId != null ? bookAuthorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookAuthor)) {
            return false;
        }
        BookAuthor other = (BookAuthor) object;
        if ((this.bookAuthorId == null && other.bookAuthorId != null) || (this.bookAuthorId != null && !this.bookAuthorId.equals(other.bookAuthorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persist.entities.BookAuthor[ bookAuthorId=" + bookAuthorId + " ]";
    }
    
}
