package LiterAlura.principal;

import LiterAlura.model.Clases.Autor;
import LiterAlura.model.Clases.Libro;
import LiterAlura.model.Datos.DatosLibro;
import LiterAlura.model.Idioma;
import LiterAlura.service.GutendexServices;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
      private Scanner teclado = new Scanner(System.in);
      private   List<Libro> biblioteca= new ArrayList<>();
    private final String URL = "https://gutendex.com/books/";
   private  GutendexServices servicios=new GutendexServices();

    public void interfaz() {
   System.out.println(Principal.inicio());
        try {
            Thread.sleep(2500); // Pausa en milisegundos
        } catch (InterruptedException e) {}
        limpiarConsola();
    //----------------------
    var opcion = -1;
  while (opcion != 0) {
        var menu = """
                    ╔==========================================╗
                    ...........Repositorio de libros............
                    ╚==========================================╝
                    
                    
                    1 - Busqueda de Libros por Titulo
                    2 - Lista de libros buscados
                    3 - Lista de autores
                    4 - Lista de autores vivos segun el anio
                    5 - Cantidad de libros por idioma
                    0 - Salir
                    
                    ...........................................
                      Libreria digital ebook-pdf-mobi-AZW3
                    ...........................................
                    \n
                    """;
        System.out.println(menu);
      System.out.print("Opcion:");
        opcion = teclado.nextInt();
        teclado.nextLine();

        switch (opcion) {
            case 1:
                filtrarxTitulo();
                break;
            case 2:
                obtenerListaConsultas();
                break;
            case 3:
                obtenerListaAutores();

                break;
            case 4:
                obtenerListaAutoresPorFecha();

                break;
            case 5:
               obtenerLibrosxIdioma();

                break;
            case 0:
                System.out.println(Principal.Salida());
                break;
            default:
                System.out.println("Opción inválida");
        }
    }}

    private void obtenerLibrosxIdioma() {
        System.out.print("""
               ╔===============================================╗
               ║              Idiomas disponible               ║
               ║...............................................║   
               ║   Es-Español                                  ║
               ║   En-Ingles                                   ║
               ║   zh-Chino                                    ║
               ║   fr-Frances                                  ║
               ║   pt-Portugal                                 ║
               ║   de-Aleman                                   ║
               ║   fi-Finlandia                                ║
               ║   s/n- no tiene ningun idioma registrado      ║
               ╚===============================================╝
               Selecciona uno de los idiomas escribiendo el codigo de idioma
               Opcion: """);
        String aux=teclado.nextLine();

        if (Idioma.validacion(aux)){
List<Libro> filtro=  biblioteca.stream()
                    .filter(e ->e.getLenguaje().equals(Idioma.fromString(aux)))
                    .collect(Collectors.toList());
        filtro.forEach(e -> System.out.println(e));}else {
        System.out.println("Ingrese una opcion valida");}
      }


    //Metodos
