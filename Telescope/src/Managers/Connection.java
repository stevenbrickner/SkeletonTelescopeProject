package Managers;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Events.EventDispatcher;
import Events.Telecommunications.Telecommands.Telecommand;
import Events.Telecommunications.Telemetry.TelemetryRequest;

public class Connection {
    private static final Map<InetAddress, Socket> clientSockets = new ConcurrentHashMap<>();

    
    private ServerSocket serverSocket;
    private static Socket clientSocket;
    private int port;
    private ExecutorService executorService;

    public Connection(int port) {
        this.port = port;
        this.executorService = Executors.newCachedThreadPool(); // You can adjust the executor type and parameters as needed
    }

    public void start() {
        System.out.println("Initializing Connection Manager");
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started and listening on port " + port);
            acceptConnections();
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void acceptConnections() {
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getInetAddress());
                registerClientSocket(clientSocket);

                // Submit a new task to the executor service to handle communication with this client
                executorService.submit(() -> handleClient(clientSocket));

            } catch (IOException e) {
                System.err.println("Error accepting connection: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void handleClient(Socket clientSocket) {
        try (
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
        ) {
            Object inputObject;
            while ((inputObject = in.readObject()) != null) {
                // Process the received object
                if (inputObject instanceof Telecommand) {
                    // Handle telecommand
                    Telecommand telecommand = (Telecommand) inputObject;
                    EventDispatcher.dispatchEvent(telecommand);

                } else if (inputObject instanceof TelemetryRequest) {
                    // Handle telemetry request
                    TelemetryRequest request = (TelemetryRequest) inputObject;
                    EventDispatcher.dispatchEvent(request);

                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error handling client connection: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public static void sendToClient(String host, int port, String data) {
        InetAddress clientAddress;
        try {
            clientAddress = InetAddress.getByName(host);
        } catch (UnknownHostException e) {
            System.err.println("Error: Invalid host address.");
            e.printStackTrace();
            return;
        }

        try {
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Write the string data to the client
                out.writeUTF(data);
                out.flush();
        
                System.out.println("Data sent to client successfully.");
            } catch (IOException e) {
                System.err.println("Error sending data to client: " + e.getMessage());
                e.printStackTrace();
            }
        }

    public static void registerClientSocket(Socket clientSocket) {
        InetSocketAddress clientAddress = (InetSocketAddress) clientSocket.getRemoteSocketAddress();
        clientSockets.put(clientAddress.getAddress(), clientSocket);
    }

    public void stop() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
                System.out.println("Server stopped");
            }
            executorService.shutdown(); // Shutdown the executor service
        } catch (IOException e) {
            System.err.println("Error stopping server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
