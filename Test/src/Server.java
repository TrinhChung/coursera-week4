import javax.naming.ldap.SortKey;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server ís running...");
        ServerSocket server = new ServerSocket(12345);
        Socket socket = server.accept();
        DataInputStream in = new DataInputStream(socket.getInputStream());
        if(in.readUTF().equals("Send")) {
            System.out.println("DaNhan");
        }
        in.close();
        socket.close();
        server.close();
    }
}
