package my.pvp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {

            ServerSocket serverSocket = new ServerSocket(9999);
            do {
                Socket socket = serverSocket.accept();
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF("Hello World");
                dataOutputStream.flush();

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String input = dis.readUTF();
                System.out.println("CLIENT: " + input);
                dataOutputStream.close();
                socket.close();

                String cmd = "";
                if(cmd.equals("EXIT")) break;


            } while(true);
            serverSocket.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
