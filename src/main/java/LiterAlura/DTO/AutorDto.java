package LiterAlura.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public record AutorDto(
  Long id,
  String nombre,
  Integer FechaDeNacimiento,
  Integer FechaDeDefuncion) {
}
