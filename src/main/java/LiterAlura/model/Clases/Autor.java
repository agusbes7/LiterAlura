package LiterAlura.model.Clases;

import LiterAlura.model.Datos.DatosAutor;
import jakarta.persistence.*;

@Entity
@Table( name = "Autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    String nombre;
    Integer FechaDeNacimiento, FechaDeDefuncion;
public  Autor(){}
    public  Autor(DatosAutor autor){
       this.nombre=autor.nombre();
       this.FechaDeDefuncion=autor.Defuncion();
       this.FechaDeNacimiento=autor.Nacimiento();}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Integer FechaDeNacimiento) {
       this.FechaDeNacimiento = FechaDeNacimiento;
    }

    public Integer getFechaDeDefuncion() {
        return FechaDeDefuncion;
    }

    public void setFechaDeDefuncion(Integer FechaDeDefuncion) {
      this.FechaDeDefuncion = FechaDeDefuncion;
    }

    @Override
    public String toString() {

        String basico= """
                 ..................Autor.....................
                 Nombre:  """ + nombre+'\n'+
                "Nacio en:  "+FechaDeNacimiento+'\n'+
                "Murio en:  "+FechaDeDefuncion+'\n'+
                "............................................";
    //verificar si tiene año de defuncion y mostrarlo, pasa a datetime
//        if(){            return  basico + opcional;
        return  basico;}

    }

