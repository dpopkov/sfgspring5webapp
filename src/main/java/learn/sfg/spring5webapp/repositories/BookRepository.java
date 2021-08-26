package learn.sfg.spring5webapp.repositories;

import learn.sfg.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
