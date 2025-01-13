package LiterAlura.DTO;

import LiterAlura.model.Clases.Autor;
import LiterAlura.model.Idioma;

public record LibroDto(
         Long id,
        String titulo,
        Autor autoria,
        Idioma lenguaje,
        Integer Descargas) {
}
