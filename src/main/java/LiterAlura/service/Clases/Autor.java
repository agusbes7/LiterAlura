package LiterAlura.service.Clases;

import LiterAlura.service.Datos.DatosAutor;

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
        String basico="Autor{ " +
                 nombre + '\'' +
                "Nacio en " + this.getFechaDeNacimiento();
        String opcional ="Año de Defuncion: el " + FechaDeDefuncion + '\'' +
                '}';
    //verificar si tiene año de defuncion y mostrarlo, pasa a datetime
//        if(){            return  basico + opcional;
        return  basico;}

    }

