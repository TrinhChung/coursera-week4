import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server() throws IOException {
        ServerSocket ss = new ServerSocket(1234);
        System.out.println("Server mo cong ket noi");
        Socket s = ss.accept();
        System.out.println("co client ket noi");
        OutputStream os = s.getOutputStream();
        InputStream is = s.getInputStream();
        int ch = is.read();
        System.out.println("Server Nhan" + (char)ch);
        int ch2 = System.in.read();
        System.out.println("Gui");

        os.write(ch);
    }
}
