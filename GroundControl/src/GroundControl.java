import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Events.Telecommunications.Telecommands.*;
import Events.Telecommunications.Telemetry.*;
import Storage.ScheduledMission;

public class GroundControl {
    private String serverAddress;
    private int serverPort;
    private boolean isConnected;
    private Socket socket;

    Scanner scanner = new Scanner(System.in);

    public GroundControl(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.isConnected = false;
    }

    public void start() {
        while (!isConnected) {
            System.out.println("Attempting to connect to server...");
            connect();
            try {
                // Sleep for a short duration before retrying connection
                Thread.sleep(2000); // Adjust the sleep duration as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while (isConnected) {
            System.out.println("Enter your choice:");
            System.out.println("1. Request sensor information");
            System.out.println("2. Add a mission to the scheduled mission log");
            System.out.print("Choice: ");
    
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sendTelemetryRequest();
                    break;
                case 2:
                    sendTelecommand();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }
    }

    private void connect() {
        try {
            socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to server: " + serverAddress + ":" + serverPort);
            isConnected = true;
        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
            // Connection failed, isConnected remains false
        }
    }

    private void sendTelemetryRequest() {
        try {
            // Obtain host and port information from the socket
            String host = socket.getInetAddress().getHostAddress();
            int port = socket.getPort();
    
            // Open output stream to send data to the server
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    
            // Send telemetry request to server with host and port information
            String telemetryRequest = "TELEMETRY_REQUEST:" + host + ":" + port;
            out.writeUTF(telemetryRequest);
            out.flush();
    
            // Close the output stream
            out.close();
        } catch (IOException e) {
            System.err.println("Error sending telemetry request: " + e.getMessage());
            e.printStackTrace();
        }
    }
    

    private void sendTelecommand() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
    
            // Create and send the telecommand
            ScheduledMission mission = new ScheduledMission(20, "Test", "Test", Instant.now().plusSeconds(30), Instant.now().plusSeconds(75));
            System.out.println("Sending telecommand: " + mission.getMissionName());
            out.writeObject(new AddMission(1, mission));
    
            // Close the output stream
            out.close();
        } catch (IOException e) {
            System.err.println("Error sending telecommand: " + e.getMessage());
            e.printStackTrace();
        }
    }
}