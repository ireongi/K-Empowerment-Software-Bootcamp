package Java_Network.Tesk.Network;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import static java.lang.System.out;

public class DateServer {
    public static void main(String[] args) {
        out.println("날짜 알림 서버");
        try(ServerSocket serverS = new ServerSocket(9000);
            Socket clientS = serverS.accept();
            PrintWriter pw = new PrintWriter(clientS.getOutputStream(), true);)
        {
            out.println("서버 : " + new Date().toString());
        }
        catch (Exception e){
            out.println("출력 오류");
        }
    }

}
