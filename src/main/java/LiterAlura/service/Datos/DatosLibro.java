package LiterAlura.service.Datos;
import LiterAlura.service.Clases.Autor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
     //   @JsonAlias("id") Integer id,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors")Autor autor,
        @JsonAlias("download_count") Integer descargas,
        @JsonAlias("languajes") String idioma) {
}
