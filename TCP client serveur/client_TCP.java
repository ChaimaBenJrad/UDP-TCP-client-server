package client_serveur_TCP;

import java.io.*;
import java.net.*;

public class client_TCP {
    public static void main(String[] args) {
        final String SERVEUR_IP = "127.0.0.1"; // Adresse IP du serveur
        final int PORT = 12345;

        try {
            //2 Création d'un socket pour se connecter au serveur
            Socket socket = new Socket(SERVEUR_IP, PORT);
            System.out.println("Connecté au serveur sur le port " + PORT);

            //3 Flux de lecture et d'écriture pour communiquer avec le serveur
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));

            //4 Lecture des messages du clavier et envoi au serveur
            String messageUtilisateur;
            while ((messageUtilisateur = clavier.readLine()) != null) {
                out.println(messageUtilisateur);
                System.out.println("Réponse du serveur : " + in.readLine());
            }

            // Fermeture des flux et du socket
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
