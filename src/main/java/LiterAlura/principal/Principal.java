package LiterAlura.principal;

import LiterAlura.service.Clases.Libro;
import LiterAlura.service.Datos.DatosLibro;
import LiterAlura.service.GutendexServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
      private Scanner teclado = new Scanner(System.in);
      private   List<Libro> biblioteca= new ArrayList<>();
    private final String URL = "https://gutendex.com/books/";
   private  GutendexServices servicios=new GutendexServices();

    public void interfaz() {
//    System.out.println(Principal.inicio());

    //----------------------
    var opcion = -1;
  while (opcion != 0) {
        var menu = """
                    -----Repositorio de libros-----
                    
                    1 - Busqueda de Libros por Titulo
                    2 - Lista de libros buscados
                    3 - Lista de autores
                    4 - Lista de autores vivos segun el anio
                    5 - Cantidad de libros por idioma
                    0 - Salir
                    ---------------------------------
                    Libreria digital ebook-pdf-mobi-AZW3
                    
                    """;
        System.out.println(menu);
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
                System.out.println("hotla");

                break;
            case 5:
                System.out.println("hfola");

                break;
            case 0:
                System.out.println(Principal.Salida());
                break;
            default:
                System.out.println("Opción inválida");
        }
    }}



    //Metodos
private  void   filtrarxTitulo() {
    System.out.println("Ingrese el titulo del libro:");
    var aux = teclado.nextLine();
    String direccion = (URL + "?search=" + aux.replace(" ", "%20")).toLowerCase().trim();

    Optional<DatosLibro> libro = servicios.filtrarxTitulo(direccion);
      if (libro.isPresent()) {
          Libro archivo = new Libro(libro.get());
         biblioteca.add(archivo);
       System.out.println(archivo);
   } else {
        System.out.println("""
                Lo sentimos no se pudo encontrar el libro
                 Asegurese de que este bien escrito
                 Puede tener otros nombres a veces""");
    }
}
    private void obtenerListaConsultas() {
biblioteca.forEach(e -> System.out.println(e));
    }
    private void obtenerListaAutores() {
biblioteca.forEach(e -> System.out.println(e.getAutoria()));
    }





   //Textos ASCii
