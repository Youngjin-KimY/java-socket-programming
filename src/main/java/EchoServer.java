import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(10001);
            System.out.println("접속을 기다립니다.");
            Socket sock = server.accept();
            InetAddress inetaddr = sock.getInetAddress();
            System.out.println(inetaddr.getHostAddress() + " 로부터 접속했습니다.");

            OutputStream out = sock.getOutputStream();
            InputStream in = sock.getInputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line = null;
            while((line = br.readLine()) != null) {
                System.out.println("클라이언트 부터 전송받은 문자열: "+line);
                pw.println("FromServer :"+line);
                pw.flush();
            }

            pw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
