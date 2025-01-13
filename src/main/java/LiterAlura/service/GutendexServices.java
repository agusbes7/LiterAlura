package LiterAlura.service;

import LiterAlura.service.API.ConsumoAPI;
import LiterAlura.service.API.ConvierteDatos;
import LiterAlura.model.Datos.DatosAutor;
import LiterAlura.model.Datos.DatosLibro;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class GutendexServices {
    private ConsumoAPI api = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private ObjectMapper mapeo = new ObjectMapper();
//.split(",")[0].trim-->para trabajar con arreglos de strings

/*    public Optional<DatosLibro> filtrarxTitulo(String url) {
        Optional<String> datos = api.obtenerDatos(url);
        if (datos.isPresent()) {
            try {
                JsonNode data = mapeo.readTree(datos.get());
                JsonNode resultado = data.get("results").get(0);
                System.out.println(resultado);
                if(resultado != null){
//Dado que el record no posee listas y no deseo hacerlo asi trabajamos es parte aca

JsonNode resultadosAutores=resultado.get("authors").get(0);
JsonNode resultadosIdioma=resultado.get("languages").get(0);
                    System.out.println("resultAutores"+ resultadosAutores);
                    System.out.println("resultIdioma"+ resultadosIdioma);
                     if(resultadosAutores!= null && resultadosIdioma!=null){
     DatosAutor aux=mapeo.treeToValue(resultadosAutores, DatosAutor.class);

       DatosLibro libro=new DatosLibro(resultado.get(0).asInt(), //id
                            resultado.get(1).toString(), //title
                            aux, //Datos autor
                           resultado.get(10).asInt(), //elemento correspondiente a las descargas
               resultadosIdioma.toString());
                return  Optional.of(libro);}
                }
                return Optional.empty();

                }catch (Exception e){
                    System.out.println("lo siento fallo el proceso de extraccion de datos "+ e.getMessage());}
           }


            return Optional.empty();
    }*/
public Optional<DatosLibro> filtrarxTitulo(String url) {
    Optional<String> datos = api.obtenerDatos(url);

    if (datos.isPresent()) {
        try {
            // Leer el JSON completo
            JsonNode data = mapeo.readTree(datos.get());
            JsonNode resultado = data.get("results").get(0);

            if (resultado != null) {
                // Extraer información del autor (primer autor)
                JsonNode autoresNode = resultado.get("authors");
                DatosAutor autor = null;
                if (autoresNode != null && autoresNode.isArray() && autoresNode.size() > 0) {
                    JsonNode primerAutor = autoresNode.get(0);
                    autor = mapeo.treeToValue(primerAutor, DatosAutor.class);
                }else {
                    autor=new DatosAutor(-1,"s/n",-1);}

                // Extraer información del idioma (primer idioma)
                JsonNode idiomasNode = resultado.get("languages");
                String idioma = null;
                if (idiomasNode != null && idiomasNode.isArray() && idiomasNode.size() > 0) {
                    idioma = idiomasNode.get(0).asText();
                }else {idioma="s/n";}

                // Crear objeto DatosLibro
                DatosLibro libro = new DatosLibro(
                        resultado.get("title").asText(),
                        autor,
                        resultado.get("download_count").asInt(),
                        idioma
                );

                return Optional.of(libro);
            }
        } catch (Exception e) {
            System.out.println("Error procesando el JSON: " + e.getMessage());
        }
    }
    return Optional.empty();
}

}