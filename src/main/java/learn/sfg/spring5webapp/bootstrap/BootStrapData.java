package learn.sfg.spring5webapp.bootstrap;

import learn.sfg.spring5webapp.domain.Author;
import learn.sfg.spring5webapp.domain.Book;
import learn.sfg.spring5webapp.domain.Publisher;
import learn.sfg.spring5webapp.repositories.AuthorRepository;
import learn.sfg.spring5webapp.repositories.BookRepository;
import learn.sfg.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {
        Publisher martin = new Publisher("George Martin");
        publisherRepository.save(martin);

        Author john = new Author("John", "Snow");
        Book winter = new Book("Winter is coming", "1234567");
        john.getBooks().add(winter);
        martin.getBooks().add(winter);
        winter.setPublisher(martin);
        winter.getAuthors().add(john);
        authorRepository.save(john);
        bookRepository.save(winter);
        publisherRepository.save(martin);

        Author holden = new Author("James", "Holden");
        Book expanse = new Book("Expanse", "7654321");
        holden.getBooks().add(expanse);
        expanse.getAuthors().add(holden);
        martin.getBooks().add(expanse);
        expanse.setPublisher(martin);
        authorRepository.save(holden);
        bookRepository.save(expanse);
        publisherRepository.save(martin);

        System.out.println("Started in BootStrapData");
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
    }
}
