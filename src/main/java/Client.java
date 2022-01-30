import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8189;
        /* у меня не получилось переопределить хост, почему-то не могу сохранить изменения в файле,
        * пишет, что нет прав вносить изменения 127.0.0.1 netology.homework */

          try(Socket clientSocket = new Socket(host, port)){
              PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(),true);
              BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

              String message1 =bufferedReader.readLine();
              System.out.println(message1);
              printWriter.println(scanner.nextLine());

              String message2 = bufferedReader.readLine();
              System.out.println(message2);
              printWriter.println(scanner.nextLine());

              String message3 = bufferedReader.readLine();
              System.out.println(message3);

          }catch (IOException e){
              System.out.println(e.getMessage());
          }
    }
}
