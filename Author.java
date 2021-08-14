package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


import javax.persistence.*;

@Entity 
public class Author {

 private String firstName;
 private String lastName;
 
 @ManyToMany (mappedBy = "authors")
 private  Set<Book> books = new HashSet<>();
 
 
 @Override
public int hashCode() {
	return id !=0 ? id.hashCode() : 0;
}
  
@Override
public boolean equals(Object obj) {
	if (this == obj) {
		return true;
	}
	
	if ( obj == null || getClass() != obj.getClass()) return false;
	
	Author author = (Author) obj;
	return id != null ? id.equals(author.id) : author.id == null; 
}

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}


 
 
public Author() {
	
}

public Author(String firstName, String lastName) {
	
	this.firstName = firstName;
	this.lastName = lastName;

}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public Set<Book> getBooks() {
	return books;
}





public void setBooks(Set<Book> books) {
	this.books = books;
}

@Override
public String toString() {
	return "Author [" + (id != null ? "id=" + id + ", " : "")
			+ (firstName != null ? "firstName=" + firstName + ", " : "")
			+ (lastName != null ? "lastName=" + lastName + ", " : "") + (books != null ? "books=" + books : "") + "]";
}
 
 
 
 
}
