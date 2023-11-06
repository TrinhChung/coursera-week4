import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class test {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF("Send");
        out.close();
        socket.close();
    }
}
