import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;

public class InfoCollectionServer {
    public static void main(String[] arstring) {
        //Take one argument, which specifies the port number that the server listens to.
        if (arstring.length != 1) {
            System.out.println("InfoCollectionServer <port>");
            System.exit(1);
        }
        int port = Integer.parseInt(arstring[0]);
        //System.setProperty("javax.net.ssl.keyStore", "cs3750keystore");
        //System.setProperty("javax.net.ssl.keyStorePassword", "password");
        try {
            // Create the SSL Server Socket. 
            SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslserversocket = (SSLServerSocket) sslserversocketfactory.createServerSocket(port);
            System.out.println("InfoCollection Server started. Listening on port " + port + "...");
          while (true) {
            // Listen to the given port and wait for a connection request from an InfoCollectionClient.
            // Create an SSL socket for every incoming SSL connection from an InfoCollectionClient. 
            // While the original thread continues with the following steps.
            SSLSocket sslsocket = (SSLSocket) sslserversocket.accept();
            InputStream inputstream = sslsocket.getInputStream();
            InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
            BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
            // Get the session of this SSL socket and display the following information
                SSLSession session = sslsocket.getSession();
                System.out.println("Peer host is: " + session.getPeerHost());
                System.out.println("Cipher suite is: " + session.getCipherSuite());
                System.out.println("Protocol is: " + session.getProtocol());
                System.out.println("Session ID is: " + session.getId());
                System.out.println("The creation time of this session is: " + session.getCreationTime());
                System.out.println("The last accessed time of this session is: " + session.getLastAccessedTime());

            // Create a new thread to handle the new client
            new Thread(new InfoCollectionHandler(sslsocket)).start();


            String string = null;
            while ((string = bufferedreader.readLine()) != null) {
                System.out.println(string);
                System.out.flush();
        
        if (string.equals("Bye!"))
            break;
            }

            bufferedreader.close();
            sslsocket.close();
          }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

class InfoCollectionHandler implements Runnable {

    private SSLSocket sslSocket;

    public InfoCollectionHandler(SSLSocket sslsocket) {
        this.sslSocket = sslsocket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(sslSocket.getOutputStream(), true);

            while (true) {
                //Send questions to and collect information from the InfoCollectionClient
                 writer.println("User Name:");
                 String nameResponse = reader.readLine();
                 // String userId = UUID.randomUUID().toString();
                 try (PrintWriter fileWriter = new PrintWriter(new FileWriter(nameResponse + ".txt", true))) {
                           fileWriter.println("User Name:" + nameResponse);
                 }
                  writer.println("Full Name:");
                 String fullnameResponse = reader.readLine();
                 fileWriter.println("Full Name:" + fullnameResponse);
                 
                  writer.println("Address:");
                 String addressResponse = reader.readLine();
                 fileWriter.println("Address:" + addressResponse);

                  writer.println("Phone number:");
                 String phoneResponse = reader.readLine();
                 fileWriter.println("Phone number:" + phoneResponse);

                  writer.println("Email address:");
                 String emailResponse = reader.readLine();
                 fileWriter.println("Email address:" + emailResponse);
                
                // Close the user file
                fileWriter.close();
        
                writer.println("Add more users? (yes or any for no)");
                String response = reader.readLine();

                if (!response.equalsIgnoreCase("yes")) {
                    sslSocket.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
