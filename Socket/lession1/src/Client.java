import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class Client {
    public Client() throws IOException {
        Socket s = new Socket("112.137.129.129",27001);
        OutputStream os = s.getOutputStream();
        InputStream is = s.getInputStream();
        String mssv = "20020370";
        byte[] PKT_HELLO = new byte[1024];
        os.write(PKT_HELLO, Integer.parseInt(mssv),mssv.length());
    }

    public static void main(String[] args) throws IOException {
        Client newClient = new Client();
    }
}
