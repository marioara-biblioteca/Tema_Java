package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)throws Exception {
        int port=Integer.parseInt(args[0]);
        int clientCounter=0;
        try{
            ServerSocket server=new ServerSocket(port);
            System.out.println("Server started...");
            while(true){
                clientCounter++;
                Socket client=server.accept();
                System.out.println("Client "+Integer.toString(clientCounter)+" started...");
                ServerClientThread sct=new ServerClientThread(client,clientCounter);
                sct.start();
                ServerClientThread.showResults();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
