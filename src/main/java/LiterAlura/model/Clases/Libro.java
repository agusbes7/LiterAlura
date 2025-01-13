package LiterAlura.model.Clases;

import LiterAlura.model.Datos.DatosAutor;
import LiterAlura.model.Datos.DatosLibro;
import LiterAlura.model.Idioma;
import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    String titulo;
    @ManyToOne
    @JoinColumn(name = "autor_id")
   Autor autoria;
    @Enumerated(EnumType.STRING)
    Idioma lenguaje;

    Integer Descargas;

//---------------------------------------------
    public  Libro(DatosLibro libro){
        this.titulo=libro.titulo();
       // this.id=libro.id();
        this.Descargas= libro.descargas();
        this.lenguaje=Idioma.fromString(libro.idioma());
  }

    public String getTitulo() {return titulo;}
    public Idioma getLenguaje() {return lenguaje;}
    public Integer getDescargas() {        return Descargas;}
    public Autor getAutoria() {return autoria;}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public void setTitulo(String titulo) {this.titulo = titulo;    }
    public void setLenguaje(Idioma lenguaje) {this.lenguaje = lenguaje;}
    public void setDescargas(Integer descargas) {Descargas = descargas;}

    public void setAutoria(Autor aux) {
        this.autoria = aux;
    }

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
