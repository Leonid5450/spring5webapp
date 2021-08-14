/**
 * 
 * 
 */

package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity

public class Book {
	


private String title;
private String isdn;
@ManyToMany
@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id"))
private Set<Author> authors = new HashSet<>();

public Book() {};

public Book ( String title ,  String isdn )
{
	this.title = title;
	this.isdn = isdn;
	
	
}

@Id
@GeneratedValue (strategy = GenerationType.AUTO)
private Long id;	 

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getIsdn() {
	return isdn;
}

public void setIsdn(String isdn) {
	this.isdn = isdn;
}

public Set<Author> getAuthors() {
	return authors;
}

public void setAuthors(Set<Author> authors) {
	this.authors = authors;
}

@Override
public int hashCode() {
	return id !=0 ? id.hashCode() : 0;
}

@Override
public String toString() {
	return "Book [" + (id != null ? "id=" + id + ", " : "") + (title != null ? "title=" + title + ", " : "")
			+ (isdn != null ? "isdn=" + isdn + ", " : "") + (authors != null ? "authors=" + authors : "") + "]";
}

@Override
public boolean equals(Object obj) {
	if (this == obj) {
		return true;
	}
	if (!(obj instanceof Book)) {
		return false;
	}
	Book other = (Book) obj;
	return Objects.equals(id, other.id);
}
	



}
