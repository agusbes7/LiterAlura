package LiterAlura.service.Datos;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosGutendex(
        @JsonAlias("results") List<DatosLibro> Resultados){
    public List<DatosLibro> Resultados() {
        return Resultados;
    }
}