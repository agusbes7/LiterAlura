package LiterAlura.model.Clases;

import LiterAlura.model.Datos.DatosLibro;

public class Libro {
    Integer id;
    String titulo;
   Autor autoria;
    String idiomas;
    public  Libro(DatosLibro libro){
        this.titulo=libro.titulo();
        this.autoria=new Autor(libro.autor());
        this.id=libro.id();
        this.Descargas= libro.descargas();
        this.idiomas=libro.idioma();
    }

    Integer Descargas;
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

    public Integer getId() {
        return id;
    }

    public Autor getAutoria() {
        return autoria;
    }

    @Override
    public String toString() {


        return """
                ╔==========================================╗
                ..................Libro.....................
                ╚==========================================╝
                   Titulo:        """+ titulo +'\n'+
               "   Autor:         " + autoria.getNombre()+'\n' +
               "   Idioma:        " + idiomas + '\n' +
               "   Descargas:     " + Descargas +'\n' +
               """
                ============================================
                
                """;}
}