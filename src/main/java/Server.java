import java.awt.print.Printable;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8189;
       while(true){
           try(ServerSocket serverSocket = new ServerSocket(port)){

               System.out.println("New connection accepted");

               Socket clientSocket = serverSocket.accept();
               PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
               BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
               System.out.println("client port:" + clientSocket.getPort());

               printWriter.println("What is your name?");
               final String name = bufferedReader.readLine();

               printWriter.println("Are you child? (yes/no)");
               final String answer = bufferedReader.readLine();
               if(answer.equals("yes")){
                   printWriter.println(String.format("Welcome to the kids area, %s Let's play!", name));
               }else{
                  printWriter.println(String.format(
                          "Welcome to the adult zone, %s! Have a good rest, or a good working day!",name));
               }

           }catch (IOException e){
               System.out.println(e.getMessage());
           }

       }

    }
}
