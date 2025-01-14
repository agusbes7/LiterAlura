# **Bienvenidos**
![Banner-3.jpg](Medias/Banner-3.jpg)

## 🚀 Presentacion 🚀

Buenas soy Agustin y como parte del programa [ONE de oracle](https://www.oracle.com/ar/education/oracle-next-education/) quiero compartir con ustedes el desarrollo
de mi primer Aplicacion java trabajando lo que es el backend y bases de datos como desafio para [Alura Latam](https://www.aluracursos.com/).

---
## ⭐ Requisitos ⭐
A continuacion describiré los softwares usados durante el proyecto y librerias que no pueden faltar.


Los softwares principales usados durante el proyecto son:

>🟢 [Intellij IDEA](https://www.jetbrains.com/idea/download/?section=windows) en su version gratituita como entorno del proyecto.
>
>🟢 [Postman](https://www.postman.com/) para estudiar los resultados de mis peticiones de manera mas comoda y rapida.
>
>🟢 [Git bash](https://git-scm.com/downloads) una herramienta muy poderosa  para llevar versionados del proyecto.
>
>🟢 [PostgreSQL](https://www.postgresql.org/download/windows/) una base de datos relacional usada en el proyecto.
> 
---
✅El manejo de archivos JSON se realizo con la libreria 🔹Jackson🔹 y la API utilizada no requiere clave

>Les comparto el desafio propuesto por alura [Liter-Alura](https://trello.com/b/WDyMPDMb/literalura-challenge-java) y los invito a intentarlo

---
## 💻--Introduccion a 📚Liter-Alura📚--💻

### A continuacion voy a describir  brevemente el funcionamiento.

📚Inicia la aplicacion y **spring** se encarga de conectar todo lo necesario con la base datos, la inyeccion de dependencias, las librerias requeridad,etc.  
Mostrammos un pequeño cartel de inicio    

![inicio.jpg](Medias%2Finicio.jpg)  

A continuacion se observa el menu  

![menu.jpg](Medias%2Fmenu.jpg)

Ya podemos elegir las opciones que queremos, contamos con una serie de libros ya en la base y podemos proceder a hacer una serie de consultas. Tambien pueden agregar nuevos si lo desean dicha funcionalidad sigue siendo servida  
❌ Se consideró la posibilidad de buscar dos veces el mismo libro y **NO** será posible añadir un libro que ya existe, pueden probarlo.    
### Libro ya existente en la base de Datos  
>>![libro ya existente.jpg](Medias%2Flibro%20ya%20existente.jpg)    

### Libro mal escrito o no existente en la API  
>>![libro no existente.jpg](Medias%2Flibro%20no%20existente.jpg)    
 
#### Antes de continuar mostrando funcionalidades algunas consideraciones
 1. A los efectos de este trabajo se considero que un autor puede tener muchos libros  
 2. Un autor no conoce la relacion con el libro  
3. Un libro puede tener solo un autor(la API retorna un arreglo de autores pero solo extraemos el primero)  
4. Idiomas tambien retorna un arreglo, pero extraemos el primero  

> Antes de implementar la base de datos por cada libro se creaba un autor aunque sea el mismo, eso se corrigio cuando empezamos a mapear las entidades en la base de datos y reemplazamos los metodos de consola por los de la base
> Cada autor es instanciado 1 vez y si se quiere agregar un libro del autor simplemente se setea con el autor que ya existe en nuestra base de datos  


📕📗📘📙📕📗📘📙📕📗📘📙![banner libros.webp](Medias%2Fbanner%20libros.webp) 📕📗📘📙📕📗📘📙📕📗

## Dado que ya tenemos varios Objetos en la base observaremos el funcionamiento de los servicios de la aplicacion  

Consultar la lista de todos los libros agregados a la base   📕📗 **opcion 2 del menu** 📘📙 
>>![lista de libros.jpg](Medias%2Flista%20de%20libros.jpg) 
> ![lista de libros2.jpg](Medias%2Flista%20de%20libros2.jpg)
  
![banner escritor.jpg](Medias%2Fbanner%20escritor.jpg)

>>📝📝Esos libros que figuran en la base fueron escritos por los siguientes autores consultando la 📕📗 **opcion 3 del menu** 📘📙
> ![listo de autores.jpg](Medias%2Flisto%20de%20autores.jpg)

>>📆 A continuacion nos pico la curiosidad de saber mas de esos autores y ver quien estaba vivo en tal año para eso podemos consultar la  📕📗 **opcion 4 del menu** 📘📙  

![banner_calendario.png](Medias%2Fbanner_calendario.png)  

Deben ingresar un año  valido es un dato de tipo entero...
No podemos preguntar si un autor estará vivo en 2026,2050 por que nadie lo sabe
Incluso para su sorpresa podran observar que existen libros que se escribieron antes del año 0  pueden probar -480,-500,-3 y ver si logran encontrar alguno de esos autores

>Autores vivos en 1930  
> >![consulta vivos.jpg](Medias%2Fconsulta%20vivos.jpg)      

>Autores vivos antes del año 0
>>![consulta vivos2.jpg](Medias%2Fconsulta%20vivos2.jpg)  

>Autores vivos en 1950
>>![consulta vivos3.jpg](Medias%2Fconsulta%20vivos3.jpg)    

>Autores vivos em 1780
>>![consulta vivos4.jpg](Medias%2Fconsulta%20vivos4.jpg)  

por ultimo deseamos saber que libros estan en determinado idioma usamos la 📕📗 **opcion 5 del menu** 📘📙  

![banner-lenguas.jpg](Medias%2Fbanner-lenguas.jpg)

Debemos ingresar uno de los idiomas del listado del Enum y ver si ya ingresamos algun libro con el respectivo idioma a nuestra base

>>>Punto a considerar el lenguaje ingles suele tener predominancia por casi todos los idiomas y siempre lo ubican primero--> dado que solo extraemos el primer idioma si en el arreglo habia mas estos quedaron en  segundo plano al igual que el buscar nuevo libros en otros idiomas generalmente no figuran porque solo existen con el nombre ingles  

>Idiomas disponibles para seleccionar en el enum(pueden agregar mas, pero no especifica la api cuantos lenguajes tiene disponibles ni cuales son, agregué los que reconocí)  
> >![consulta idiomas2.jpg](Medias%2Fconsulta%20idiomas2.jpg)

>Libros agregados en ingles 
>>![consulta idiomas.jpg](Medias%2Fconsulta%20idiomas.jpg)
> observen que intenté añadir El Aleph de borges, pero no lo encontró a pesar de ser bastante reconocido internacionalmente y mas en latinoamerica  
 
>Libros agregados en Español
>>![consulta idiomas3.jpg](Medias%2Fconsulta%20idiomas3.jpg)
> para evitar inconvenientes que suelen tener las consolas y motores de busquedas con la letra pronunciada como enie tan caracteristica de Argentina y otros lugare HispanoHablantes
 
Quedaron pendientes unos desafios extras opcionales que intentaré hacer en el futuro si dispongo del tiempo.  
Finalmente un cartel de salida con una frase muy conocida por la mayoria de los que estén leyendo esto     

![final.jpg](Medias%2Ffinal.jpg)

### 📶--API--📶

📚Con respecto a la api  es la siguiente [GUTENDEX](https://gutendex.com/) es ideal para personas que estan iniciando en este mundo y requieren practicar y reforzar los conocimientos entre los que me incluyo
No requiere ninguna KEY lo cual facilita las cosas.  
Aunque en nuestro diseño y requerimientos no usamos más que uno de los metodos la misma Cuenta con varias formas para realizar consultas por id, por autor,por lenguaje, por nombre,etc
varias de las consultas que nosotros tuvimos que construir manualmente luego de obtener una base de libros

Para poder convertir la aplicacion de consola y conectarla a una base de datos hubo que agregar algunas **application.properties** muy importante no se las olviden    

>spring.datasource.url=jdbc:postgresql://${DB_HOST}/liter_alura
> spring.datasource.username=postgres
> spring.datasource.password=${DB_Password}
> spring.datasource.driver-class-name=org.postgresql.Driver
> hibernate.dialect=org.hibernate.dialect.HSQLDialect 
> spring.jpa.hibernate.ddl-auto=update 
> spring.jpa.show-sql=true 
> spring.jpa.format-sql=true    

Las que ven encerradas entre {} son variables de entorno que creamos para evitar exponer informacion sensible sugiero hacer lo mismo y pueden darle el nombre que deseen

### 📶--TABLAS DE POSTGRESQL--📶
Luego de mapear nuestra entidades, tabla,columnas y ciertos atributos que requerian configurarlos de otra manera asi quedaron las tablas luego de las primeras consultas mientras continuabamos puliendo los detalles 

![bdd libros.jpg](Medias%2Fbdd%20libros.jpg)
![bdd autores.jpg](Medias%2Fbdd%20autores.jpg)
## 🗃️--Documentacion--🗃️

🔸 [Documentacion de java](https://docs.oracle.com/en/java/javase/17/docs/api/index.html) Documentacion de todas las clases y metodos junto con sus implementaciones   
🔸[Atajos Intellij](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf) Atajos de teclado para explotar el potencial del entorno  
🔸[Descripcion de clases de java](https://www.aluracursos.com/blog/estructura-datos-con-java) un resumen de las collecciones y otras estructuras que te pueden ser util  
🔸[Clase HTTP Client](https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpClient.html) Les dejo a mano la clase que les permite construir su request
🔸[Gutendex](https://gutendex.com/) Toda la informacion de la estructura del json y que tipos de consultas podemos hacer las van a encontrar ahi y podran practicar
🔸[Spring initializer](https://start.spring.io/) Crear el proyecto y añadir las dependencias de JPA y postgreSQL
🔸[Documentacion de Query Spring JPA](https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html) Tipos de consultas derivadas o configuracion de las nativos que podemos usar en la BDD
🔸[Documentacion de PostgreSQL](https://www.postgresql.org/docs/current/) Introducirse un poco en el funcionamiento de postgreSQL y el entorno pgAdmin
  

![Banner-3.jpg](Medias%2FBanner-3.jpg)