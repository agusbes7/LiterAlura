package LiterAlura.repository;

import LiterAlura.model.Clases.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroGutendex  extends JpaRepository<Libro,Long> {
}
