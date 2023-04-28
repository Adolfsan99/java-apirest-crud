package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
public class Main {
    public static void main(String[] args) throws IOException {
        // Este código en Java utiliza la clase URL y HttpURLConnection para enviar una solicitud
        // PUT a un servicio web en línea y luego leer y mostrar la respuesta JSON.
        URL url = new URL("https://jsonplaceholder.typicode.com/users/1");

        // Aquí se crea un objeto URL que representa la ubicación del recurso en línea al que se enviará la solicitud PUT.
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Luego se crea una conexión HttpURLConnection al recurso URL especificado.
        connection.setRequestMethod("PUT");

        // Aquí se establece el método de solicitud en PUT.
        connection.setRequestProperty("Content-Type", "application/json");

        // Se establece la propiedad de cabecera "Content-Type" en "application/json" para indicar que se envía un cuerpo JSON.
        connection.setDoOutput(true);

        // Se habilita la salida en la conexión para enviar los datos en la solicitud.
        String requestBody = "{\"name\":\"John Doe\",\"email\":\"johndoe@example.com\"}";

        // Aquí se define el cuerpo de la solicitud en formato JSON.
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(requestBody);
        writer.flush();
        writer.close();

        // Se crea un flujo de salida para la conexión y se escribe el cuerpo de la solicitud en él.
        // Luego se vacía el búfer y se cierra el flujo de salida.
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