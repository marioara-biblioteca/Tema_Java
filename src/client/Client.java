package client;
import people.University;

import java.net.*;
import java.io.*;
import java.nio.Buffer;

public class Client {
    public static String readHuman(BufferedReader stdIn){
        String name,surname,uni,age;
        try {
            System.out.println("Enter a your name: ");
            name=stdIn.readLine();
            System.out.println("Enter your surname: ");
            surname=stdIn.readLine();
            System.out.println("Enter your age: ");
            age=stdIn.readLine();
            System.out.println("Enter your university: ");
            uni=stdIn.readLine();
            return name+';'+surname+';'+age+';'+uni+';';

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws  Exception{
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        try {
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter socketOut = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String clientMessage = "", serverMessage = "";

            while (true) {
                System.out.println("Are you a student(S) or a professor(P)?");
                clientMessage=stdIn.readLine();
                if(clientMessage.equals("S")){
                    clientMessage="S;"+readHuman(stdIn);
                    System.out.println("Enter your study year: ");
                    clientMessage+=stdIn.readLine();

                }else if (clientMessage.equals("P")){
                    clientMessage="P;"+readHuman(stdIn);
                    System.out.println("Enter your subject: ");
                    clientMessage+=stdIn.readLine();
                }else if (clientMessage.equals("bye")) break;

                //trimitem pe socket la server
                socketOut.println(clientMessage);

                serverMessage=socketIn.readLine();
                System.out.println("Server greeting: "+serverMessage);
                serverMessage=socketIn.readLine();
                System.out.println("Server work: "+serverMessage);
            }
            socketIn.close();
            socketOut.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
