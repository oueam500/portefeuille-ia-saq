package api;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DemandeApi {

    public static void start() throws IOException {

        HttpServer server =
                HttpServer.create(
                        new InetSocketAddress(8080),
                        0
                );

        server.createContext(
                "/demandes",
                (HttpExchange exchange) -> {

                    String json = Files.readString(
                            Paths.get("demandes.json")
                    );

                    exchange.getResponseHeaders().add(
                            "Content-Type",
                            "application/json"
                    );

                    exchange.getResponseHeaders().add(
                            "Access-Control-Allow-Origin",
                            "*"
                    );

                    exchange.sendResponseHeaders(
                            200,
                            json.getBytes().length
                    );

                    OutputStream os =
                            exchange.getResponseBody();

                    os.write(
                            json.getBytes()
                    );

                    os.close();
                }
        );

        server.start();

        System.out.println(
                "API démarrée : http://localhost:8080/demandes"
        );
    }
}
