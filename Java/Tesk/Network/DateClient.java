package Java_Network.Tesk.Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class DateClient {
    public static void main(String[] args) throws IOException {
        System.out.print("IP 주소를 입력하시오 : ");
        Scanner sc = new Scanner(System.in);
        String localhost = sc.nextLine();

        try (Socket clientS = new Socket(localhost, 9000);) {
            System.out.println("날짜 알림 고객 서비스 시작");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(clientS.getInputStream()))) {
                String answer = br.readLine();
                System.out.println(answer);
            } catch (Exception e) {

            }
        }catch (Exception e) {

        }
    }
}
