package client_serveur_TCP;

import java.io.*;
import java.net.*;

public class serveur_TCP {
    public static void main(String[] args) {
        final int PORT = 12345;

        try {
            //1 Création d'un ServerSocket qui écoutera les connexions sur le port spécifié
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Serveur en attente de connexion sur le port " + PORT + "...");

            //3 Attente de la connexion d'un client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connecté : " + clientSocket.getInetAddress().getHostAddress());

            // Flux de lecture et d'écriture pour communiquer avec le client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Lecture des messages du client et envoi d'une réponse
            String messageClient;
            while ((messageClient = in.readLine()) != null) {
                System.out.println("Message reçu du client : " + messageClient);
                out.println("Message reçu par le serveur : " + messageClient);
            }

            // Fermeture des flux et des sockets
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
