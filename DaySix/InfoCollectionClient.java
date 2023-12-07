import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class InfoCollectionClient {
    public static void main(String[] args) {
        // Take two arguments, which specify the ip/dns and the port number of the remote InfoCollection Server.
        if (args.length != 2) {
            System.out.println("InfoCollectionClient <server_hostname> <server_port>");
            System.exit(1);
        }
        String serverAddress = args[0];
        int port = Integer.parseInt(args[1]);

        try {
            // Create an SSL socket to connect to your InfoCollection server. Catch the exception, terminate the program, 
            // and display error on the standard output if any.
            SSLSocketFactory socketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) socketFactory.createSocket(serverAddress, port);

            // Get the session of this SSL socket and display the following information
            SSLSession session = sslSocket.getSession();
            System.out.println("Peer host is: " + session.getPeerHost());
            System.out.println("Cipher suite is: " + session.getCipherSuite());
            System.out.println("Protocol is: " + session.getProtocol());
            System.out.println("Session ID is: " + session.getId());
            System.out.println("The creation time of this session is: " + session.getCreationTime());
            System.out.println("The last accessed time of this session is: " + session.getLastAccessedTime());

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(sslSocket.getOutputStream(), true);

            while (true) {
                // Read each question from the Info Collection server, one at a time, and display each 
                // question on the standard output to ask the user to input the answer.
                // Read the user’s answer from the standard input and send it to the server.
                // If the user answers any except for “yes” to the InfoCollection Server’s Step 5.g, 
                // close the SSL connection and terminate this program AFTER sending the user’s answer to the InfoCollection Server.
                // Otherwise, repeat reading each question.

                // Read each question from the server and display it
                String question = reader.readLine();
                if (question == null) {
                    // If server closed the connection, terminate the program
                    break;
                }
                System.out.println(question);

                // Read the user's answer from the standard input and send it to the server
                String answer = reader.readLine();
                writer.println(answer);

                // If the user answers anything except "yes," close the SSL connection and terminate the program
                if (!answer.equalsIgnoreCase("yes")) {
                    sslSocket.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}