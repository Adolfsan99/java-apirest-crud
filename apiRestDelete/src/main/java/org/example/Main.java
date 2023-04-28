package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class Main {
    public static void main(String[] args) throws IOException {
        // Este código en Java utiliza la clase URL y HttpURLConnection para enviar una solicitud DELETE a un
        // servicio web en línea y luego leer y mostrar la respuesta.
        URL url = new URL("https://jsonplaceholder.typicode.com/users/1");

        // Aquí se crea un objeto URL que representa la ubicación del recurso en línea al que se enviará la solicitud DELETE.
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Luego se crea una conexión HttpURLConnection al recurso URL especificado.
        connection.setRequestMethod("DELETE");

        // Aquí se establece el método de solicitud en DELETE.
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        // Aquí se obtiene el código de respuesta de la conexión y se muestra en la consola.
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();

        // Se crea un lector de entrada para la conexión y se lee la respuesta en un StringBuilder. Luego se cierra el lector de entrada.
        System.out.println(response.toString());
    }
}