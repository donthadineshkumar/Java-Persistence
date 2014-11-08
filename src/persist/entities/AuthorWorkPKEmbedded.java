
package persist.entities;

import java.math.BigInteger;
import javax.persistence.Embeddable;

@Embeddable
public class AuthorWorkPKEmbedded {
    
    private BigInteger bookId;
    private BigInteger authorId;

    public AuthorWorkPKEmbedded() {
    }

    public AuthorWorkPKEmbedded(BigInteger bookId, BigInteger authorId) {
        this.bookId = bookId;
        this.authorId = authorId;
    }


    public BigInteger getBookId() {
        return bookId;
    }

    public void setBookId(BigInteger bookId) {
        this.bookId = bookId;
    }

    public BigInteger getAuthorId() {
        return authorId;
    }

    public void setAuthorId(BigInteger authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthorWorkEmbedded)) {
            return false;
        }
        if(obj == null){
            return false;
        }
        AuthorWorkEmbedded pk =(AuthorWorkEmbedded) obj;
        return ( (bookId == ((AuthorWorkPKEmbedded) obj).getBookId()) && 
                      (authorId == ((AuthorWorkPKEmbedded) obj).getAuthorId())  );
        
    }

    @Override
    public int hashCode() {
        return bookId.hashCode() + authorId.hashCode();
    }
    
    
    
    
}
