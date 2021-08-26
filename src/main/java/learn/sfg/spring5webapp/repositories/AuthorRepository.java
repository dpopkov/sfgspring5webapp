package learn.sfg.spring5webapp.repositories;

import learn.sfg.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
