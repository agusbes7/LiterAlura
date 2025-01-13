package LiterAlura.model.Clases;

import LiterAlura.model.Datos.DatosLibro;
import LiterAlura.model.Idioma;

public class Libro {
    //Integer id;
    String titulo;
   Autor autoria;
    Idioma lenguaje;
    Integer Descargas;

//---------------------------------------------
    public  Libro(DatosLibro libro){
        this.titulo=libro.titulo();
        this.autoria=new Autor(libro.autor());
       // this.id=libro.id();
        this.Descargas= libro.descargas();
        this.lenguaje=Idioma.fromString(libro.idioma());}

    public String getTitulo() {return titulo;}
    public Idioma getLenguaje() {return lenguaje;}
    public Integer getDescargas() {        return Descargas;}
    public Autor getAutoria() {return autoria;}

    public void setTitulo(String titulo) {this.titulo = titulo;    }
    public void setLenguaje(Idioma lenguaje) {this.lenguaje = lenguaje;}
    public void setDescargas(Integer descargas) {Descargas = descargas;}

    @Override
    public String toString() {
        return """
                ╔==========================================╗
                ..................Libro.....................
                ╚==========================================╝
                   Titulo:        """+ titulo +'\n'+
               "   Autor:         " + autoria.getNombre()+'\n' +
               "   Idioma:        " + lenguaje + '\n' +
               "   Descargas:     " + Descargas +'\n' +
               """
                ============================================
                
                """;}
}