public static   String  Salida() {
  String mensaje="""
             #####                                                                                                 \s
            #     #  ####  #       ####  #####  # #    #     ####   ####  #       ####  #####    ##   #####   #### \s
            #       #    # #      #    # #    # # ##   #    #    # #    # #      #    # #    #  #  #  #    # #    #\s
            #       #    # #      #    # #    # # # #  #    #      #    # #      #    # #    # #    # #    # #    #\s
            #       #    # #      #    # #####  # #  # #    #      #    # #      #    # #####  ###### #    # #    #\s
            #     # #    # #      #    # #   #  # #   ##    #    # #    # #      #    # #   #  #    # #    # #    #\s
             #####   ####  ######  ####  #    # # #    #     ####   ####  ######  ####  #    # #    # #####   #### \s
                                                                                                                   \s
            #######                                                                   \s
            #        ####  ##### ######     ####  #    # ###### #    # #####  ####    \s
            #       #        #   #         #    # #    # #      ##   #   #   #    #   \s
            #####    ####    #   #####     #      #    # #####  # #  #   #   #    #   \s
            #            #   #   #         #      #    # #      #  # #   #   #    #   \s
            #       #    #   #   #         #    # #    # #      #   ##   #   #    #   \s
            #######  ####    #   ######     ####   ####  ###### #    #   #    ####    \s
                                                                                      \s
             #####                                                                                                 \s
            #     # ######    #    #   ##      ##### ###### #####  #    # # #    #   ##   #####   ####             \s
            #       #         #    #  #  #       #   #      #    # ##  ## # ##   #  #  #  #    # #    #            \s
             #####  #####     ###### #    #      #   #####  #    # # ## # # # #  # #    # #    # #    #            \s
                  # #         #    # ######      #   #      #####  #    # # #  # # ###### #    # #    # ### ### ###\s
            #     # #         #    # #    #      #   #      #   #  #    # # #   ## #    # #    # #    # ### ### ###\s
             #####  ######    #    # #    #      #   ###### #    # #    # # #    # #    # #####   ####  ### ### ###\s
                                                                                                                    \s""";
  return mensaje;
}
public static String inicio(){
    String mensaje= """
             #####                                                                                                                                                                                                                                                       \s
            #     # ######     ####  #    # # ###### #    #    ###### #####    ##      ######  ####  #####   ##      #    #   ##     ##   #    #   ##       ####  #    #   ##   #    # #####   ####     #    # ######    #      ###### #    #   ##   #    # #####        \s
            #       #         #    # #    # # #      ##   #    #      #    #  #  #     #      #        #    #  #     ##  ##  #  #   #  #  ##   #  #  #     #    # #    #  #  #  ##   # #    # #    #    ##  ## #         #      #      #    #  #  #  ##   #   #          \s
             #####  #####     #    # #    # # #####  # #  #    #####  #    # #    #    #####   ####    #   #    #    # ## # #    # #    # # #  # #    #    #      #    # #    # # #  # #    # #    #    # ## # #####     #      #####  #    # #    # # #  #   #          \s
                  # #         #  # # #    # # #      #  # #    #      #####  ######    #           #   #   ######    #    # ###### ###### #  # # ######    #      #    # ###### #  # # #    # #    #    #    # #         #      #      #    # ###### #  # #   #    ###   \s
            #     # #         #   #  #    # # #      #   ##    #      #   #  #    #    #      #    #   #   #    #    #    # #    # #    # #   ## #    #    #    # #    # #    # #   ## #    # #    #    #    # #         #      #       #  #  #    # #   ##   #    ###   \s
             #####  ######     ### #  ####  # ###### #    #    ###### #    # #    #    ######  ####    #   #    #    #    # #    # #    # #    # #    #     ####   ####  #    # #    # #####   ####     #    # ######    ###### ######   ##   #    # #    #   #     #    \s
                                                                                                                                                                                                                                                                   #     \s
                                                                                                                                                                                                                                                                                    \s
            #####  ###### #####   ####      ####  #####  ######  ####      ####  #    # ######    #    # ######    #####  ###### #####  # #####   ####      ####    ##   #    # #####  #   ##   #####     #    #   ##   #####  #   ##    ####     #    # ######  ####  ######  #### \s
            #    # #      #    # #    #    #    # #    # #      #    #    #    # #    # #         #    # #         #    # #      #    # # #    # #    #    #    #  #  #  ##  ## #    # #  #  #  #    #    #    #  #  #  #    # #  #  #  #         #    # #      #    # #      #     \s
            #    # #####  #    # #    #    #      #    # #####  #    #    #    # #    # #####     ###### #####     #    # #####  #####  # #    # #    #    #      #    # # ## # #####  # #    # #    #    #    # #    # #    # # #    #  ####     #    # #####  #      #####   #### \s
            #####  #      #####  #    #    #      #####  #      #    #    #  # # #    # #         #    # #         #    # #      #    # # #    # #    #    #      ###### #    # #    # # ###### #####     #    # ###### #####  # ######      #    #    # #      #      #           #\s
            #      #      #   #  #    #    #    # #   #  #      #    #    #   #  #    # #         #    # #         #    # #      #    # # #    # #    #    #    # #    # #    # #    # # #    # #   #      #  #  #    # #   #  # #    # #    #     #  #  #      #    # #      #    #\s
            #      ###### #    #  ####      ####  #    # ######  ####      ### #  ####  ######    #    # ######    #####  ###### #####  # #####   ####      ####  #    # #    # #####  # #    # #    #      ##   #    # #    # # #    #  ####       ##   ######  ####  ######  #### \s
                                                                                                                                                                                                                                                                                    \s
                                                                                                           \s
            #####  ######  ####  #####  ######    ###### #    # #####  ####  #    #  ####  ######  ####    \s
            #    # #      #      #    # #         #      ##   #   #   #    # ##   # #    # #      #        \s
            #    # #####   ####  #    # #####     #####  # #  #   #   #    # # #  # #      #####   ####    \s
            #    # #           # #    # #         #      #  # #   #   #    # #  # # #      #           #   \s
            #    # #      #    # #    # #         #      #   ##   #   #    # #   ## #    # #      #    #   \s
            #####  ######  ####  #####  ######    ###### #    #   #    ####  #    #  ####  ######  ####    \s
                                                                                                           \s
              ##    #                                                                  ######                                                            #     #                                                                  #                             \s
             #     # #   #      #  ####  #   ##      ###### #    #    ###### #         #     #   ##    ####     #####  ######    #        ##    ####     ##   ##   ##   #####    ##   #    # # #      #        ##    ####         #       ###### #    # #  #### \s
            #     #   #  #      # #    # #  #  #     #      ##   #    #      #         #     #  #  #  #         #    # #         #       #  #  #         # # # #  #  #  #    #  #  #  #    # # #      #       #  #  #             #       #      #    # # #     \s
            #    #     # #      # #      # #    #    #####  # #  #    #####  #         ######  #    #  ####     #    # #####     #      #    #  ####     #  #  # #    # #    # #    # #    # # #      #      #    #  ####         #       #####  #    # #  #### \s
            #    ####### #      # #      # ######    #      #  # #    #      #         #       ######      #    #    # #         #      ######      #    #     # ###### #####  ###### #    # # #      #      ######      # ###    #       #      # ## # #      #\s
             #   #     # #      # #    # # #    #    #      #   ##    #      #         #       #    # #    #    #    # #         #      #    # #    #    #     # #    # #   #  #    #  #  #  # #      #      #    # #    # ###    #       #      ##  ## # #    #\s
              ## #     # ###### #  ####  # #    #    ###### #    #    ###### ######    #       #    #  ####     #####  ######    ###### #    #  ####     #     # #    # #    # #    #   ##   # ###### ###### #    #  ####   #     ####### ###### #    # #  #### \s
                                                                                                                                                                                                                           #                                    \s
             #####                                            ##  \s
            #     #   ##   #####  #####   ####  #      #        # \s
            #        #  #  #    # #    # #    # #      #         #\s
            #       #    # #    # #    # #    # #      #         #\s
            #       ###### #####  #####  #    # #      #         #\s
            #     # #    # #   #  #   #  #    # #      #        # \s
             #####  #    # #    # #    #  ####  ###### ###### ##\s""";

 return   mensaje;}
}
