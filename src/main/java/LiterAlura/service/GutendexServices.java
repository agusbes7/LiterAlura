package LiterAlura.service;

import LiterAlura.service.API.ConsumoAPI;
import LiterAlura.service.API.ConvierteDatos;
import LiterAlura.service.API.IConvierteDatos;
import LiterAlura.service.Clases.Libro;
import LiterAlura.service.Datos.DatosGutendex;
import LiterAlura.service.Datos.DatosLibro;

import java.util.Optional;

public class GutendexServices {
    private ConsumoAPI consumoAPI;
    private IConvierteDatos convierteDatos;

    public Libro filtrarxTitulo(String url) {
        String json = consumoAPI.obtenerDatos(url);
       if(json.contains("null") || json.contains("false")){
           System.out.println("No se encontró");
           return null;}
        var aux = convierteDatos.obtenerDatos(json, DatosGutendex.class);
        Optional<DatosLibro> primerLibro = aux.Resultados().stream().findFirst();
        if (primerLibro.isPresent()) {
            Libro l = new Libro(primerLibro.get());
l.toString();}

        return null;
    }

    }




