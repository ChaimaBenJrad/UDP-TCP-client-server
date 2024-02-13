package client_serveur_TCP;

import java.io.*;
import java.net.*;

public class client_TCP {
    public static void main(String[] args) {
        final String SERVEUR_IP = "127.0.0.1"; // Adresse IP du serveur
        final int PORT = 12345;

        try {
            // Cr�ation d'un socket pour se connecter au serveur
            Socket socket = new Socket(SERVEUR_IP, PORT);
            System.out.println("Connect� au serveur sur le port " + PORT);

            // Flux de lecture et d'�criture pour communiquer avec le serveur
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));

            // Lecture des messages du clavier et envoi au serveur
            String messageUtilisateur;
            while ((messageUtilisateur = clavier.readLine()) != null) {
                out.println(messageUtilisateur);
                System.out.println("R�ponse du serveur : " + in.readLine());
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