private  void   filtrarxTitulo() {
    System.out.print("Ingrese el titulo del libro:");
    var aux = teclado.nextLine();
    String direccion = (URL + "?search=" + aux.replace(" ", "%20")).toLowerCase().trim();
    Optional<DatosLibro> libro = servicios.filtrarxTitulo(direccion);
      if (libro.isPresent()) {
          Libro archivo = new Libro(libro.get());
          String title= archivo.getTitulo();
        Optional<Libro> existe=biblioteca.stream()
                  .filter(e -> e.getTitulo().contains(title))
                .findFirst();
              if(existe.isPresent()) {
                  System.out.println("Este libro ya existe en su biblioteca");
          return;}
          else{
         biblioteca.add(archivo);
       System.out.println(archivo);}
   } else {
        System.out.println("""
               ╔===============================================╗
               ║¡¡ Lo sentimos no se pudo encontrar el libro!! ║
               ║  Asegurese de que este bien escrito...        ║
               ║  Puede tener otros nombres a veces !!!        ║
               ╚===============================================╝\n""");
    }
}
    private void obtenerListaConsultas() {
biblioteca.forEach(e -> System.out.println(e));
    }
    private void obtenerListaAutores() {
        String aux= """
               ╔===============================================╗
               ║.....................Autores...................║
               ╚===============================================╝
                """;
        System.out.println(aux);
biblioteca.forEach(e -> System.out.println("Nombre:   "+e.getAutoria().getNombre() + "  Titulo:  "+ e.getTitulo()));
    }
    private void obtenerListaAutoresPorFecha() {
        System.out.print("Ingrese la fecha en la que desea buscar (año): ");
        Integer aux = teclado.nextInt();
        if (aux > 0 && aux <= LocalDate.now().getYear()) {
            List<Libro> existen = biblioteca.stream()
                    .filter(e -> e.getAutoria().getFechaDeNacimiento() <= aux && e.getAutoria().getFechaDeDefuncion()>=aux)
                    .collect(Collectors.toList());
            if (existen.isEmpty()) {
                System.out.println("No se encuentran Autores vivos en dicha fecha");
                return;
            }
            String txt = """
                    ╔===============================================╗
                    ║................Autores vivos..................║
                    ╚===============================================╝""";

            System.out.println(txt);
            existen.forEach(e -> System.out.println(e.getAutoria().getNombre()));
        } else {
            System.out.println("Ingrese una fecha que sea valida");
        }

    }



