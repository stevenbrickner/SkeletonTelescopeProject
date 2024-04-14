public class GroundControlDriver {
    public static void main(String[] args) {
        // Adjust server address and port as needed
        String serverAddress = "localhost";
        int serverPort = 12345;

        GroundControl groundControl = new GroundControl(serverAddress, serverPort);
        groundControl.start();
    }
}