package LiterAlura.service;

import LiterAlura.service.API.ConsumoAPI;
import LiterAlura.service.API.ConvierteDatos;
import LiterAlura.service.API.IConvierteDatos;
import LiterAlura.service.Clases.Autor;
import LiterAlura.service.Datos.DatosAutor;
import LiterAlura.service.Datos.DatosLibro;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GutendexServices {
    private ConsumoAPI api = new ConsumoAPI();
    private IConvierteDatos conversor = new ConvierteDatos();
    private ObjectMapper mapeo = new ObjectMapper();


    public Optional<DatosLibro> filtrarxTitulo(String url) {
        Optional<String> datos = api.obtenerDatos(url);
        Optional<DatosAutor> autor;
        Optional<String> idioma;
            if (datos.isPresent()) {
                try {
                    JsonNode library = mapeo.readTree(datos.get());
                    JsonNode nodo = library.get("results");
//----------------Chequeo de Datos-------------------------------------------
                    if (nodo == null || nodo.size() == 0) {
                        return Optional.empty();
                    } // Si no hay nada en "results"
                   //-----------------Primer Libro de results------------------------------------------
                    JsonNode primerResult = nodo.get(0);
//----------------Chequeo de Datos-------------------------------------------
                    if (primerResult == null || primerResult.size() == 0) {
                        return Optional.empty();}                   // System.out.println("Resultado del nodo results:" + primerResult);

DatosLibro contenedor = mapeo.convertValue(primerResult, DatosLibro.class); //System.out.println("Resultado del contenedor : " + contenedor);

                    return Optional.of(contenedor);}
                ////-----------------Primer Autor del libro------------------------------------------
//autor = this.obtenerAutor(primerResult);
//if (autor.isEmpty()) {return Optional.empty();} // No hay autor
////-----------------Primer idioma de la lista------------------------------------------
//JsonNode idiomas = primerResult.get("languages");
// idioma = this.obteneridioma(idiomas);
//if (idioma.isEmpty()) {return Optional.empty();} // No hay idioma
////-----------------Objeto Datos libro------------------------------------------
//
//DatosLibro result = this.obtenerDatos(contenedor, autor.get(), idioma.get());
//return Optional.of(result);}
                catch (Exception e){
                    System.err.println("Error en el proceso: " + e.getMessage());}
            }
            return Optional.empty();} // Si no se obtienen datos de la API


    //-----------------------------------------------------------
        /*private Optional<DatosAutor> obtenerAutor(JsonNode auxiliar) {
            JsonNode authorsNode = auxiliar.get("authors");
            if (authorsNode != null && authorsNode.size() > 0) {
                DatosAutor primero = mapeo.convertValue(authorsNode.get(0), DatosAutor.class);
                return Optional.of(primero);
            }
            return Optional.empty();
        }


        //-----------------------------------------------------------
        private Optional<String> obteneridioma(JsonNode auxiliar) {
            if (auxiliar != null && auxiliar.size() > 0) {
                List<String> listaIdiomas = mapeo.convertValue(auxiliar, new TypeReference<List<String>>() {});
                return listaIdiomas.stream().findFirst();
            }
            return Optional.empty();
        }

//-----------------------------------------------------------

//    private DatosLibro obtenerDatos(DatosLibro aux, DatosAutor primero, String idioma) {
//        return new DatosLibro(
//                aux.id(),aux.titulo(),
//                primero,aux.descargas(),
//                idioma);}*/
}