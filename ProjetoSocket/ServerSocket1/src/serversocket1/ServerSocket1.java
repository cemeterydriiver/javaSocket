
package serversocket1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerSocket1 {

   
    public static void main(String[] args) {
        try {
            //serviço de escuta
            ServerSocket servidor = new ServerSocket(3334);
            System.out.println("Servidor iniciado na porta 3334");
            
            //canal de comunicação
            Socket cliente = servidor.accept(); 
            System.out.println("Cliente do IP: " +cliente.getInetAddress().getHostAddress());
            
            Scanner in = new Scanner(cliente.getInputStream());
            
            while(in.hasNextLine()){
                System.out.println(in.nextLine());
            }
            
            in.close();
            servidor.close();
            
        } catch (IOException ex) {
            System.out.println("Erro ao iniciar servidor");
        }
    }
    
}
