import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    
    public static void main(String[] args){
        
        //Definición de número de puerto y Socket del cliente
        final int PUERTO = 5000;
        Socket socket = null;
        
        //Definición de diferentes flujos de entrada y salida de datos
        DataInputStream stringIn;
        DataInputStream intIn;
        DataInputStream floatIn;
        DataInputStream boolIn;
        
        DataOutputStream stringOut;
        DataOutputStream intOut;
        DataOutputStream floatOut;
        DataOutputStream boolOut;
        
        //Servidor en espera de clientes
        try{
            ServerSocket servidor = new ServerSocket(PUERTO);
            System.out.println("Se ha iniciado el servidor...");
            
            while(true){
                socket = servidor.accept();
                
                System.out.println("Cliente conectado...");
                
                stringIn = new DataInputStream(socket.getInputStream());
                intIn = new DataInputStream(socket.getInputStream());
                floatIn = new DataInputStream(socket.getInputStream());
                boolIn = new DataInputStream(socket.getInputStream());
                
                stringOut = new DataOutputStream(socket.getOutputStream());
                intOut = new DataOutputStream(socket.getOutputStream());
                floatOut = new DataOutputStream(socket.getOutputStream());
                boolOut = new DataOutputStream(socket.getOutputStream());
                
                String mensaje = stringIn.readUTF();
                int entero = intIn.readInt();
                float real = floatIn.readFloat();
                boolean binario = boolIn.readBoolean();
                
                System.out.println("***Datos recibidos desde el Cliente***");
                System.out.println("Esto es un 'String': "+mensaje);
                System.out.println("Esto es un 'int': "+entero);
                System.out.println("Esto es un 'float': "+real);
                System.out.println("Esto es un 'boolean': "+binario);
                System.out.println();
                
                System.out.println("Enviando datos al cliente...");
                stringOut.writeUTF("¡Hola cliente!");
                intOut.writeInt(5000);
                floatOut.writeFloat((float) 3.14159);
                boolOut.writeBoolean(true);
                
                socket.close();
                System.out.println("Se ha cerrado la conexión con el cliente...");
                
            }
            
        }catch(IOException e) {
            e.printStackTrace();
        }
        
        
    }
    
}
