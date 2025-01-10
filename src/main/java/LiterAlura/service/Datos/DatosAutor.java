package LiterAlura.service.Datos;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        @JsonAlias("birth_year") Integer Nacimiento,
 @JsonAlias("name") String nombre,
 @JsonAlias("death_year") Integer Defuncion) {
}