//-------------Extras visuales------------------------------------------------
public static   String  Salida() {
  String mensaje="""
          
          
          █▀▀ █▀█ █░░ █▀█ █▀█ █ █▄░█   █▀▀ █▀█ █░░ █▀█ █▀█ ▄▀█ █▀▄ █▀█   █▀▀ █▀ ▀█▀ █▀▀   █▀▀ █░█ █▀▀ █▄░█ ▀█▀ █▀█   █▀ █▀▀
          █▄▄ █▄█ █▄▄ █▄█ █▀▄ █ █░▀█   █▄▄ █▄█ █▄▄ █▄█ █▀▄ █▀█ █▄▀ █▄█   ██▄ ▄█ ░█░ ██▄   █▄▄ █▄█ ██▄ █░▀█ ░█░ █▄█   ▄█ ██▄
          
          █░█ ▄▀█   ▀█▀ █▀▀ █▀█ █▀▄▀█ █ █▄░█ ▄▀█ █▀▄ █▀█   ░ ░ ░
          █▀█ █▀█   ░█░ ██▄ █▀▄ █░▀░█ █ █░▀█ █▀█ █▄▀ █▄█   ▄ ▄ ▄""";
  return mensaje;
}
public static String inicio(){
    String mensaje= """
██████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
█░░░░░░░░░░░░░░░░███░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░░░███░░░░░░░░░░█░░░░░░░░░░░░░░█
█░░▄▀▄▀▄▀▄▀▄▀▄▀░░███░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀▄▀░░███░░▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█
█░░▄▀░░░░░░░░▄▀░░███░░▄▀░░░░░░░░░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░░░░░░░░░█░░░░▄▀░░░░█░░░░░░▄▀░░░░░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░░░░░░░▄▀░░███░░░░▄▀░░░░█░░▄▀░░░░░░▄▀░░█
█░░▄▀░░████░░▄▀░░███░░▄▀░░█████████░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░███████████░░▄▀░░███████░░▄▀░░█████░░▄▀░░██░░▄▀░░█░░▄▀░░████░░▄▀░░█████░░▄▀░░███░░▄▀░░██░░▄▀░░█
█░░▄▀░░░░░░░░▄▀░░███░░▄▀░░░░░░░░░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░░░░░███░░▄▀░░███████░░▄▀░░█████░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░░░▄▀░░█████░░▄▀░░███░░▄▀░░██░░▄▀░░█
█░░▄▀▄▀▄▀▄▀▄▀▄▀░░███░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░███░░▄▀░░███████░░▄▀░░█████░░▄▀░░██░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀▄▀░░█████░░▄▀░░███░░▄▀░░██░░▄▀░░█
█░░▄▀░░░░░░▄▀░░░░███░░▄▀░░░░░░░░░░█░░▄▀░░░░░░░░░░█░░▄▀░░██░░▄▀░░█░░░░░░░░░░▄▀░░███░░▄▀░░███████░░▄▀░░█████░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░▄▀░░░░█████░░▄▀░░███░░▄▀░░██░░▄▀░░█
█░░▄▀░░██░░▄▀░░█████░░▄▀░░█████████░░▄▀░░█████████░░▄▀░░██░░▄▀░░█████████░░▄▀░░███░░▄▀░░███████░░▄▀░░█████░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░███████░░▄▀░░███░░▄▀░░██░░▄▀░░█
█░░▄▀░░██░░▄▀░░░░░░█░░▄▀░░░░░░░░░░█░░▄▀░░█████████░░▄▀░░░░░░▄▀░░█░░░░░░░░░░▄▀░░█░░░░▄▀░░░░█████░░▄▀░░█████░░▄▀░░░░░░▄▀░░█░░▄▀░░██░░▄▀░░░░░░█░░░░▄▀░░░░█░░▄▀░░░░░░▄▀░░█
█░░▄▀░░██░░▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░█████████░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀░░█████░░▄▀░░█████░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░██░░▄▀▄▀▄▀░░█░░▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█
█░░░░░░██░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░█████████░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░█████░░░░░░█████░░░░░░░░░░░░░░█░░░░░░██░░░░░░░░░░█░░░░░░░░░░█░░░░░░░░░░░░░░█
██████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
██████████████████████████████████████████████████████████████████████████████████████████████████
█░░░░░░░░░░░░███░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░█████████
█░░▄▀▄▀▄▀▄▀░░░░█░░▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░█████████
█░░▄▀░░░░▄▀▄▀░░█░░░░▄▀░░░░█░░▄▀░░░░░░░░░░█░░░░▄▀░░░░█░░░░░░▄▀░░░░░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░█████████
█░░▄▀░░██░░▄▀░░███░░▄▀░░███░░▄▀░░███████████░░▄▀░░███████░░▄▀░░█████░░▄▀░░██░░▄▀░░█░░▄▀░░█████████
█░░▄▀░░██░░▄▀░░███░░▄▀░░███░░▄▀░░███████████░░▄▀░░███████░░▄▀░░█████░░▄▀░░░░░░▄▀░░█░░▄▀░░█████████
█░░▄▀░░██░░▄▀░░███░░▄▀░░███░░▄▀░░██░░░░░░███░░▄▀░░███████░░▄▀░░█████░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░█████████
█░░▄▀░░██░░▄▀░░███░░▄▀░░███░░▄▀░░██░░▄▀░░███░░▄▀░░███████░░▄▀░░█████░░▄▀░░░░░░▄▀░░█░░▄▀░░█████████
█░░▄▀░░██░░▄▀░░███░░▄▀░░███░░▄▀░░██░░▄▀░░███░░▄▀░░███████░░▄▀░░█████░░▄▀░░██░░▄▀░░█░░▄▀░░█████████
█░░▄▀░░░░▄▀▄▀░░█░░░░▄▀░░░░█░░▄▀░░░░░░▄▀░░█░░░░▄▀░░░░█████░░▄▀░░█████░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░░░░░█
█░░▄▀▄▀▄▀▄▀░░░░█░░▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀░░█████░░▄▀░░█████░░▄▀░░██░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█
█░░░░░░░░░░░░███░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░█████░░░░░░█████░░░░░░██░░░░░░█░░░░░░░░░░░░░░█
██████████████████████████████████████████████████████████████████████████████████████████████████""";

 return   mensaje;}
    public static void limpiarConsola() {
        // Escape ANSI (funciona en muchas consolas)
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
