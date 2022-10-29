package server;

import people.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

public class ServerClientThread extends Thread{
    Socket socket;
    int clientCount;
    static List<People> humans =new ArrayList<>();
    private People parseClientMessage(String clientMessage){
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer=new StringTokenizer(clientMessage,";");
        while(tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        if(tokens.get(0).equals("S"))
            return new Student(tokens.get(1),tokens.get(2),University.getUni(tokens.get(4)),Integer.parseInt(tokens.get(3)),Integer.parseInt(tokens.get(5)));
        else return new Professor(tokens.get(1),tokens.get(2),Integer.parseInt(tokens.get(3)),University.getUni(tokens.get(4)),tokens.get(5));

    }
    public ServerClientThread(Socket socket, int clientCount) {
        this.socket = socket;
        this.clientCount = clientCount;

    }
    public static void showResults(){
        System.out.println("Finishing up...");
        Collections.sort(humans);
        System.out.println(humans.toString());
    }
    @Override
    public void run() {
        try {
            PrintWriter socketOut=new PrintWriter(socket.getOutputStream(),true);
            BufferedReader socketIn=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientMessage="",serverMessage="";
            while(true){
                clientMessage=socketIn.readLine();
                if(clientMessage==null || clientMessage.equals("bye")) break;
                System.out.println("From client number " +Integer.toString(clientCount)+" to server message to be parsed is: "+clientMessage);

                People client=parseClientMessage(clientMessage);
                serverMessage=client.greeting();
                serverMessage="From Server greeting processed message is : "+serverMessage+", client: "+Integer.toString(clientCount);
                socketOut.println(serverMessage);
                serverMessage=client.doWork();
                serverMessage="From Server work processed message is : "+serverMessage+", client: "+Integer.toString(clientCount);
                socketOut.println(serverMessage);
                if(!humans.contains(client))
                    humans.add(client);

            }
            socketIn.close();
            socketOut.close();
            socket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        ServerClientThread.showResults();
    }
}
