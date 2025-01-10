package LiterAlura.service.Clases;

import LiterAlura.service.Datos.DatosLibro;

public class Libro {
   // Long id;
    String titulo;
    Autor autoria;
    String idiomas;
    Integer Descargas;

    public  Libro(DatosLibro libro){
        this.titulo=libro.titulo();
        this.autoria=libro.autor();
        this.idiomas=libro.idioma();}
      //  this.id=libro.id();    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getDescargas() {
        return Descargas;
    }

    public void setDescargas(Integer descargas) {
        Descargas = descargas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                autoria.toString() +
                ", idiomas='" + idiomas + '\'' +
                ", Descargas=" + Descargas +
                '}';
    }
}
