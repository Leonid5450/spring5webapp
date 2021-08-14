package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;


@Component 
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository   bookRepository;
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Started in BootStrap0");	
	Author eric = new Author("Eric", "Ziskind");
	System.out.println(eric.toString());
	System.out.print("Received Author" + eric.getId());
	Book b_musk = new Book("Three Mushketers",  "UBS-766444");
	
	System.out.println(b_musk.toString());
	
	eric.getBooks().add(b_musk);
	b_musk.getAuthors().add(eric);
	authorRepository.save(eric);
	bookRepository.save(b_musk);
	
	System.out.println("Started in BootStrap");
	System.out.println("Number of books " + bookRepository.count());
	}

}
