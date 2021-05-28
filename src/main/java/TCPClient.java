import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        String fullName = getString("ad ve soyadinizi daxil edin");
        String ipAndPort = getString("Serverin ip ve portunu daxil edin");
        String[] arr = ipAndPort.split(":");
        String ip = arr[0];
        int port = Integer.parseInt(arr[1]);

            writeToServer(ip, port);

    }

    public static void writeToServer(String ip, int port) throws Exception {

        Socket socket = new Socket(ip, port);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(outputStream);
        String file = getString("Zəhmət olmasa göndərmək istədiyiniz faylın yerləşdiyi keçidi qeyd edin");
        byte[] bytes = Files.readAllBytes(Paths.get(file));
        dos.writeInt(bytes.length);
        dos.write(bytes);
        System.out.println("ugurla gonderildi");

    }


    public static String getString(String title) {
        System.out.println(title);
        return title = new Scanner(System.in).nextLine();
    }
}