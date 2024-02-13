package client_serveur_UDP;

public class main {
    public static void main(String[] args) {
        Thread serverThread = new Thread(() -> serveur_UDP.main(new String[]{}));
        Thread clientThread = new Thread(() -> client_UDP.main(new String[]{}));

        serverThread.start();
        clientThread.start();
    }
}
