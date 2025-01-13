package LiterAlura.repository;

import LiterAlura.model.Clases.Libro;
import LiterAlura.model.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    Optional<Libro> findBytitulo(String titulo);
Optional<List<Libro>> findBylenguaje(Idioma lenguaje);


}