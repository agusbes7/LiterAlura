package LiterAlura.service.API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public String obtenerDatos(String url){
        String json;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println("Hubo un error en la solicitud... "+ e.getClass().getSimpleName());
            System.out.println("mensaje de error... "+ e.getMessage());
       return  json="error";
        } catch (InterruptedException e) {
            System.out.println("Hubo un error en la solicitud... "+ e.getClass().getSimpleName());
            System.out.println("mensaje de error... "+ e.getMessage());
            return  json="error";}
         json= response.body();
        return json;
    }
}
