package LiterAlura.model.Clases;

import LiterAlura.model.Datos.DatosAutor;

public class Autor {
    String nombre;
    Integer FechaDeNacimiento, FechaDeDefuncion;

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

    public void setFechaDeNacimiento(String FechaDeNacimiento) {
        FechaDeNacimiento = FechaDeNacimiento;
    }

    public Integer getFechaDeDefuncion() {
        return FechaDeDefuncion;
    }

    public void setFechaDeDefuncion(String FechaDeDefuncion) {
        FechaDeDefuncion = FechaDeDefuncion;
    }

    @Override
    public String toString() {

        String basico= """
                 ..................Autor.....................
                 Nombre:  """ + nombre+'\n'+
                "Nacio en:  "+this.getFechaDeNacimiento()+'\n'+
                "Murio en:  "+getFechaDeDefuncion()+'\n'+
                "............................................";
    //verificar si tiene año de defuncion y mostrarlo, pasa a datetime
//        if(){            return  basico + opcional;
        return  basico;}

    }

