package gfg.org.MinorProject1.Digital.Library.repository;

import gfg.org.MinorProject1.Digital.Library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author findByEmail(String authorEmail);
}
