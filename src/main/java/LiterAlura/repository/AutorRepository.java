package LiterAlura.repository;

import LiterAlura.model.Clases.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombre(String nombre);

    @Query(value = "SELECT * FROM autores WHERE fecha_de_nacimiento <= :fechaConsulta AND" +
            " (fecha_de_defuncion IS NULL OR fecha_de_defuncion > :fechaConsulta);",nativeQuery = true)
   Optional<List<Autor>>AutoresVivos(Integer fechaConsulta);
}