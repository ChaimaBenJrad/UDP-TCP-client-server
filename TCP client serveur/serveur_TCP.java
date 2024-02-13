package client_serveur_TCP;

import java.io.*;
import java.net.*;

public class serveur_TCP {
    public static void main(String[] args) {
        final int PORT = 12345;

        try {
            // Cr�ation d'un ServerSocket qui �coutera les connexions sur le port sp�cifi�
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Serveur en attente de connexion sur le port " + PORT + "...");

            // Attente de la connexion d'un client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connect� : " + clientSocket.getInetAddress().getHostAddress());

            // Flux de lecture et d'�criture pour communiquer avec le client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Lecture des messages du client et envoi d'une r�ponse
            String messageClient;
            while ((messageClient = in.readLine()) != null) {
                System.out.println("Message re�u du client : " + messageClient);
                out.println("Message re�u par le serveur : " + messageClient);
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
