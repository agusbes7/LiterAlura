package LiterAlura.repository;

import LiterAlura.model.Clases.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombre(String nombre);
    Optional<List<Autor>> findByFechaDeNacimientoLessThanAndFechaDeDefuncionIsnullorFechaDeDefuncionGreatherThan(Integer anio);
}