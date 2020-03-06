package my.pvp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9999);

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            String serverInput = dis.readUTF();
            System.out.println(serverInput);

            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            dos.writeUTF(line);
            dis.close();
            dos.flush();

            dos.close();
            socket.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
