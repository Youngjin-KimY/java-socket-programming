import java.io.*;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket sock = new Socket("127.0.0.1",10001);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            OutputStream out = sock.getOutputStream();
            InputStream in = sock.getInputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
            BufferedReader br = new BufferedReader((new InputStreamReader(in)));
            String line = null;
            while((line = keyboard.readLine()) != null) {
                if(line.equals("quit")) break;
                pw.println(line);
                pw.flush();
                String echo = br.readLine();
                System.out.println("서버로 부터 받은 문자: "+echo);
            }

            pw.close();
            br.close();
            sock.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
