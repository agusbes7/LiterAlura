package LiterAlura.service.API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class ConsumoAPI {
    public Optional<String> obtenerDatos(String url) {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                return Optional.of(response.body());
            } catch (IOException | InterruptedException e) {
                System.out.println("Error durante la solicitud: " + e.getMessage());
                return Optional.empty();
            }
        }
    }