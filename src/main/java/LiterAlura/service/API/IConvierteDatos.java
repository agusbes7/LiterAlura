package LiterAlura.service.API;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
