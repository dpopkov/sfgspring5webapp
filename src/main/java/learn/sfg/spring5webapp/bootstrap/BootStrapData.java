package learn.sfg.spring5webapp.bootstrap;

import learn.sfg.spring5webapp.domain.Author;
import learn.sfg.spring5webapp.domain.Book;
import learn.sfg.spring5webapp.repositories.AuthorRepository;
import learn.sfg.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        Author john = new Author("John", "Snow");
        Book winter = new Book("Winter is coming", "1234567");
        john.getBooks().add(winter);
        winter.getAuthors().add(john);
        authorRepository.save(john);
        bookRepository.save(winter);

        Author holden = new Author("James", "Holden");
        Book expanse = new Book("Expanse", "7654321");
        holden.getBooks().add(expanse);
        expanse.getAuthors().add(holden);
        authorRepository.save(holden);
        bookRepository.save(expanse);

        System.out.println("Started in BootStrapData");
        System.out.println("Number of books: " + bookRepository.count());
    }
}
