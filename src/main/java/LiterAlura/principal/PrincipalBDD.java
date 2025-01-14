package LiterAlura.principal;

import LiterAlura.model.Clases.Autor;
import LiterAlura.model.Clases.Libro;
import LiterAlura.model.Datos.DatosLibro;
import LiterAlura.model.Idioma;
import LiterAlura.repository.AutorRepository;
import LiterAlura.repository.LibroRepository;
import LiterAlura.service.GutendexServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
@Component
public class PrincipalBDD {
      private Scanner teclado = new Scanner(System.in);
      private   List<Libro> biblioteca= new ArrayList<>();
      private  List<Autor> escritores=new ArrayList<>();
    private final String URL = "https://gutendex.com/books/";
   private  GutendexServices servicios=new GutendexServices();
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;


    @Autowired
    public PrincipalBDD(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;}

    public void interfaz() {
   System.out.println(PrincipalBDD.inicio());
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
                System.out.println(PrincipalBDD.Salida());
                break;
            default:
                System.out.println("Opción inválida");
        }
    }}

      //......................................................

    //Metodos
private  void   filtrarxTitulo() {
    System.out.print("Ingrese el titulo del libro:");
    var title = teclado.nextLine();
    String direccion = (URL + "?search=" + title.replace(" ", "%20")).toLowerCase().trim();
    Optional<DatosLibro> archivo = servicios.filtrarxTitulo(direccion);

    //buscar si existe el libro en gutendex
    if(archivo.isPresent()){
//--------------------------------------------------
            DatosLibro aux=archivo.get();
            //buscar si ya fue agregado a la base de datos
            if (libroRepository.findBytitulo(aux.titulo()).isPresent()) {
            System.out.println("El libro ya existe: " + aux.titulo());
            return;}
//------Buscar si el autor ya existe en la base--------------------------------------------
    Optional<Autor> autor = autorRepository.findByNombre(aux.autor().nombre());
//---------------------Si no existe creamos el autor y lo seteamos en libros y lo guardamos en autorRepository----------
        Libro libro = new Libro(aux);
            if(autor.isEmpty()) {
            Autor nuevo = new Autor(aux.autor());
            libro.setAutoria(nuevo);
            autorRepository.save(nuevo); //guardamos el nuevo autor
        }        else{
                libro.setAutoria(autor.get());}
         libroRepository.save(libro);
//----------------Si existe seteamos el mismo autor en el nuevo libro y guardamos-------------------------------------------------------
    System.out.println("Libro agregado exitosamente: "+'\n' + libro);
return;    }
        System.out.println("""
               ╔===============================================╗
               ║¡¡ Lo sentimos no se pudo encontrar el libro!! ║
               ║  Asegurese de que este bien escrito...        ║
               ║  Puede tener otros nombres a veces !!!        ║
               ╚===============================================╝""");
    }
    //......................................................

    private void obtenerListaConsultas() {
     biblioteca=libroRepository.findAll();
biblioteca.forEach(System.out::println);}
    //......................................................

    private void obtenerListaAutores() {
        String aux= """
               ╔===============================================╗
               ║.....................Autores...................║
               ╚===============================================╝
               """;
        System.out.println(aux);
escritores=autorRepository.findAll();
        escritores.forEach(e -> System.out.println(e.getNombre()));}
    //......................................................
    private void obtenerListaAutoresPorFecha() {
        System.out.print("Ingrese la fecha en la que desea buscar (año): ");
        Integer aux = teclado.nextInt();
        if (aux > 0 && aux <= LocalDate.now().getYear()) {
            String txt = """
                    ╔===============================================╗
                    ║................Autores vivos..................║
                    ╚===============================================╝""";

            System.out.println(txt);
//            Optional<List<Autor>> autores = autorRepository.findByFechaDeNacimientoLessThanAndFechaDeDefuncionIsnullorFechaDeDefuncionGreatherThan(aux);
//            if (autores.isPresent()) {
//                autores.get().forEach(e -> System.out.println(e.getNombre()));
//            } else {
//                System.out.println("No se encontraron autores vivos en esa fecha");
//            }
        } else {
            System.out.println("Ingrese una fecha que sea valida");
        }}
//......................................................

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
Optional<List<Libro>> cuaderno=libroRepository.findBylenguaje(Idioma.fromString(aux));
if (cuaderno.isPresent()){
    cuaderno.get().forEach(e -> System.out.println(e.getTitulo()));}
else {
    System.out.println("No hay ningun libro en dicho idioma");}

        }else {
            System.out.println("Ingrese una opcion valida");}
    }


//-------------Extras visuales------------------------------------------------
public static   String  Salida() {
  String mensaje="""
          █▀▀ █▀█ █░░ █▀█ █▀█ █ █▄░█   █▀▀ █▀█ █░░ █▀█ █▀█ ▄▀█ █▀▄ █▀█   █▀▀ █▀ ▀█▀ █▀▀   █▀▀ █░█ █▀▀ █▄░█ ▀█▀ █▀█   █▀ █▀▀
          █▄▄ █▄█ █▄▄ █▄█ █▀▄ █ █░▀█   █▄▄ █▄█ █▄▄ █▄█ █▀▄ █▀█ █▄▀ █▄█   ██▄ ▄█ ░█░ ██▄   █▄▄ █▄█ ██▄ █░▀█ ░█░ █▄█   ▄█ ██▄
          
          █░█ ▄▀█   ▀█▀ █▀▀ █▀█ █▀▄▀█ █ █▄░█ ▄▀█ █▀▄ █▀█   ░ ░ ░
          █▀█ █▀█   ░█░ ██▄ █▀▄ █░▀░█ █ █░▀█ █▀█ █▄▀ █▄█   ▄ ▄ ▄""";
  return mensaje;}
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
